package com.bs.plugins.custom.tc.productreturnmoney.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.tc.subscription.entity.Subscription;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.tc.platformservicefee.entity.PlatformServiceFee;	
import java.util.ArrayList;

public class BaseProductReturnMoney extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**会员主键Id-**/
	private Long memberId;
	/**SPV公司Id-**/
	private Long spvId;
	/**产品主键Id-**/
	private Long productId;
	/**认购表主键Id-**/
	private Long subscriptionId;
	/**认购交易单号-**/
	private String transactionNumber;
	/**SPV还款主键Id-**/
	private Long spvIntoObjectId;
	/**还款交易号-**/
	private String objectIncomeNumber;
	/**返款交易号-**/
	private String returnNumber;
	/**返款支付平台流水号-**/
	private String payPlantformNumber;
	/**产品名称-**/
	private String productName;
	/**产品代码-**/
	private String productCode;
	/**分账本金-**/
	private BigDecimal distributePrincipal;
	/**分账利息-**/
	private BigDecimal distributeInterest;
	/**分账总金额-**/
	private BigDecimal distributeAmount;
	/**分账计算状态-0：分账失败 1：分账成功**/
	private Integer distributeStatus;
	/**分账计算时间-**/
	private String distributeTime;
	/**起息日期-**/
	private String interestRateDate;
	/**预计兑付日期-**/
	private String paymentDate;
	/**实际止息日期-**/
	private String actualExpirationDate;
	/**预期收益率-**/
	private BigDecimal expectedProfitRatio;
	/**预期收益-**/
	private BigDecimal expectedProfit;
	/**实际收益率-**/
	private BigDecimal actualProfitRatio;
	/**实际返款金额-**/
	private BigDecimal actualReturnAmount;
	/**客户服务费-**/
	private BigDecimal memberServiceFee;
	/**客户服务费费率-**/
	private BigDecimal memberServiceFeeRatio;
	/**返款时间-**/
	private String returnTime;
	/**返款状态-0：未还款 1：已还款 2：还款成功 3：还款失败 4：拒绝返款**/
	private Integer returnStatus;
	/**业务审核状态-0：待审核 1：审核通过 2：审核不通过**/
	private Integer businessCheckStatus;
	/**对账时间-**/
	private String checkingTime;
	/**对帐状态-0：未对账 1：对账成功 2：对账失败**/
	private Integer checkingStatus;
	/**标的转入状态-0：未转入 1：已转入 2：转入成功 3：转入失败**/
	private Integer objectIncomeStatus;
	/**标的转入时间-**/
	private String objectIncomeTime;
	/**备注-**/
	private String remark;
	/**用户中心-SPV公司信息表**/
	private SpvCorporation spvCorporation;
	/**交易中心-客户认购产品数据存储表**/
	private Subscription subscription;
	/**产品管理-产品信息存储表**/
	private Product product;
	/**交易中心-平台服务费信息存储表**/
	private ArrayList<PlatformServiceFee> platformServiceFees;

	public BaseProductReturnMoney() {
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
	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Long getSpvIntoObjectId() {
		return spvIntoObjectId;
	}

	public void setSpvIntoObjectId(Long spvIntoObjectId) {
		this.spvIntoObjectId = spvIntoObjectId;
	}
	public String getObjectIncomeNumber() {
		return objectIncomeNumber;
	}

	public void setObjectIncomeNumber(String objectIncomeNumber) {
		this.objectIncomeNumber = objectIncomeNumber;
	}
	public String getReturnNumber() {
		return returnNumber;
	}

	public void setReturnNumber(String returnNumber) {
		this.returnNumber = returnNumber;
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
	public Integer getDistributeStatus() {
		return distributeStatus;
	}

	public void setDistributeStatus(Integer distributeStatus) {
		this.distributeStatus = distributeStatus;
	}
	public String getDistributeTime() {
		return distributeTime;
	}

	public void setDistributeTime(String distributeTime) {
		this.distributeTime = distributeTime;
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
	public BigDecimal getExpectedProfit() {
		return expectedProfit;
	}

	public void setExpectedProfit(BigDecimal expectedProfit) {
		this.expectedProfit = expectedProfit;
	}
	public BigDecimal getActualProfitRatio() {
		return actualProfitRatio;
	}

	public void setActualProfitRatio(BigDecimal actualProfitRatio) {
		this.actualProfitRatio = actualProfitRatio;
	}
	public BigDecimal getActualReturnAmount() {
		return actualReturnAmount;
	}

	public void setActualReturnAmount(BigDecimal actualReturnAmount) {
		this.actualReturnAmount = actualReturnAmount;
	}
	public BigDecimal getMemberServiceFee() {
		return memberServiceFee;
	}

	public void setMemberServiceFee(BigDecimal memberServiceFee) {
		this.memberServiceFee = memberServiceFee;
	}
	public BigDecimal getMemberServiceFeeRatio() {
		return memberServiceFeeRatio;
	}

	public void setMemberServiceFeeRatio(BigDecimal memberServiceFeeRatio) {
		this.memberServiceFeeRatio = memberServiceFeeRatio;
	}
	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public Integer getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Integer returnStatus) {
		this.returnStatus = returnStatus;
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
	public Integer getObjectIncomeStatus() {
		return objectIncomeStatus;
	}

	public void setObjectIncomeStatus(Integer objectIncomeStatus) {
		this.objectIncomeStatus = objectIncomeStatus;
	}
	public String getObjectIncomeTime() {
		return objectIncomeTime;
	}

	public void setObjectIncomeTime(String objectIncomeTime) {
		this.objectIncomeTime = objectIncomeTime;
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
	public Subscription getSubscription () {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public Product getProduct () {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public ArrayList<PlatformServiceFee> getPlatformServiceFee () {
		return platformServiceFees;
	}

	public void setPlatformServiceFee(ArrayList<PlatformServiceFee> platformServiceFees) {
		this.platformServiceFees = platformServiceFees;
	}	
}
