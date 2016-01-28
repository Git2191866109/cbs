package com.bs.plugins.custom.uc.userrolerelation.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.uc.userrolerelation.entity.UserRoleRelation;
import com.bs.plugins.custom.uc.userrolerelation.base.BaseUserRoleRelationService;

@Service
public class UserRoleRelationService extends BaseUserRoleRelationService<UserRoleRelation> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData userRoleRelationIndex(UserRoleRelation userRoleRelation){
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
	public ResultData jumpModify(UserRoleRelation userRoleRelation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(UserRoleRelation userRoleRelation){
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
	public ResultData jumpList(UserRoleRelation userRoleRelation){
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
	public ResultData jumpPaginated(UserRoleRelation userRoleRelation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**分配角色**/
	public ResultData createReateion(UserRoleRelation userRoleRelation){
		ResultData resultData = new ResultData();
		try {
			if(userRoleRelation!=null&&userRoleRelation.getArray()!=null){
				String [] authArray =userRoleRelation.getArray().split(",");
				//删除全部该角色的权限
					delete(userRoleRelation);
					//该角色集合是否为空
					if(userRoleRelation.getArray().length()>0){
						//赋予该角色所选权限
						for(String roleId:authArray){
							userRoleRelation.setRoleId(Long.parseLong(roleId));
							resultData=create(userRoleRelation);
						}
					}else{
						resultData.setStatus(IBaseService.SUCCESS);
					}
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(FAIL);;
			e.printStackTrace();
		}
		return resultData;	
	}
	
	
}
