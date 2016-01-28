package com.bs.plugins.custom.uc.userrolerelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.uc.role.entity.Role;
import com.bs.plugins.custom.uc.user.entity.User;

public class BaseUserRoleRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**用户ID-用户随机编号：系统生成**/
	private Long userId;
	/**角色ID-**/
	private Long roleId;
	/**角色信息表**/
	private Role role;
	/**用户信息表**/
	private User user;

	public BaseUserRoleRelation() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	public Role getRole () {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public User getUser () {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
