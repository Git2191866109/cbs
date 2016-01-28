package com.bs.plugins.custom.sm.serviceprovider.dao;

import java.util.List;

import com.bs.plugins.custom.sm.serviceprovider.base.BaseServiceProviderDao;
import com.bs.plugins.custom.sm.serviceprovider.entity.ServiceProvider;

public interface IServiceProviderDao extends BaseServiceProviderDao<ServiceProvider>{

	public ServiceProvider selectServiceprovide();
	
	public List<ServiceProvider> selectAllServiceprovide();

}
