package com.bs.plugins.custom.tc.subscription.dao;

import java.util.List;
import java.util.Map;

import com.bs.plugins.custom.tc.subscription.base.BaseSubscriptionDao;
import com.bs.plugins.custom.tc.subscription.entity.Subscription;

public interface ISubscriptionDao extends BaseSubscriptionDao<Subscription>{
	
	public List<Subscription> selectSubscriptionPaginated(Subscription subscription)throws Exception;
	
	public Long selectSubscriptionCount(Subscription subscription)throws Exception;
	
	public List<Subscription> selectBusinessauditPaginated(Subscription subscription)throws Exception;
	
	public Long selectBusinessauditCount(Subscription subscription)throws Exception;
	
	public Integer updateLoanStatusById(Subscription subscription)throws Exception;
	
	public Integer updateLoanStatusByIds(Subscription subscription)throws Exception;
	
	public Integer updateRemarkById(Subscription subscription)throws Exception;
	
	public List<Subscription> selectFinanceauditPaginated(Subscription subscription)throws Exception;
	
	public Long selectFinanceauditCount(Subscription subscription)throws Exception;
	
	public List<Map<String,Object>> financeauditExport(Subscription subscription)throws Exception;
	
	public Subscription selectOneSubscriptionById(Subscription subscription)throws Exception;

	public List<Map<String,Object>> statisticsSubscriptionRecord(Map map)throws Exception;
	
	public List<Subscription> selectSubscriptionByIdOrIds(Subscription subscription)throws Exception;
}
