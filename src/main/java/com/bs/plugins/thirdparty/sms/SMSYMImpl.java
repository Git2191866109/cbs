package com.bs.plugins.thirdparty.sms;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.bs.plugins.custom.sm.businesssend.entity.BusinessSend;
import com.bs.plugins.thirdparty.sms.ymsms.HttpClientUtil;
import com.bs.plugins.thirdparty.sms.ymsms.XMLUtil;

public class SMSYMImpl implements SMS{

	public static Logger log = Logger.getLogger("sms");
	
	/**
	 * 通道配置
	 */
	private Map<String,String> channel ;
	/**
	 * 状态码
	 */
	private Map<String,String> statusCode;
	/**
	 * 错误码
	 */
	private Map<String,String> errorCode;
	
	
	public Map<String, String> getChannel() {
		return channel;
	}

	public void setChannel(Map<String, String> channel) {
		this.channel = channel;
	}

	public Map<String, String> getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Map<String, String> statusCode) {
		this.statusCode = statusCode;
	}

	
	public Map<String, String> getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Map<String, String> errorCode) {
		this.errorCode = errorCode;
	}

	
	@Override
	public Map<String, String> getCodeInfo() {
		return this.statusCode;
	}

	@Override
	public Map<String, String> getChannelInfo() {
		return this.channel;
	}
	
	@Override
	public Map<String, String> getErrorCodeInfo() {
		return this.errorCode;
	}
	
	public SMSYMImpl() {
		System.err.println("SMSYMImpl 正在实例化。。。");
	}


	@Override
	public BusinessSend send(BusinessSend businessSend) throws Exception {
		// URL地址
    	String url = channel.get("httpSendPath");
    	// 用户序列号
    	String cdkey = channel.get("cdkey");
    	// 用户密码
    	String password = channel.get("password");
    	// 手机号
    	String phone = businessSend.getMobilePhone();
    	// 短信内容
    	String message = businessSend.getContent()+"【签名】";
    	// 附加号
    	String addserial = channel.get("addserial");
    	// 唯一序列ID
    	String seqid = businessSend.getMessageSerial() == null ?
				System.currentTimeMillis()+getFixLenthString(6) : businessSend.getMessageSerial();
    	// 短信优先级
    	String smspriority = channel.get("smspriority");
    	
    	StringBuffer params = new StringBuffer();
		String result= "";
		try{	
			params.append(url)
			.append("?").append("cdkey=").append(cdkey)
			.append("&").append("password=").append(password)
			.append("&").append("phone=").append(phone)
			.append("&").append("message=").append(URLEncoder.encode(message, "utf-8"))
			.append("&").append("addserial=").append(addserial)
			.append("&").append("seqid=").append(seqid)
			.append("&").append("smspriority=").append(smspriority);
			log.debug("亿美短信发送参数:" + params.toString());
			result = HttpClientUtil.getInstance().doGetRequest(params.toString());
			log.debug("亿美短信发送返回结果:" + result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		
		// 解析 xml
		String json = XMLUtil.xmltoJson(result);
		@SuppressWarnings("rawtypes")
		Map map = (Map)JSON.parseObject(json);
		BusinessSend bs = new BusinessSend();
		bs.setId(businessSend.getId());
		bs.setMessageSerial(seqid);// 不设置，会有个默认的随机串作为ssid
		Integer status = Integer.valueOf((String)map.get("error"));
		bs.setStatus(status);
		//bs.setType("15");// 亿美文档没有长短类型
		return bs;
		
	}

	
	
	
	@Override
	public List<BusinessSend> fetch() throws Exception {
		// URL地址
    	String url = channel.get("httpFetchPath");
    	// 用户序列号
    	String cdkey = channel.get("cdkey");
    	// 用户密码
    	String password = channel.get("password");
		StringBuffer params= new StringBuffer(); 
		String result = "";
		try{
			params.append(url)
			.append("?").append("cdkey=").append(cdkey)
			.append("&").append("password=").append(password);
			log.debug("亿美短信查询报告参数:" +  params.toString());
			result = HttpClientUtil.getInstance().doGetRequest(params.toString());
			log.debug("亿美短信查询报告返回结果:" + result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	
		// 解析 xml
		String json = XMLUtil.xmltoJson(result);
		@SuppressWarnings("rawtypes")
		Map map = (Map)JSON.parseObject(json);
		List<BusinessSend> lbs = new ArrayList<BusinessSend>();
		@SuppressWarnings("unchecked")
		List<Map<String,String>> rl= (List<Map<String,String>>)map.get("message");
		if(!rl.isEmpty()){
			for(Map<String,String> m : rl){
				BusinessSend bs = new BusinessSend();
				bs.setMessageSerial(m.get("seqid"));
				bs.setStatusReport(Integer.valueOf(m.get("state")));// // 成功送达： DELIVRD  
				bs.setStatements(m.get("error")); // 状态码
				//bs.setTotalCount(Integer.valueOf(m.get("pktotal")));
				lbs.add(bs);
			}
		}
		return lbs;
	}

	public String getFixLenthString(int strLength) {
		 Random rm = new Random();
		 // 获得随机数
		 double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
		 // 将获得的获得随机数转化为字符串
		 String fixLenthString = String.valueOf(pross);
		 // 返回固定的长度的随机数
		 return fixLenthString.substring(1, strLength + 1);
		}
	
	
}
