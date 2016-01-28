package com.bs.plugins.thirdparty.sms;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.bs.plugins.custom.sc.parameter.entity.Parameter;
import com.bs.plugins.custom.sc.parameter.service.ParameterService;
import com.bs.plugins.custom.sm.businesssend.entity.BusinessSend;
import com.bs.plugins.custom.sm.businesssend.service.BusinessSendService;
import com.bs.plugins.custom.sm.serviceprovider.entity.ServiceProvider;
import com.bs.plugins.custom.sm.serviceprovider.service.ServiceProviderService;

public class SMSHandleImpl implements SMSHandle,ApplicationContextAware {

	public static Logger log = Logger.getLogger("sms");
	
	private static final String RETRY_COUNT_CODE = "count";
	private static final Integer DEFAULT_COUNT = 3;
	
	@Autowired
	private BusinessSendService businessSendService;
	@Autowired
	private ServiceProviderService serviceProviderService;
	@Autowired
	private ParameterService parameterService;
	
	
	private static ApplicationContext applicationContext;
	
	/**
	 * 处理短信补发业务，通过job调用
	 */
	@Override
	public void reissue() {
		// 补发针对提交失败的补发
		try {
			// 启用的通道
			ServiceProvider serviceProvider = fetchServiceProvider();
			SMS smsImpl = fetchSMS(serviceProvider);
			log.debug("线程"+Thread.currentThread().getName()+"正在使用"+smsImpl.getClass().getSimpleName()+"类的实例:"+smsImpl+"--->发送补发短信");
			Integer count = DEFAULT_COUNT;// 默认等于3
			Parameter parameter = parameterService.selectByCode(RETRY_COUNT_CODE);
			if(parameter != null && !"".equals(parameter.getCode())){ 
				try{
					count = Integer.valueOf(parameter.getCode());
				}catch(Exception e){
					count = DEFAULT_COUNT;
				}
			}
			// 待发送短信列表(只补发类型)
			BusinessSend param = new BusinessSend();
			param.setNow(System.currentTimeMillis());
			param.setRetryCount(count);
			List<BusinessSend> lbs = businessSendService.selectSupplementSends(param);
			if(lbs != null ){
				for(BusinessSend bs : lbs){
					// 内容不为空
					String c = bs.getContent();
					if(c != null && !"".equals(c)){
						// 最后一次切换通道发送
						if(count.intValue()-1 == (bs.getRetryCount() == null ? 0 :bs.getRetryCount().intValue())){
							// 查询所有通道
							List<ServiceProvider> list = fetchAllServiceProvider();
							for(ServiceProvider sp : list){
								// 如果没有备用通道，还用该通道发送
								if(serviceProvider.getCode().equals(sp.getCode()) && list.size() > 1)
									continue;
								
								SMS backupSms = fetchSMS(sp);
								log.debug("线程"+Thread.currentThread().getName()+"正在自动切换且使用备用通道"+backupSms.getClass().getSimpleName()+"类的实例:"+backupSms+"--->发送补发短信");
								// 切换通道发送短信
								BusinessSend rbs = backupSms.send(bs);		// 发送短信
								rbs.setSpCode(serviceProvider.getCode());	// 发送通道code
								Integer rc = rbs.getRetryCount() == null 
										? 1 : rbs.getRetryCount() + 1;
								rbs.setRetryCount(rc);						// 补发次数(每次加一)
								rbs.setSpCode(sp.getCode());				// 更新通道类型
								updateById(rbs);
								
								break;
							}
						}else {
							BusinessSend rbs = smsImpl.send(bs);		// 发送短信
							rbs.setSpCode(serviceProvider.getCode());	// 发送通道code
							Integer rc = rbs.getRetryCount() == null 
									? 1 : rbs.getRetryCount() + 1;
							rbs.setRetryCount(rc);						// 补发次数(每次加一)
							updateById(rbs);							// 更发送提交状态
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
		
	}

	
	
	
	/**
	 * 处理短信发送业务，通过job调用
	 */
	@Override
	public void send() {
		
		// 需要锁机制(集群环境下,保证不重复发送) // 目前先不进行限制
		// 保证线程安全(防止重复发送的问题)// 目前先限制为单线程
		try {
			// 启用的通道
			ServiceProvider serviceProvider = fetchServiceProvider();
			SMS smsImpl = fetchSMS(serviceProvider);
			log.debug("线程"+Thread.currentThread().getName()+"正在使用"+smsImpl.getClass().getSimpleName()+"类的实例:"+smsImpl+"--->发送短信");
			// 待发送短信列表(不包含需要补发类型)
			BusinessSend param = new BusinessSend();
			param.setNow(System.currentTimeMillis());
			List<BusinessSend> lbs = businessSendService.findListByStatus(param);
			if(lbs != null ){
				for(BusinessSend bs : lbs){
					// 内容不为空
					String c = bs.getContent();
					if(c != null && !"".equals(c)){
						BusinessSend rbs = smsImpl.send(bs);		// 发送短信
						rbs.setSpCode(serviceProvider.getCode());	// 发送通道code
						updateById(rbs);							// 更发送提交状态
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
	}

	
	
	
	/**
	 * 处理短信报告获取业务，通过job调用
	 */
	@Override
	public void fetch() {
		try {
			SMS smsImpl = fetchSMS(fetchServiceProvider());
			Map<String, String> errorCode = smsImpl.getErrorCodeInfo();
			Map<String, String> statusCode = smsImpl.getCodeInfo();
			log.debug("线程"+Thread.currentThread().getName()+"正在使用"+smsImpl.getClass().getSimpleName()+"类的实例:"+smsImpl+"--->获取报告");
			// 状态报告 List
			List<BusinessSend> lbs = smsImpl.fetch();
			if(lbs != null){
				for(BusinessSend bs:lbs){
					// 设置错误和说明
					if(errorCode != null && !errorCode.isEmpty()){
						// 根据错误状态码获得错误信息
						String e = errorCode.get(bs.getStatements());
						if(e != null){
							// 错误状态码陈述
							bs.setStatements("【"+bs.getStatements()+"】"+e);
						}else {
							bs.setStatements("【"+bs.getStatements()+"】");
						}
					}
					// 设置状态码
					if(statusCode != null && !statusCode.isEmpty()){
						// 根据错误状态码获得错误信息
						String s = statusCode.get(bs.getStatusReport()+"");
						if(s != null){
							bs.setStatusReport(Integer.valueOf(s));
						}
					}
					// 更新状态
					updateBySid(bs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		} 
	}

	
	
	/**
	 * 单独定时任务
	 * 处理完成的短信移动到历史记录表中
	 */
	@Override
	public void move() {
		try {
			businessSendService.moveBusinessSendToBusinessSent();
			log.debug("正在短信息移动到 --->历史表");
		} catch (Exception e) {
			log.debug("短信息移动到历史表:"+e);
		}
	}
	
	
	
	private Integer updateById(BusinessSend bs) {
			return businessSendService.updateBusinessSendById(bs);
	}

	
	
	private Integer updateBySid(BusinessSend bs) {
		return businessSendService.updateBusinessSendBySid(bs);
	}  
	
	
	private ServiceProvider fetchServiceProvider(){
		ServiceProvider serviceProvider = serviceProviderService.selectUseServiceprovide();
		if(serviceProvider == null){
			throw new RuntimeException("短信通道未进行配置");
		}
		return serviceProvider;
	}
	
	/**
	 * 查询所有通道信息
	 * @return
	 */
	private List<ServiceProvider> fetchAllServiceProvider(){
		return serviceProviderService.selectAllServiceprovide();
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SMSHandleImpl.applicationContext = applicationContext;  
	}
	
	
	
	private SMS fetchSMS(ServiceProvider serviceProvider) throws Exception{
		if(serviceProvider != null && !"".equals(serviceProvider.getCode())){
			return SMSHandleImpl.getBean(serviceProvider.getCode());
		}
		throw new RuntimeException("短信通道未进行配置");
	}
	
	
	
    private static SMS getBean(String name) throws Exception{ 
    	Object obj = applicationContext.getBean(name);
    	if(obj != null && obj instanceof SMS){
    		return (SMS)obj;
    	}
    	throw new Exception("获得Bean名称为"+name+"存在异常,配置有误或者不存在该通道");
    }
    
    
}
