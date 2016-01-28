package com.bs.plugins.custom.tc.withdrawcashrecords.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseWithdrawCashRecords extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**会员主键Id-**/
	private Long memberId;
	/**交易单号-**/
	private String transactionNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**提现金额-**/
	private BigDecimal amount;
	/**证件类型-**/
	private Integer iDCardType;
	/**证件号码-**/
	private String iDCard;
	/**银行名称-**/
	private String bankName;
	/**银行代码-**/
	private String bankCode;
	/**银行卡号-**/
	private String bankCardNumber;
	/**提现完成时间-**/
	private String finishTime;
	/**提现申请时间-**/
	private String applyTime;
	/**手续费收费方式-1：交易方承担（客户） 2：平台商户承担（学费帮）**/
	private Integer handlingChargeType;
	/**提现手续费-**/
	private BigDecimal handlingCharge;
	/**提现状态-0：提现失败 1：提现成功 2：提现冻结**/
	private Integer status;
	/**是否为问题单-1：是 0：否**/
	private Integer isQuestionnaire;
	/**对账时间-**/
	private String checkingTime;
	/**对帐状态-**/
	private Integer checkingStatus;
	/**备注-**/
	private String remark;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseWithdrawCashRecords() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getPayPlantformNumber() {
		return payPlantformNumber;
	}

	public void setPayPlantformNumber(String payPlantformNumber) {
		this.payPlantformNumber = payPlantformNumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getIDCardType() {
		return iDCardType;
	}

	public void setIDCardType(Integer iDCardType) {
		this.iDCardType = iDCardType;
	}
	public String getIDCard() {
		return iDCard;
	}

	public void setIDCard(String iDCard) {
		this.iDCard = iDCard;
	}
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public Integer getHandlingChargeType() {
		return handlingChargeType;
	}

	public void setHandlingChargeType(Integer handlingChargeType) {
		this.handlingChargeType = handlingChargeType;
	}
	public BigDecimal getHandlingCharge() {
		return handlingCharge;
	}

	public void setHandlingCharge(BigDecimal handlingCharge) {
		this.handlingCharge = handlingCharge;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsQuestionnaire() {
		return isQuestionnaire;
	}

	public void setIsQuestionnaire(Integer isQuestionnaire) {
		this.isQuestionnaire = isQuestionnaire;
	}
	public String getCheckingTime() {
		return checkingTime;
	}

	public void setCheckingTime(String checkingTime) {
		this.checkingTime = checkingTime;
	}
	public Integer getCheckingStatus() {
		return checkingStatus;
	}

	public void setCheckingStatus(Integer checkingStatus) {
		this.checkingStatus = checkingStatus;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
