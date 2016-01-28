package com.bs.plugins.thirdparty.sms.wxtlsms;

import com.bs.plugins.thirdparty.sms.wxtlsms.util.CodingUtils;
import com.bs.plugins.thirdparty.sms.wxtlsms.util.HttpUtil;

/**
 * 无线天利短信对接 - 基于 HTTP 协议
 * @author Liu Xue
 * 
 */
public class TestSmsFetchReport {


	public static void main(String[] args)
	{
		//http服务端url
		String httpPath = "http://58.68.247.137:9053/communication/fetchReports.ashx";
		StringBuffer params= new StringBuffer();
		//客户端ID
		String cid="9196";
		//客户端密码
		String pwd="YkB15L";
		//一次获取状态报告的数量
		int cnt=10;
		int a;
		for (a=0;a<1;a++)
		{    params = new StringBuffer();
			try
			{
				params.append("cid=").append(CodingUtils.encodeBase64URL(cid))
				.append("&").append("pwd=").append(CodingUtils.encodeBase64URL(pwd))
				.append("&").append("cnt=").append(cnt);
				String result=HttpUtil.sendPostRequestByParam(httpPath,params.toString());
				System.out.println(result);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		
	}
	
	
	

}
