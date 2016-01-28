package com.bs.plugins.custom.eb.educationmode.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;	
import com.bs.plugins.custom.eb.goalitemrelation.entity.GoalItemRelation;	
import com.bs.plugins.custom.eb.budgetselection.entity.BudgetSelection;	
import java.util.ArrayList;

public class BaseEducationMode extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**成长阶段主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long growStagesId;
	/**名称-**/
	private String name;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**年龄阶段信息存储表**/
	private GrowStages growStages;
	/**教育方式与预算项目关系信息存储表**/
	private ArrayList<ModeItemRelation> modeItemRelations;
	/**教育目标与预算项关系信息存储表**/
	private ArrayList<GoalItemRelation> goalItemRelations;
	/**教育预算-预算选择项**/
	private ArrayList<BudgetSelection> budgetSelections;

	public BaseEducationMode() {
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public GrowStages getGrowStages () {
		return growStages;
	}

	public void setGrowStages(GrowStages growStages) {
		this.growStages = growStages;
	}
	public ArrayList<ModeItemRelation> getModeItemRelation () {
		return modeItemRelations;
	}

	public void setModeItemRelation(ArrayList<ModeItemRelation> modeItemRelations) {
		this.modeItemRelations = modeItemRelations;
	}	
	public ArrayList<GoalItemRelation> getGoalItemRelation () {
		return goalItemRelations;
	}

	public void setGoalItemRelation(ArrayList<GoalItemRelation> goalItemRelations) {
		this.goalItemRelations = goalItemRelations;
	}	
	public ArrayList<BudgetSelection> getBudgetSelection () {
		return budgetSelections;
	}

	public void setBudgetSelection(ArrayList<BudgetSelection> budgetSelections) {
		this.budgetSelections = budgetSelections;
	}	
}
