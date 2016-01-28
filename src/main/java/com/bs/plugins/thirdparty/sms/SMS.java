package com.bs.plugins.thirdparty.sms;

import java.util.List;
import java.util.Map;

import com.bs.plugins.custom.sm.businesssend.entity.BusinessSend;

/**
 * 短信的接收和发送
 * @author Liu
 *
 */
public interface SMS {

	/**
	 * 短信发送到网关
	 * @return 提交结果
	 */
	BusinessSend send(BusinessSend businessSend) throws Exception;
	
	
	/**
	 * 获取报告 
	 * @return 获得报告
	 */
	List<BusinessSend> fetch() throws Exception;
	
	
	/**
	 * 获得状态码
	 * @param map
	 * @return
	 */
	Map<String,String> getCodeInfo();
	
	
	/**
	 * 获得错误码
	 * @return
	 */
	Map<String,String> getErrorCodeInfo();
	
	
	/**
	 * 通道信息
	 * @param map
	 * @return
	 */
	Map<String,String> getChannelInfo();
	
	
	
}
