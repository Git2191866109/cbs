package com.bs.plugins.thirdparty.sms.ymsms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;

import com.bs.plugins.thirdparty.sms.wxtlsms.util.CodingUtils;
import com.bs.plugins.thirdparty.sms.wxtlsms.util.HttpUtil;

public class HttpClientUtil {
    private static Logger logger = Logger.getLogger(HttpClientUtil.class);
    private static HttpClient client = null;

    // 构造单例
    private HttpClientUtil() {

		MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = new HttpConnectionManagerParams();
		// 默认连接超时时间
		params.setConnectionTimeout(5000);
		// 默认读取超时时间
		params.setSoTimeout(10000);
		// 默认单个host最大连接数
		params.setDefaultMaxConnectionsPerHost(100);// very important!!
		// 最大总连接数
		params.setMaxTotalConnections(256);// very important!!
		httpConnectionManager.setParams(params);

		client = new HttpClient(httpConnectionManager);

		client.getParams().setConnectionManagerTimeout(3000);
		// client.getParams().setIntParameter("http.socket.timeout", 10000);
		// client.getParams().setIntParameter("http.connection.timeout", 5000);
    }

    private static class ClientUtilInstance {
    	private static final HttpClientUtil ClientUtil = new HttpClientUtil();
    }

    public static HttpClientUtil getInstance() {
    	return ClientUtilInstance.ClientUtil;
    }

    /**
     * 发送http GET请求，并返回http响应字符串
     *
     * @param urlstr
     *            完整的请求url字符串
     * @return
     */
    public String doGetRequest(String urlstr) {
		String response = "";
		HttpMethod httpmethod = new GetMethod(urlstr);
			try {
			    int statusCode = client.executeMethod(httpmethod);
			    InputStream _InputStream = null;
			    if (statusCode == HttpStatus.SC_OK) {
				_InputStream = httpmethod.getResponseBodyAsStream();
			    }
			    if (_InputStream != null) {
				response = GetResponseString(_InputStream, "UTF-8");
			    }
			} catch (HttpException e) {
			    logger.error("获取响应错误，原因：" + e.getMessage());
			    e.printStackTrace();
			} catch (IOException e) {
			    logger.error("获取响应错误，原因1：" + e.getMessage());
			    e.printStackTrace();
			} finally {
			    httpmethod.releaseConnection();

			}
		return response;
    }

    /**
     *
     * @param _InputStream
     * @param Charset
     * @return
     */
    public String GetResponseString(InputStream _InputStream, String Charset) {
		String response = "";
			try {
			    if (_InputStream != null) {
				StringBuffer buffer = new StringBuffer();
				InputStreamReader isr = new InputStreamReader(_InputStream, Charset);
				Reader in = new BufferedReader(isr);
				int ch;
				while ((ch = in.read()) > -1) {
				    buffer.append((char) ch);
				}
				response = buffer.toString();
				buffer = null;
			    }
			} catch (Exception e) {
			    logger.error("获取响应错误，原因：" + e.getMessage());
			    response = response + e.getMessage();
			    e.printStackTrace();
			}
		return response;
    }

    public static void main(String[] args) throws Exception {

    	send();
    	//fetch();



    	/*<?xml version="1.0" encoding="UTF-8"?>
    	<response>
	    	<error>0</error>
	    	<message>
		    	<srctermid>15011169565</srctermid>
		    	<submitDate>20151127163731</submitDate>
		    	<receiveDate>20151127163735</receiveDate>
		    	<addSerial></addSerial>
		    	<addSerialRev></addSerialRev>
		    	<state>DELIVRD</state>
		    	<seqid>1448613453553</seqid>
		    </message>
		    <message>
		    	<srctermid>15011169565</srctermid>
		    	<submitDate>20151127163746</submitDate>
		    	<receiveDate>20151127163751</receiveDate>
		    	<addSerial></addSerial>
		    	<addSerialRev></addSerialRev>
		    	<state>DELIVRD</state>
		    	<seqid>1448613468327</seqid>
		    </message>
		    <message>
		    	<srctermid>15011169565</srctermid>
		    	<submitDate>20151127163757</submitDate>
		    	<receiveDate>20151127163759</receiveDate>
		    	<addSerial></addSerial>
		    	<addSerialRev></addSerialRev>
		    	<state>DELIVRD</state>
		    	<seqid>1448613478472</seqid>
	    	</message>
    	</response>*/


    	//<?xml version="1.0" encoding="UTF-8"?><response><error>0</error><message></message></response>
    	//<?xml version="1.0" encoding="UTF-8"?><response><error>0</error><message></message></response>


    	//http://hprpt2.eucp.b2m.cn:8080/sdkproxy/regist.action?cdkey=8SDK-EMY-6699-RETMK&password=457263
    }

    public static void send() throws Exception{
    	// URL地址
    	String url = "http://hprpt2.eucp.b2m.cn:8080/sdkproxy/sendsms.action";
    	// 用户序列号
    	//String cdkey = "0SDK-EBB-6699-RCZUN";
    	String cdkey = "8SDK-EMY-6699-RETMK";
    	// 用户密码
    	//String password = "799067";
    	String password = "457263";
    	// 手机号
    	String phone = "1501116956";
    	//String phone = "13146411118";
    	// 短信内容
    	String message = System.currentTimeMillis()+1000+"【学费帮】";
    	// 附加号
    	String addserial = "";//"346007";//
    	// 唯一序列ID
    	String seqid = System.currentTimeMillis()+"";
    	// 短信优先级
    	String smspriority = "1";

    	StringBuffer params = new StringBuffer();
		String result= "";
		try{
			params.append(url)
			.append("?").append("cdkey=").append(cdkey)
			.append("&").append("password=").append(password)
			.append("&").append("phone=").append(phone)
			.append("&").append("message=").append(URLEncoder.encode(message, "UTF-8"))
			.append("&").append("addserial=").append(addserial)
			.append("&").append("seqid=").append(seqid)
			.append("&").append("smspriority=").append(smspriority);
			logger.debug("亿美短信发送参数:" + params.toString());
			result = getInstance().doGetRequest(params.toString());
			logger.debug("亿美短信发送返回结果:" + result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
    }


    public static void fetch() throws Exception{
    	// 获取状态报告
    	String url = "http://hprpt2.eucp.b2m.cn:8080/sdkproxy/getreport.action";
    	// 用户序列号
    	//String cdkey = "0SDK-EBB-6699-RCZUN";
    	String cdkey = "8SDK-EMY-6699-RETMK";
    	// 用户密码
    	//String password = "799067";
    	String password = "457263";

    	StringBuffer params = new StringBuffer();
		String result= "";
		try{
			params.append(url)
			.append("?").append("cdkey=").append(cdkey)
			.append("&").append("password=").append(password);
			logger.debug("亿美短信报告参数:" + params.toString());
			result = getInstance().doGetRequest(params.toString());
			logger.debug("亿美短信报告返回结果:" + result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
    }



}
