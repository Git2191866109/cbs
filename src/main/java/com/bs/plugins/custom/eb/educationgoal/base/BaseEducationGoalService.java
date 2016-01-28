package com.bs.plugins.custom.eb.educationgoal.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;
import com.bs.plugins.custom.eb.educationgoal.dao.IEducationGoalDao;

public class BaseEducationGoalService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IEducationGoalDao educationGoalDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationGoalDao.insert(educationGoal);
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
	public ResultData modify(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationGoalDao.updateById(educationGoal);
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
	public ResultData modifyById(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationGoalDao.updateById(educationGoal);
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
	public ResultData modifyComplete(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationGoalDao.updateCompleteById(educationGoal);
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
	public ResultData delete(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationGoalDao.delete(educationGoal);
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
	public ResultData deleteById(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationGoalDao.deleteById(educationGoal);
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
			Integer result = educationGoalDao.deleteAll();
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
	public ResultData single(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			EducationGoal educationGoalTemp = educationGoalDao.selectOneById(educationGoal);
			if (educationGoalTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("educationGoal", educationGoalTemp);
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
	public ResultData list(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			List<EducationGoal> educationGoalList = educationGoalDao.selectList(educationGoal);
			if (educationGoalList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("educationGoalList", educationGoalList);
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
	public ResultData paginated(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			List<EducationGoal> educationGoalList = educationGoalDao.selectPaginatedList(educationGoal);
			Long educationGoalCount = educationGoalDao.getCount(educationGoal);
			if (educationGoalList != null){
				long record = educationGoalCount == null?0:educationGoalCount;
				int pageCount = (int) Math.ceil(record / (double) educationGoal.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", educationGoal.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", educationGoalList);
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
	
	public IEducationGoalDao getEducationGoalDao() {
		return educationGoalDao;
	}

	public void setEducationGoalDao(IEducationGoalDao educationGoalDao) {
		this.educationGoalDao = educationGoalDao;
	}
}
