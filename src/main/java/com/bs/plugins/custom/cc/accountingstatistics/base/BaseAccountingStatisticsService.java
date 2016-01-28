package com.bs.plugins.custom.cc.accountingstatistics.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.accountingstatistics.entity.AccountingStatistics;
import com.bs.plugins.custom.cc.accountingstatistics.dao.IAccountingStatisticsDao;

public class BaseAccountingStatisticsService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAccountingStatisticsDao accountingStatisticsDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingStatisticsDao.insert(accountingStatistics);
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
	public ResultData modify(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingStatisticsDao.updateById(accountingStatistics);
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
	public ResultData modifyById(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingStatisticsDao.updateById(accountingStatistics);
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
	public ResultData modifyComplete(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingStatisticsDao.updateCompleteById(accountingStatistics);
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
	public ResultData delete(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingStatisticsDao.delete(accountingStatistics);
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
	public ResultData deleteById(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingStatisticsDao.deleteById(accountingStatistics);
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
			Integer result = accountingStatisticsDao.deleteAll();
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
	public ResultData single(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			AccountingStatistics accountingStatisticsTemp = accountingStatisticsDao.selectOneById(accountingStatistics);
			if (accountingStatisticsTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("accountingStatistics", accountingStatisticsTemp);
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
	public ResultData list(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			List<AccountingStatistics> accountingStatisticsList = accountingStatisticsDao.selectList(accountingStatistics);
			if (accountingStatisticsList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("accountingStatisticsList", accountingStatisticsList);
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
	public ResultData paginated(AccountingStatistics accountingStatistics){
		ResultData resultData = new ResultData();
		try {
			List<AccountingStatistics> accountingStatisticsList = accountingStatisticsDao.selectPaginatedList(accountingStatistics);
			Long accountingStatisticsCount = accountingStatisticsDao.getCount(accountingStatistics);
			if (accountingStatisticsList != null){
				long record = accountingStatisticsCount == null?0:accountingStatisticsCount;
				int pageCount = (int) Math.ceil(record / (double) accountingStatistics.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", accountingStatistics.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", accountingStatisticsList);
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
	
	public IAccountingStatisticsDao getAccountingStatisticsDao() {
		return accountingStatisticsDao;
	}

	public void setAccountingStatisticsDao(IAccountingStatisticsDao accountingStatisticsDao) {
		this.accountingStatisticsDao = accountingStatisticsDao;
	}
}
