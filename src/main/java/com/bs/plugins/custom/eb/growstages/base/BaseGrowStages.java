package com.bs.plugins.custom.eb.growstages.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.goalitemrelation.entity.GoalItemRelation;	
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;	
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;	
import com.bs.plugins.custom.eb.greadeyear.entity.GreadeYear;	
import com.bs.plugins.custom.eb.budgetselection.entity.BudgetSelection;	
import java.util.ArrayList;

public class BaseGrowStages extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**阶段名称-**/
	private String name;
	/**阶段代码-**/
	private String code;
	/**开始年龄-1：公立 2：私立 3：国外**/
	private Integer startAge;
	/**结束年龄-1：大学 2：高中 3：小学 4：幼儿园**/
	private Integer endAge;
	/**是否包括国外-1：是 0：否**/
	private Integer isInclude;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**教育目标与预算项关系信息存储表**/
	private ArrayList<GoalItemRelation> goalItemRelations;
	/**教育方式信息存储表**/
	private ArrayList<EducationMode> educationModes;
	/**教育方式与预算项目关系信息存储表**/
	private ArrayList<ModeItemRelation> modeItemRelations;
	/**年级年序信息存储表**/
	private ArrayList<GreadeYear> greadeYears;
	/**教育预算-预算选择项**/
	private ArrayList<BudgetSelection> budgetSelections;

	public BaseGrowStages() {
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
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStartAge() {
		return startAge;
	}

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
	}
	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}
	public Integer getIsInclude() {
		return isInclude;
	}

	public void setIsInclude(Integer isInclude) {
		this.isInclude = isInclude;
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
	
	public ArrayList<GoalItemRelation> getGoalItemRelation () {
		return goalItemRelations;
	}

	public void setGoalItemRelation(ArrayList<GoalItemRelation> goalItemRelations) {
		this.goalItemRelations = goalItemRelations;
	}	
	public ArrayList<EducationMode> getEducationMode () {
		return educationModes;
	}

	public void setEducationMode(ArrayList<EducationMode> educationModes) {
		this.educationModes = educationModes;
	}	
	public ArrayList<ModeItemRelation> getModeItemRelation () {
		return modeItemRelations;
	}

	public void setModeItemRelation(ArrayList<ModeItemRelation> modeItemRelations) {
		this.modeItemRelations = modeItemRelations;
	}	
	public ArrayList<GreadeYear> getGreadeYear () {
		return greadeYears;
	}

	public void setGreadeYear(ArrayList<GreadeYear> greadeYears) {
		this.greadeYears = greadeYears;
	}	
	public ArrayList<BudgetSelection> getBudgetSelection () {
		return budgetSelections;
	}

	public void setBudgetSelection(ArrayList<BudgetSelection> budgetSelections) {
		this.budgetSelections = budgetSelections;
	}	
}
