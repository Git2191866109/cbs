package com.bs.core.initialize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitializeData {

	//图片上传路径
	private Map<String,String > picUploadUrl;

	public Map<String, String> getPicUploadUrl() {
		return picUploadUrl;
	}

	public void setPicUploadUrl(Map<String, String> picUploadUrl) {
		this.picUploadUrl = picUploadUrl;
	}

	/**
	 * 系统配置文件数据初始化存储对象
	 */
	public Map<String, List<Object>> configFileData;

	
	public Map<String, List<Object>> getConfigFileData() {
		return configFileData;
	}

	public void setConfigFileData(Map<String, List<Object>> configFileData) {
		this.configFileData = configFileData;
	}

	/**
	 * 系统数据库数据自定义初始化存储对象
	 */
	public Map<String,Object> databaseData = new HashMap<String,Object>();


	public Map<String, Object> getDatabaseData() {
		return databaseData;
	}

	public void setDatabaseData(Map<String, Object> databaseData) {
		this.databaseData = databaseData;
	}
	
	
}
