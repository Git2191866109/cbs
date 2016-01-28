package com.bs.plugins.custom.uc.log.entity;

import com.bs.plugins.custom.uc.log.base.BaseLog;

public class Log extends BaseLog {

	private static final long serialVersionUID = 1L;
	private String isLog;
	private String startTime;
	private String endTime;
	
	public Log() {
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getIsLog() {
		return isLog;
	}

	public void setIsLog(String isLog) {
		this.isLog = isLog;
	}
	
	
}
