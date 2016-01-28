package com.bs.plugins.custom.eb.budgetitem.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.eb.budgetitem.base.BaseBudgetItem;

public class BudgetItem extends BaseBudgetItem {

	private static final long serialVersionUID = 1L;

	//根节点
	public String rId;
	/**开支项名称-**/
	@NotEmpty
	private String name;
	/**开支项代码-**/
	@NotEmpty
	@Pattern(regexp = "^[0-9]{1,20}")
	private String code;

	public BudgetItem() {
	}
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
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
	
}
