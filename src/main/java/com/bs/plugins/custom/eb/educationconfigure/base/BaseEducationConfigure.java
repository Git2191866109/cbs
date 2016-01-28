package com.bs.plugins.custom.eb.educationconfigure.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;

public class BaseEducationConfigure extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**教育期望_主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long eduGoalId_master;
	/**教育期望_副-**/
	private Long eduGoalId_vice;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**教育期望信息存储表**/
	private EducationGoal educationGoal;

	public BaseEducationConfigure() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getEduGoalId_master() {
		return eduGoalId_master;
	}

	public void setEduGoalId_master(Long eduGoalId_master) {
		this.eduGoalId_master = eduGoalId_master;
	}
	public Long getEduGoalId_vice() {
		return eduGoalId_vice;
	}

	public void setEduGoalId_vice(Long eduGoalId_vice) {
		this.eduGoalId_vice = eduGoalId_vice;
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
	
	public EducationGoal getEducationGoal () {
		return educationGoal;
	}

	public void setEducationGoal(EducationGoal educationGoal) {
		this.educationGoal = educationGoal;
	}
}
