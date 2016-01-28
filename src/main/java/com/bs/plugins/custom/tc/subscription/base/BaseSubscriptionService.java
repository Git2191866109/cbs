package com.bs.plugins.custom.tc.subscription.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.subscription.entity.Subscription;
import com.bs.plugins.custom.tc.subscription.dao.ISubscriptionDao;

public class BaseSubscriptionService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISubscriptionDao subscriptionDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.insert(subscription);
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
	public ResultData modify(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.updateById(subscription);
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
	public ResultData modifyById(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.updateById(subscription);
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
	public ResultData modifyComplete(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.updateCompleteById(subscription);
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
	public ResultData delete(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.delete(subscription);
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
	public ResultData deleteById(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.deleteById(subscription);
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
			Integer result = subscriptionDao.deleteAll();
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
	public ResultData single(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Subscription subscriptionTemp = subscriptionDao.selectOneById(subscription);
			if (subscriptionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subscription", subscriptionTemp);
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
	public ResultData list(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			List<Subscription> subscriptionList = subscriptionDao.selectList(subscription);
			if (subscriptionList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subscriptionList", subscriptionList);
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
	public ResultData paginated(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			List<Subscription> subscriptionList = subscriptionDao.selectPaginatedList(subscription);
			Long subscriptionCount = subscriptionDao.getCount(subscription);
			if (subscriptionList != null){
				long record = subscriptionCount == null?0:subscriptionCount;
				int pageCount = (int) Math.ceil(record / (double) subscription.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", subscription.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", subscriptionList);
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
	
	public ISubscriptionDao getSubscriptionDao() {
		return subscriptionDao;
	}

	public void setSubscriptionDao(ISubscriptionDao subscriptionDao) {
		this.subscriptionDao = subscriptionDao;
	}
}
