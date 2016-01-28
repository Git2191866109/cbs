package com.bs.plugins.custom.tc.accountingdetail.dao;

import java.util.List;

import com.bs.plugins.custom.tc.accountingdetail.base.BaseAccountingDetailDao;
import com.bs.plugins.custom.tc.accountingdetail.entity.AccountingDetail;

public interface IAccountingDetailDao extends BaseAccountingDetailDao<AccountingDetail>{
	
	public List<AccountingDetail> selectClientPaginated(AccountingDetail entity) throws Exception;
	
	public Long selectClientCount(AccountingDetail entity)throws Exception;
	
}
