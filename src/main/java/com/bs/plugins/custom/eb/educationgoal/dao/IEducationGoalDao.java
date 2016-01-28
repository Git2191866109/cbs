package com.bs.plugins.custom.eb.educationgoal.dao;

import java.util.List;

import com.bs.plugins.custom.eb.educationgoal.base.BaseEducationGoalDao;
import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;

public interface IEducationGoalDao extends BaseEducationGoalDao<EducationGoal>{

	public List<EducationGoal> selectListByid(EducationGoal ed) throws Exception;
	public List<EducationGoal> selectEducationConfigure(EducationGoal ed) throws Exception;
	
}
