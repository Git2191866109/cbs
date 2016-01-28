package com.bs.plugins.custom.uc.role.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.DateUtil;
import com.bs.plugins.custom.uc.role.base.BaseRoleService;
import com.bs.plugins.custom.uc.role.entity.Role;
import com.bs.plugins.custom.uc.roleauthrelation.entity.RoleAuthRelation;
import com.bs.plugins.custom.uc.roleauthrelation.service.RoleAuthRelationService;
import com.bs.plugins.custom.uc.user.dao.IUserDao;
import com.bs.plugins.custom.uc.user.entity.User;
import com.bs.plugins.custom.uc.userrolerelation.dao.IUserRoleRelationDao;
import com.bs.plugins.custom.uc.userrolerelation.entity.UserRoleRelation;

@Service
public class RoleService extends BaseRoleService<Role> {
	
	@Autowired
	private IUserRoleRelationDao userRoleRelationDao;
	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private RoleAuthRelationService roleAuthRelationService;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData roleIndex(Role role){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(Role role){
		ResultData resultData = new ResultData();
		try {
			resultData=super.single(role);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Role role){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(Role role){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(Role role){
		ResultData resultData = new ResultData();
		try {
			List<Role> roleList = super.getRoleDao().selectPaginatedList(role);
			Long roleCount = super.getRoleDao().getCount(role);
			if (roleList != null){
				long record = roleCount == null?0:roleCount;
				int pageCount = (int) Math.ceil(record / (double) role.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", role.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", roleList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**
	 * 根据用户账号获取权限
	 * @param account
	 * @return
	 */
	public List<Role> getRolesByAccount(User user){
		user =iUserDao.selectByAccount(user);
		UserRoleRelation userRoleRelation=new UserRoleRelation();
		userRoleRelation.setUserId(user.getId());
		List<UserRoleRelation> listRoles = userRoleRelationDao.selectRoleByUserId(userRoleRelation);
		List<Role>  roleList=new ArrayList<Role>();
		if(listRoles!=null&&listRoles.size()>0){
			for(UserRoleRelation relation:listRoles){
				roleList.add(relation.getRole());
			}
		}
		return roleList;
	}
	/**
	 * 创建角色
	 * @param user
	 * @return
	 */
	public ResultData create(Role role){

		
		ResultData resultData = new ResultData();
		try {
			if(null!=role){
				role.setCreateTime(DateUtil.dateToStringWithTime(new Date()));
			resultData=super.create(role);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	/**
	 * 修改角色
	 * @param user
	 * @return
	 */
	public ResultData modify(Role role){
		ResultData resultData = new ResultData();
		try {
			if(null!=role){
			role.setModifyTime(DateUtil.dateToStringWithTime(new Date()));
				Integer result = super.getRoleDao().update(role);
				if (result > 0){
					resultData.setStatus(IBaseService.SUCCESS);
				}
				else{
					resultData.setStatus(IBaseService.FAIL);
				}
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	/**
	 * 删除角色
	 * @param user
	 * @return
	 */
	public ResultData delete(Role role){
		ResultData resultData = new ResultData();
		try {
			if(null!=role){
				UserRoleRelation userRoleRelation=new UserRoleRelation();
				userRoleRelation.setRoleId(role.getId());
				//删除关系
				RoleAuthRelation roleAuthRelation =new RoleAuthRelation();
				roleAuthRelation.setRoleId(role.getId());
				roleAuthRelationService.delete(roleAuthRelation);
				//删除用户角色之间的关系 
				userRoleRelationDao.delete(userRoleRelation);
				//删角色
				Role roleentity=new Role();
				roleentity.setId(role.getId());
				resultData=super.delete(roleentity);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	/**
	 * 绑定角色页面
	 * @param user
	 * @return
	 */
	public ResultData bind(Role role){
		ResultData resultData = new ResultData();
		try {
			//全部的角色
			List<Role> roleList =super.getRoleDao().selectAll();
			//用户已经有的角色
			List<Role> roleArray =getRoleDao().selectRoleByUser(role);
			//左树
			List<Map<String, Object>> treeLeft = new ArrayList<Map<String,Object>>();
			for( int i=0;i<roleList.size();i++){
				Map<String, Object> right=new HashMap<String, Object>();
				Role roleLeft =roleList.get(i);
				for(Role roleRight:roleArray){
				if(roleLeft.getId() == roleRight.getId()){
					right.put("checked", true);
				
				}
				}
				right.put("icon", "../../../static/css/zTreeStyle/img/diy/3.png");
				right.put("id", roleLeft.getId());
				right.put("name", roleLeft.getName());
				right.put("pId", 0);
				treeLeft.add(right);
			}
			String zNodes = JSONArray.toJSONString(treeLeft).toString();
			resultData.setStatus(SUCCESS);
			resultData.addObject("zNodes", zNodes);
			resultData.addObject("userId",role.getId());
			} catch (Exception e) {
				resultData.setStatus(FAIL);
				resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
}
