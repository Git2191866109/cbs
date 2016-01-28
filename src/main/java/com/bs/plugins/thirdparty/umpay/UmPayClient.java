package com.bs.plugins.thirdparty.umpay;

import com.bs.core.common.Constant;
import com.bs.plugins.thirdparty.umpay.bean.PaymentData;
import com.bs.plugins.thirdparty.umpay.bean.RequestHelper;
import com.bs.plugins.thirdparty.umpay.constants.IParam;
import com.bs.plugins.thirdparty.umpay.constants.IServiceConst;
import com.umpay.api.common.ReqData;
import com.umpay.api.paygate.v40.Mer2Plat_v40;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;

/**
 * User: zhangqh6
 * Date: 2016/1/4 16:29:29
 */
public class UmPayClient {

    public static Logger logger = Logger.getLogger(UmPayClient.class);

    /**
     * http 底层请求,调用支付平台
     * @param url
     * @param paramMap
     * @return
     */
    public static Map<String,String> callPaymentPlantQuery(String url, Map<String, String> paramMap) {
        DefaultHttpClient httpclient = null;
        try {
            // 允许客户端访问的账号和密码
            // 默认httpclient 对象
            httpclient = new DefaultHttpClient();
            logger.debug("==>http request post submit url is：" + url);
            // http post对象
            HttpPost httpPost = new HttpPost(url);

            // http参数传送对象
            MultipartEntity multipartEntity = new MultipartEntity();
            httpPost.setEntity(multipartEntity);
            // 自定义传值
            if (paramMap != null) {
                Iterator<String> iterator = paramMap.keySet().iterator();
                while(iterator.hasNext()){
                    String key = iterator.next();
                    String value = paramMap.get(key);
                    if (value == null){
                        continue;
                    }
                    multipartEntity.addPart(key, new StringBody(value));
                }
            }
            // 设置到httpPost中
            httpPost.setEntity(multipartEntity);
            try {
                // 提交请求
                HttpResponse rsp = httpclient.execute(httpPost);
                // json数据
                String content = EntityUtils.toString(rsp.getEntity(), Constant.ENCODING);
                if (content != null){
                    //获取报文名称
                    String messgeName = null; /*= customSource.getProperty(Constant.FUNDS_CUSTODIAN_TRADE_RESPONSE_MESSAGE_NAME);*/
                    if (messgeName == null || messgeName.equals("")){
                        messgeName = "MobilePayPlatform";
                    }
                    //解析返回结果
                    return HtmlParseUtil.xmlToMap(content, messgeName);
                }
            } catch (ConnectTimeoutException cte) {
                System.out.println("请求通信[" + url + "]时连接超时");
                cte.printStackTrace();
            } catch (SocketTimeoutException ste) {
                System.out.println("请求通信[" + url + "]时读取超时");
                ste.printStackTrace();
            } catch (ClientProtocolException cpe) {
                System.out.println("请求通信[" + url + "]时协议异常");
                cpe.printStackTrace();
            } catch (IOException ioe) {
                System.out.println("请求通信[" + url + "]时网络异常");
                ioe.printStackTrace();
            } catch (Exception e) {
                System.out.println("请求通信[" + url + "]时偶遇异常");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if (httpclient != null) {
                httpclient.getConnectionManager().shutdown();
            }
        }
        return null;
    }

    /**
     * http 底层请求,调用支付平台
     * @param url
     * @param paramMap
     * @return
     */
    public static PaymentData callPaymentPlant(String url, Map<String, String> paramMap) {
        DefaultHttpClient httpclient = null;
        try {
            // 允许客户端访问的账号和密码
            // 默认httpclient 对象
            httpclient = new DefaultHttpClient();
            logger.debug("==>http request post submit url is：" + url);
            // http post对象
            HttpPost httpPost = new HttpPost(url);

            // http参数传送对象
            MultipartEntity multipartEntity = new MultipartEntity();
            httpPost.setEntity(multipartEntity);
            // 自定义传值
            if (paramMap != null) {
                Iterator<String> iterator = paramMap.keySet().iterator();
                while(iterator.hasNext()){
                    String key = iterator.next();
                    String value = paramMap.get(key);
                    if (value == null){
                        continue;
                    }
                    multipartEntity.addPart(key, new StringBody(value));
                }
            }
            // 设置到httpPost中
            httpPost.setEntity(multipartEntity);
            try {
                // 提交请求
                HttpResponse rsp = httpclient.execute(httpPost);
                // json数据
                String content = EntityUtils.toString(rsp.getEntity(), Constant.ENCODING);
                if (content != null){
                    //获取报文名称
                    String messgeName = null; /*= customSource.getProperty(Constant.FUNDS_CUSTODIAN_TRADE_RESPONSE_MESSAGE_NAME);*/
                    if (messgeName == null || messgeName.equals("")){
                        messgeName = "MobilePayPlatform";
                    }
                    //解析返回结果
                    Map<String,String> resultMap = HtmlParseUtil.xmlToMap(content, messgeName);
                    //结果返回
                    PaymentData paymentData = new PaymentData();
                    //map拷贝到bean对象中
                    BeanUtils.populate(paymentData, resultMap);
                    return paymentData;
                }
            } catch (ConnectTimeoutException cte) {
                System.out.println("请求通信[" + url + "]时连接超时");
                cte.printStackTrace();
            } catch (SocketTimeoutException ste) {
                System.out.println("请求通信[" + url + "]时读取超时");
                ste.printStackTrace();
            } catch (ClientProtocolException cpe) {
                System.out.println("请求通信[" + url + "]时协议异常");
                cpe.printStackTrace();
            } catch (IOException ioe) {
                System.out.println("请求通信[" + url + "]时网络异常");
                ioe.printStackTrace();
            } catch (Exception e) {
                System.out.println("请求通信[" + url + "]时偶遇异常");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if (httpclient != null) {
                httpclient.getConnectionManager().shutdown();
            }
        }
        return null;
    }
}
