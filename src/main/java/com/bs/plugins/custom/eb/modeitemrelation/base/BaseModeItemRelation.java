package com.bs.plugins.custom.eb.modeitemrelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;

public class BaseModeItemRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**成长阶段主键Id-**/
	private Long growStagesId;
	/**教育方式主键Id-**/
	private Long eduModeId;
	/**预算分类大项主键Id-**/
	private Long budgetCategoryId;
	/**预算项数据主键Id-操作日志主键ID：操作日志记录表主键。**/
	private Long budgetItemDataId;
	/**预算分类小项主键Id-**/
	private Long budgetItemId;
	/**是否设置数据-1：是 0：否 默认：0**/
	private Integer isSetData;
	/**年龄阶段信息存储表**/
	private GrowStages growStages;
	/**教育方式信息存储表**/
	private EducationMode educationMode;
	/**预算分类信息存储表**/
	private BudgetCategory budgetCategory;
	/**预算项目信息存储表**/
	private BudgetItem budgetItem;
	/**预算项数据信息存储表**/
	private BudgetItemData budgetItemData;

	public BaseModeItemRelation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Long getBudgetCategoryId() {
		return budgetCategoryId;
	}

	public void setBudgetCategoryId(Long budgetCategoryId) {
		this.budgetCategoryId = budgetCategoryId;
	}
	public Long getBudgetItemDataId() {
		return budgetItemDataId;
	}

	public void setBudgetItemDataId(Long budgetItemDataId) {
		this.budgetItemDataId = budgetItemDataId;
	}
	public Long getBudgetItemId() {
		return budgetItemId;
	}

	public void setBudgetItemId(Long budgetItemId) {
		this.budgetItemId = budgetItemId;
	}
	public Integer getIsSetData() {
		return isSetData;
	}

	public void setIsSetData(Integer isSetData) {
		this.isSetData = isSetData;
	}
	
	public GrowStages getGrowStages () {
		return growStages;
	}

	public void setGrowStages(GrowStages growStages) {
		this.growStages = growStages;
	}
	public EducationMode getEducationMode () {
		return educationMode;
	}

	public void setEducationMode(EducationMode educationMode) {
		this.educationMode = educationMode;
	}
	public BudgetCategory getBudgetCategory () {
		return budgetCategory;
	}

	public void setBudgetCategory(BudgetCategory budgetCategory) {
		this.budgetCategory = budgetCategory;
	}
	public BudgetItem getBudgetItem () {
		return budgetItem;
	}

	public void setBudgetItem(BudgetItem budgetItem) {
		this.budgetItem = budgetItem;
	}
	public BudgetItemData getBudgetItemData () {
		return budgetItemData;
	}

	public void setBudgetItemData(BudgetItemData budgetItemData) {
		this.budgetItemData = budgetItemData;
	}
}
