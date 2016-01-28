package com.bs.plugins.custom.uc.role.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.uc.roleauthrelation.entity.RoleAuthRelation;	
import com.bs.plugins.custom.uc.userrolerelation.entity.UserRoleRelation;	
import java.util.ArrayList;

public class BaseRole extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**角色ID-**/
	private Long id;
	/**角色名称-**/
	private String name;
	/**角色说明-**/
	private String description;
	/**角色类型-0：超级管理员 1：其他管理员**/
	private Integer type;
	/**角色状态-角色状态： 0：禁用 1：开启**/
	private Integer status;
	/**创建时间-**/
	private String createTime;
	/**更新时间-**/
	private String modifyTime;
	/**创建者-**/
	private Long creatorId;
	/**用户角色关系映射表**/
	private ArrayList<RoleAuthRelation> roleAuthRelations;
	/**用户角色关系映射表**/
	private ArrayList<UserRoleRelation> userRoleRelations;

	public BaseRole() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public ArrayList<RoleAuthRelation> getRoleAuthRelation () {
		return roleAuthRelations;
	}

	public void setRoleAuthRelation(ArrayList<RoleAuthRelation> roleAuthRelations) {
		this.roleAuthRelations = roleAuthRelations;
	}	
	public ArrayList<UserRoleRelation> getUserRoleRelation () {
		return userRoleRelations;
	}

	public void setUserRoleRelation(ArrayList<UserRoleRelation> userRoleRelations) {
		this.userRoleRelations = userRoleRelations;
	}	
}
