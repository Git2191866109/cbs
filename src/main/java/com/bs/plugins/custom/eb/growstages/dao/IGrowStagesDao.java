package com.bs.plugins.custom.eb.growstages.dao;

import java.util.List;

import com.bs.plugins.custom.eb.growstages.base.BaseGrowStagesDao;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;

public interface IGrowStagesDao extends BaseGrowStagesDao<GrowStages>{
	
	public List<GrowStages> selectPaginatedListOrderByCode(GrowStages GrowStages) throws Exception;
	
		public List<GrowStages> findParentNode(); 
	
}
