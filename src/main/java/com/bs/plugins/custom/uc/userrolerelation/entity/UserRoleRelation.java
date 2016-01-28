package com.bs.plugins.custom.uc.userrolerelation.entity;

import com.bs.plugins.custom.uc.userrolerelation.base.BaseUserRoleRelation;

public class UserRoleRelation extends BaseUserRoleRelation {

	private static final long serialVersionUID = 1L;
	//需要添加的角色集合
	private  String  array;

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
	}

	public UserRoleRelation() {
	}
	
}
