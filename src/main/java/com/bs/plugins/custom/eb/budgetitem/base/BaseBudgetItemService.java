package com.bs.plugins.custom.eb.budgetitem.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;
import com.bs.plugins.custom.eb.budgetitem.dao.IBudgetItemDao;

public class BaseBudgetItemService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetItemDao budgetItemDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDao.insert(budgetItem);
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
	public ResultData modify(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDao.updateById(budgetItem);
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
	public ResultData modifyById(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDao.updateById(budgetItem);
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
	public ResultData modifyComplete(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDao.updateCompleteById(budgetItem);
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
	public ResultData delete(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDao.delete(budgetItem);
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
	public ResultData deleteById(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDao.deleteById(budgetItem);
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
			Integer result = budgetItemDao.deleteAll();
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
	public ResultData single(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			BudgetItem budgetItemTemp = budgetItemDao.selectOneById(budgetItem);
			if (budgetItemTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetItem", budgetItemTemp);
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
	public ResultData list(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItem> budgetItemList = budgetItemDao.selectList(budgetItem);
			if (budgetItemList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetItemList", budgetItemList);
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
	public ResultData paginated(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItem> budgetItemList = budgetItemDao.selectPaginatedList(budgetItem);
			Long budgetItemCount = budgetItemDao.getCount(budgetItem);
			if (budgetItemList != null){
				long record = budgetItemCount == null?0:budgetItemCount;
				int pageCount = (int) Math.ceil(record / (double) budgetItem.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetItem.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetItemList);
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
	
	public IBudgetItemDao getBudgetItemDao() {
		return budgetItemDao;
	}

	public void setBudgetItemDao(IBudgetItemDao budgetItemDao) {
		this.budgetItemDao = budgetItemDao;
	}
}
