package com.bs.plugins.custom.uc.log.dao;

import java.util.List;

import com.bs.plugins.custom.uc.log.base.BaseLogDao;
import com.bs.plugins.custom.uc.log.entity.Log;

public interface ILogDao extends BaseLogDao<Log>{
	/**
	 * 插入log数据
	 * 
	 * @param sqlid
	 * @param t
	 */
	public Integer saveLog(Log log);
	
	public Long getCountByCondition(Log log);
	
	public List<Log> selectPaginatedListByCondition(Log log);
}
