package com.bs.plugins.custom.sc.parameter.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.parameter.entity.Parameter;
import com.bs.plugins.custom.sc.parameter.dao.IParameterDao;

public class BaseParameterService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IParameterDao parameterDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterDao.insert(parameter);
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
	public ResultData modify(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterDao.updateById(parameter);
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
	public ResultData modifyById(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterDao.updateById(parameter);
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
	public ResultData modifyComplete(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterDao.updateCompleteById(parameter);
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
	public ResultData delete(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterDao.delete(parameter);
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
	public ResultData deleteById(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterDao.deleteById(parameter);
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
			Integer result = parameterDao.deleteAll();
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
	public ResultData single(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			Parameter parameterTemp = parameterDao.selectOneById(parameter);
			if (parameterTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("parameter", parameterTemp);
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
	public ResultData list(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			List<Parameter> parameterList = parameterDao.selectList(parameter);
			if (parameterList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("parameterList", parameterList);
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
	public ResultData paginated(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			List<Parameter> parameterList = parameterDao.selectPaginatedList(parameter);
			Long parameterCount = parameterDao.getCount(parameter);
			if (parameterList != null){
				long record = parameterCount == null?0:parameterCount;
				int pageCount = (int) Math.ceil(record / (double) parameter.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", parameter.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", parameterList);
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
	
	public IParameterDao getParameterDao() {
		return parameterDao;
	}

	public void setParameterDao(IParameterDao parameterDao) {
		this.parameterDao = parameterDao;
	}
}
