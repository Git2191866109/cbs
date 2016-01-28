package com.bs.plugins.custom.eb.modeitemrelation.entity;


import com.bs.plugins.custom.eb.modeitemrelation.base.BaseModeItemRelation;

public class ModeItemRelation extends BaseModeItemRelation {

	private static final long serialVersionUID = 1L;
	///**预算项目信息存储表**/ 集合
	private String  budgetItemArray;
	
	
	public String getBudgetItemArray() {
		return budgetItemArray;
	}


	public void setBudgetItemArray(String budgetItemArray) {
		this.budgetItemArray = budgetItemArray;
	}


	public ModeItemRelation() {
	}
	
}
