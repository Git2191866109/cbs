package com.bs.plugins.thirdparty.sms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.bs.plugins.custom.sm.businesssend.entity.BusinessSend;
import com.bs.plugins.thirdparty.sms.wxtlsms.util.CodingUtils;
import com.bs.plugins.thirdparty.sms.wxtlsms.util.HttpUtil;


/**
 * 短信HTTP协议发送接口实现 无线天利
 * @author Liu
 *
 */

public class SMSWXTLImpl implements SMS {
	
	public static Logger log = Logger.getLogger("sms");
	
	private Map<String,String> channel ;
	
	private Map<String,String> statusCode;
	
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
	
	public SMSWXTLImpl() {
		System.err.println("SMSWXTLImpl 实例化了");
	}

	/**
	 * 短信发送
	 */
	@Override
	public BusinessSend send(BusinessSend businessSend) throws Exception {
		//http服务端url
		String httpSendPath = channel.get("httpSendPath");
		//客户端ID
		String cid = channel.get("cid");
		//客户端密码
		String pwd = channel.get("pwd");
		//通道组id
		String productid = channel.get("productid");
		//手号机
		String mobile = businessSend.getMobilePhone();
		//短信内容3
		String content = businessSend.getContent()+"【学费帮】";
		//子号码
		String lcode = channel.get("lcode");
		//短信唯一标识,用于匹配状态报告
		String ssid = businessSend.getMessageSerial() == null ?
				System.currentTimeMillis()+getFixLenthString(6) : businessSend.getMessageSerial();
		//短信类型:15普通短信,32长短信
		String format = channel.get("format");
		//客户自定义签名,可以不填
		String sign = channel.get("sign");
		//客户自定义内容,目前没有用到,不用填写
		String custom = channel.get("custom");
		
		StringBuffer params = new StringBuffer();
		String result= "";
		try{	
			params.append("cid=").append(CodingUtils.encodeBase64URL(cid))
			.append("&").append("pwd=").append(CodingUtils.encodeBase64URL(pwd))
			.append("&").append("productid=").append(CodingUtils.encodeURL(productid))
			.append("&").append("mobile=").append(CodingUtils.encodeBase64URL(mobile+""))
			.append("&").append("content=").append(CodingUtils.encodeBase64URL(content))
			.append("&").append("lcode=").append(lcode)
			.append("&").append("ssid=").append(ssid)
			.append("&").append("format=").append(format)
			.append("&").append("sign=").append(CodingUtils.encodeBase64URL(sign))
			.append("&").append("custom=").append(CodingUtils.encodeURL(custom));
			log.debug("无线天利短信发送参数:" + params.toString());
			result = HttpUtil.sendPostRequestByParam(httpSendPath,params.toString());
			log.debug("无线天利短信发送返回结果:" + result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		@SuppressWarnings("rawtypes")
		Map map = (Map)JSON.parseObject(result);
		BusinessSend bs = new BusinessSend();
		bs.setId(businessSend.getId());
		bs.setMessageSerial(ssid);// 不设置，会有个默认的随机串作为ssid
		Integer status = Integer.valueOf((String)map.get("status"));
		bs.setStatus(status);
		bs.setType(format);// 短信类型
		return bs;
	}

	/**
	 * 报告反馈
	 */
	@Override
	public List<BusinessSend> fetch() throws Exception {
		//http服务端url
		String httpFetchPath = channel.get("httpFetchPath");
		//客户端ID
		String cid = channel.get("cid");
		//客户端密码
		String pwd = channel.get("pwd");
		//一次获取状态报告的数量
		String cnt = channel.get("cnt");
		StringBuffer params= new StringBuffer(); 
		String result = "";
		try{
			params.append("cid=").append(CodingUtils.encodeBase64URL(cid))
			.append("&").append("pwd=").append(CodingUtils.encodeBase64URL(pwd))
			.append("&").append("cnt=").append(cnt);
			result = HttpUtil.sendPostRequestByParam(httpFetchPath,params.toString());
			log.debug("无线天利短信查询报告返回结果:" + result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		
		@SuppressWarnings("rawtypes")
		Map map = (Map)JSON.parseObject(result);
		List<BusinessSend> lbs = new ArrayList<BusinessSend>();
		@SuppressWarnings("unchecked")
		List<Map<String,String>> rl= (List<Map<String,String>>)map.get("data");
		if(!rl.isEmpty()){
			for(Map<String,String> m : rl){
				BusinessSend bs = new BusinessSend();
				bs.setMessageSerial(m.get("ssid"));
				bs.setStatusReport(Integer.valueOf(m.get("status")));// 转发状态码
				bs.setStatements(m.get("errorcode")); // 成功送达： DELIVRD  // 错误码
				bs.setTotalCount(Integer.valueOf(m.get("pktotal")));
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
	
	
	
	public static void main(String[] args) {
		
//		Map obj = (Map)JSON.parse("{msgid:1447743838902,mobile:15011169565,status:0}");
//		System.err.println(obj.get("msgid"));
//		
//		String s = "{\"status\":\"0\",\"data\":[{\"pktotal\":\"1\",\"status\":\"0\",\"ssid\":\"1447743838902\",\"csid\":\"3111164164070821\",\"errorcode\":\"DELIVRD\",\"pknumber\":\"1\",\"custom\":\"\",\"mobile\":\"15011169565\"},{\"pktotal\":\"1\",\"status\":\"2\",\"ssid\":\"1447744973306\",\"csid\":\"3111183189467724\",\"errorcode\":\"-21\",\"pknumber\":\"1\",\"custom\":\"\",\"mobile\":\"15011169565\"}],\"size\":\"2\"}";
//		Object obj1 = JSON.parse(s);
//		System.err.println(obj1);
//		
//		String s2 = "{\"status\":\"0\",\"data\":[],\"size\":\"0\"}";
//		Map obj2 = (Map)JSON.parse(s2);
//		System.err.println(obj2);
//		List<Map<String,String>> rl= (List<Map<String,String>>)obj2.get("data");
//		if(!rl.isEmpty()){
//			System.err.println(obj2);
//		}
		
		
	}



}
