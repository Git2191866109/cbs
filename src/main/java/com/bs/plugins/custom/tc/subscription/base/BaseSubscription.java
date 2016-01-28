package com.bs.plugins.custom.tc.subscription.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.tc.productamountlock.entity.ProductAmountLock;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.tc.loan.entity.Loan;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.tc.subscriptioncontract.entity.SubscriptionContract;	
import com.bs.plugins.custom.tc.productreturnmoney.entity.ProductReturnMoney;	
import java.util.ArrayList;

public class BaseSubscription extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**会员主键Id-**/
	private Long memberId;
	/**SPV公司Id-**/
	private Long spvId;
	/**放款主键ID-**/
	private Long loanId;
	/**放款交易号-**/
	private String loanNumber;
	/**产品主键Id-**/
	private Long productId;
	/**额度锁定主键Id-**/
	private Long amountLockId;
	/**交易单号-**/
	private String transactionNumber;
	/**支付平台流水号(放款)-**/
	private String payPlantformNumber;
	/**产品账户号-**/
	private String umpayProductAccountNo;
	/**产品名称-**/
	private String productName;
	/**产品代码-**/
	private String productCode;
	/**交易状态-1：存续中 2：兑付中 3：已兑付 4：兑付失败 5：延期 6：已退款 0：认购失败**/
	private Integer tradeStatus;
	/**认购金额-**/
	private BigDecimal investAmount;
	/**份额-**/
	private Integer shares;
	/**认购时间-**/
	private String orderTime;
	/**起息日期-**/
	private String interestRateDate;
	/**预计兑付日期-**/
	private String paymentDate;
	/**预计止息日期-**/
	private String expectedExpirationDate;
	/**实际止息日期-**/
	private String actualExpirationDate;
	/**预期收益率-**/
	private BigDecimal expectedProfitRatio;
	/**预期收益-**/
	private BigDecimal expectedProfit;
	/**Spv服务费-**/
	private BigDecimal spvServiceFee;
	/**Spv服务费费率-**/
	private BigDecimal spvServiceFeeRatio;
	/**实际放款金额-**/
	private BigDecimal actualLoanAmount;
	/**放款时间-**/
	private String loanTime;
	/**放款状态-0：未放款 1：已放款 2：放款成功 3：放款失败 4：拒绝放款**/
	private Integer loanStatus;
	/**认购状态-1：认购成功 0：认购失败**/
	private Integer status;
	/**回款分账状态-0：分账失败 1：分账成功**/
	private Integer distributeStatus;
	/**回款分账时间-**/
	private String distributeTime;
	/**是否回购-**/
	private Integer isBuyBack;
	/**对帐状态-0：未对账 1：对账成功 2：对账失败**/
	private Integer checkingStatus;
	/**对账时间-**/
	private String checkingTime;
	/**合同路径-**/
	private String contractPath;
	/**备注-**/
	private String remark;
	/****/
	private ProductAmountLock productAmountLock;
	/**用户中心-SPV公司信息表**/
	private SpvCorporation spvCorporation;
	/**交易中心-Spv放款信息存储表**/
	private Loan loan;
	/**产品管理-产品信息存储表**/
	private Product product;
	/**交易中心-客户任何合同信息存储表**/
	private ArrayList<SubscriptionContract> subscriptionContracts;
	/**交易中心-产品返款分账信息存储表**/
	private ArrayList<ProductReturnMoney> productReturnMoneys;

	public BaseSubscription() {
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
	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getAmountLockId() {
		return amountLockId;
	}

	public void setAmountLockId(Long amountLockId) {
		this.amountLockId = amountLockId;
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
	public Integer getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public BigDecimal getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(BigDecimal investAmount) {
		this.investAmount = investAmount;
	}
	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}
	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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
	public String getExpectedExpirationDate() {
		return expectedExpirationDate;
	}

	public void setExpectedExpirationDate(String expectedExpirationDate) {
		this.expectedExpirationDate = expectedExpirationDate;
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
	public BigDecimal getActualLoanAmount() {
		return actualLoanAmount;
	}

	public void setActualLoanAmount(BigDecimal actualLoanAmount) {
		this.actualLoanAmount = actualLoanAmount;
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
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
	public Integer getIsBuyBack() {
		return isBuyBack;
	}

	public void setIsBuyBack(Integer isBuyBack) {
		this.isBuyBack = isBuyBack;
	}
	public Integer getCheckingStatus() {
		return checkingStatus;
	}

	public void setCheckingStatus(Integer checkingStatus) {
		this.checkingStatus = checkingStatus;
	}
	public String getCheckingTime() {
		return checkingTime;
	}

	public void setCheckingTime(String checkingTime) {
		this.checkingTime = checkingTime;
	}
	public String getContractPath() {
		return contractPath;
	}

	public void setContractPath(String contractPath) {
		this.contractPath = contractPath;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public ProductAmountLock getProductAmountLock () {
		return productAmountLock;
	}

	public void setProductAmountLock(ProductAmountLock productAmountLock) {
		this.productAmountLock = productAmountLock;
	}
	public SpvCorporation getSpvCorporation () {
		return spvCorporation;
	}

	public void setSpvCorporation(SpvCorporation spvCorporation) {
		this.spvCorporation = spvCorporation;
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
	public ArrayList<SubscriptionContract> getSubscriptionContract () {
		return subscriptionContracts;
	}

	public void setSubscriptionContract(ArrayList<SubscriptionContract> subscriptionContracts) {
		this.subscriptionContracts = subscriptionContracts;
	}	
	public ArrayList<ProductReturnMoney> getProductReturnMoney () {
		return productReturnMoneys;
	}

	public void setProductReturnMoney(ArrayList<ProductReturnMoney> productReturnMoneys) {
		this.productReturnMoneys = productReturnMoneys;
	}	
}
