package com.bs.plugins.custom.uc.role.dao;

import java.util.List;

import com.bs.plugins.custom.uc.role.base.BaseRoleDao;
import com.bs.plugins.custom.uc.role.entity.Role;

public interface IRoleDao extends BaseRoleDao<Role>{
	//根据用户ID查询
	public List<Role> selectRoleByUser(Role role);
	public Integer update(Role role);



}
