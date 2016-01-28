package com.bs.plugins.custom.uc.user.dao;

import java.util.List;

import com.bs.plugins.custom.uc.user.base.BaseUserDao;
import com.bs.plugins.custom.uc.user.entity.User;

public interface IUserDao extends BaseUserDao<User>{
	public User selectByAccount(User user);
	public int updateByAccount(User user);
	public int updateByUserId(User user);
	public int  setCodeNull(User user);
	//查看用户角色是否禁用
	public User queryRoleIsDisabled(User user);
	//查看用户是否禁用
	public User queryIsDisable(User user);
	public List<User> findPaginatedList(User user);
	
}
