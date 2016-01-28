package com.bs.plugins.custom.sc.agestages.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;	
import java.util.ArrayList;

public class BaseAgeStages extends Entity {

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
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**预算项目信息存储表**/
	private ArrayList<BudgetItem> budgetItems;

	public BaseAgeStages() {
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
	
	public ArrayList<BudgetItem> getBudgetItem () {
		return budgetItems;
	}

	public void setBudgetItem(ArrayList<BudgetItem> budgetItems) {
		this.budgetItems = budgetItems;
	}	
}
