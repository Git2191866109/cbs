package com.bs.core.dao;

import java.util.List;

import com.bs.core.entity.Entity;

public interface IBaseRedisDao<T extends Entity> {
	
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public boolean add(final String key,final T t); 	
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public boolean add(final T t);  
	/**
	 * 添加
	 * @param list
	 * @return
	 */
	public boolean add(final List<T> list); 
	
	/**
	 * 删除
	 * @param key
	 */
	public void delete(String key);  
	
	/**
	 * 删除
	 * @param keys
	 */
	public void delete(List<String> keys); 
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public boolean update(final String key,final T t);  
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public boolean update(final T t);
	
	/**
	 * 查询
	 * @param keyId
	 * @return
	 */
	public String get(final String keyId);
	/**
	 * 查询
	 * @param keyId
	 * @return
	 */
	public <T> T get(final String key, final Class<T> cls);
	/**
	 * 查询
	 * @param keyId
	 * @return
	 */
	public String getByString(final String keyId); 
	/**
	 * 添加
	 * @param validateCode
	 * @param s
	 *
	 */
	public boolean add(String keyId, String sValue);  
}
