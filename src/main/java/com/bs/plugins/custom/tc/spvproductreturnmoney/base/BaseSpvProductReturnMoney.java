package com.bs.plugins.custom.tc.spvproductreturnmoney.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.pc.product.entity.Product;

public class BaseSpvProductReturnMoney extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**会员主键Id-**/
	private Long memberId;
	/**SPV公司Id-**/
	private Long spvId;
	/**产品主键Id-**/
	private Long productId;
	/**还款交易单号-**/
	private String transactionNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**产品名称-**/
	private String productName;
	/**产品代码-**/
	private String productCode;
	/**还款本金-**/
	private BigDecimal distributePrincipal;
	/**还款利息-**/
	private BigDecimal distributeInterest;
	/**还款总金额-**/
	private BigDecimal distributeAmount;
	/**起息日期-**/
	private String interestRateDate;
	/**预计兑付日期-**/
	private String paymentDate;
	/**实际止息日期-**/
	private String actualExpirationDate;
	/**预期收益率-**/
	private BigDecimal expectedProfitRatio;
	/**实际收益率-**/
	private BigDecimal actualProfitRatio;
	/**SPV服务费-**/
	private BigDecimal spvServiceFee;
	/**SPV服务费费率-**/
	private BigDecimal spvServiceFeeRatio;
	/**业务审核状态-0：待审核 1：审核通过 2：审核不通过**/
	private Integer businessCheckStatus;
	/**对账时间-**/
	private String checkingTime;
	/**对帐状态-0：未对账 1：对账成功 2：对账失败**/
	private Integer checkingStatus;
	/**转入标的状态-0：未转入 1：已转入 2：转入成功 3：转入失败**/
	private Integer intoObjectStatus;
	/**转入标的时间-**/
	private String intoObjectTime;
	/**备注-**/
	private String remark;
	/**用户中心-SPV公司信息表**/
	private SpvCorporation spvCorporation;
	/**用户中心-会员信息存储表**/
	private Member member;
	/**产品管理-产品信息存储表**/
	private Product product;

	public BaseSpvProductReturnMoney() {
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
	public BigDecimal getDistributePrincipal() {
		return distributePrincipal;
	}

	public void setDistributePrincipal(BigDecimal distributePrincipal) {
		this.distributePrincipal = distributePrincipal;
	}
	public BigDecimal getDistributeInterest() {
		return distributeInterest;
	}

	public void setDistributeInterest(BigDecimal distributeInterest) {
		this.distributeInterest = distributeInterest;
	}
	public BigDecimal getDistributeAmount() {
		return distributeAmount;
	}

	public void setDistributeAmount(BigDecimal distributeAmount) {
		this.distributeAmount = distributeAmount;
	}
	public String getInterestRateDate() {
		return interestRateDate;
	}

	public void setInterestRateDate(String interestRateDate) {
		this.interestRateDate = interestRateDate;
	}
	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getActualExpirationDate() {
		return actualExpirationDate;
	}

	public void setActualExpirationDate(String actualExpirationDate) {
		this.actualExpirationDate = actualExpirationDate;
	}
	public BigDecimal getExpectedProfitRatio() {
		return expectedProfitRatio;
	}

	public void setExpectedProfitRatio(BigDecimal expectedProfitRatio) {
		this.expectedProfitRatio = expectedProfitRatio;
	}
	public BigDecimal getActualProfitRatio() {
		return actualProfitRatio;
	}

	public void setActualProfitRatio(BigDecimal actualProfitRatio) {
		this.actualProfitRatio = actualProfitRatio;
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
	public Integer getBusinessCheckStatus() {
		return businessCheckStatus;
	}

	public void setBusinessCheckStatus(Integer businessCheckStatus) {
		this.businessCheckStatus = businessCheckStatus;
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
	public Integer getIntoObjectStatus() {
		return intoObjectStatus;
	}

	public void setIntoObjectStatus(Integer intoObjectStatus) {
		this.intoObjectStatus = intoObjectStatus;
	}
	public String getIntoObjectTime() {
		return intoObjectTime;
	}

	public void setIntoObjectTime(String intoObjectTime) {
		this.intoObjectTime = intoObjectTime;
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
