package com.bs.plugins.custom.sc.parametercategory.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.parametercategory.entity.ParameterCategory;
import com.bs.plugins.custom.sc.parametercategory.dao.IParameterCategoryDao;

public class BaseParameterCategoryService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IParameterCategoryDao parameterCategoryDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterCategoryDao.insert(parameterCategory);
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
	public ResultData modify(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterCategoryDao.updateById(parameterCategory);
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
	public ResultData modifyById(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterCategoryDao.updateById(parameterCategory);
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
	public ResultData modifyComplete(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterCategoryDao.updateCompleteById(parameterCategory);
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
	public ResultData delete(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterCategoryDao.delete(parameterCategory);
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
	public ResultData deleteById(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = parameterCategoryDao.deleteById(parameterCategory);
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
			Integer result = parameterCategoryDao.deleteAll();
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
	public ResultData single(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			ParameterCategory parameterCategoryTemp = parameterCategoryDao.selectOneById(parameterCategory);
			if (parameterCategoryTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("parameterCategory", parameterCategoryTemp);
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
	public ResultData list(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			List<ParameterCategory> parameterCategoryList = parameterCategoryDao.selectList(parameterCategory);
			if (parameterCategoryList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("parameterCategoryList", parameterCategoryList);
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
	public ResultData paginated(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			List<ParameterCategory> parameterCategoryList = parameterCategoryDao.selectPaginatedList(parameterCategory);
			Long parameterCategoryCount = parameterCategoryDao.getCount(parameterCategory);
			if (parameterCategoryList != null){
				long record = parameterCategoryCount == null?0:parameterCategoryCount;
				int pageCount = (int) Math.ceil(record / (double) parameterCategory.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", parameterCategory.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", parameterCategoryList);
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
	
	public IParameterCategoryDao getParameterCategoryDao() {
		return parameterCategoryDao;
	}

	public void setParameterCategoryDao(IParameterCategoryDao parameterCategoryDao) {
		this.parameterCategoryDao = parameterCategoryDao;
	}
}
