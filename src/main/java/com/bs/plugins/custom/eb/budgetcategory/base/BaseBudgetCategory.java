package com.bs.plugins.custom.eb.budgetcategory.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;	
import com.bs.plugins.custom.eb.itemfield.entity.ItemField;	
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;	
import java.util.ArrayList;

public class BaseBudgetCategory extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**分类名称-**/
	private String name;
	/**分类代码-**/
	private String code;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**预算项目信息存储表**/
	private ArrayList<BudgetItem> budgetItems;
	/**预算项字段信息存储表**/
	private ArrayList<ItemField> itemFields;
	/**教育方式与预算项目关系信息存储表**/
	private ArrayList<ModeItemRelation> modeItemRelations;

	public BaseBudgetCategory() {
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
	public ArrayList<ItemField> getItemField () {
		return itemFields;
	}

	public void setItemField(ArrayList<ItemField> itemFields) {
		this.itemFields = itemFields;
	}	
	public ArrayList<ModeItemRelation> getModeItemRelation () {
		return modeItemRelations;
	}

	public void setModeItemRelation(ArrayList<ModeItemRelation> modeItemRelations) {
		this.modeItemRelations = modeItemRelations;
	}	
}
