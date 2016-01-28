package com.bs.plugins.custom.tc.withdrawcashrecords.entity;

import com.bs.plugins.custom.tc.withdrawcashrecords.base.BaseWithdrawCashRecords;

public class WithdrawCashRecords extends BaseWithdrawCashRecords {

	private String applyTimeStartTime;

	private String applyTimeEndTime;

	private static final long serialVersionUID = 1L;

	public WithdrawCashRecords() {
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
