package com.bs.plugins.custom.tc.productreturnmoney.entity;

import com.bs.plugins.custom.tc.productreturnmoney.base.BaseProductReturnMoney;

public class ProductReturnMoney extends BaseProductReturnMoney {

	private static final long serialVersionUID = 1L;

	public ProductReturnMoney() {
	}
	
	private String[] ids;
	
	private String idStr;
	
	private String startTime;
	
	private String endTime;
	
	private String distributePrincipalStr;
	
	private String distributeInterestStr;
	
	private String distributeAmountStr;
	
	private String actualReturnAmountStr;
	
	private String memberName;
	
	private String umpayAccountNo;
	
	private String spvUmpayAccountNo;
	
	private String spvUmpayMerchantNo;
	
	private String umpayUserNo;
	
	private String umpayUserAccountNo;
	
	private String orderTime;
	
	private String mobilePhone;
	
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
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

	public String getDistributePrincipalStr() {
		return distributePrincipalStr;
	}

	public void setDistributePrincipalStr(String distributePrincipalStr) {
		this.distributePrincipalStr = distributePrincipalStr;
	}

	public String getDistributeInterestStr() {
		return distributeInterestStr;
	}

	public void setDistributeInterestStr(String distributeInterestStr) {
		this.distributeInterestStr = distributeInterestStr;
	}

	public String getDistributeAmountStr() {
		return distributeAmountStr;
	}

	public void setDistributeAmountStr(String distributeAmountStr) {
		this.distributeAmountStr = distributeAmountStr;
	}

	public String getActualReturnAmountStr() {
		return actualReturnAmountStr;
	}

	public void setActualReturnAmountStr(String actualReturnAmountStr) {
		this.actualReturnAmountStr = actualReturnAmountStr;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getUmpayAccountNo() {
		return umpayAccountNo;
	}

	public void setUmpayAccountNo(String umpayAccountNo) {
		this.umpayAccountNo = umpayAccountNo;
	}

	public String getSpvUmpayAccountNo() {
		return spvUmpayAccountNo;
	}

	public void setSpvUmpayAccountNo(String spvUmpayAccountNo) {
		this.spvUmpayAccountNo = spvUmpayAccountNo;
	}

	public String getSpvUmpayMerchantNo() {
		return spvUmpayMerchantNo;
	}

	public void setSpvUmpayMerchantNo(String spvUmpayMerchantNo) {
		this.spvUmpayMerchantNo = spvUmpayMerchantNo;
	}

	public String getUmpayUserNo() {
		return umpayUserNo;
	}

	public void setUmpayUserNo(String umpayUserNo) {
		this.umpayUserNo = umpayUserNo;
	}

	public String getUmpayUserAccountNo() {
		return umpayUserAccountNo;
	}

	public void setUmpayUserAccountNo(String umpayUserAccountNo) {
		this.umpayUserAccountNo = umpayUserAccountNo;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
}
