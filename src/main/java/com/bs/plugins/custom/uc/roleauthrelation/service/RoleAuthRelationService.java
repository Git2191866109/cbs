package com.bs.plugins.custom.uc.roleauthrelation.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.uc.roleauthrelation.base.BaseRoleAuthRelationService;
import com.bs.plugins.custom.uc.roleauthrelation.entity.RoleAuthRelation;

@Service
public class RoleAuthRelationService extends BaseRoleAuthRelationService<RoleAuthRelation> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData roleAuthRelationIndex(RoleAuthRelation roleAuthRelation){
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
	public ResultData jumpModify(RoleAuthRelation roleAuthRelation){
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
	public ResultData jumpCreate(RoleAuthRelation roleAuthRelation){
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
	public ResultData jumpList(RoleAuthRelation roleAuthRelation){
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
	public ResultData jumpPaginated(RoleAuthRelation roleAuthRelation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**添加关系**/     
	public ResultData createReateion(RoleAuthRelation roleAuthRelation){
		ResultData resultData = new ResultData();
		try {
			if(roleAuthRelation!=null&&roleAuthRelation.getArray()!=null){
				String [] authArray =roleAuthRelation.getArray().split(",");
				//删除全部该角色的权限
				super.getRoleAuthRelationDao().delete(roleAuthRelation);
				if(!authArray[0].toString().equals("null")){
					//用户删除所有权限
					for(String authId:authArray){
						roleAuthRelation.setAuthId(Long.parseLong(authId));
						resultData=create(roleAuthRelation);
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
