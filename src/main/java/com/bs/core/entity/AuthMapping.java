package com.bs.core.entity;

import java.io.Serializable;



public class AuthMapping implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**key**/
	private String key;
	/**权限代码**/
	private String code;
	/**视图名称**/
	private String viewName;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
}
