package com.bs.plugins.custom.tc.subscriptioncontract.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.tc.subscription.entity.Subscription;

public class BaseSubscriptionContract extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**交易单号-**/
	private String transactionNumber;
	/**合同模板Id-**/
	private Long contractTemplateId;
	/**合同编号-**/
	private String contactNumber;
	/**备注-**/
	private String remark;
	/**交易中心-客户认购产品数据存储表**/
	private Subscription subscription;

	public BaseSubscriptionContract() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Long getContractTemplateId() {
		return contractTemplateId;
	}

	public void setContractTemplateId(Long contractTemplateId) {
		this.contractTemplateId = contractTemplateId;
	}
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Subscription getSubscription () {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
}
