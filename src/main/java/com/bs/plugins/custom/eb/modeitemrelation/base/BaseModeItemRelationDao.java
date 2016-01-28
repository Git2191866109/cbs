package com.bs.plugins.custom.eb.modeitemrelation.base;


import java.util.List;
import com.bs.core.entity.Entity;

public interface BaseModeItemRelationDao<T extends Entity>{
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
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectModeItemRelationGrowStages(T entity) throws Exception;
	
	/**
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectModeItemRelationEducationMode(T entity) throws Exception;
	
	/**
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectModeItemRelationBudgetCategory(T entity) throws Exception;
	
	/**
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectModeItemRelationBudgetItem(T entity) throws Exception;
	
	/**
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectModeItemRelationBudgetItemData(T entity) throws Exception;
	
	
}
