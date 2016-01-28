package com.bs.plugins.custom.eb.budgetdatarelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetdatarelation.entity.BudgetDataRelation;
import com.bs.plugins.custom.eb.budgetdatarelation.dao.IBudgetDataRelationDao;

public class BaseBudgetDataRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetDataRelationDao budgetDataRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetDataRelation budgetDataRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetDataRelationDao.insert(budgetDataRelation);
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
	public ResultData delete(BudgetDataRelation budgetDataRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetDataRelationDao.delete(budgetDataRelation);
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
			Integer result = budgetDataRelationDao.deleteAll();
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
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(BudgetDataRelation budgetDataRelation){
		ResultData resultData = new ResultData();
		try {
			List<BudgetDataRelation> budgetDataRelationList = budgetDataRelationDao.selectList(budgetDataRelation);
			if (budgetDataRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetDataRelationList", budgetDataRelationList);
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
	public ResultData paginated(BudgetDataRelation budgetDataRelation){
		ResultData resultData = new ResultData();
		try {
			List<BudgetDataRelation> budgetDataRelationList = budgetDataRelationDao.selectPaginatedList(budgetDataRelation);
			Long budgetDataRelationCount = budgetDataRelationDao.getCount(budgetDataRelation);
			if (budgetDataRelationList != null){
				long record = budgetDataRelationCount == null?0:budgetDataRelationCount;
				int pageCount = (int) Math.ceil(record / (double) budgetDataRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetDataRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetDataRelationList);
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
	
	public IBudgetDataRelationDao getBudgetDataRelationDao() {
		return budgetDataRelationDao;
	}

	public void setBudgetDataRelationDao(IBudgetDataRelationDao budgetDataRelationDao) {
		this.budgetDataRelationDao = budgetDataRelationDao;
	}
}
