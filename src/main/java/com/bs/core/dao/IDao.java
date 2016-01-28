package com.bs.core.dao;

import java.util.List;

import com.bs.core.entity.Entity;

public interface IDao<T extends Entity> {
	
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
	public Integer update(T entity) throws Exception;

	/**
	 * 数据库删除
	 * 
	 * @param sqlid
	 * @param t
	 */
	public Integer delete(T entity) throws Exception;
	
	/**
	 * 根据主键ID删除数据
	 * @param entity
	 * @return
	 * @throws Exception
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
	 * @return
	 */
	public List<T> selectList(T entity) throws Exception;
	
	/**
	 *查询所有数据
	 * @param sqlid
	 * @param t
	 * @return
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
	 * 查询分页列表
	 * @param sqlid
	 * @param entity
	 * @param skipResults
	 * @param maxResults
	 * @return
	 */
	public List<T> selectPaginatedList(T entity) throws Exception;
}