package com.bs.plugins.custom.tc.spvaccountingdetail.entity;

import com.bs.plugins.custom.tc.spvaccountingdetail.base.BaseSpvAccountingDetail;

public class SpvAccountingDetail extends BaseSpvAccountingDetail {

	private static final long serialVersionUID = 1L;

	public SpvAccountingDetail() {
	}
	
	private String productName;
	
	private String corporationName;
	
	private String startTime;
	
	private String endTime;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
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
