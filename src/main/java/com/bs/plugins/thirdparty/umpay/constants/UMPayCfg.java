package com.bs.plugins.thirdparty.umpay.constants;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Properties;

/**
 * User: zhangqh6
 * Date: 2016/1/4 15:55:55
 */
@Component
public class UMPayCfg implements InitializingBean {

    public static UMPayCfg instance = null;

    @Autowired
    public Properties customSource;

    public Properties getCustomSource() {
        return customSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

//    //值映射关系配置
//    private  Map<String,Map<String,String>> valMapper;
//
//    //回调页面地址配置
//    private  Map<String,String>  retUrlCfg = null;
//
//    //通知接口地址配置
//    private  Map<String,String>  notifyUrl = null;


//    public void setValMapper(Map<String, Map<String, String>> valMapper) {
//        this.valMapper = valMapper;
//    }
//
//
//    public void setRetUrlCfg(Map<String, String> retUrlCfg) {
//        this.retUrlCfg = retUrlCfg;
//    }
//
//
//    public void setNotifyUrl(Map<String, String> notifyUrl) {
//        this.notifyUrl = notifyUrl;
//    }



//    /**
//     * 获取转换后的值
//     * @param paramCode
//     * @param originalValue
//     * @return
//     */
//    public  String getMapValue(String paramCode, String originalValue) throws Exception {
//        if(valMapper.containsKey(paramCode)) {
//            Map<String, String> tempMap = valMapper.get(paramCode);
//            if(tempMap.containsKey(originalValue)) {
//                return valMapper.get(paramCode).get(originalValue);
//            }else {
//                throw new Exception("不存在该参数！");
//            }
//        }
//        return originalValue;
//    }
//
//    /**
//     * 获取回调页面地址
//     * @param interfaceName
//     * @return
//     */
//    public String  getRetUrl(String interfaceName) {
//        return retUrlCfg.get(interfaceName);
//    }
//
//    /**
//     * 获取异步通知接口地址
//     * @param interfaceName
//     * @return
//     */
//    public String  getNotifyUrl(String interfaceName) {
//        return notifyUrl.get(interfaceName);
//    }


}
