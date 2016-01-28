package com.bs.plugins.custom.uc.roleauthrelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.uc.role.entity.Role;
import com.bs.plugins.custom.uc.authorization.entity.Authorization;

public class BaseRoleAuthRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**角色ID-**/
	private Long roleId;
	/**权限ID-系统权限代码，编码为数字，具有一定的规律。格式如下：1，11，111，112，12，121，122，13，131，132……**/
	private Long authId;
	/**角色信息表**/
	private Role role;
	/**权限管理信息存储表**/
	private Authorization authorization;

	public BaseRoleAuthRelation() {
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}
	
	public Role getRole () {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public Authorization getAuthorization () {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
}
