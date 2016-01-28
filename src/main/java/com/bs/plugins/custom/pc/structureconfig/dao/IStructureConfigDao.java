package com.bs.plugins.custom.pc.structureconfig.dao;

import com.bs.plugins.custom.pc.structureconfig.base.BaseStructureConfigDao;
import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;

import java.util.List;

public interface IStructureConfigDao extends BaseStructureConfigDao<StructureConfig>{


    /**
     * 关联查询主表数据
     * @param sqlid
     * @param t
     * @return list
     */
    public List<StructureConfig> getStructureConfigHomeList(StructureConfig entity) throws Exception;

    /**
     * 关联查询主表表数据
     * @param sqlid
     * @param t
     * @return list
     */
    public List<StructureConfig> selectStructureConfigAttributeNew(StructureConfig entity) throws Exception;

}
