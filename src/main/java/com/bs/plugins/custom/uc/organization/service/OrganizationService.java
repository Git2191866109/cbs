package com.bs.plugins.custom.uc.organization.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.DateUtil;
import com.bs.plugins.custom.uc.organization.base.BaseOrganizationService;
import com.bs.plugins.custom.uc.organization.entity.Organization;
import com.bs.plugins.custom.uc.user.dao.IUserDao;
import com.bs.plugins.custom.uc.user.entity.User;

@Service
public class OrganizationService extends BaseOrganizationService<Organization> {
	
	
	@Autowired
	private IUserDao userDao;
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData organizationIndex(Organization organization){
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
	public ResultData jumpModify(Organization organization){
		ResultData resultData = new ResultData();
		try {
			resultData=super.single(organization);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Organization organization){
		ResultData resultData = new ResultData();
		try {
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(Organization organization){
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
	public ResultData jumpPaginated(Organization organization){
		ResultData resultData = new ResultData();
		try {
			//add your code
			resultData=super.paginated(organization);
		
		
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**创建机构**/
	public ResultData create(Organization organization){
		ResultData resultData = new ResultData();
		try {
			if(null!=organization){
			organization.setCreateTime(DateUtil.dateToStringWithTime(new Date()));
			resultData=super.create(organization);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	/**修改机构**/
	public ResultData modify(Organization organization){
		ResultData resultData = new ResultData();
		try {
			if(null!=organization){
			organization.setModifyTime(DateUtil.dateToStringWithTime(new Date()));
				try {
					Integer result = super.getOrganizationDao().update(organization);
					if (result > 0){
						resultData.setStatus(IBaseService.SUCCESS);
					}
					else{
						resultData.setStatus(IBaseService.FAIL);
					}
				} catch (Exception e) {
					resultData.setStatusException(e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	
	/**删除机构**/
	public ResultData delete(Organization organization){
		ResultData resultData = new ResultData();
		try {
			if(null!=organization){
				Organization organizationEntity = super.getOrganizationDao().selectOneById(organization);
			//把机构关联的所有用户机构ID
				User user=new User();
				user.setOrgCode(organizationEntity.getCode());
				userDao.setCodeNull(user);
				organization.setName(null);
				resultData=super.delete(organization);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	/**
	 * 查询所有机构
	 * @param entity
	 * @return
	 */
	public ResultData selectAll(ResultData resultData){
		try {
			List<Organization> organizationList = super.getOrganizationDao().selectAll();
			if (organizationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("organizationList", organizationList);
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
	
}
