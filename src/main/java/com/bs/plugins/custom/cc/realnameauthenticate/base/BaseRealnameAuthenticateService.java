package com.bs.plugins.custom.cc.realnameauthenticate.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.realnameauthenticate.entity.RealnameAuthenticate;
import com.bs.plugins.custom.cc.realnameauthenticate.dao.IRealnameAuthenticateDao;

public class BaseRealnameAuthenticateService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IRealnameAuthenticateDao realnameAuthenticateDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			Integer result = realnameAuthenticateDao.insert(realnameAuthenticate);
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
	public ResultData modify(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			Integer result = realnameAuthenticateDao.updateById(realnameAuthenticate);
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
	public ResultData modifyById(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			Integer result = realnameAuthenticateDao.updateById(realnameAuthenticate);
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
	public ResultData modifyComplete(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			Integer result = realnameAuthenticateDao.updateCompleteById(realnameAuthenticate);
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
	public ResultData delete(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			Integer result = realnameAuthenticateDao.delete(realnameAuthenticate);
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
	public ResultData deleteById(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			Integer result = realnameAuthenticateDao.deleteById(realnameAuthenticate);
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
			Integer result = realnameAuthenticateDao.deleteAll();
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
	public ResultData single(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			RealnameAuthenticate realnameAuthenticateTemp = realnameAuthenticateDao.selectOneById(realnameAuthenticate);
			if (realnameAuthenticateTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("realnameAuthenticate", realnameAuthenticateTemp);
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
	public ResultData list(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			List<RealnameAuthenticate> realnameAuthenticateList = realnameAuthenticateDao.selectList(realnameAuthenticate);
			if (realnameAuthenticateList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("realnameAuthenticateList", realnameAuthenticateList);
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
	public ResultData paginated(RealnameAuthenticate realnameAuthenticate){
		ResultData resultData = new ResultData();
		try {
			List<RealnameAuthenticate> realnameAuthenticateList = realnameAuthenticateDao.selectPaginatedList(realnameAuthenticate);
			Long realnameAuthenticateCount = realnameAuthenticateDao.getCount(realnameAuthenticate);
			if (realnameAuthenticateList != null){
				long record = realnameAuthenticateCount == null?0:realnameAuthenticateCount;
				int pageCount = (int) Math.ceil(record / (double) realnameAuthenticate.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", realnameAuthenticate.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", realnameAuthenticateList);
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
	
	public IRealnameAuthenticateDao getRealnameAuthenticateDao() {
		return realnameAuthenticateDao;
	}

	public void setRealnameAuthenticateDao(IRealnameAuthenticateDao realnameAuthenticateDao) {
		this.realnameAuthenticateDao = realnameAuthenticateDao;
	}
}
