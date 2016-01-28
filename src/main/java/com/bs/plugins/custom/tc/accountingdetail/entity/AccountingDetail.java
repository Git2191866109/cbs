package com.bs.plugins.custom.tc.accountingdetail.entity;

import com.bs.plugins.custom.tc.accountingdetail.base.BaseAccountingDetail;

public class AccountingDetail extends BaseAccountingDetail {

	private static final long serialVersionUID = 1L;

	public AccountingDetail() {
	}
	
	private String startTime;
	
	private String endTime;
	
	private String counterpartyName;

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
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
