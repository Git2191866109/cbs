package com.bs.plugins.custom.eb.stagescategory.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.stagescategory.entity.StagesCategory;
import com.bs.plugins.custom.eb.stagescategory.dao.IStagesCategoryDao;

public class BaseStagesCategoryService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IStagesCategoryDao stagesCategoryDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = stagesCategoryDao.insert(stagesCategory);
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
	public ResultData modify(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = stagesCategoryDao.updateById(stagesCategory);
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
	public ResultData modifyById(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = stagesCategoryDao.updateById(stagesCategory);
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
	public ResultData delete(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = stagesCategoryDao.delete(stagesCategory);
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
	public ResultData deleteById(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = stagesCategoryDao.deleteById(stagesCategory);
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
			Integer result = stagesCategoryDao.deleteAll();
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
	public ResultData single(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			StagesCategory stagesCategoryTemp = stagesCategoryDao.selectOneById(stagesCategory);
			if (stagesCategoryTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("stagesCategory", stagesCategoryTemp);
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
	public ResultData list(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			List<StagesCategory> stagesCategoryList = stagesCategoryDao.selectList(stagesCategory);
			if (stagesCategoryList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("stagesCategoryList", stagesCategoryList);
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
	public ResultData paginated(StagesCategory stagesCategory){
		ResultData resultData = new ResultData();
		try {
			List<StagesCategory> stagesCategoryList = stagesCategoryDao.selectPaginatedList(stagesCategory);
			Long stagesCategoryCount = stagesCategoryDao.getCount(stagesCategory);
			if (stagesCategoryList != null){
				long record = stagesCategoryCount == null?0:stagesCategoryCount;
				int pageCount = (int) Math.ceil(record / (double) stagesCategory.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", stagesCategory.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", stagesCategoryList);
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
	
	public IStagesCategoryDao getStagesCategoryDao() {
		return stagesCategoryDao;
	}

	public void setStagesCategoryDao(IStagesCategoryDao stagesCategoryDao) {
		this.stagesCategoryDao = stagesCategoryDao;
	}
}
