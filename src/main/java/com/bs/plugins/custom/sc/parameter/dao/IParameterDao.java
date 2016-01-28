package com.bs.plugins.custom.sc.parameter.dao;

import com.bs.plugins.custom.sc.parameter.base.BaseParameterDao;
import com.bs.plugins.custom.sc.parameter.entity.Parameter;

import java.util.List;

public interface IParameterDao extends BaseParameterDao<Parameter>{
    public List<Parameter> selectPaginatedByParameterCategoryIdList(Parameter Parameter) throws Exception;

    public Parameter selectByCode(String code);

}
