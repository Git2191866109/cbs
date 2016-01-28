package com.bs.plugins.custom.sm.serviceprovider.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sm.serviceprovider.entity.ServiceProvider;
import com.bs.plugins.custom.sm.serviceprovider.dao.IServiceProviderDao;

public class BaseServiceProviderService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IServiceProviderDao serviceProviderDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			Integer result = serviceProviderDao.insert(serviceProvider);
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
	public ResultData modify(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			Integer result = serviceProviderDao.updateById(serviceProvider);
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
	public ResultData modifyById(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			Integer result = serviceProviderDao.updateById(serviceProvider);
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
	public ResultData modifyComplete(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			Integer result = serviceProviderDao.updateCompleteById(serviceProvider);
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
	public ResultData delete(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			Integer result = serviceProviderDao.delete(serviceProvider);
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
	public ResultData deleteById(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			Integer result = serviceProviderDao.deleteById(serviceProvider);
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
			Integer result = serviceProviderDao.deleteAll();
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
	public ResultData single(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			ServiceProvider serviceProviderTemp = serviceProviderDao.selectOneById(serviceProvider);
			if (serviceProviderTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("serviceProvider", serviceProviderTemp);
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
	public ResultData list(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			List<ServiceProvider> serviceProviderList = serviceProviderDao.selectList(serviceProvider);
			if (serviceProviderList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("serviceProviderList", serviceProviderList);
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
	public ResultData paginated(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			List<ServiceProvider> serviceProviderList = serviceProviderDao.selectPaginatedList(serviceProvider);
			Long serviceProviderCount = serviceProviderDao.getCount(serviceProvider);
			if (serviceProviderList != null){
				long record = serviceProviderCount == null?0:serviceProviderCount;
				int pageCount = (int) Math.ceil(record / (double) serviceProvider.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", serviceProvider.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", serviceProviderList);
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
	
	public IServiceProviderDao getServiceProviderDao() {
		return serviceProviderDao;
	}

	public void setServiceProviderDao(IServiceProviderDao serviceProviderDao) {
		this.serviceProviderDao = serviceProviderDao;
	}
}
