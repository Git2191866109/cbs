package com.bs.plugins.custom.sc.agestages.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.agestages.entity.AgeStages;
import com.bs.plugins.custom.sc.agestages.dao.IAgeStagesDao;

public class BaseAgeStagesService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAgeStagesDao ageStagesDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 通用跳转
	 * @param entity
	 * @return
	 */
	public ResultData gopage(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			if (ageStages.getId() != null){
				ageStages = ageStagesDao.selectOneById(ageStages);
				resultData.addObject("ageStages", ageStages);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData save(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = ageStagesDao.insert(ageStages);
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
	public ResultData modify(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = ageStagesDao.updateById(ageStages);
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
	public ResultData modifyById(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = ageStagesDao.updateById(ageStages);
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
	public ResultData delete(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = ageStagesDao.delete(ageStages);
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
	public ResultData deleteById(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			Integer result = ageStagesDao.deleteById(ageStages);
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
			Integer result = ageStagesDao.deleteAll();
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
	public ResultData single(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			AgeStages ageStagesTemp = ageStagesDao.selectOneById(ageStages);
			if (ageStagesTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("ageStages", ageStagesTemp);
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
	public ResultData list(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			List<AgeStages> ageStagesList = ageStagesDao.selectList(ageStages);
			if (ageStagesList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("ageStagesList", ageStagesList);
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
	public ResultData paginated(AgeStages ageStages){
		ResultData resultData = new ResultData();
		try {
			List<AgeStages> ageStagesList = ageStagesDao.selectPaginatedList(ageStages);
			Long ageStagesCount = ageStagesDao.getCount(ageStages);
			if (ageStagesList != null){
				long record = ageStagesCount == null?0:ageStagesCount;
				int pageCount = (int) Math.ceil(record / (double) ageStages.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", ageStages.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", ageStagesList);
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
}
