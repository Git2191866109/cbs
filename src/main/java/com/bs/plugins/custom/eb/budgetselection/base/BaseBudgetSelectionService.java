package com.bs.plugins.custom.eb.budgetselection.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetselection.entity.BudgetSelection;
import com.bs.plugins.custom.eb.budgetselection.dao.IBudgetSelectionDao;

public class BaseBudgetSelectionService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetSelectionDao budgetSelectionDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetSelectionDao.insert(budgetSelection);
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
	public ResultData modify(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetSelectionDao.updateById(budgetSelection);
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
	public ResultData modifyById(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetSelectionDao.updateById(budgetSelection);
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
	public ResultData modifyComplete(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetSelectionDao.updateCompleteById(budgetSelection);
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
	public ResultData delete(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetSelectionDao.delete(budgetSelection);
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
	public ResultData deleteById(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetSelectionDao.deleteById(budgetSelection);
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
			Integer result = budgetSelectionDao.deleteAll();
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
	public ResultData single(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			BudgetSelection budgetSelectionTemp = budgetSelectionDao.selectOneById(budgetSelection);
			if (budgetSelectionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetSelection", budgetSelectionTemp);
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
	public ResultData list(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			List<BudgetSelection> budgetSelectionList = budgetSelectionDao.selectList(budgetSelection);
			if (budgetSelectionList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetSelectionList", budgetSelectionList);
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
	public ResultData paginated(BudgetSelection budgetSelection){
		ResultData resultData = new ResultData();
		try {
			List<BudgetSelection> budgetSelectionList = budgetSelectionDao.selectPaginatedList(budgetSelection);
			Long budgetSelectionCount = budgetSelectionDao.getCount(budgetSelection);
			if (budgetSelectionList != null){
				long record = budgetSelectionCount == null?0:budgetSelectionCount;
				int pageCount = (int) Math.ceil(record / (double) budgetSelection.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetSelection.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetSelectionList);
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
	
	public IBudgetSelectionDao getBudgetSelectionDao() {
		return budgetSelectionDao;
	}

	public void setBudgetSelectionDao(IBudgetSelectionDao budgetSelectionDao) {
		this.budgetSelectionDao = budgetSelectionDao;
	}
}
