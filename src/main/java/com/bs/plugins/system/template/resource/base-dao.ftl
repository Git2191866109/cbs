package com.bs.plugins.custom.${daoPackage};


import java.util.List;
import com.bs.core.entity.Entity;

public interface Base${entity}Dao<T extends Entity>{
	<#assign idIsExist="false"/>
	<#list columns as column>
	<#if column.code?lower_case=='id' >
		<#assign idIsExist="true"/>
	</#if>
	</#list>
	/**
	 * 数据库插入
	 * 
	 * @param sqlid
	 * @param t
	 */
	public Integer insert(T entity) throws Exception;

	
	<#if idIsExist == "true">
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


	</#if>
	
	/**
	 * 数据库删除
	 * @param sqlid
	 * @param t
	 */
	public Integer delete(T entity) throws Exception;
	
	<#if idIsExist == "true">
	/**
	 * 根据主键ID删除数据
	 * @param sqlid
	 * @param t
	 */
	public Integer deleteById(T entity) throws Exception;
	</#if>
	
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

	<#if idIsExist == "true">
	/**
	 * 查询单条记录
	 * @param sqlid
	 * @param t
	 * @return
	 */
	public T selectOneById(T entity) throws Exception;
	</#if>

	/**
	 * 查询单条记录
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectPaginatedList(T entity) throws Exception;
	
	<#assign isChildReference="false"/>
	<#assign isParentReference="false"/>
	<#list references as reference>
	<#if table.code == reference.childTable.code>
		<#assign isChildReference="true"/>
	</#if>
	<#if table.code == reference.parentTable.code>
		<#assign isParentReference="true"/>
	</#if>
	</#list>
	
	<#if isChildReference == "true">
	/**
	 * 关联查询主表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectAssociations(T entity) throws Exception;
	</#if>
	
	<#if isParentReference == "true">
	/**
	 * 关联查询子表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> selectCollections(T entity) throws Exception;
	</#if>
	
	<#list references as reference>
	<#if table.code == reference.childTable.code>
	<#assign isChildReference="true"/>
	<#list reference.joins as join>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
	<#assign ccode="${join.childTableColumn.table.code}"/>
	<#assign cidx="${ccode?index_of('_')}"/>
	<#assign clen="${ccode?length}"/>
	
	/**
	 * 关联查询主表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> select${ccode?substring(cidx?number+1,clen?number)}${pcode?substring(idx?number+1,len?number)}(T entity) throws Exception;
	</#list>
	</#if>
	</#list>
	
	
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#assign isParentReference="true"/>
	<#list reference.joins as join>
	<#assign ccode="${join.childTableColumn.table.code}"/>
	<#assign cidx="${ccode?index_of('_')}"/>
	<#assign clen="${ccode?length}"/>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign pidx="${pcode?index_of('_')}"/>
	<#assign plen="${pcode?length}"/>
	
	/**
	 * 关联查询子表表数据
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> select${pcode?substring(pidx?number+1,plen?number)}${ccode?substring(cidx?number+1,clen?number)}(T entity) throws Exception;
	</#list>
	</#if>
	</#list>
}
