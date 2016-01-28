package com.bs.plugins.custom.eb.educationgoal.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.budgetbasicinfo.entity.BudgetBasicInfo;	
import com.bs.plugins.custom.eb.goalitemrelation.entity.GoalItemRelation;	
import com.bs.plugins.custom.eb.educationconfigure.entity.EducationConfigure;	
import java.util.ArrayList;

public class BaseEducationGoal extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**阶段名称-**/
	private String name;
	/**国内或国外-1：国内 0：国外**/
	private Integer isInland;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**预算表基础信息存储表**/
	private ArrayList<BudgetBasicInfo> budgetBasicInfos;
	/**教育目标与预算项关系信息存储表**/
	private ArrayList<GoalItemRelation> goalItemRelations;
	/**教育期望信息存储表**/
	private ArrayList<EducationConfigure> educationConfigures;

	public BaseEducationGoal() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getIsInland() {
		return isInland;
	}

	public void setIsInland(Integer isInland) {
		this.isInland = isInland;
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
	
	public ArrayList<BudgetBasicInfo> getBudgetBasicInfo () {
		return budgetBasicInfos;
	}

	public void setBudgetBasicInfo(ArrayList<BudgetBasicInfo> budgetBasicInfos) {
		this.budgetBasicInfos = budgetBasicInfos;
	}	
	public ArrayList<GoalItemRelation> getGoalItemRelation () {
		return goalItemRelations;
	}

	public void setGoalItemRelation(ArrayList<GoalItemRelation> goalItemRelations) {
		this.goalItemRelations = goalItemRelations;
	}	
	public ArrayList<EducationConfigure> getEducationConfigure () {
		return educationConfigures;
	}

	public void setEducationConfigure(ArrayList<EducationConfigure> educationConfigures) {
		this.educationConfigures = educationConfigures;
	}	
}
