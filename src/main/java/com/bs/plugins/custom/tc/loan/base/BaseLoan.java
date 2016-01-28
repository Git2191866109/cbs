package com.bs.plugins.custom.tc.loan.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.tc.subscription.entity.Subscription;	
import com.bs.plugins.custom.tc.platformservicefee.entity.PlatformServiceFee;	
import java.util.ArrayList;

public class BaseLoan extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**SPV公司Id-**/
	private Long spvId;
	/**产品主键Id-**/
	private Long productId;
	/**放款交易号-**/
	private String tradeNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**产品名称-**/
	private String productName;
	/**产品代码-**/
	private String productCode;
	/**放款总金额-**/
	private BigDecimal totalLoanAmount;
	/**Spv服务费-**/
	private BigDecimal spvServiceFee;
	/**Spv服务费费率-**/
	private BigDecimal spvServiceFeeRatio;
	/**放款时间-**/
	private String loanTime;
	/**放款状态-0：未放款 1：已放款 2：放款成功 3：放款失败 4：拒绝放款**/
	private Integer loanStatus;
	/**对账时间-**/
	private String checkingTime;
	/**对帐状态-0：未对账 1：对账成功 2：对账失败**/
	private Integer checkingStatus;
	/**备注-**/
	private String remark;
	/**产品管理-产品信息存储表**/
	private Product product;
	/**交易中心-客户认购产品数据存储表**/
	private ArrayList<Subscription> subscriptions;
	/**交易中心-平台服务费信息存储表**/
	private ArrayList<PlatformServiceFee> platformServiceFees;

	public BaseLoan() {
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
	public String getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getPayPlantformNumber() {
		return payPlantformNumber;
	}

	public void setPayPlantformNumber(String payPlantformNumber) {
		this.payPlantformNumber = payPlantformNumber;
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
	public BigDecimal getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}
	public BigDecimal getSpvServiceFee() {
		return spvServiceFee;
	}

	public void setSpvServiceFee(BigDecimal spvServiceFee) {
		this.spvServiceFee = spvServiceFee;
	}
	public BigDecimal getSpvServiceFeeRatio() {
		return spvServiceFeeRatio;
	}

	public void setSpvServiceFeeRatio(BigDecimal spvServiceFeeRatio) {
		this.spvServiceFeeRatio = spvServiceFeeRatio;
	}
	public String getLoanTime() {
		return loanTime;
	}

	public void setLoanTime(String loanTime) {
		this.loanTime = loanTime;
	}
	public Integer getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(Integer loanStatus) {
		this.loanStatus = loanStatus;
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
	public ArrayList<PlatformServiceFee> getPlatformServiceFee () {
		return platformServiceFees;
	}

	public void setPlatformServiceFee(ArrayList<PlatformServiceFee> platformServiceFees) {
		this.platformServiceFees = platformServiceFees;
	}	
}
