package com.bs.plugins.system.entity;

import java.util.ArrayList;




public class Config extends Entity{
	
	private static final long serialVersionUID = 1L;
	/**权限名称**/
	private String name;
	/**权限代码**/
	private String code;
	/**权限代码**/
	private String codeKey;
	/**视图名称**/
	private String viewName;
	/**节点名称**/
	private String nodeName;
	/**视图类型**/
	private String viewType;
	/**模型名称**/
	private String modelName;
	/**模型名称前缀**/
	private String modelNamePrefix;
	/**模型名称后缀**/
	private String modelNameSuffix;
	/**模型文件路径名称**/
	private String modelPathName;
	/**方法名称**/
	private String methodName;
	/**模板名称**/
	private String templateName;
	/**节点层级**/
	private Integer level;
	/**功能类型**/
	private String menuType;
	/**文件绝对路径**/
	private String pluginConfigAbsolutePath;
	/**文件绝对路径**/
	private String pluginConfigFileName;
	/**列表快捷功能**/
	private ArrayList<Config> shortcuts;
	
	public Config(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getPluginConfigAbsolutePath() {
		return pluginConfigAbsolutePath;
	}

	public void setPluginConfigAbsolutePath(String pluginConfigAbsolutePath) {
		this.pluginConfigAbsolutePath = pluginConfigAbsolutePath;
	}

	public String getPluginConfigFileName() {
		return pluginConfigFileName;
	}

	public void setPluginConfigFileName(String pluginConfigFileName) {
		this.pluginConfigFileName = pluginConfigFileName;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getModelPathName() {
		return modelPathName;
	}

	public void setModelPathName(String modelPathName) {
		this.modelPathName = modelPathName;
	}

	public String getModelNamePrefix() {
		return modelNamePrefix;
	}

	public void setModelNamePrefix(String modelNamePrefix) {
		this.modelNamePrefix = modelNamePrefix;
	}

	public String getModelNameSuffix() {
		return modelNameSuffix;
	}

	public void setModelNameSuffix(String modelNameSuffix) {
		this.modelNameSuffix = modelNameSuffix;
	}

	public ArrayList<Config> getShortcuts() {
		return shortcuts;
	}

	public void setShortcuts(ArrayList<Config> shortcuts) {
		this.shortcuts = shortcuts;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}
	
}

