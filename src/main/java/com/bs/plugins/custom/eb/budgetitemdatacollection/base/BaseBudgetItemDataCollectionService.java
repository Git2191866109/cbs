package com.bs.plugins.custom.eb.budgetitemdatacollection.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetitemdatacollection.entity.BudgetItemDataCollection;
import com.bs.plugins.custom.eb.budgetitemdatacollection.dao.IBudgetItemDataCollectionDao;

public class BaseBudgetItemDataCollectionService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetItemDataCollectionDao budgetItemDataCollectionDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataCollectionDao.insert(budgetItemDataCollection);
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
	public ResultData modify(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataCollectionDao.updateById(budgetItemDataCollection);
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
	public ResultData modifyById(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataCollectionDao.updateById(budgetItemDataCollection);
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
	public ResultData modifyComplete(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataCollectionDao.updateCompleteById(budgetItemDataCollection);
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
	public ResultData delete(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataCollectionDao.delete(budgetItemDataCollection);
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
	public ResultData deleteById(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataCollectionDao.deleteById(budgetItemDataCollection);
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
			Integer result = budgetItemDataCollectionDao.deleteAll();
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
	public ResultData single(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			BudgetItemDataCollection budgetItemDataCollectionTemp = budgetItemDataCollectionDao.selectOneById(budgetItemDataCollection);
			if (budgetItemDataCollectionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetItemDataCollection", budgetItemDataCollectionTemp);
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
	public ResultData list(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItemDataCollection> budgetItemDataCollectionList = budgetItemDataCollectionDao.selectList(budgetItemDataCollection);
			if (budgetItemDataCollectionList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetItemDataCollectionList", budgetItemDataCollectionList);
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
	public ResultData paginated(BudgetItemDataCollection budgetItemDataCollection){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItemDataCollection> budgetItemDataCollectionList = budgetItemDataCollectionDao.selectPaginatedList(budgetItemDataCollection);
			Long budgetItemDataCollectionCount = budgetItemDataCollectionDao.getCount(budgetItemDataCollection);
			if (budgetItemDataCollectionList != null){
				long record = budgetItemDataCollectionCount == null?0:budgetItemDataCollectionCount;
				int pageCount = (int) Math.ceil(record / (double) budgetItemDataCollection.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetItemDataCollection.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetItemDataCollectionList);
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
	
	public IBudgetItemDataCollectionDao getBudgetItemDataCollectionDao() {
		return budgetItemDataCollectionDao;
	}

	public void setBudgetItemDataCollectionDao(IBudgetItemDataCollectionDao budgetItemDataCollectionDao) {
		this.budgetItemDataCollectionDao = budgetItemDataCollectionDao;
	}
}
