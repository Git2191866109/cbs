package com.bs.core.utils;

import com.bs.core.service.SpringContextUtil;

import java.text.MessageFormat;
import java.util.Properties;

/**
 * 属性文件工具类
 * User: zhangqh6
 * Date: 2015/11/16 17:15:15
 */
public class PropertiesUtils {

    /**
     * 根据Property的Key，获取相应的消息内容
     * @param key 键值
     * @return 字符串
     */
    public static String getProperty(String key) {
        return ((Properties) SpringContextUtil.getBean("customSource")).getProperty(key);
    }

    /**
     * 根据Property的Key，获取相应的消息内容，并替换占位符相应内容
     * @param key 键值
     * @param args 占位符对应参数
     * @return 字符串
     */
    public static String getProperty(String key, Object... args) {
        return MessageFormat.format(getProperty(key), args);
    }
}
