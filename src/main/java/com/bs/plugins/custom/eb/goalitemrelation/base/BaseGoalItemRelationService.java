package com.bs.plugins.custom.eb.goalitemrelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.goalitemrelation.entity.GoalItemRelation;
import com.bs.plugins.custom.eb.goalitemrelation.dao.IGoalItemRelationDao;

public class BaseGoalItemRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IGoalItemRelationDao goalItemRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalItemRelationDao.insert(goalItemRelation);
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
	public ResultData modify(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalItemRelationDao.updateById(goalItemRelation);
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
	public ResultData modifyById(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalItemRelationDao.updateById(goalItemRelation);
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
	public ResultData modifyComplete(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalItemRelationDao.updateCompleteById(goalItemRelation);
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
	public ResultData delete(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalItemRelationDao.delete(goalItemRelation);
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
	public ResultData deleteById(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalItemRelationDao.deleteById(goalItemRelation);
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
			Integer result = goalItemRelationDao.deleteAll();
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
	public ResultData single(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			GoalItemRelation goalItemRelationTemp = goalItemRelationDao.selectOneById(goalItemRelation);
			if (goalItemRelationTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("goalItemRelation", goalItemRelationTemp);
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
	public ResultData list(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			List<GoalItemRelation> goalItemRelationList = goalItemRelationDao.selectList(goalItemRelation);
			if (goalItemRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("goalItemRelationList", goalItemRelationList);
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
	public ResultData paginated(GoalItemRelation goalItemRelation){
		ResultData resultData = new ResultData();
		try {
			List<GoalItemRelation> goalItemRelationList = goalItemRelationDao.selectPaginatedList(goalItemRelation);
			Long goalItemRelationCount = goalItemRelationDao.getCount(goalItemRelation);
			if (goalItemRelationList != null){
				long record = goalItemRelationCount == null?0:goalItemRelationCount;
				int pageCount = (int) Math.ceil(record / (double) goalItemRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", goalItemRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", goalItemRelationList);
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
	
	public IGoalItemRelationDao getGoalItemRelationDao() {
		return goalItemRelationDao;
	}

	public void setGoalItemRelationDao(IGoalItemRelationDao goalItemRelationDao) {
		this.goalItemRelationDao = goalItemRelationDao;
	}
}
