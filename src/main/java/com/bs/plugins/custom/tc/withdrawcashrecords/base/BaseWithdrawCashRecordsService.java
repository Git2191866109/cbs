package com.bs.plugins.custom.tc.withdrawcashrecords.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.withdrawcashrecords.entity.WithdrawCashRecords;
import com.bs.plugins.custom.tc.withdrawcashrecords.dao.IWithdrawCashRecordsDao;

public class BaseWithdrawCashRecordsService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IWithdrawCashRecordsDao withdrawCashRecordsDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = withdrawCashRecordsDao.insert(withdrawCashRecords);
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
	public ResultData modify(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = withdrawCashRecordsDao.updateById(withdrawCashRecords);
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
	public ResultData modifyById(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = withdrawCashRecordsDao.updateById(withdrawCashRecords);
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
	public ResultData modifyComplete(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = withdrawCashRecordsDao.updateCompleteById(withdrawCashRecords);
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
	public ResultData delete(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = withdrawCashRecordsDao.delete(withdrawCashRecords);
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
	public ResultData deleteById(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = withdrawCashRecordsDao.deleteById(withdrawCashRecords);
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
			Integer result = withdrawCashRecordsDao.deleteAll();
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
	public ResultData single(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			WithdrawCashRecords withdrawCashRecordsTemp = withdrawCashRecordsDao.selectOneById(withdrawCashRecords);
			if (withdrawCashRecordsTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("withdrawCashRecords", withdrawCashRecordsTemp);
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
	public ResultData list(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			List<WithdrawCashRecords> withdrawCashRecordsList = withdrawCashRecordsDao.selectList(withdrawCashRecords);
			if (withdrawCashRecordsList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("withdrawCashRecordsList", withdrawCashRecordsList);
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
	public ResultData paginated(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			List<WithdrawCashRecords> withdrawCashRecordsList = withdrawCashRecordsDao.selectPaginatedList(withdrawCashRecords);
			Long withdrawCashRecordsCount = withdrawCashRecordsDao.getCount(withdrawCashRecords);
			if (withdrawCashRecordsList != null){
				long record = withdrawCashRecordsCount == null?0:withdrawCashRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) withdrawCashRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", withdrawCashRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", withdrawCashRecordsList);
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
	
	public IWithdrawCashRecordsDao getWithdrawCashRecordsDao() {
		return withdrawCashRecordsDao;
	}

	public void setWithdrawCashRecordsDao(IWithdrawCashRecordsDao withdrawCashRecordsDao) {
		this.withdrawCashRecordsDao = withdrawCashRecordsDao;
	}
}
