package com.bs.plugins.custom.tc.rechargerecords.entity;

import com.bs.plugins.custom.tc.rechargerecords.base.BaseRechargeRecords;

public class RechargeRecords extends BaseRechargeRecords {

	private String applyTimeStartTime;

	private String applyTimeEndTime;

	private static final long serialVersionUID = 1L;

	public RechargeRecords() {
	}

	public String getApplyTimeStartTime() {
		return applyTimeStartTime;
	}

	public void setApplyTimeStartTime(String applyTimeStartTime) {
		this.applyTimeStartTime = applyTimeStartTime;
	}

	public String getApplyTimeEndTime() {
		return applyTimeEndTime;
	}

	public void setApplyTimeEndTime(String applyTimeEndTime) {
		this.applyTimeEndTime = applyTimeEndTime;
	}
}
