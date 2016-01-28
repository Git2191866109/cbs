package com.bs.plugins.custom.uc.userrolerelation.dao;

import java.util.List;

import com.bs.plugins.custom.uc.userrolerelation.base.BaseUserRoleRelationDao;
import com.bs.plugins.custom.uc.userrolerelation.entity.UserRoleRelation;

public interface IUserRoleRelationDao extends BaseUserRoleRelationDao<UserRoleRelation>{
	public List<UserRoleRelation> selectUserById(UserRoleRelation userRoleRelation);
	public List<UserRoleRelation> selectRoleByUserId(UserRoleRelation userRoleRelation);
	
}
