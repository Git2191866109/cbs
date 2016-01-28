package com.bs.plugins.custom.uc.organization.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.uc.organization.base.BaseOrganization;

public class Organization extends BaseOrganization {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Pattern(regexp = "^[0-9]{1,20}")
	private String code;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{1,50}")
	private String name;
	
	public Organization() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
