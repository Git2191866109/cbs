package com.bs.plugins.custom.tc.spvwithdrawcashrecords.entity;

import com.bs.plugins.custom.tc.spvwithdrawcashrecords.base.BaseSpvWithdrawCashRecords;

public class SpvWithdrawCashRecords extends BaseSpvWithdrawCashRecords {

	private String applyTimeStartTime;

	private String applyTimeEndTime;

	private static final long serialVersionUID = 1L;

	public SpvWithdrawCashRecords() {
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
