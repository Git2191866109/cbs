package com.bs.plugins.custom.tc.withdrawcashrecords.dao;

import com.bs.plugins.custom.tc.withdrawcashrecords.base.BaseWithdrawCashRecordsDao;
import com.bs.plugins.custom.tc.withdrawcashrecords.entity.WithdrawCashRecords;

import java.util.List;

public interface IWithdrawCashRecordsDao extends BaseWithdrawCashRecordsDao<WithdrawCashRecords>{

    /**
     * 计算满足条件条数
     * @param sqlid
     * @param t
     */
    public Long getNewCount(WithdrawCashRecords entity) throws Exception;

    /**
     * 查询单条记录
     * @param sqlid
     * @param t
     * @return list
     */
    public List<WithdrawCashRecords> selectPaginatedNewList(WithdrawCashRecords entity) throws Exception;
}
