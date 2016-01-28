package com.bs.plugins.custom.eb.budgetbasicinfo.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.budgetbasicinfo.entity.BudgetBasicInfo;
import com.bs.plugins.custom.eb.budgetbasicinfo.dao.IBudgetBasicInfoDao;

public class BaseBudgetBasicInfoService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBudgetBasicInfoDao budgetBasicInfoDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetBasicInfoDao.insert(budgetBasicInfo);
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
	public ResultData modify(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetBasicInfoDao.updateById(budgetBasicInfo);
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
	public ResultData modifyById(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetBasicInfoDao.updateById(budgetBasicInfo);
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
	public ResultData modifyComplete(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetBasicInfoDao.updateCompleteById(budgetBasicInfo);
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
	public ResultData delete(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetBasicInfoDao.delete(budgetBasicInfo);
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
	public ResultData deleteById(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = budgetBasicInfoDao.deleteById(budgetBasicInfo);
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
			Integer result = budgetBasicInfoDao.deleteAll();
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
	public ResultData single(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			BudgetBasicInfo budgetBasicInfoTemp = budgetBasicInfoDao.selectOneById(budgetBasicInfo);
			if (budgetBasicInfoTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetBasicInfo", budgetBasicInfoTemp);
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
	public ResultData list(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			List<BudgetBasicInfo> budgetBasicInfoList = budgetBasicInfoDao.selectList(budgetBasicInfo);
			if (budgetBasicInfoList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("budgetBasicInfoList", budgetBasicInfoList);
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
	public ResultData paginated(BudgetBasicInfo budgetBasicInfo){
		ResultData resultData = new ResultData();
		try {
			List<BudgetBasicInfo> budgetBasicInfoList = budgetBasicInfoDao.selectPaginatedList(budgetBasicInfo);
			Long budgetBasicInfoCount = budgetBasicInfoDao.getCount(budgetBasicInfo);
			if (budgetBasicInfoList != null){
				long record = budgetBasicInfoCount == null?0:budgetBasicInfoCount;
				int pageCount = (int) Math.ceil(record / (double) budgetBasicInfo.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetBasicInfo.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetBasicInfoList);
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
	
	public IBudgetBasicInfoDao getBudgetBasicInfoDao() {
		return budgetBasicInfoDao;
	}

	public void setBudgetBasicInfoDao(IBudgetBasicInfoDao budgetBasicInfoDao) {
		this.budgetBasicInfoDao = budgetBasicInfoDao;
	}
}
