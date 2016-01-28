package com.bs.plugins.custom.uc.organization.dao;

import com.bs.plugins.custom.uc.organization.base.BaseOrganizationDao;
import com.bs.plugins.custom.uc.organization.entity.Organization;

public interface IOrganizationDao extends BaseOrganizationDao<Organization>{
public int update(Organization org);
}
