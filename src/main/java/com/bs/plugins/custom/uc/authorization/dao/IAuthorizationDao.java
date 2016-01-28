package com.bs.plugins.custom.uc.authorization.dao;

import java.util.List;

import com.bs.plugins.custom.uc.authorization.base.BaseAuthorizationDao;
import com.bs.plugins.custom.uc.authorization.entity.Authorization;

public interface IAuthorizationDao extends BaseAuthorizationDao<Authorization>{

	public List<Authorization> selectAuthsByRoleIds(Authorization authorization);
	public List<Authorization> selectSubAuthByParentCode(Authorization authorization);
	public Authorization selectOneByCode(Authorization authorization);
	public List<Authorization> selectSubAuthByLevel(Authorization authorization);
	public List<Authorization> selectRoleAuthRelationByAuthId(Authorization authorization);
	public Integer updateByCode(Authorization authorization);
	public List<Authorization> selectAllTreeLevel();
	//查看已拥有权限
	public List<Authorization> selectAuthorizationRoleList(Authorization authorization);
	
}
