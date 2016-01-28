package com.bs.plugins.custom.sm.serviceprovider.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.sm.serviceprovider.base.BaseServiceProvider;

public class ServiceProvider extends BaseServiceProvider {

	private static final long serialVersionUID = 1L;

	public ServiceProvider() {
	}
	/**SP名称-**/
	@NotEmpty
	private String name;
	/**SP代码-**/
	@NotEmpty
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
