package com.bs.plugins.custom.sm.businesssent.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sm.businesssent.entity.BusinessSent;
import com.bs.plugins.custom.sm.businesssent.dao.IBusinessSentDao;

public class BaseBusinessSentService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBusinessSentDao businessSentDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSentDao.insert(businessSent);
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
	public ResultData modify(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSentDao.updateById(businessSent);
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
	public ResultData modifyById(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSentDao.updateById(businessSent);
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
	public ResultData modifyComplete(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSentDao.updateCompleteById(businessSent);
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
	public ResultData delete(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSentDao.delete(businessSent);
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
	public ResultData deleteById(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSentDao.deleteById(businessSent);
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
			Integer result = businessSentDao.deleteAll();
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
	public ResultData single(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			BusinessSent businessSentTemp = businessSentDao.selectOneById(businessSent);
			if (businessSentTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("businessSent", businessSentTemp);
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
	public ResultData list(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			List<BusinessSent> businessSentList = businessSentDao.selectList(businessSent);
			if (businessSentList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("businessSentList", businessSentList);
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
	public ResultData paginated(BusinessSent businessSent){
		ResultData resultData = new ResultData();
		try {
			List<BusinessSent> businessSentList = businessSentDao.selectPaginatedList(businessSent);
			Long businessSentCount = businessSentDao.getCount(businessSent);
			if (businessSentList != null){
				long record = businessSentCount == null?0:businessSentCount;
				int pageCount = (int) Math.ceil(record / (double) businessSent.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", businessSent.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", businessSentList);
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
	
	public IBusinessSentDao getBusinessSentDao() {
		return businessSentDao;
	}

	public void setBusinessSentDao(IBusinessSentDao businessSentDao) {
		this.businessSentDao = businessSentDao;
	}
}
