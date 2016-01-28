package com.bs.plugins.custom.eb.budgetitemdata.entity;

import com.bs.plugins.custom.eb.budgetitemdata.base.BaseBudgetItemData;

public class BudgetItemData extends BaseBudgetItemData {

	private static final long serialVersionUID = 1L;
	private String yearsArray;//得到前台所属的 year集合 (供添加使用)
	private String yearsList;//得到前台所属的 year集合 (供更新使用)
	
	private String tableName;//表明
	private String provinceCode;//省份code
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getYearsList() {
		return yearsList;
	}
	public void setYearsList(String yearsList) {
		this.yearsList = yearsList;
	}
	public String getYearsArray() {
		return yearsArray;
	}
	public void setYearsArray(String yearsArray) {
		this.yearsArray = yearsArray;
	}
	public BudgetItemData() {
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
