package com.bs.plugins.custom.tc.productreturnmoney.dao;

import java.util.List;

import com.bs.plugins.custom.tc.productreturnmoney.base.BaseProductReturnMoneyDao;
import com.bs.plugins.custom.tc.productreturnmoney.entity.ProductReturnMoney;

public interface IProductReturnMoneyDao extends BaseProductReturnMoneyDao<ProductReturnMoney>{
	public Integer updateByIdOrIds(ProductReturnMoney entity) throws Exception;
	
	public Integer updateReturnStatusById(ProductReturnMoney entity) throws Exception;
	
	public Long selectProductReturnMoneyCount(ProductReturnMoney entity) throws Exception;
	
	public List<ProductReturnMoney> selectProductReturnMoneyList(ProductReturnMoney entity) throws Exception;
	
	//查询标的转入还款的list
	public List<ProductReturnMoney> selectProductReturnMoneyByIdOrIds(ProductReturnMoney entity) throws Exception;
	
	//查询需要返款的list
	public List<ProductReturnMoney> selectReturnMoneyByIdOrIds(ProductReturnMoney entity) throws Exception;
	
	public Integer updateObjectIncomeStatusById(ProductReturnMoney entity) throws Exception;
	
	public Integer updateObjectIncomeStatusByIds(ProductReturnMoney entity) throws Exception;
}
