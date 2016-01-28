package com.bs.plugins.custom.tc.rechargerecords.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.rechargerecords.entity.RechargeRecords;
import com.bs.plugins.custom.tc.rechargerecords.dao.IRechargeRecordsDao;

public class BaseRechargeRecordsService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IRechargeRecordsDao rechargeRecordsDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = rechargeRecordsDao.insert(rechargeRecords);
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
	public ResultData modify(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = rechargeRecordsDao.updateById(rechargeRecords);
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
	public ResultData modifyById(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = rechargeRecordsDao.updateById(rechargeRecords);
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
	public ResultData modifyComplete(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = rechargeRecordsDao.updateCompleteById(rechargeRecords);
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
	public ResultData delete(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = rechargeRecordsDao.delete(rechargeRecords);
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
	public ResultData deleteById(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = rechargeRecordsDao.deleteById(rechargeRecords);
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
			Integer result = rechargeRecordsDao.deleteAll();
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
	public ResultData single(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			RechargeRecords rechargeRecordsTemp = rechargeRecordsDao.selectOneById(rechargeRecords);
			if (rechargeRecordsTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("rechargeRecords", rechargeRecordsTemp);
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
	public ResultData list(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			List<RechargeRecords> rechargeRecordsList = rechargeRecordsDao.selectList(rechargeRecords);
			if (rechargeRecordsList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("rechargeRecordsList", rechargeRecordsList);
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
	public ResultData paginated(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			List<RechargeRecords> rechargeRecordsList = rechargeRecordsDao.selectPaginatedList(rechargeRecords);
			Long rechargeRecordsCount = rechargeRecordsDao.getCount(rechargeRecords);
			if (rechargeRecordsList != null){
				long record = rechargeRecordsCount == null?0:rechargeRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) rechargeRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", rechargeRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", rechargeRecordsList);
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
	
	public IRechargeRecordsDao getRechargeRecordsDao() {
		return rechargeRecordsDao;
	}

	public void setRechargeRecordsDao(IRechargeRecordsDao rechargeRecordsDao) {
		this.rechargeRecordsDao = rechargeRecordsDao;
	}
}
