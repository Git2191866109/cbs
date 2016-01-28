package com.bs.plugins.custom.tc.spvrechargerecords.dao;

import com.bs.plugins.custom.tc.spvrechargerecords.base.BaseSpvRechargeRecordsDao;
import com.bs.plugins.custom.tc.spvrechargerecords.entity.SpvRechargeRecords;

import java.util.List;

public interface ISpvRechargeRecordsDao extends BaseSpvRechargeRecordsDao<SpvRechargeRecords>{

    /**
     * 计算满足条件条数
     * @param sqlid
     * @param t
     */
    public Long getNewCount(SpvRechargeRecords entity) throws Exception;

    /**
     * 查询单条记录
     * @param sqlid
     * @param t
     * @return list
     */
    public List<SpvRechargeRecords> selectPaginatedNewList(SpvRechargeRecords entity) throws Exception;
}
