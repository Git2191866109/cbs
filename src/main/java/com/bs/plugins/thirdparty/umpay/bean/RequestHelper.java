package com.bs.plugins.thirdparty.umpay.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.bs.core.common.Constant;
import com.bs.plugins.thirdparty.umpay.constants.IParam;
import com.bs.plugins.thirdparty.umpay.constants.UMPayCfg;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.umpay.api.common.ReqData;
import com.umpay.api.exception.ReqDataException;
import com.umpay.api.paygate.v40.Mer2Plat_v40;

import javax.annotation.Resource;

/**
 * User: zhangqh6
 * Date: 2015/12/28 13:48:48
 */
public class RequestHelper {

    private static Properties propertiesUtil = UMPayCfg.instance.getCustomSource();

    private Map<String, String> requestData;

    private RequestHelper() {
        requestData = new HashMap<String, String>();
    }

    public Map<String, String> getRequestData() {
        return requestData;
    }

    public void put(String key, String value) {
        if(StringUtils.isNotBlank(value)) {
            requestData.put(key, value);
        }
    }

    public static String  getProperty(String... key) {
        StringBuffer keyBuffer = new StringBuffer();
        keyBuffer.append("umpay");
        for (String s : key) {
            keyBuffer.append(".").append(s);
        }

        return propertiesUtil.getProperty(keyBuffer.toString().replaceAll("_","."));
    }
    
    public static RequestHelper getInstance(String interfaceName) {
    	return getInstance(interfaceName, null);
    }

    public static RequestHelper getInstance(String interfaceName,String flag) {
        RequestHelper requestHelper = new RequestHelper();
        requestHelper.put(IParam.PUB.SERVICE,interfaceName);
        requestHelper.put(IParam.PUB.SIGN_TYPE,getProperty(IParam.PUB.SIGN_TYPE));
        requestHelper.put(IParam.PUB.CHARSET, getProperty(IParam.PUB.CHARSET));
        requestHelper.put(IParam.PUB.RES_FORMAT, getProperty(IParam.PUB.RES_FORMAT));
        requestHelper.put(IParam.PUB.MER_ID, getProperty(IParam.PUB.MER_ID));
        requestHelper.put(IParam.PUB.VERSION,getProperty(IParam.PUB.VERSION));

        String retUrl = getProperty(IParam.PUB.RET_URL,interfaceName,flag);
        if(StringUtils.isNotBlank(retUrl)) {
            requestHelper.put(IParam.PUB.RET_URL, retUrl);
        }
        String notifyUrl = getProperty(IParam.PUB.NOTIFY_URL , interfaceName,flag);
        if(StringUtils.isNotBlank(notifyUrl)) {
            requestHelper.put(IParam.PUB.NOTIFY_URL, notifyUrl);
        }

        String notifyFlag = getProperty(IParam.PUB.APPLY_NOTIFY_FLAG, interfaceName,flag);
        if(StringUtils.isNotBlank(notifyFlag)) {
            requestHelper.put(IParam.PUB.APPLY_NOTIFY_FLAG, notifyFlag);
        }
        return requestHelper;
    }

    public ReqData makeReqDataByPost() throws ReqDataException {
        return  Mer2Plat_v40.makeReqDataByPost(getRequestData());
    }

    public ReqData makeReqDataByGet() throws ReqDataException {
        return  Mer2Plat_v40.makeReqDataByGet(getRequestData());
    }
}
