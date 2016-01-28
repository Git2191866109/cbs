package com.bs.plugins.custom.eb.goalbudgetrelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;

public class BaseGoalBudgetRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**教育目标Id-**/
	private Long eduGoalId;
	/**成长阶段Id-**/
	private Long growStagesId;
	/**预算大项-**/
	private Long categoryId;
	/**预算小项-**/
	private Long itemId;
	/**教育目标信息存储表**/
	private EducationGoal educationGoal;
	/**年龄阶段信息存储表**/
	private GrowStages growStages;
	/**预算分类信息存储表**/
	private BudgetCategory budgetCategory;
	/**预算项目信息存储表**/
	private BudgetItem budgetItem;

	public BaseGoalBudgetRelation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public EducationGoal getEducationGoal () {
		return educationGoal;
	}

	public void setEducationGoal(EducationGoal educationGoal) {
		this.educationGoal = educationGoal;
	}
	public GrowStages getGrowStages () {
		return growStages;
	}

	public void setGrowStages(GrowStages growStages) {
		this.growStages = growStages;
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
}
