package com.bs.plugins.custom.sc.parameter.entity;

import com.bs.plugins.custom.sc.parameter.base.BaseParameter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Parameter extends BaseParameter {

	private static final long serialVersionUID = 1L;

	public Parameter() {
	}
	/**名称-名称**/
	@NotEmpty
	private String name;
	/**编码-编码**/
	@NotEmpty
	private String code;
	/**值-值**/
	@NotEmpty
	private String value;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
}
