package com.bs.plugins.custom.cc.bankcardbinding.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseBankCardBinding extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-**/
	private Long id;
	/**会员主键ID-**/
	private Long memberId;
	/**交易单号-**/
	private String transactionNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**银行卡号-1：身份证 2：警官证 3：护照 4：驾驶证 5：其他**/
	private String cardNumber;
	/**银行账户名-**/
	private String bankAccount;
	/**银行编码-**/
	private String bankCode;
	/**银行名称-**/
	private String bankName;
	/**开户银行名称-**/
	private String openingBankName;
	/**联行号-**/
	private String linkLineNumber;
	/**省份-**/
	private String province;
	/**城市-**/
	private String city;
	/**是否有效-1：有效 0：无效**/
	private Integer isValid;
	/**是否为黑名单-1：是 0：否**/
	private Integer isBlackList;
	/**是否快捷支付卡-0：否 1：是**/
	private Integer isQuickCard;
	/**绑定时间-**/
	private String bindingTime;
	/**解绑时间-**/
	private String unbindTime;
	/**绑定完成时间-**/
	private String finishTime;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseBankCardBinding() {
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
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getOpeningBankName() {
		return openingBankName;
	}

	public void setOpeningBankName(String openingBankName) {
		this.openingBankName = openingBankName;
	}
	public String getLinkLineNumber() {
		return linkLineNumber;
	}

	public void setLinkLineNumber(String linkLineNumber) {
		this.linkLineNumber = linkLineNumber;
	}
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Integer getIsBlackList() {
		return isBlackList;
	}

	public void setIsBlackList(Integer isBlackList) {
		this.isBlackList = isBlackList;
	}
	public Integer getIsQuickCard() {
		return isQuickCard;
	}

	public void setIsQuickCard(Integer isQuickCard) {
		this.isQuickCard = isQuickCard;
	}
	public String getBindingTime() {
		return bindingTime;
	}

	public void setBindingTime(String bindingTime) {
		this.bindingTime = bindingTime;
	}
	public String getUnbindTime() {
		return unbindTime;
	}

	public void setUnbindTime(String unbindTime) {
		this.unbindTime = unbindTime;
	}
	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
