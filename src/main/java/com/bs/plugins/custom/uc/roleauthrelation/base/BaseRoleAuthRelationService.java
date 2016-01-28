package com.bs.plugins.custom.uc.roleauthrelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.uc.roleauthrelation.entity.RoleAuthRelation;
import com.bs.plugins.custom.uc.roleauthrelation.dao.IRoleAuthRelationDao;

public class BaseRoleAuthRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IRoleAuthRelationDao roleAuthRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(RoleAuthRelation roleAuthRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = roleAuthRelationDao.insert(roleAuthRelation);
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
		return resultData;
	}
		
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData delete(RoleAuthRelation roleAuthRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = roleAuthRelationDao.delete(roleAuthRelation);
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
		return resultData;
	}
	
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteAll(){
		ResultData resultData = new ResultData();
		try {
			Integer result = roleAuthRelationDao.deleteAll();
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
		return resultData;
	}
	
	
	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(RoleAuthRelation roleAuthRelation){
		ResultData resultData = new ResultData();
		try {
			List<RoleAuthRelation> roleAuthRelationList = roleAuthRelationDao.selectList(roleAuthRelation);
			if (roleAuthRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("roleAuthRelationList", roleAuthRelationList);
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
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(RoleAuthRelation roleAuthRelation){
		ResultData resultData = new ResultData();
		try {
			List<RoleAuthRelation> roleAuthRelationList = roleAuthRelationDao.selectPaginatedList(roleAuthRelation);
			Long roleAuthRelationCount = roleAuthRelationDao.getCount(roleAuthRelation);
			if (roleAuthRelationList != null){
				long record = roleAuthRelationCount == null?0:roleAuthRelationCount;
				int pageCount = (int) Math.ceil(record / (double) roleAuthRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", roleAuthRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", roleAuthRelationList);
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
	
	
	@Override
	public void afterPropertiesSet() throws Exception {

	}
	
	public InitializeData getInitializeData() {
		return initializeData;
	}

	public void setInitializeData(InitializeData initializeData) {
		this.initializeData = initializeData;
	}
	
	public IRoleAuthRelationDao getRoleAuthRelationDao() {
		return roleAuthRelationDao;
	}

	public void setRoleAuthRelationDao(IRoleAuthRelationDao roleAuthRelationDao) {
		this.roleAuthRelationDao = roleAuthRelationDao;
	}
}
