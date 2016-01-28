package com.bs.plugins.custom.tc.appointment.entity;

import com.bs.plugins.custom.tc.appointment.base.BaseAppointment;

public class Appointment extends BaseAppointment {

	private static final long serialVersionUID = 1L;

	private String startTime; // 开始时间
	private String endTime; // 结束时间


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


	public Appointment() {
	}

}
