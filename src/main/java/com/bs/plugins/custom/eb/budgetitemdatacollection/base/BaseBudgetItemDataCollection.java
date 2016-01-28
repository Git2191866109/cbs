package com.bs.plugins.custom.eb.budgetitemdatacollection.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;
import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;	
import java.util.ArrayList;

public class BaseBudgetItemDataCollection extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**预算项数据主键Id-**/
	private Long itemDataId;
	/**地区主键Id-**/
	private Long areaId;
	/**教育目标主键Id-**/
	private Long eduGoalId;
	/**成长阶段主键Id-**/
	private Long growStagesId;
	/**预算分类大项主键Id-**/
	private Long budgetCategoryId;
	/**预算分类小项主键Id-**/
	private Long budgetItemId;
	/**小项低档金额总计-**/
	private BigDecimal itemLowAmount;
	/**小项高档金额总计-**/
	private BigDecimal itemHighAmount;
	/**普通金额-**/
	private BigDecimal lowAmount;
	/**高档金额-**/
	private BigDecimal highAmount;
	/**每次金额-**/
	private BigDecimal amount;
	/**每次最大费用-**/
	private BigDecimal maxAmount;
	/**每年次数-**/
	private Integer yearCount;
	/**年数-**/
	private Integer years;
	/**年次数最大值-**/
	private Integer maxYearCount;
	/**支出年龄-**/
	private Integer paymentAge;
	/**是否分档-1：是 0：否**/
	private Integer isGrading;
	/**是否只有高档-0：否 1：是**/
	private Integer gradingType;
	/**付费方式-1：月 2：学期 3：年**/
	private Integer paymentMethod;
	/**支付月份-**/
	private Integer paymentMonth;
	/**是否计算通胀-**/
	private Integer isInflation;
	/**是否按地区换算-0：不换算 1：换算**/
	private Integer isAreaTranslation;
	/**备注-**/
	private String comment;
	/**数据来源-**/
	private String dataSources;
	/**培训机构名称-**/
	private String trainingAgencyName;
	/**预算项数据信息存储表**/
	private BudgetItemData budgetItemData;
	/**预算项字段值信息存储表**/
	private ArrayList<ItemFieldValue> itemFieldValues;

	public BaseBudgetItemDataCollection() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemDataId() {
		return itemDataId;
	}

	public void setItemDataId(Long itemDataId) {
		this.itemDataId = itemDataId;
	}
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public Long getEduGoalId() {
		return eduGoalId;
	}

	public void setEduGoalId(Long eduGoalId) {
		this.eduGoalId = eduGoalId;
	}
	public Long getGrowStagesId() {
		return growStagesId;
	}

	public void setGrowStagesId(Long growStagesId) {
		this.growStagesId = growStagesId;
	}
	public Long getBudgetCategoryId() {
		return budgetCategoryId;
	}

	public void setBudgetCategoryId(Long budgetCategoryId) {
		this.budgetCategoryId = budgetCategoryId;
	}
	public Long getBudgetItemId() {
		return budgetItemId;
	}

	public void setBudgetItemId(Long budgetItemId) {
		this.budgetItemId = budgetItemId;
	}
	public BigDecimal getItemLowAmount() {
		return itemLowAmount;
	}

	public void setItemLowAmount(BigDecimal itemLowAmount) {
		this.itemLowAmount = itemLowAmount;
	}
	public BigDecimal getItemHighAmount() {
		return itemHighAmount;
	}

	public void setItemHighAmount(BigDecimal itemHighAmount) {
		this.itemHighAmount = itemHighAmount;
	}
	public BigDecimal getLowAmount() {
		return lowAmount;
	}

	public void setLowAmount(BigDecimal lowAmount) {
		this.lowAmount = lowAmount;
	}
	public BigDecimal getHighAmount() {
		return highAmount;
	}

	public void setHighAmount(BigDecimal highAmount) {
		this.highAmount = highAmount;
	}
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}
	public Integer getYearCount() {
		return yearCount;
	}

	public void setYearCount(Integer yearCount) {
		this.yearCount = yearCount;
	}
	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getMaxYearCount() {
		return maxYearCount;
	}

	public void setMaxYearCount(Integer maxYearCount) {
		this.maxYearCount = maxYearCount;
	}
	public Integer getPaymentAge() {
		return paymentAge;
	}

	public void setPaymentAge(Integer paymentAge) {
		this.paymentAge = paymentAge;
	}
	public Integer getIsGrading() {
		return isGrading;
	}

	public void setIsGrading(Integer isGrading) {
		this.isGrading = isGrading;
	}
	public Integer getGradingType() {
		return gradingType;
	}

	public void setGradingType(Integer gradingType) {
		this.gradingType = gradingType;
	}
	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Integer getPaymentMonth() {
		return paymentMonth;
	}

	public void setPaymentMonth(Integer paymentMonth) {
		this.paymentMonth = paymentMonth;
	}
	public Integer getIsInflation() {
		return isInflation;
	}

	public void setIsInflation(Integer isInflation) {
		this.isInflation = isInflation;
	}
	public Integer getIsAreaTranslation() {
		return isAreaTranslation;
	}

	public void setIsAreaTranslation(Integer isAreaTranslation) {
		this.isAreaTranslation = isAreaTranslation;
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDataSources() {
		return dataSources;
	}

	public void setDataSources(String dataSources) {
		this.dataSources = dataSources;
	}
	public String getTrainingAgencyName() {
		return trainingAgencyName;
	}

	public void setTrainingAgencyName(String trainingAgencyName) {
		this.trainingAgencyName = trainingAgencyName;
	}
	
	public BudgetItemData getBudgetItemData () {
		return budgetItemData;
	}

	public void setBudgetItemData(BudgetItemData budgetItemData) {
		this.budgetItemData = budgetItemData;
	}
	public ArrayList<ItemFieldValue> getItemFieldValue () {
		return itemFieldValues;
	}

	public void setItemFieldValue(ArrayList<ItemFieldValue> itemFieldValues) {
		this.itemFieldValues = itemFieldValues;
	}	
}
