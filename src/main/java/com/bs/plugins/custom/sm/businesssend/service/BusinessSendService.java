package com.bs.plugins.custom.sm.businesssend.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.sm.businesssend.entity.BusinessSend;
import com.bs.plugins.custom.sm.businesssent.dao.IBusinessSentDao;
import com.bs.plugins.custom.sm.businesssent.entity.BusinessSent;
import com.bs.plugins.custom.sm.serviceprovider.dao.IServiceProviderDao;
import com.bs.plugins.custom.sm.serviceprovider.entity.ServiceProvider;
import com.bs.plugins.custom.sc.parameter.entity.Parameter;
import com.bs.plugins.custom.sc.parameter.service.ParameterService;
import com.bs.plugins.custom.sm.businesssend.base.BaseBusinessSendService;
import com.bs.plugins.custom.sm.businesssend.dao.IBusinessSendDao;

@Service
public class BusinessSendService extends BaseBusinessSendService<BusinessSend> {
	
	private static final String RETRY_COUNT_CODE = "count";
	private static final Integer DEFAULT_COUNT = 3;
	
	@Autowired
	private IBusinessSendDao businessSendDao;
	@Autowired
	private IBusinessSentDao businessSentDao;
	@Autowired
	private IServiceProviderDao serviceProviderDao;
	@Autowired
	private ParameterService parameterService;
	
	public BusinessSendService(){
		
		System.err.println("--------------BusinessSendService--------------实例化了");
	}
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData selectIndex(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			List<ServiceProvider> list = serviceProviderDao.selectAll();
			resultData.addObject("serviceProviderList", list);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	
	
	public List<BusinessSend> findListByStatus(BusinessSend bs){
		return businessSendDao.selectNotSends(bs);
	}
	
	/**
	 * 短信补发列表
	 * @param count
	 * @return
	 */
	public List<BusinessSend> selectSupplementSends(BusinessSend bs ){
		return businessSendDao.selectSupplementSends(bs);
	}
	
	
	public Integer updateBusinessSendById(BusinessSend bs){
		try {
			return businessSendDao.updateById(bs);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public Integer updateBusinessSendBySid(BusinessSend bs){
		return businessSendDao.updateBySid(bs);
	}
	
	
	/**
	 * 将已发送过的短信移动到历史记录表 
	 * @throws Exception 
	 */
	public void moveBusinessSendToBusinessSent() throws Exception{
		Integer count = DEFAULT_COUNT;// 默认等于3
		Parameter parameter = parameterService.selectByCode(RETRY_COUNT_CODE);
		if(parameter != null && !"".equals(parameter.getCode())){ 
			try{
				count = Integer.valueOf(parameter.getCode());
			}catch(Exception e){
				count = DEFAULT_COUNT;
			}
		}
		BusinessSend businessSend = new BusinessSend();
		businessSend.setRetryCount(count); // 从字典表中查询 
		businessSend.setNow(System.currentTimeMillis());
		List<BusinessSend> list = businessSendDao.selectSents(businessSend); 
		for(BusinessSend bs : list){
			BusinessSent bst = new BusinessSent();
			BeanUtils.copyProperties(bs, bst, BusinessSent.class);
			// 插入Sent
			businessSentDao.insert(bst);
			// 删除 Send
			businessSendDao.delete(bs);
		}
	}
	
	/**
	 * 查询短信表和短信历史表
	 * @param bs
	 * @return
	 */
	public ResultData selectAllSms(BusinessSend bs){
		ResultData resultData = new ResultData();
		try {
			List<BusinessSend> businessSendList = businessSendDao.selectAllSms(bs);
			Long businessSendCount = businessSendDao.getAllSmsCount(bs);
			if (businessSendList != null){
				long record = businessSendCount == null?0:businessSendCount;
				int pageCount = (int) Math.ceil(record / (double) bs.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", bs.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", businessSendList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			}else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	
	public ResultData statistics(BusinessSend bs) throws Exception{
		Long waitSubmit = businessSendDao.selectWaitSubmitCount(bs);// 待提交
		Long submitSuccess = businessSendDao.selectSubmitSuccessCount(bs); // 提交成功且已发送
		Long successSend = businessSendDao.selectSuccessSendCount(bs); // 发送成功
		Long ssnsc = businessSendDao.selectSuccessSubmitNotSendCount(bs); // 提交成功未发送
		
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("waitSubmit", waitSubmit);
		m.put("submitSuccess", submitSuccess+ssnsc);
		m.put("successSend", successSend);
		ResultData rd = new ResultData();
		rd.setResultMap(m);
		return rd;
		
	}
	public ResultData statisticsIndex(BusinessSend bs) throws Exception{
		ResultData resultData = new ResultData();
		try {
			List<ServiceProvider> list = serviceProviderDao.selectAll();
			resultData.addObject("serviceProviderList", list);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
}
