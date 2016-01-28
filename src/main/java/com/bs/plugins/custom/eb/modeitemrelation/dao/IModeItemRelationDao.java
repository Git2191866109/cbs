package com.bs.plugins.custom.eb.modeitemrelation.dao;


import java.util.List;

import com.bs.plugins.custom.eb.modeitemrelation.base.BaseModeItemRelationDao;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;

public interface IModeItemRelationDao extends BaseModeItemRelationDao<ModeItemRelation>{

	public Integer getModeItemRelation(ModeItemRelation modeItemRelation);
	public List<ModeItemRelation> findTreeData(ModeItemRelation modeItemRelation);
	public List<ModeItemRelation> getTreeBudgetCategory(ModeItemRelation modeItemRelation);
	public List<ModeItemRelation> getTreeBudgetItem(ModeItemRelation modeItemRelation);
	public List<ModeItemRelation> selectAssociationsByLeft(ModeItemRelation modelItemRelation)throws Exception;
	public void deleteALLByBudgetCategoryId(ModeItemRelation modelItemRelation)throws Exception;
}
