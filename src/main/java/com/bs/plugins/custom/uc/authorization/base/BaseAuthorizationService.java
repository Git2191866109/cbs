package com.bs.plugins.custom.uc.authorization.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.uc.authorization.entity.Authorization;
import com.bs.plugins.custom.uc.authorization.dao.IAuthorizationDao;

public class BaseAuthorizationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAuthorizationDao authorizationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			Integer result = authorizationDao.insert(authorization);
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
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modify(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			Integer result = authorizationDao.updateById(authorization);
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
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modifyById(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			Integer result = authorizationDao.updateById(authorization);
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
	 * 修改(完全修改)
	 * @param entity
	 * @return
	 */
	public ResultData modifyComplete(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			Integer result = authorizationDao.updateCompleteById(authorization);
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
	public ResultData delete(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			Integer result = authorizationDao.delete(authorization);
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
	public ResultData deleteById(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			Integer result = authorizationDao.deleteById(authorization);
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
			Integer result = authorizationDao.deleteAll();
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
	 * 查询单条数据
	 * @param entity
	 * @return
	*/
	public ResultData single(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			Authorization authorizationTemp = authorizationDao.selectOneById(authorization);
			if (authorizationTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("authorization", authorizationTemp);
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
	public ResultData list(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			List<Authorization> authorizationList = authorizationDao.selectList(authorization);
			if (authorizationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("authorizationList", authorizationList);
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
	public ResultData paginated(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			List<Authorization> authorizationList = authorizationDao.selectPaginatedList(authorization);
			Long authorizationCount = authorizationDao.getCount(authorization);
			if (authorizationList != null){
				long record = authorizationCount == null?0:authorizationCount;
				int pageCount = (int) Math.ceil(record / (double) authorization.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", authorization.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", authorizationList);
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
	
	public IAuthorizationDao getAuthorizationDao() {
		return authorizationDao;
	}

	public void setAuthorizationDao(IAuthorizationDao authorizationDao) {
		this.authorizationDao = authorizationDao;
	}
}
