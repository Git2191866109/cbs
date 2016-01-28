package com.bs.plugins.custom.sc.parametercategory.entity;

import com.bs.plugins.custom.sc.parametercategory.base.BaseParameterCategory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class ParameterCategory extends BaseParameterCategory {

	private static final long serialVersionUID = 1L;

	public ParameterCategory() {
	}
	/**分类表代码-**/
	@NotEmpty
	private String code;
	/**分类表名称-**/
	@NotEmpty
	private String name;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
