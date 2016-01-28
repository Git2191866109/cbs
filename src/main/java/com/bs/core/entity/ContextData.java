package com.bs.core.entity;

public class ContextData {

	/**url 前缀  例如：/goto  /form/submit **/
	private String urlPrefix;
	/**模型名称**/
	private String model;
	/**方法名称**/
	private String method;
	/**权限code 代码**/
	private String code;
	/**实体对象**/
	private Object command;
	/**请求URL**/
	private String requestUrl;
	/**视图名称**/
	private String viewName;


	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getCommand() {
		return command;
	}

	public void setCommand(Object command) {
		this.command = command;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
}
