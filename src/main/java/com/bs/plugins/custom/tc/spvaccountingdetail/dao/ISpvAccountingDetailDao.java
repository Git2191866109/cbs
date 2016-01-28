package com.bs.plugins.custom.tc.spvaccountingdetail.dao;

import java.util.List;

import com.bs.plugins.custom.tc.accountingdetail.entity.AccountingDetail;
import com.bs.plugins.custom.tc.spvaccountingdetail.base.BaseSpvAccountingDetailDao;
import com.bs.plugins.custom.tc.spvaccountingdetail.entity.SpvAccountingDetail;

public interface ISpvAccountingDetailDao extends BaseSpvAccountingDetailDao<SpvAccountingDetail>{
	
	public List<SpvAccountingDetail> selectSPVPaginated(SpvAccountingDetail entity) throws Exception;
	
	public Long selectSPVCount(SpvAccountingDetail entity) throws Exception;
}
