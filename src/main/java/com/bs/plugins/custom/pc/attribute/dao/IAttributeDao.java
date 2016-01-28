package com.bs.plugins.custom.pc.attribute.dao;

import com.bs.plugins.custom.pc.attribute.base.BaseAttributeDao;
import com.bs.plugins.custom.pc.attribute.entity.Attribute;

import java.util.List;

public interface IAttributeDao extends BaseAttributeDao<Attribute>{

    /**
     * 查询单条记录
     * @param sqlid
     * @param t
     * @return list
     */
    public List<Attribute> selectNewPaginatedList(Attribute entity) throws Exception;

    /**
     * 计算满足条件条数
     * @param sqlid
     * @param t
     */
    public Long getNewPaginatedCount(Attribute entity) throws Exception;

}
