package com.bs.plugins.custom.tc.spvrechargerecords.entity;

import com.bs.plugins.custom.tc.spvrechargerecords.base.BaseSpvRechargeRecords;

public class SpvRechargeRecords extends BaseSpvRechargeRecords {

	private String applyTimeStartTime;

	private String applyTimeEndTime;

	private static final long serialVersionUID = 1L;

	public SpvRechargeRecords() {
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
