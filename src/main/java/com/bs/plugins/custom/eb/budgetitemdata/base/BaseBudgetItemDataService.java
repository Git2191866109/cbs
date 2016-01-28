package com.bs.plugins.custom.eb.budgetitemdata.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;
import com.bs.plugins.custom.eb.budgetitemdata.dao.IBudgetItemDataDao;

public class BaseBudgetItemDataService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetItemDataDao budgetItemDataDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataDao.insert(budgetItemData);
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
	public ResultData modify(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataDao.updateById(budgetItemData);
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
	public ResultData modifyById(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataDao.updateById(budgetItemData);
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
	public ResultData modifyComplete(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataDao.updateCompleteById(budgetItemData);
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
	public ResultData delete(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataDao.delete(budgetItemData);
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
	public ResultData deleteById(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetItemDataDao.deleteById(budgetItemData);
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
			Integer result = budgetItemDataDao.deleteAll();
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
	public ResultData single(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			BudgetItemData budgetItemDataTemp = budgetItemDataDao.selectOneById(budgetItemData);
			if (budgetItemDataTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetItemData", budgetItemDataTemp);
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
	public ResultData list(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItemData> budgetItemDataList = budgetItemDataDao.selectList(budgetItemData);
			if (budgetItemDataList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetItemDataList", budgetItemDataList);
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
	public ResultData paginated(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItemData> budgetItemDataList = budgetItemDataDao.selectPaginatedList(budgetItemData);
			Long budgetItemDataCount = budgetItemDataDao.getCount(budgetItemData);
			if (budgetItemDataList != null){
				long record = budgetItemDataCount == null?0:budgetItemDataCount;
				int pageCount = (int) Math.ceil(record / (double) budgetItemData.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetItemData.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetItemDataList);
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
	
	public IBudgetItemDataDao getBudgetItemDataDao() {
		return budgetItemDataDao;
	}

	public void setBudgetItemDataDao(IBudgetItemDataDao budgetItemDataDao) {
		this.budgetItemDataDao = budgetItemDataDao;
	}
}
