package com.bs.plugins.custom.tc.spvwithdrawcashrecords.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.spvwithdrawcashrecords.entity.SpvWithdrawCashRecords;
import com.bs.plugins.custom.tc.spvwithdrawcashrecords.dao.ISpvWithdrawCashRecordsDao;

public class BaseSpvWithdrawCashRecordsService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISpvWithdrawCashRecordsDao spvWithdrawCashRecordsDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvWithdrawCashRecordsDao.insert(spvWithdrawCashRecords);
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
	public ResultData modify(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvWithdrawCashRecordsDao.updateById(spvWithdrawCashRecords);
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
	public ResultData modifyById(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvWithdrawCashRecordsDao.updateById(spvWithdrawCashRecords);
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
	public ResultData modifyComplete(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvWithdrawCashRecordsDao.updateCompleteById(spvWithdrawCashRecords);
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
	public ResultData delete(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvWithdrawCashRecordsDao.delete(spvWithdrawCashRecords);
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
	public ResultData deleteById(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvWithdrawCashRecordsDao.deleteById(spvWithdrawCashRecords);
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
			Integer result = spvWithdrawCashRecordsDao.deleteAll();
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
	public ResultData single(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			SpvWithdrawCashRecords spvWithdrawCashRecordsTemp = spvWithdrawCashRecordsDao.selectOneById(spvWithdrawCashRecords);
			if (spvWithdrawCashRecordsTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvWithdrawCashRecords", spvWithdrawCashRecordsTemp);
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
	public ResultData list(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			List<SpvWithdrawCashRecords> spvWithdrawCashRecordsList = spvWithdrawCashRecordsDao.selectList(spvWithdrawCashRecords);
			if (spvWithdrawCashRecordsList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvWithdrawCashRecordsList", spvWithdrawCashRecordsList);
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
	public ResultData paginated(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			List<SpvWithdrawCashRecords> spvWithdrawCashRecordsList = spvWithdrawCashRecordsDao.selectPaginatedList(spvWithdrawCashRecords);
			Long spvWithdrawCashRecordsCount = spvWithdrawCashRecordsDao.getCount(spvWithdrawCashRecords);
			if (spvWithdrawCashRecordsList != null){
				long record = spvWithdrawCashRecordsCount == null?0:spvWithdrawCashRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) spvWithdrawCashRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvWithdrawCashRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", spvWithdrawCashRecordsList);
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
	
	public ISpvWithdrawCashRecordsDao getSpvWithdrawCashRecordsDao() {
		return spvWithdrawCashRecordsDao;
	}

	public void setSpvWithdrawCashRecordsDao(ISpvWithdrawCashRecordsDao spvWithdrawCashRecordsDao) {
		this.spvWithdrawCashRecordsDao = spvWithdrawCashRecordsDao;
	}
}
