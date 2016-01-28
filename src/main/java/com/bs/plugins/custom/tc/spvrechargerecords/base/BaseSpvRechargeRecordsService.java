package com.bs.plugins.custom.tc.spvrechargerecords.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.spvrechargerecords.entity.SpvRechargeRecords;
import com.bs.plugins.custom.tc.spvrechargerecords.dao.ISpvRechargeRecordsDao;

public class BaseSpvRechargeRecordsService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISpvRechargeRecordsDao spvRechargeRecordsDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvRechargeRecordsDao.insert(spvRechargeRecords);
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
	public ResultData modify(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvRechargeRecordsDao.updateById(spvRechargeRecords);
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
	public ResultData modifyById(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvRechargeRecordsDao.updateById(spvRechargeRecords);
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
	public ResultData modifyComplete(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvRechargeRecordsDao.updateCompleteById(spvRechargeRecords);
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
	public ResultData delete(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvRechargeRecordsDao.delete(spvRechargeRecords);
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
	public ResultData deleteById(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvRechargeRecordsDao.deleteById(spvRechargeRecords);
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
			Integer result = spvRechargeRecordsDao.deleteAll();
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
	public ResultData single(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			SpvRechargeRecords spvRechargeRecordsTemp = spvRechargeRecordsDao.selectOneById(spvRechargeRecords);
			if (spvRechargeRecordsTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvRechargeRecords", spvRechargeRecordsTemp);
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
	public ResultData list(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			List<SpvRechargeRecords> spvRechargeRecordsList = spvRechargeRecordsDao.selectList(spvRechargeRecords);
			if (spvRechargeRecordsList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvRechargeRecordsList", spvRechargeRecordsList);
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
	public ResultData paginated(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			List<SpvRechargeRecords> spvRechargeRecordsList = spvRechargeRecordsDao.selectPaginatedList(spvRechargeRecords);
			Long spvRechargeRecordsCount = spvRechargeRecordsDao.getCount(spvRechargeRecords);
			if (spvRechargeRecordsList != null){
				long record = spvRechargeRecordsCount == null?0:spvRechargeRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) spvRechargeRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvRechargeRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", spvRechargeRecordsList);
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
	
	public ISpvRechargeRecordsDao getSpvRechargeRecordsDao() {
		return spvRechargeRecordsDao;
	}

	public void setSpvRechargeRecordsDao(ISpvRechargeRecordsDao spvRechargeRecordsDao) {
		this.spvRechargeRecordsDao = spvRechargeRecordsDao;
	}
}
