package com.bs.plugins.custom.eb.budgetcategory.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.budgetcategory.dao.IBudgetCategoryDao;

public class BaseBudgetCategoryService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetCategoryDao budgetCategoryDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetCategoryDao.insert(budgetCategory);
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
	public ResultData modify(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetCategoryDao.updateById(budgetCategory);
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
	public ResultData modifyById(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetCategoryDao.updateById(budgetCategory);
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
	public ResultData modifyComplete(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetCategoryDao.updateCompleteById(budgetCategory);
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
	public ResultData delete(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetCategoryDao.delete(budgetCategory);
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
	public ResultData deleteById(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetCategoryDao.deleteById(budgetCategory);
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
			Integer result = budgetCategoryDao.deleteAll();
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
	public ResultData single(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			BudgetCategory budgetCategoryTemp = budgetCategoryDao.selectOneById(budgetCategory);
			if (budgetCategoryTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetCategory", budgetCategoryTemp);
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
	public ResultData list(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			List<BudgetCategory> budgetCategoryList = budgetCategoryDao.selectList(budgetCategory);
			if (budgetCategoryList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetCategoryList", budgetCategoryList);
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
	public ResultData paginated(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			List<BudgetCategory> budgetCategoryList = budgetCategoryDao.selectPaginatedList(budgetCategory);
			Long budgetCategoryCount = budgetCategoryDao.getCount(budgetCategory);
			if (budgetCategoryList != null){
				long record = budgetCategoryCount == null?0:budgetCategoryCount;
				int pageCount = (int) Math.ceil(record / (double) budgetCategory.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetCategory.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetCategoryList);
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
	
	public IBudgetCategoryDao getBudgetCategoryDao() {
		return budgetCategoryDao;
	}

	public void setBudgetCategoryDao(IBudgetCategoryDao budgetCategoryDao) {
		this.budgetCategoryDao = budgetCategoryDao;
	}
}
