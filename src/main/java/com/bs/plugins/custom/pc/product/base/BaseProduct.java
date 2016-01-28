package com.bs.plugins.custom.pc.product.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.basicproduct.entity.BasicProduct;
import com.bs.plugins.custom.aa.assetcategory.entity.AssetCategory;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;	
import com.bs.plugins.custom.tc.productamountlock.entity.ProductAmountLock;	
import com.bs.plugins.custom.tc.spvaccountingdetail.entity.SpvAccountingDetail;	
import com.bs.plugins.custom.tc.accountingdetail.entity.AccountingDetail;	
import com.bs.plugins.custom.pc.productcontract.entity.ProductContract;	
import com.bs.plugins.custom.tc.productreturnmoney.entity.ProductReturnMoney;	
import com.bs.plugins.custom.tc.subscription.entity.Subscription;	
import com.bs.plugins.custom.tc.appointment.entity.Appointment;	
import com.bs.plugins.custom.tc.spvproductreturnmoney.entity.SpvProductReturnMoney;	
import com.bs.plugins.custom.tc.loan.entity.Loan;	
import com.bs.plugins.custom.pc.subproduct.entity.SubProduct;	
import com.bs.plugins.custom.tc.platformservicefee.entity.PlatformServiceFee;	
import java.util.ArrayList;

