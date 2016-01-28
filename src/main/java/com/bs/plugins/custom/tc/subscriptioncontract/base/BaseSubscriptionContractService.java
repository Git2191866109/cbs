package com.bs.plugins.custom.tc.subscriptioncontract.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.subscriptioncontract.entity.SubscriptionContract;
import com.bs.plugins.custom.tc.subscriptioncontract.dao.ISubscriptionContractDao;

public class BaseSubscriptionContractService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISubscriptionContractDao subscriptionContractDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionContractDao.insert(subscriptionContract);
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
	public ResultData modify(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionContractDao.updateById(subscriptionContract);
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
	public ResultData modifyById(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionContractDao.updateById(subscriptionContract);
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
	public ResultData modifyComplete(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionContractDao.updateCompleteById(subscriptionContract);
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
	public ResultData delete(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionContractDao.delete(subscriptionContract);
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
	public ResultData deleteById(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionContractDao.deleteById(subscriptionContract);
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
			Integer result = subscriptionContractDao.deleteAll();
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
	public ResultData single(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			SubscriptionContract subscriptionContractTemp = subscriptionContractDao.selectOneById(subscriptionContract);
			if (subscriptionContractTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subscriptionContract", subscriptionContractTemp);
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
	public ResultData list(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			List<SubscriptionContract> subscriptionContractList = subscriptionContractDao.selectList(subscriptionContract);
			if (subscriptionContractList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subscriptionContractList", subscriptionContractList);
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
	public ResultData paginated(SubscriptionContract subscriptionContract){
		ResultData resultData = new ResultData();
		try {
			List<SubscriptionContract> subscriptionContractList = subscriptionContractDao.selectPaginatedList(subscriptionContract);
			Long subscriptionContractCount = subscriptionContractDao.getCount(subscriptionContract);
			if (subscriptionContractList != null){
				long record = subscriptionContractCount == null?0:subscriptionContractCount;
				int pageCount = (int) Math.ceil(record / (double) subscriptionContract.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", subscriptionContract.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", subscriptionContractList);
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
	
	public ISubscriptionContractDao getSubscriptionContractDao() {
		return subscriptionContractDao;
	}

	public void setSubscriptionContractDao(ISubscriptionContractDao subscriptionContractDao) {
		this.subscriptionContractDao = subscriptionContractDao;
	}
}
