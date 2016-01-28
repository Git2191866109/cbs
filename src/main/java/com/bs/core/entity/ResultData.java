package com.bs.core.entity;

import java.io.Serializable;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public class ResultData extends ModelAndView implements Serializable {

	private static final long serialVersionUID = 5574468630643899188L;
	
	/**系统操作状态**/
	private String status;
	/**系统操作状态如有异常设置该参数**/
	private String statusException;
	/**系统操作提示信息**/
	private String promptMessage;
	/**自定义消息后缀**/
	public static String messageSuffix;
	/**实体bean对象**/
	private Entity resultEntity;
	/**字符串对象**/
	private String resultString;
	/**下载文件路径*/
	private String downloadFilePath;
	/**下载文件名称*/
	private String downloadFileName;
	
	private BindingResult bindingResult;
	
	private Map<String, Object> resultMap;
	
	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}
	public String getStatusException() {
		return statusException;
	}
	public void setStatusException(String statusException) {
		this.statusException = statusException;
	}
	public String getMessageSuffix() {
		return messageSuffix;
	}
	public static void setMessageSuffix(String messageSuffix) {
		ResultData.messageSuffix = messageSuffix;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPromptMessage() {
		return promptMessage;
	}
	public BindingResult getBindingResult() {
		return bindingResult;
	}
	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	public Entity getResultEntity() {
		return resultEntity;
	}
	public void setResultEntity(Entity resultEntity) {
		this.resultEntity = resultEntity;
	}
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	public String getDownloadFilePath() {
		return downloadFilePath;
	}
	public void setDownloadFilePath(String downloadFilePath) {
		this.downloadFilePath = downloadFilePath;
	}
	public String getDownloadFileName() {
		return downloadFileName;
	}
	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
	
}