public class BaseProduct extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**基础产品Id-**/
	private Long basicProductId;
	/**SPV公司主键Id-**/
	private Long spvId;
	/**产品分类Id-**/
	private Long categoryId;
	/**资产类别代码-**/
	private String assetCategoryCode;
	/**名称-名称**/
	private String name;
	/**编码-编码**/
	private String code;
	/**产品总金额-**/
	private Integer totalAmount;
	/**产品剩余额度-**/
	private Integer surplusAmount;
	/**首次发布时间-**/
	private String firstPublishTime;
	/**托管账户号-**/
	private String umpayAccountNo;
	/**描述-描述**/
	private String description;
	/**状态-1：待售 2：在售 3：售罄 4：暂停销售 5：存续中 6：兑付中 7：已兑付**/
	private Integer status;
	/**分账状态-**/
	private Integer distributeStatus;
	/**创建人-创建人**/
	private Long creatorId;
	/**创建时间-创建时间**/
	private String createTime;
	/**修改人-修改人**/
	private Long modifierId;
	/**修改时间-修改时间**/
	private String modifyTime;
	/**删除标识-1：是 0：否**/
	private Integer isDelete;
	/**排序-**/
	private Long sort;
	/**视图名称-**/
	private String viewName;
	/**产品中心-基础产品信息存储表**/
	private BasicProduct basicProduct;
	/****/
	private AssetCategory assetCategory;
	/**产品中心-产品属性信息表**/
	private ArrayList<ProductAttributeConfig> productAttributeConfigs;
	/****/
	private ArrayList<ProductAmountLock> productAmountLocks;
	/**交易中心-SPV公司进出账明细信息存储表**/
	private ArrayList<SpvAccountingDetail> spvAccountingDetails;
	/**交易中心-进出账明细信息存储表**/
	private ArrayList<AccountingDetail> accountingDetails;
	/**产品中心-产品合同表**/
	private ArrayList<ProductContract> productContracts;
	/**交易中心-产品返款分账信息存储表**/
	private ArrayList<ProductReturnMoney> productReturnMoneys;
	/**交易中心-客户认购产品数据存储表**/
	private ArrayList<Subscription> subscriptions;
	/**交易中心-客户预约产品数据存储表**/
	private ArrayList<Appointment> appointments;
	/**交易中心-SPV产品还款信息存储表**/
	private ArrayList<SpvProductReturnMoney> spvProductReturnMoneys;
	/**交易中心-Spv放款信息存储表**/
	private ArrayList<Loan> loans;
	/**产品中心-子产品信息存储表**/
	private ArrayList<SubProduct> subProducts;
	/**交易中心-平台服务费信息存储表**/
	private ArrayList<PlatformServiceFee> platformServiceFees;

	public BaseProduct() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getBasicProductId() {
		return basicProductId;
	}

	public void setBasicProductId(Long basicProductId) {
		this.basicProductId = basicProductId;
	}
	public Long getSpvId() {
		return spvId;
	}

	public void setSpvId(Long spvId) {
		this.spvId = spvId;
	}
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getAssetCategoryCode() {
		return assetCategoryCode;
	}

	public void setAssetCategoryCode(String assetCategoryCode) {
		this.assetCategoryCode = assetCategoryCode;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getSurplusAmount() {
		return surplusAmount;
	}

	public void setSurplusAmount(Integer surplusAmount) {
		this.surplusAmount = surplusAmount;
	}
	public String getFirstPublishTime() {
		return firstPublishTime;
	}

	public void setFirstPublishTime(String firstPublishTime) {
		this.firstPublishTime = firstPublishTime;
	}
	public String getUmpayAccountNo() {
		return umpayAccountNo;
	}

	public void setUmpayAccountNo(String umpayAccountNo) {
		this.umpayAccountNo = umpayAccountNo;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	public BasicProduct getBasicProduct () {
		return basicProduct;
	}

	public void setBasicProduct(BasicProduct basicProduct) {
		this.basicProduct = basicProduct;
	}
	public AssetCategory getAssetCategory () {
		return assetCategory;
	}

	public void setAssetCategory(AssetCategory assetCategory) {
		this.assetCategory = assetCategory;
	}
	public ArrayList<ProductAttributeConfig> getProductAttributeConfig () {
		return productAttributeConfigs;
	}

	public void setProductAttributeConfig(ArrayList<ProductAttributeConfig> productAttributeConfigs) {
		this.productAttributeConfigs = productAttributeConfigs;
	}	
	public ArrayList<ProductAmountLock> getProductAmountLock () {
		return productAmountLocks;
	}

	public void setProductAmountLock(ArrayList<ProductAmountLock> productAmountLocks) {
		this.productAmountLocks = productAmountLocks;
	}	
	public ArrayList<SpvAccountingDetail> getSpvAccountingDetail () {
		return spvAccountingDetails;
	}

	public void setSpvAccountingDetail(ArrayList<SpvAccountingDetail> spvAccountingDetails) {
		this.spvAccountingDetails = spvAccountingDetails;
	}	
	public ArrayList<AccountingDetail> getAccountingDetail () {
		return accountingDetails;
	}

	public void setAccountingDetail(ArrayList<AccountingDetail> accountingDetails) {
		this.accountingDetails = accountingDetails;
	}	
	public ArrayList<ProductContract> getProductContract () {
		return productContracts;
	}

	public void setProductContract(ArrayList<ProductContract> productContracts) {
		this.productContracts = productContracts;
	}	
	public ArrayList<ProductReturnMoney> getProductReturnMoney () {
		return productReturnMoneys;
	}

	public void setProductReturnMoney(ArrayList<ProductReturnMoney> productReturnMoneys) {
		this.productReturnMoneys = productReturnMoneys;
	}	
	public ArrayList<Subscription> getSubscription () {
		return subscriptions;
	}

	public void setSubscription(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}	
	public ArrayList<Appointment> getAppointment () {
		return appointments;
	}

	public void setAppointment(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}	
	public ArrayList<SpvProductReturnMoney> getSpvProductReturnMoney () {
		return spvProductReturnMoneys;
	}

	public void setSpvProductReturnMoney(ArrayList<SpvProductReturnMoney> spvProductReturnMoneys) {
		this.spvProductReturnMoneys = spvProductReturnMoneys;
	}	
	public ArrayList<Loan> getLoan () {
		return loans;
	}

	public void setLoan(ArrayList<Loan> loans) {
		this.loans = loans;
	}	
	public ArrayList<SubProduct> getSubProduct () {
		return subProducts;
	}

	public void setSubProduct(ArrayList<SubProduct> subProducts) {
		this.subProducts = subProducts;
	}	
	public ArrayList<PlatformServiceFee> getPlatformServiceFee () {
		return platformServiceFees;
	}

	public void setPlatformServiceFee(ArrayList<PlatformServiceFee> platformServiceFees) {
		this.platformServiceFees = platformServiceFees;
	}	
}
