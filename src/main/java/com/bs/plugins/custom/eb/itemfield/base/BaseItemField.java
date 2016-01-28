package com.bs.plugins.custom.eb.itemfield.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;	
import java.util.ArrayList;

public class BaseItemField extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**大类主键Id-**/
	private Long categoryId;
	/**表名称-**/
	private String tableName;
	/**表中文名称-**/
	private String columnName;
	/**字段名-**/
	private String columnCode;
	/**字段别名-**/
	private String columnAlias;
	/**是否显示-**/
	private Integer isShow;
	/**展示方式-1：输入框 2：下拉 3：复选 4：单选 5：文本**/
	private Integer showType;
	/**排序-**/
	private Integer rank;
	/**预算分类信息存储表**/
	private BudgetCategory budgetCategory;
	/**预算项字段值信息存储表**/
	private ArrayList<ItemFieldValue> itemFieldValues;

	public BaseItemField() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}
	public String getColumnAlias() {
		return columnAlias;
	}

	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
	}
	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public BudgetCategory getBudgetCategory () {
		return budgetCategory;
	}

	public void setBudgetCategory(BudgetCategory budgetCategory) {
		this.budgetCategory = budgetCategory;
	}
	public ArrayList<ItemFieldValue> getItemFieldValue () {
		return itemFieldValues;
	}

	public void setItemFieldValue(ArrayList<ItemFieldValue> itemFieldValues) {
		this.itemFieldValues = itemFieldValues;
	}	
}
