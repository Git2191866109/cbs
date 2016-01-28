package com.bs.plugins.custom.tc.spvrechargerecords.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;

public class BaseSpvRechargeRecords extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**Spv公司主键Id-**/
	private Long spvId;
	/**Spv公司名称-**/
	private String spvName;
	/**交易单号-**/
	private String transactionNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**充值金额-**/
	private BigDecimal amount;
	/**银行名称-**/
	private String bankName;
	/**银行代码-**/
	private String bankCode;
	/**银行卡号-**/
	private String bankCardNumber;
	/**充值手续费-**/
	private BigDecimal handlingCharge;
	/**手续费收费方式-1：交易方承担（客户） 2：平台商户承担（学费帮）**/
	private Integer handlingChargeType;
	/**充值申请时间-**/
	private String applyTime;
	/**充值完成时间-**/
	private String finishTime;
	/**充值状态-0：充值失败 1：充值成功 2：充值创建**/
	private Integer status;
	/**是否为问题单-1：是 0：否**/
	private Integer isQuestionnaire;
	/**对账时间-**/
	private String checkingTime;
	/**对帐状态-**/
	private Integer checkingStatus;
	/**备注-**/
	private String remark;
	/**用户中心-SPV公司信息表**/
	private SpvCorporation spvCorporation;

	public BaseSpvRechargeRecords() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getSpvId() {
		return spvId;
	}

	public void setSpvId(Long spvId) {
		this.spvId = spvId;
	}
	public String getSpvName() {
		return spvName;
	}

	public void setSpvName(String spvName) {
		this.spvName = spvName;
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
	public BigDecimal getHandlingCharge() {
		return handlingCharge;
	}

	public void setHandlingCharge(BigDecimal handlingCharge) {
		this.handlingCharge = handlingCharge;
	}
	public Integer getHandlingChargeType() {
		return handlingChargeType;
	}

	public void setHandlingChargeType(Integer handlingChargeType) {
		this.handlingChargeType = handlingChargeType;
	}
	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
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
	
	public SpvCorporation getSpvCorporation () {
		return spvCorporation;
	}

	public void setSpvCorporation(SpvCorporation spvCorporation) {
		this.spvCorporation = spvCorporation;
	}
}
