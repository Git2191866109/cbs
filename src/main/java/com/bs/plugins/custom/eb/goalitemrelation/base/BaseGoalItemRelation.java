package com.bs.plugins.custom.eb.goalitemrelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;

public class BaseGoalItemRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**教育目标主键Id-**/
	private Long eduGoalId;
	/**教育方式主键Id-**/
	private Long eduModeId;
	/**成长阶段主键Id-**/
	private Long growStagesId;
	/**投入类型-1：常规 2：普通 3：高档**/
	private Integer inputType;
	/**国内或国外-1：国内 0：国外**/
	private Integer isInland;
	/**教育期望信息存储表**/
	private EducationGoal educationGoal;
	/**年龄阶段信息存储表**/
	private GrowStages growStages;
	/**教育方式信息存储表**/
	private EducationMode educationMode;

	public BaseGoalItemRelation() {
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
	public Long getEduModeId() {
		return eduModeId;
	}

	public void setEduModeId(Long eduModeId) {
		this.eduModeId = eduModeId;
	}
	public Long getGrowStagesId() {
		return growStagesId;
	}

	public void setGrowStagesId(Long growStagesId) {
		this.growStagesId = growStagesId;
	}
	public Integer getInputType() {
		return inputType;
	}

	public void setInputType(Integer inputType) {
		this.inputType = inputType;
	}
	public Integer getIsInland() {
		return isInland;
	}

	public void setIsInland(Integer isInland) {
		this.isInland = isInland;
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
	public EducationMode getEducationMode () {
		return educationMode;
	}

	public void setEducationMode(EducationMode educationMode) {
		this.educationMode = educationMode;
	}
}
