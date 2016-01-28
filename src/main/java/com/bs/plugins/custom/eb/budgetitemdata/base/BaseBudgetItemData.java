package com.bs.plugins.custom.eb.budgetitemdata.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.sc.area.entity.Area;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;	
import com.bs.plugins.custom.eb.budgetitemdatacollection.entity.BudgetItemDataCollection;	
import java.util.ArrayList;

public class BaseBudgetItemData extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**地区代码-**/
	private String areaCode;
	/**教育目标主键Id-**/
	private Long eduGoalId;
	/**成长阶段主键Id-**/
	private Long growStagesId;
	/**教育方式主键Id-**/
	private Long eduModeId;
	/**预算分类大项主键Id-**/
	private Long categoryId;
	/**预算分类小项主键Id-**/
	private Long itemId;
	/**国内或国外-1：国内 0：国外**/
	private Integer isInland;
	/**小项低档金额总计-**/
	private BigDecimal lowAmountTotal;
	/**小项高档金额总计-**/
	private BigDecimal highAmountTotal;
	/**每次普通金额-**/
	private BigDecimal lowAmount;
	/**每次高档金额-**/
	private BigDecimal highAmount;
	/**每次最大费用-**/
	private BigDecimal maxAmount;
	/**每年总次数-**/
	private Integer systemYearCount;
	/**每年次数-**/
	private Double yearCount;
	/**年次数最大值-**/
	private Integer maxYearCount;
	/**开始年数-**/
	private Integer years;
	/**结束年数-**/
	private Integer endYears;
	/**支出年龄-**/
	private Integer paymentGrade;
	/**是否分档-1：是 0：否**/
	private Integer isGrading;
	/**是否只有高档-0：否 1：是**/
	private Integer gradingType;
	/**付费方式-2月付 1半年付 0年付**/
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
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String updateDate;
	/**创建者ID-**/
	private Long creatorId;
	/**地区信息存储表**/
	private Area area;
	/**教育方式与预算项目关系信息存储表**/
	private ArrayList<ModeItemRelation> modeItemRelations;
	/**预算项数据采集信息存储表**/
	private ArrayList<BudgetItemDataCollection> budgetItemDataCollections;

	public BaseBudgetItemData() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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
	public Long getEduModeId() {
		return eduModeId;
	}

	public void setEduModeId(Long eduModeId) {
		this.eduModeId = eduModeId;
	}
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Integer getIsInland() {
		return isInland;
	}

	public void setIsInland(Integer isInland) {
		this.isInland = isInland;
	}
	public BigDecimal getLowAmountTotal() {
		return lowAmountTotal;
	}

	public void setLowAmountTotal(BigDecimal lowAmountTotal) {
		this.lowAmountTotal = lowAmountTotal;
	}
	public BigDecimal getHighAmountTotal() {
		return highAmountTotal;
	}

	public void setHighAmountTotal(BigDecimal highAmountTotal) {
		this.highAmountTotal = highAmountTotal;
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
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}
	public Integer getSystemYearCount() {
		return systemYearCount;
	}

	public void setSystemYearCount(Integer systemYearCount) {
		this.systemYearCount = systemYearCount;
	}
	public Double getYearCount() {
		return yearCount;
	}

	public void setYearCount(Double yearCount) {
		this.yearCount = yearCount;
	}
	public Integer getMaxYearCount() {
		return maxYearCount;
	}

	public void setMaxYearCount(Integer maxYearCount) {
		this.maxYearCount = maxYearCount;
	}
	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getEndYears() {
		return endYears;
	}

	public void setEndYears(Integer endYears) {
		this.endYears = endYears;
	}
	public Integer getPaymentGrade() {
		return paymentGrade;
	}

	public void setPaymentGrade(Integer paymentGrade) {
		this.paymentGrade = paymentGrade;
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
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public Area getArea () {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	public ArrayList<ModeItemRelation> getModeItemRelation () {
		return modeItemRelations;
	}

	public void setModeItemRelation(ArrayList<ModeItemRelation> modeItemRelations) {
		this.modeItemRelations = modeItemRelations;
	}	
	public ArrayList<BudgetItemDataCollection> getBudgetItemDataCollection () {
		return budgetItemDataCollections;
	}

	public void setBudgetItemDataCollection(ArrayList<BudgetItemDataCollection> budgetItemDataCollections) {
		this.budgetItemDataCollections = budgetItemDataCollections;
	}	
}
