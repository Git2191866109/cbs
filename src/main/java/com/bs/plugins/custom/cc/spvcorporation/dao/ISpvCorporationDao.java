package com.bs.plugins.custom.cc.spvcorporation.dao;

import java.util.List;

import com.bs.plugins.custom.cc.spvcorporation.base.BaseSpvCorporationDao;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;

public interface ISpvCorporationDao extends BaseSpvCorporationDao<SpvCorporation>{
	
	public SpvCorporation selectByType(SpvCorporation entity)throws Exception;
	
	public int updateByType(SpvCorporation entity)throws Exception;
	/**
	 * 类型不为学费帮的信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public List<SpvCorporation> selectPaginatedListByStatus(SpvCorporation entity)throws Exception;
	/**
	 * 类型不为学费帮的信息个数
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Long getCountByStatus(SpvCorporation entity)throws Exception;

	public int updateSpvById(SpvCorporation entity)throws Exception;

}
