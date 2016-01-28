package com.bs.plugins.custom.eb.budgetlist.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetlist.entity.BudgetList;
import com.bs.plugins.custom.eb.budgetlist.dao.IBudgetListDao;

public class BaseBudgetListService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetListDao budgetListDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetListDao.insert(budgetList);
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
	public ResultData modify(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetListDao.updateById(budgetList);
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
	public ResultData modifyById(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetListDao.updateById(budgetList);
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
	public ResultData delete(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetListDao.delete(budgetList);
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
	public ResultData deleteById(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetListDao.deleteById(budgetList);
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
			Integer result = budgetListDao.deleteAll();
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
	public ResultData single(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			BudgetList budgetListTemp = budgetListDao.selectOneById(budgetList);
			if (budgetListTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetList", budgetListTemp);
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
	public ResultData list(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			List<BudgetList> budgetListList = budgetListDao.selectList(budgetList);
			if (budgetListList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetListList", budgetListList);
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
	public ResultData paginated(BudgetList budgetList){
		ResultData resultData = new ResultData();
		try {
			List<BudgetList> budgetListList = budgetListDao.selectPaginatedList(budgetList);
			Long budgetListCount = budgetListDao.getCount(budgetList);
			if (budgetListList != null){
				long record = budgetListCount == null?0:budgetListCount;
				int pageCount = (int) Math.ceil(record / (double) budgetList.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetList.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetListList);
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
	
	public IBudgetListDao getBudgetListDao() {
		return budgetListDao;
	}

	public void setBudgetListDao(IBudgetListDao budgetListDao) {
		this.budgetListDao = budgetListDao;
	}
}
