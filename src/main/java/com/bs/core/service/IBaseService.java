package com.bs.core.service;

import org.springframework.beans.factory.InitializingBean;



public interface IBaseService extends InitializingBean {
	/**系统处理状态只有两种成功和失败，且对应success和fail两个视图**/
	public static String SUCCESS = "success";
	public static String FAIL = "fail";
	public static String LEFT = "left";
	public static String TOP = "top";
}
  