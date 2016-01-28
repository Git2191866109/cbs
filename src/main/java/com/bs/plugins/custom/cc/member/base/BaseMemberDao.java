package com.bs.plugins.custom.cc.member.base;


import java.util.List;
import com.bs.core.entity.Entity;

public interface BaseMemberDao<T extends Entity>{
	/**
	 * 数据库插入
	 * 
	 * @param sqlid
	 * @param t
	 */
	public Integer insert(T entity) throws Exception;

	
	/**
	 * 数据库修改
	 * 
	 * @param sqlid
	 * @param t
	 */
	public Integer updateById(T entity) throws Exception;

	/**
	* 数据库修改(包含空值修改)
	*
	* @param sqlid
	* @param t
	*/
	public Integer updateCompleteById(T entity) throws Exception;


	
	/**
	 * 数据库删除
	 * @param sqlid
	 * @param t
	 */
	public Integer delete(T entity) throws Exception;
	
	/**
	 * 根据主键ID删除数据
	 * @param sqlid
	 * @param t
	 */
	public Integer deleteById(T entity) throws Exception;
	
	/**
	 * 删除所有数据
	 * @return
	 * @throws Exception
	 */
	public Integer deleteAll() throws Exception;

	/**
	 * 计算满足条件条数
	 * @param sqlid
	 * @param t
	 */
	public Long getCount(T entity) throws Exception;

	/**
	 * 查询列表
	 * @param sqlid
	 * @param t
	 * @return List
	 */
	public List<T> selectList(T entity) throws Exception;
	
	/**
	 *查询所有数据
	 * @param sqlid
	 * @param t
	 * @return List
	 */
	public List<T> selectAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param sqlid
	 * @param t
	 * @return
	 */
	public T selectOneById(T entity) throws Exception;

	/**
	 * 查询单条记录
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectPaginatedList(T entity) throws Exception;
	
	
	/**
	 * 关联查询主表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectAssociations(T entity) throws Exception;
	
	/**
	 * 关联查询子表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectCollections(T entity) throws Exception;
	
	
	/**
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberEmailActivateValid(T entity) throws Exception;
	
	/**
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberSpvCorporation(T entity) throws Exception;
	
	
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberBudgetBasicInfo(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberRealnameAuthenticate(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberLoginRecord(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberMemberChild(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberFeedback(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberAccountingStatistics(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberQuestionAnswer(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberAccountingDetail(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberProductAmountLock(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberBankCardBinding(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberAccounting(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberWithdrawCashRecords(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberRechargeRecords(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberBankCardChangeApply(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberAppointment(T entity) throws Exception;
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectMemberSpvProductReturnMoney(T entity) throws Exception;
}
