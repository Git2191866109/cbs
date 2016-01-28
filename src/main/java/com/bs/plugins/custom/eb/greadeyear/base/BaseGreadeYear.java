package com.bs.plugins.custom.eb.greadeyear.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.growstages.entity.GrowStages;

public class BaseGreadeYear extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**成长阶段主键Id-**/
	private Long growStageId;
	/**名称-**/
	private String name;
	/**年级-**/
	private Integer greade;
	/**开始年序-**/
	private Integer startYear;
	/**结束年序-**/
	private Integer endYear;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**年龄阶段信息存储表**/
	private GrowStages growStages;

	public BaseGreadeYear() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getGrowStageId() {
		return growStageId;
	}

	public void setGrowStageId(Long growStageId) {
		this.growStageId = growStageId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getGreade() {
		return greade;
	}

	public void setGreade(Integer greade) {
		this.greade = greade;
	}
	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}
	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
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
}
