package com.bs.plugins.custom.tc.platformservicefee.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.tc.productreturnmoney.entity.ProductReturnMoney;
import com.bs.plugins.custom.tc.loan.entity.Loan;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;

public class BasePlatformServiceFee extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**平台公司Id-**/
	private Long platformId;
	/**Spv主键Id-**/
	private Long spvId;
	/**产品主键Id-**/
	private Long productId;
	/**会员回款分账表主键Id-**/
	private Long returnMoneyId;
	/**Spv放款表表主键Id-**/
	private Long spvLoanId;
	/**服务费交易号-**/
	private String tradeNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**本金总额-**/
	private BigDecimal principalAmount;
	/**服务费金额-**/
	private BigDecimal serviceFee;
	/**服务费费率-**/
	private BigDecimal serviceFeeRatio;
	/**收取时间-**/
	private String takeTime;
	/**收取状态-0：未收取 1：已收取 2：收取成功 3：收取失败**/
	private Integer takeStatus;
	/**收取完成时间-**/
	private String takeFinishTime;
	/**对账时间-**/
	private String checkingTime;
	/**对帐状态-0：未对账 1：对账成功 2：对账失败**/
	private Integer checkingStatus;
	/**备注-**/
	private String remark;
	/**交易中心-产品返款分账信息存储表**/
	private ProductReturnMoney productReturnMoney;
	/**交易中心-Spv放款信息存储表**/
	private Loan loan;
	/**产品管理-产品信息存储表**/
	private Product product;
	/**用户中心-SPV公司信息表**/
	private SpvCorporation spvCorporation;

	public BasePlatformServiceFee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
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
	public Long getReturnMoneyId() {
		return returnMoneyId;
	}

	public void setReturnMoneyId(Long returnMoneyId) {
		this.returnMoneyId = returnMoneyId;
	}
	public Long getSpvLoanId() {
		return spvLoanId;
	}

	public void setSpvLoanId(Long spvLoanId) {
		this.spvLoanId = spvLoanId;
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
	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}
	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}
	public BigDecimal getServiceFeeRatio() {
		return serviceFeeRatio;
	}

	public void setServiceFeeRatio(BigDecimal serviceFeeRatio) {
		this.serviceFeeRatio = serviceFeeRatio;
	}
	public String getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}
	public Integer getTakeStatus() {
		return takeStatus;
	}

	public void setTakeStatus(Integer takeStatus) {
		this.takeStatus = takeStatus;
	}
	public String getTakeFinishTime() {
		return takeFinishTime;
	}

	public void setTakeFinishTime(String takeFinishTime) {
		this.takeFinishTime = takeFinishTime;
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
	
	public ProductReturnMoney getProductReturnMoney () {
		return productReturnMoney;
	}

	public void setProductReturnMoney(ProductReturnMoney productReturnMoney) {
		this.productReturnMoney = productReturnMoney;
	}
	public Loan getLoan () {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	public Product getProduct () {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public SpvCorporation getSpvCorporation () {
		return spvCorporation;
	}

	public void setSpvCorporation(SpvCorporation spvCorporation) {
		this.spvCorporation = spvCorporation;
	}
}
