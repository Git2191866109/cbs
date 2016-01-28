package com.bs.plugins.custom.eb.growstages.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.growstages.dao.IGrowStagesDao;

public class BaseGrowStagesService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IGrowStagesDao growStagesDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = growStagesDao.insert(growStages);
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
	public ResultData modify(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = growStagesDao.updateById(growStages);
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
	public ResultData modifyById(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = growStagesDao.updateById(growStages);
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
	public ResultData modifyComplete(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = growStagesDao.updateCompleteById(growStages);
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
	public ResultData delete(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = growStagesDao.delete(growStages);
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
	public ResultData deleteById(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = growStagesDao.deleteById(growStages);
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
			Integer result = growStagesDao.deleteAll();
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
	public ResultData single(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			GrowStages growStagesTemp = growStagesDao.selectOneById(growStages);
			if (growStagesTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("growStages", growStagesTemp);
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
	public ResultData list(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			List<GrowStages> growStagesList = growStagesDao.selectList(growStages);
			if (growStagesList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("growStagesList", growStagesList);
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
	public ResultData paginated(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			List<GrowStages> growStagesList = growStagesDao.selectPaginatedList(growStages);
			Long growStagesCount = growStagesDao.getCount(growStages);
			if (growStagesList != null){
				long record = growStagesCount == null?0:growStagesCount;
				int pageCount = (int) Math.ceil(record / (double) growStages.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", growStages.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", growStagesList);
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
	
	public IGrowStagesDao getGrowStagesDao() {
		return growStagesDao;
	}

	public void setGrowStagesDao(IGrowStagesDao growStagesDao) {
		this.growStagesDao = growStagesDao;
	}
}
