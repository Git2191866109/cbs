package com.bs.plugins.custom.sc.area.dao;

import java.util.List;

import com.bs.plugins.custom.sc.area.base.BaseAreaDao;
import com.bs.plugins.custom.sc.area.entity.Area;

public interface IAreaDao extends BaseAreaDao<Area>{
	
	public long selectSubLevel(Area area)throws Exception;
	
	public String selectRelationPathByParentCode(Area area)throws Exception;
	
	public String selectSpell(Area area)throws Exception;
	
	public List<Area> selectListByCode(Area area)throws Exception;

	public List<Area> getArea(Area area);
	
	public Integer selectChildNote(Area area)throws Exception;
	
}
