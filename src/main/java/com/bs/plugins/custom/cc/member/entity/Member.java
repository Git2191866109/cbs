package com.bs.plugins.custom.cc.member.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.cc.member.base.BaseMember;

public class Member extends BaseMember {

	private static final long serialVersionUID = 1L;

	public Member() {
	}

	private String startTime;
	private String endTime;
	/**
	 * 重复密码
	 */
	private String confirmPassword;
	/**余额-**/
	private BigDecimal availableAmount;
	/**冻结金额-**/
	private BigDecimal frozenAmount;
	/**冻结金额-**/
	private BigDecimal freeChargeAmount;
	/**证件号码-**/
	@NotEmpty
	private String certificateNo;
	public BigDecimal getFreeChargeAmount() {
		return freeChargeAmount;
	}

	public void setFreeChargeAmount(BigDecimal freeChargeAmount) {
		this.freeChargeAmount = freeChargeAmount;
	}

	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}

	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
