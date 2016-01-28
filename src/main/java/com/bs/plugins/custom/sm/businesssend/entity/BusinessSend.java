package com.bs.plugins.custom.sm.businesssend.entity;

import com.bs.plugins.custom.sm.businesssend.base.BaseBusinessSend;

public class BusinessSend extends BaseBusinessSend {

	private static final long serialVersionUID = 1L;

	public BusinessSend() {
	}
	
	private String startTime; // 开始时间
	
	private String endTime; // 结束时间
	
	private Long now;// 当前时间的毫秒值
	
	
	public Long getNow() {
		return now;
	}

	public void setNow(Long now) {
		this.now = now;
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

}
