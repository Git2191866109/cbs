package com.bs.plugins.custom.eb.budgetcategory.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.eb.budgetcategory.base.BaseBudgetCategory;

public class BudgetCategory extends BaseBudgetCategory {

	private static final long serialVersionUID = 1L;

	public BudgetCategory() {
	}
	/**费用大类名称-**/
	@NotEmpty
	private String name;
	/**费用大类代码-**/
	@NotEmpty
	@Pattern(regexp = "^[0-9]{1,20}")
	private String code;

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
