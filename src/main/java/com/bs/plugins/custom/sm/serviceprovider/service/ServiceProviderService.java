package com.bs.plugins.custom.sm.serviceprovider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.sm.serviceprovider.base.BaseServiceProviderService;
import com.bs.plugins.custom.sm.serviceprovider.dao.IServiceProviderDao;
import com.bs.plugins.custom.sm.serviceprovider.entity.ServiceProvider;

@Service
public class ServiceProviderService extends BaseServiceProviderService<ServiceProvider> {
	
	@Autowired
	private IServiceProviderDao serviceProviderDao;  
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData configIndex(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			ServiceProvider sp = serviceProviderDao.selectOneById(serviceProvider);
			resultData.addObject(sp);
			ServiceProvider isExist = serviceProviderDao.selectServiceprovide();
			if(isExist != null){
				resultData.addObject("isExist", "1");// 存在使用的通道
			}else {
				resultData.addObject("isExist", "0");// 不存在使用的通道
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**跳转到创建页**/
	public ResultData jumpCreate(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			ServiceProvider sp = serviceProviderDao.selectServiceprovide();
			if(sp != null){
				resultData.addObject("isExist", "1");// 存在使用的通道
			}else {
				resultData.addObject("isExist", "0");// 不存在使用的通道
			}
			resultData.setStatus(SUCCESS);
		}catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(ServiceProvider serviceProvider){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**
	 * 查询短信使用的运营商
	 * @return
	 */
	public ServiceProvider selectUseServiceprovide(){
		return serviceProviderDao.selectServiceprovide();
	}
	
	
	public List<ServiceProvider> selectAllServiceprovide(){
		return serviceProviderDao.selectAllServiceprovide();
	}
	
}
