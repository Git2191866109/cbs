package com.bs.plugins.custom.sm.businesssend.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sm.businesssend.entity.BusinessSend;
import com.bs.plugins.custom.sm.businesssend.dao.IBusinessSendDao;

public class BaseBusinessSendService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBusinessSendDao businessSendDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSendDao.insert(businessSend);
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
	public ResultData modify(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSendDao.updateById(businessSend);
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
	public ResultData modifyById(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSendDao.updateById(businessSend);
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
	public ResultData modifyComplete(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSendDao.updateCompleteById(businessSend);
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
	public ResultData delete(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSendDao.delete(businessSend);
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
	public ResultData deleteById(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = businessSendDao.deleteById(businessSend);
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
			Integer result = businessSendDao.deleteAll();
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
	public ResultData single(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			BusinessSend businessSendTemp = businessSendDao.selectOneById(businessSend);
			if (businessSendTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("businessSend", businessSendTemp);
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
	public ResultData list(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			List<BusinessSend> businessSendList = businessSendDao.selectList(businessSend);
			if (businessSendList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("businessSendList", businessSendList);
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
	public ResultData paginated(BusinessSend businessSend){
		ResultData resultData = new ResultData();
		try {
			List<BusinessSend> businessSendList = businessSendDao.selectPaginatedList(businessSend);
			Long businessSendCount = businessSendDao.getCount(businessSend);
			if (businessSendList != null){
				long record = businessSendCount == null?0:businessSendCount;
				int pageCount = (int) Math.ceil(record / (double) businessSend.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", businessSend.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", businessSendList);
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
	
	public IBusinessSendDao getBusinessSendDao() {
		return businessSendDao;
	}

	public void setBusinessSendDao(IBusinessSendDao businessSendDao) {
		this.businessSendDao = businessSendDao;
	}
}
