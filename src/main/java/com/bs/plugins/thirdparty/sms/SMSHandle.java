package com.bs.plugins.thirdparty.sms;

/**
 * 短信管理
 * @author Liu
 *
 */
public interface SMSHandle {

	
	/**
	 * 补发
	 */
	void reissue();
	
	
	/**
	 * 发送
	 */
	void send();
	
	
	/**
	 * 报告获取
	 */
	void fetch();
	
	
	/**
	 * 移动已发送的短息到历史表
	 */
	void move();
	

}
