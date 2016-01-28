package com.bs.plugins.custom.uc.authorization.entity;

import java.util.Set;

import com.bs.plugins.custom.uc.authorization.base.BaseAuthorization;

public class Authorization extends BaseAuthorization {

	private static final long serialVersionUID = 1L;
	private Set<String> roleId;
	private Long parentIdTemp;
	
	public Authorization() {
	}

	public Set<String> getRoleId() {
		return roleId;
	}

	public void setRoleId(Set<String> roleId) {
		this.roleId = roleId;
	}

	public Long getParentIdTemp() {
		return parentIdTemp;
	}

	public void setParentIdTemp(Long parentIdTemp) {
		this.parentIdTemp = parentIdTemp;
	}
	
}
