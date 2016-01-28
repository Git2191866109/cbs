package com.bs.plugins.custom.pc.basicproduct.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.pc.product.entity.Product;	
import java.util.ArrayList;

public class BaseBasicProduct extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-主键ID**/
	private Long id;
	/**spv主键Id-**/
	private Long spvId;
	/**名称-名称**/
	private String name;
	/**产品代码-编码**/
	private String code;
	/**总金额-**/
	private Integer totalAmount;
	/**起息日期-**/
	private String interestRateDate;
	/**预计止息日期-**/
	private String profitExpirationDate;
	/**实际止息日期-**/
	private String actualExpirationDate;
	/**预计兑付日期-**/
	private String paymentDate;
	/**实际兑付日期-**/
	private String actualPaymentDate;
	/**预期收益率-**/
	private BigDecimal expectedProfitRatio;
	/**实际预期收益率-**/
	private BigDecimal actualExpectedProfitRatio;
	/**预期收益-**/
	private BigDecimal expectedProfit;
	/**实际收益-**/
	private BigDecimal actualProfit;
	/**描述-描述**/
	private String description;
	/**创建时间-创建时间**/
	private String createTime;
	/**修改人-修改人**/
	private Long modifierId;
	/**修改时间-修改时间**/
	private String modifyTime;
	/**删除标识-1：是 0：否**/
	private Integer isDelete;
	/**创建人-创建人**/
	private Long creatorId;
	/**用户中心-SPV公司信息表**/
	private SpvCorporation spvCorporation;
	/**产品管理-产品信息存储表**/
	private ArrayList<Product> products;

	public BaseBasicProduct() {
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
	public String getInterestRateDate() {
		return interestRateDate;
	}

	public void setInterestRateDate(String interestRateDate) {
		this.interestRateDate = interestRateDate;
	}
	public String getProfitExpirationDate() {
		return profitExpirationDate;
	}

	public void setProfitExpirationDate(String profitExpirationDate) {
		this.profitExpirationDate = profitExpirationDate;
	}
	public String getActualExpirationDate() {
		return actualExpirationDate;
	}

	public void setActualExpirationDate(String actualExpirationDate) {
		this.actualExpirationDate = actualExpirationDate;
	}
	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getActualPaymentDate() {
		return actualPaymentDate;
	}

	public void setActualPaymentDate(String actualPaymentDate) {
		this.actualPaymentDate = actualPaymentDate;
	}
	public BigDecimal getExpectedProfitRatio() {
		return expectedProfitRatio;
	}

	public void setExpectedProfitRatio(BigDecimal expectedProfitRatio) {
		this.expectedProfitRatio = expectedProfitRatio;
	}
	public BigDecimal getActualExpectedProfitRatio() {
		return actualExpectedProfitRatio;
	}

	public void setActualExpectedProfitRatio(BigDecimal actualExpectedProfitRatio) {
		this.actualExpectedProfitRatio = actualExpectedProfitRatio;
	}
	public BigDecimal getExpectedProfit() {
		return expectedProfit;
	}

	public void setExpectedProfit(BigDecimal expectedProfit) {
		this.expectedProfit = expectedProfit;
	}
	public BigDecimal getActualProfit() {
		return actualProfit;
	}

	public void setActualProfit(BigDecimal actualProfit) {
		this.actualProfit = actualProfit;
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
	public Integer getisDelete() {
		return isDelete;
	}

	public void setisDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public SpvCorporation getSpvCorporation () {
		return spvCorporation;
	}

	public void setSpvCorporation(SpvCorporation spvCorporation) {
		this.spvCorporation = spvCorporation;
	}
	public ArrayList<Product> getProduct () {
		return products;
	}

	public void setProduct(ArrayList<Product> products) {
		this.products = products;
	}	
}
