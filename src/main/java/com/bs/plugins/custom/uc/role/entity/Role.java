package com.bs.plugins.custom.uc.role.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.uc.role.base.BaseRole;

public class Role extends BaseRole {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{1,50}")
	private String name;
	//是否禁用
	private String disable;
	
	public Role() {
	}

	
	public String getDisable() {
		return disable;
	}


	public void setDisable(String disable) {
		this.disable = disable;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
}
