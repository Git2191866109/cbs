package com.bs.plugins.custom.tc.spvaccountingdetail.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.pc.product.entity.Product;

public class BaseSpvAccountingDetail extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**SPV公司Id-**/
	private Long spvId;
	/**产品ID-**/
	private Long productId;
	/**交易单号-**/
	private String transactionNumber;
	/**流向-进出账流向 0：出账 1：进账**/
	private Integer flowTo;
	/**金额-入账：正数 出账：负数**/
	private BigDecimal amount;
	/**账户余额-**/
	private BigDecimal accountBalance;
	/**Umpay账户余额-**/
	private BigDecimal umpayAccountBalance;
	/**业务类型-1：认购订单 2：赎回订单 3： 活动 4：充值 5：提现 6：放款入账 7：还款出账 9：充值手续费 10：提现手续费**/
	private Integer businessType;
	/**业务ID-**/
	private Long businessId;
	/**账务类型-1-本金 2-利息 3-手续费 4-服务费 5-本金+利息 6:提现 7:充值**/
	private Integer accountType;
	/**管理员ID-**/
	private Long operatorId;
	/**管理员-平台管理员**/
	private String operator;
	/**描述-**/
	private String description;
	/**创建时间-**/
	private String createTime;
	/**产品管理-产品信息存储表**/
	private Product product;

	public BaseSpvAccountingDetail() {
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
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
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
	
	public Product getProduct () {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
