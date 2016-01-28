package com.bs.plugins.custom.tc.rechargerecords.dao;

import com.bs.plugins.custom.tc.rechargerecords.base.BaseRechargeRecordsDao;
import com.bs.plugins.custom.tc.rechargerecords.entity.RechargeRecords;

import java.util.List;

public interface IRechargeRecordsDao extends BaseRechargeRecordsDao<RechargeRecords>{

    /**
     * 查询单条记录
     * @param sqlid
     * @param t
     * @return list
     */
    public List<RechargeRecords> selectPaginatedNewList(RechargeRecords entity) throws Exception;


    /**
     * 计算满足条件条数
     * @param sqlid
     * @param t
     */
    public Long getNewCount(RechargeRecords entity) throws Exception;
}
