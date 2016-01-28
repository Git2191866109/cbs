package com.bs.plugins.custom.eb.educationmode.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.eb.educationmode.base.BaseEducationMode;

public class EducationMode extends BaseEducationMode {

	private static final long serialVersionUID = 1L;

	public EducationMode() {
	}
	/**教育方式名称-**/
	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
