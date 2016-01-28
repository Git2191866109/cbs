package com.bs.plugins.custom.eb.budgetdatarelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;

public class BaseBudgetDataRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**预算项Id-**/
	private Long itemId;
	/**预算项值Id-**/
	private Long fieldValueId;
	/**阶段属性Id-**/
	private Long dataAttributeId;
	/**预算项目字段值信息存储表**/
	private ItemFieldValue itemFieldValue;
	/**预算项目信息存储表**/
	private BudgetItem budgetItem;
	/**成长阶段分类信息存储表**/
	private EducationMode educationMode;

	public BaseBudgetDataRelation() {
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getFieldValueId() {
		return fieldValueId;
	}

	public void setFieldValueId(Long fieldValueId) {
		this.fieldValueId = fieldValueId;
	}
	public Long getDataAttributeId() {
		return dataAttributeId;
	}

	public void setDataAttributeId(Long dataAttributeId) {
		this.dataAttributeId = dataAttributeId;
	}
	
	public ItemFieldValue getItemFieldValue () {
		return itemFieldValue;
	}

	public void setItemFieldValue(ItemFieldValue itemFieldValue) {
		this.itemFieldValue = itemFieldValue;
	}
	public BudgetItem getBudgetItem () {
		return budgetItem;
	}

	public void setBudgetItem(BudgetItem budgetItem) {
		this.budgetItem = budgetItem;
	}
	public EducationMode getEducationMode () {
		return educationMode;
	}

	public void setEducationMode(EducationMode educationMode) {
		this.educationMode = educationMode;
	}
}
