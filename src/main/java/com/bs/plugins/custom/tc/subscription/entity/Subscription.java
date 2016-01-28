package com.bs.plugins.custom.tc.subscription.entity;

import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.tc.subscription.base.BaseSubscription;
import com.bs.plugins.custom.tc.subscriptioncontract.entity.SubscriptionContract;

public class Subscription extends BaseSubscription {

	private static final long serialVersionUID = 1L;

	public Subscription() {
		
	}
	
	//开始时间(不通功能里面的开始时间意义不一样)
	private String startTime;
	//结束时间(不通功能里面的结束时间意义不一样)
	private String endTime;
	//批量审核
	private String[] ids;
	
	private String idStr;
	
	private String iDCard;
	
	private String openingBankName;
	
	private Member member;
	
	private Product product;
	
	private String investAmountStr;
	
	private String beginActualExpirationDate;
	
	private String endActualExpirationDate;
	
	private String endSubmitPaymentTime;
	
	private String beginSubmitPaymentTime;
	
	private Long productCategoryId;
	
	private String mobilePhone;
	
	private String categoryName;
	
	private String memberName;
	
	private String spvShortName;
	
	private String umpayAccountNo;
	
	private String spvUmpayAccountNo;
	
	private String spvUmpayMerchantNo;
	
	private SubscriptionContract subscriptionContracts;
	
	public SubscriptionContract getSubscriptionContracts() {
		return subscriptionContracts;
	}

	public void setSubscriptionContracts(SubscriptionContract subscriptionContracts) {
		this.subscriptionContracts = subscriptionContracts;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getOpeningBankName() {
		return openingBankName;
	}

	public void setOpeningBankName(String openingBankName) {
		this.openingBankName = openingBankName;
	}

	public String getInvestAmountStr() {
		return investAmountStr;
	}

	public void setInvestAmountStr(String investAmountStr) {
		this.investAmountStr = investAmountStr;
	}

	public String getBeginActualExpirationDate() {
		return beginActualExpirationDate;
	}

	public void setBeginActualExpirationDate(String beginActualExpirationDate) {
		this.beginActualExpirationDate = beginActualExpirationDate;
	}

	public String getEndActualExpirationDate() {
		return endActualExpirationDate;
	}

	public void setEndActualExpirationDate(String endActualExpirationDate) {
		this.endActualExpirationDate = endActualExpirationDate;
	}

	public String getEndSubmitPaymentTime() {
		return endSubmitPaymentTime;
	}

	public void setEndSubmitPaymentTime(String endSubmitPaymentTime) {
		this.endSubmitPaymentTime = endSubmitPaymentTime;
	}

	public String getBeginSubmitPaymentTime() {
		return beginSubmitPaymentTime;
	}

	public void setBeginSubmitPaymentTime(String beginSubmitPaymentTime) {
		this.beginSubmitPaymentTime = beginSubmitPaymentTime;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getiDCard() {
		return iDCard;
	}

	public void setiDCard(String iDCard) {
		this.iDCard = iDCard;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSpvShortName() {
		return spvShortName;
	}

	public void setSpvShortName(String spvShortName) {
		this.spvShortName = spvShortName;
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
}
