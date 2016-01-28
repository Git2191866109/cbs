package com.bs.plugins.custom.eb.itemfieldvalue.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.itemfield.entity.ItemField;
import com.bs.plugins.custom.eb.budgetitemdatacollection.entity.BudgetItemDataCollection;

public class BaseItemFieldValue extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**预算项字段主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long itemFieldId;
	/**预算项收集数据Id-**/
	private Long dataCollectionId;
	/**字段值名称-**/
	private String fieldName;
	/**字段值-**/
	private String fieldValue;
	/**预算项字段信息存储表**/
	private ItemField itemField;
	/**预算项数据采集信息存储表**/
	private BudgetItemDataCollection budgetItemDataCollection;

	public BaseItemFieldValue() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemFieldId() {
		return itemFieldId;
	}

	public void setItemFieldId(Long itemFieldId) {
		this.itemFieldId = itemFieldId;
	}
	public Long getDataCollectionId() {
		return dataCollectionId;
	}

	public void setDataCollectionId(Long dataCollectionId) {
		this.dataCollectionId = dataCollectionId;
	}
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	public ItemField getItemField () {
		return itemField;
	}

	public void setItemField(ItemField itemField) {
		this.itemField = itemField;
	}
	public BudgetItemDataCollection getBudgetItemDataCollection () {
		return budgetItemDataCollection;
	}

	public void setBudgetItemDataCollection(BudgetItemDataCollection budgetItemDataCollection) {
		this.budgetItemDataCollection = budgetItemDataCollection;
	}
}
