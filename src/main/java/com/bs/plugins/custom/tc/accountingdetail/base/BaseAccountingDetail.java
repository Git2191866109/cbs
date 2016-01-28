package com.bs.plugins.custom.tc.accountingdetail.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.pc.product.entity.Product;

public class BaseAccountingDetail extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**会员Id-**/
	private Long memberId;
	/**产品ID-**/
	private Long productId;
	/**流向-进出账流向 0 出账 1 进账**/
	private Integer flowTo;
	/**金额-入账：正数 出账：负数**/
	private BigDecimal amount;
	/**账户余额-**/
	private BigDecimal accountBalance;
	/**Umpay账户余额-**/
	private BigDecimal umpayAccountBalance;
	/**交易对手类型-1: 学费帮 2：SPV 3：会员**/
	private Integer counterpartyType;
	/**交易对手Id-**/
	private Long counterpartyId;
	/**业务类型-1：认购订单 2：赎回订单 3： 活动 4：充值 5：提现 6：返款**/
	private Integer businessType;
	/**业务ID-**/
	private Long businessId;
	/**账务类型-1-本金 2-利息 3-手续费 4-服务费 5-本金+利息 6:提现 7:充值**/
	private Integer accountType;
	/**交易单号-**/
	private String transactionNumber;
	/**管理员ID-**/
	private Long operatorId;
	/**管理员-平台管理员**/
	private String operator;
	/**描述-**/
	private String description;
	/**创建时间-**/
	private String createTime;
	/**用户中心-会员信息存储表**/
	private Member member;
	/**产品管理-产品信息存储表**/
	private Product product;

	public BaseAccountingDetail() {
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
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getFlowTo() {
		return flowTo;
	}

	public void setFlowTo(Integer flowTo) {
		this.flowTo = flowTo;
	}
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public BigDecimal getUmpayAccountBalance() {
		return umpayAccountBalance;
	}

	public void setUmpayAccountBalance(BigDecimal umpayAccountBalance) {
		this.umpayAccountBalance = umpayAccountBalance;
	}
	public Integer getCounterpartyType() {
		return counterpartyType;
	}

	public void setCounterpartyType(Integer counterpartyType) {
		this.counterpartyType = counterpartyType;
	}
	public Long getCounterpartyId() {
		return counterpartyId;
	}

	public void setCounterpartyId(Long counterpartyId) {
		this.counterpartyId = counterpartyId;
	}
	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}
	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
}
