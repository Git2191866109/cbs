package com.bs.plugins.custom.eb.educationmode.dao;

import java.util.List;
import java.util.Map;

import com.bs.plugins.custom.eb.educationmode.base.BaseEducationModeDao;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;

public interface IEducationModeDao extends BaseEducationModeDao<EducationMode>{
	
	public List<EducationMode> selectPaginatedByGrowStageIdList(EducationMode educationMode) throws Exception;
	public List<EducationMode> getEducationMode(EducationMode educationMode);
	public List<Map<String, Object>> getTreeEducationMode(EducationMode educationMode);
}
