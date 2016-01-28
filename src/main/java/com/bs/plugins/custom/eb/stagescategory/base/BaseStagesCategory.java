package com.bs.plugins.custom.eb.stagescategory.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.budgetdatarelation.entity.BudgetDataRelation;	
import java.util.ArrayList;

public class BaseStagesCategory extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**成长阶段Id-**/
	private Long growStagesId;
	/**属性名称-**/
	private String name;
	/**属性类型-1：国内 2：国外**/
	private Integer type;
	/**开始年龄-1：公立 2：私立 3：国外**/
	private Integer startAge;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**年龄阶段信息存储表**/
	private GrowStages growStages;
	/**成长阶段与预算数据关系存储表**/
	private ArrayList<BudgetDataRelation> budgetDataRelations;

	public BaseStagesCategory() {
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
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStartAge() {
		return startAge;
	}

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
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
	public ArrayList<BudgetDataRelation> getBudgetDataRelation () {
		return budgetDataRelations;
	}

	public void setBudgetDataRelation(ArrayList<BudgetDataRelation> budgetDataRelations) {
		this.budgetDataRelations = budgetDataRelations;
	}	
}
