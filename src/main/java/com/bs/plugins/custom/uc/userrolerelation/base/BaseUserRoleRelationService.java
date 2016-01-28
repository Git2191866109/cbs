package com.bs.plugins.custom.uc.userrolerelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.uc.userrolerelation.entity.UserRoleRelation;
import com.bs.plugins.custom.uc.userrolerelation.dao.IUserRoleRelationDao;

public class BaseUserRoleRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IUserRoleRelationDao userRoleRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(UserRoleRelation userRoleRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = userRoleRelationDao.insert(userRoleRelation);
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
	public ResultData delete(UserRoleRelation userRoleRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = userRoleRelationDao.delete(userRoleRelation);
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
			Integer result = userRoleRelationDao.deleteAll();
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
	public ResultData list(UserRoleRelation userRoleRelation){
		ResultData resultData = new ResultData();
		try {
			List<UserRoleRelation> userRoleRelationList = userRoleRelationDao.selectList(userRoleRelation);
			if (userRoleRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("userRoleRelationList", userRoleRelationList);
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
	public ResultData paginated(UserRoleRelation userRoleRelation){
		ResultData resultData = new ResultData();
		try {
			List<UserRoleRelation> userRoleRelationList = userRoleRelationDao.selectPaginatedList(userRoleRelation);
			Long userRoleRelationCount = userRoleRelationDao.getCount(userRoleRelation);
			if (userRoleRelationList != null){
				long record = userRoleRelationCount == null?0:userRoleRelationCount;
				int pageCount = (int) Math.ceil(record / (double) userRoleRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", userRoleRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", userRoleRelationList);
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
	
	public IUserRoleRelationDao getUserRoleRelationDao() {
		return userRoleRelationDao;
	}

	public void setUserRoleRelationDao(IUserRoleRelationDao userRoleRelationDao) {
		this.userRoleRelationDao = userRoleRelationDao;
	}
}
