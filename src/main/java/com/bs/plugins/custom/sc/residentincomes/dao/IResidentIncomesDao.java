package com.bs.plugins.custom.sc.residentincomes.dao;

import java.util.List;

import com.bs.plugins.custom.sc.residentincomes.base.BaseResidentIncomesDao;
import com.bs.plugins.custom.sc.residentincomes.entity.ResidentIncomes;

public interface IResidentIncomesDao extends BaseResidentIncomesDao<ResidentIncomes>{
	
	public List<ResidentIncomes> selectListByAreaCode() throws Exception;
	
	public List<ResidentIncomes> selectRelationPathByBaseData();
	
	public List<ResidentIncomes> selectCodeSpellingList();

	public List<ResidentIncomes> selectCreateDate( ResidentIncomes residentIncomes);
}
