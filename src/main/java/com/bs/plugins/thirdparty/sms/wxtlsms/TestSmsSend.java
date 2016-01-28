package com.bs.plugins.thirdparty.sms.wxtlsms;

import com.bs.plugins.thirdparty.sms.wxtlsms.util.CodingUtils;
import com.bs.plugins.thirdparty.sms.wxtlsms.util.HttpUtil;

/**
 * http接口短信发送示例  正式环境
 * @author Administrator
 *
 */
public class TestSmsSend {

	
	public static void main(String[] args)
	{
		//http服务端url
		String httpPath = "http://58.68.247.137:9053/communication/sendSms.ashx";
		//客户端ID
		String cid="9196";
		//客户端密码
		String pwd="YkB15L";
		//通道组id
		String productid="201512034";
		//手号机
		String mobile="15011169565";
		//短信内容3
		String content="富灵灵【学费帮】";
		System.err.println(content.length());
		//子号码
		String lcode="";
		//短信唯一标识,用于匹配状态报告
		String ssid=System.currentTimeMillis()+"";
		//短信类型:15普通短信,32长短信
		String format="15";
		//客户自定义签名,可以不填
		String sign="";
		//客户自定义内容,目前没有用到,不用填写
		String custom="";
		
		StringBuffer params = new StringBuffer();
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
			System.out.println(params.toString());
			String result=HttpUtil.sendPostRequestByParam(httpPath,params.toString());
			System.out.println("r="+result);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
