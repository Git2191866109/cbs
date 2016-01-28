package com.bs.plugins.custom.tc.productamountlock.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.tc.subscription.entity.Subscription;	
import java.util.ArrayList;

public class BaseProductAmountLock extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**产品Id-**/
	private Long productId;
	/**SPV公司Id-**/
	private Long spvId;
	/**会员Id-**/
	private Long memberId;
	/**产品名称-**/
	private String productName;
	/**产品代码-**/
	private String productCode;
	/**交易单号-**/
	private String transactionNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**产品账户号-**/
	private String umpayProductAccountNo;
	/**锁定金额-**/
	private Integer lockAmount;
	/**份额-**/
	private Integer shares;
	/**资金转入状态-0：等待转入 1：转入成功 2：转入失败**/
	private Integer intoStatus;
	/**处理状态-注释：是否将已锁定并且支付成功的临时锁定处理到订单表 0 ： 未处理 1 ： 已处理**/
	private Integer handleStatus;
	/**处理完成时间-**/
	private String finishTime;
	/**认购时间-**/
	private String subsTime;
	/**过期时间-**/
	private Long expireTime;
	/**备注-**/
	private String remark;
	/**用户中心-会员信息存储表**/
	private Member member;
	/**产品管理-产品信息存储表**/
	private Product product;
	/**交易中心-客户认购产品数据存储表**/
	private ArrayList<Subscription> subscriptions;

	public BaseProductAmountLock() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getSpvId() {
		return spvId;
	}

	public void setSpvId(Long spvId) {
		this.spvId = spvId;
	}
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	public String getUmpayProductAccountNo() {
		return umpayProductAccountNo;
	}

	public void setUmpayProductAccountNo(String umpayProductAccountNo) {
		this.umpayProductAccountNo = umpayProductAccountNo;
	}
	public Integer getLockAmount() {
		return lockAmount;
	}

	public void setLockAmount(Integer lockAmount) {
		this.lockAmount = lockAmount;
	}
	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}
	public Integer getIntoStatus() {
		return intoStatus;
	}

	public void setIntoStatus(Integer intoStatus) {
		this.intoStatus = intoStatus;
	}
	public Integer getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(Integer handleStatus) {
		this.handleStatus = handleStatus;
	}
	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getSubsTime() {
		return subsTime;
	}

	public void setSubsTime(String subsTime) {
		this.subsTime = subsTime;
	}
	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
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
	public Product getProduct () {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public ArrayList<Subscription> getSubscription () {
		return subscriptions;
	}

	public void setSubscription(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}	
}
