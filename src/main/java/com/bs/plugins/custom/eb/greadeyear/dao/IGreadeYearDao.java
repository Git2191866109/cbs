package com.bs.plugins.custom.eb.greadeyear.dao;

import java.util.List;

import com.bs.plugins.custom.eb.greadeyear.base.BaseGreadeYearDao;
import com.bs.plugins.custom.eb.greadeyear.entity.GreadeYear;

public interface IGreadeYearDao extends BaseGreadeYearDao<GreadeYear>{
	
	public List<GreadeYear> selectPaginatedListOrderByGreade(GreadeYear greadeYear) throws Exception;

	public GreadeYear selectMinAndMaxYearByGrowStageId(GreadeYear greadeYear) throws Exception;
	
}
