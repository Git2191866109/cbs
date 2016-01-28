package com.bs.plugins.custom.eb.educationconfigure.dao;

import com.bs.plugins.custom.eb.educationconfigure.base.BaseEducationConfigureDao;
import com.bs.plugins.custom.eb.educationconfigure.entity.EducationConfigure;

public interface IEducationConfigureDao extends BaseEducationConfigureDao<EducationConfigure>{

	
		public int deleteAllByeducationId(EducationConfigure ec) throws Exception;
	
}
