package com.bs.plugins.custom.eb.goalbudgetrelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.goalbudgetrelation.entity.GoalBudgetRelation;
import com.bs.plugins.custom.eb.goalbudgetrelation.dao.IGoalBudgetRelationDao;

public class BaseGoalBudgetRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IGoalBudgetRelationDao goalBudgetRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalBudgetRelationDao.insert(goalBudgetRelation);
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
	public ResultData modify(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalBudgetRelationDao.updateById(goalBudgetRelation);
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
	public ResultData modifyById(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalBudgetRelationDao.updateById(goalBudgetRelation);
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
	public ResultData delete(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalBudgetRelationDao.delete(goalBudgetRelation);
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
	public ResultData deleteById(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = goalBudgetRelationDao.deleteById(goalBudgetRelation);
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
			Integer result = goalBudgetRelationDao.deleteAll();
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
	public ResultData single(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			GoalBudgetRelation goalBudgetRelationTemp = goalBudgetRelationDao.selectOneById(goalBudgetRelation);
			if (goalBudgetRelationTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("goalBudgetRelation", goalBudgetRelationTemp);
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
	public ResultData list(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			List<GoalBudgetRelation> goalBudgetRelationList = goalBudgetRelationDao.selectList(goalBudgetRelation);
			if (goalBudgetRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("goalBudgetRelationList", goalBudgetRelationList);
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
	public ResultData paginated(GoalBudgetRelation goalBudgetRelation){
		ResultData resultData = new ResultData();
		try {
			List<GoalBudgetRelation> goalBudgetRelationList = goalBudgetRelationDao.selectPaginatedList(goalBudgetRelation);
			Long goalBudgetRelationCount = goalBudgetRelationDao.getCount(goalBudgetRelation);
			if (goalBudgetRelationList != null){
				long record = goalBudgetRelationCount == null?0:goalBudgetRelationCount;
				int pageCount = (int) Math.ceil(record / (double) goalBudgetRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", goalBudgetRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", goalBudgetRelationList);
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
	
	public IGoalBudgetRelationDao getGoalBudgetRelationDao() {
		return goalBudgetRelationDao;
	}

	public void setGoalBudgetRelationDao(IGoalBudgetRelationDao goalBudgetRelationDao) {
		this.goalBudgetRelationDao = goalBudgetRelationDao;
	}
}
