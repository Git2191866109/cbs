package com.bs.plugins.custom.tc.spvwithdrawcashrecords.dao;

import com.bs.plugins.custom.tc.spvwithdrawcashrecords.base.BaseSpvWithdrawCashRecordsDao;
import com.bs.plugins.custom.tc.spvwithdrawcashrecords.entity.SpvWithdrawCashRecords;

import java.util.List;

public interface ISpvWithdrawCashRecordsDao extends BaseSpvWithdrawCashRecordsDao<SpvWithdrawCashRecords>{
    /**
     * 查询单条记录
     * @param sqlid
     * @param t
     * @return list
     */
    public List<SpvWithdrawCashRecords> selectPaginatedNewList(SpvWithdrawCashRecords entity) throws Exception;

    /**
     * 计算满足条件条数
     * @param sqlid
     * @param t
     */
    public Long getNewCount(SpvWithdrawCashRecords entity) throws Exception;
}
