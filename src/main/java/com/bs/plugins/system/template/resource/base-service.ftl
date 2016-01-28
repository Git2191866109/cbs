package com.bs.plugins.custom.${baseServicePackage};

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.${entityImportPackage};
import com.bs.plugins.custom.${daoImportPackage};

public class Base${entity}Service<T extends Entity> implements IBaseService {
	
	@Autowired
	private I${entity}Dao ${entity?uncap_first}Dao;
	
	@Autowired
	private InitializeData initializeData;
	
	<#assign idIsExist="false"/>
	<#list columns as column>
	<#if column.code?lower_case=='id' >
		<#assign idIsExist="true"/>
	</#if>
	</#list>	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			Integer result = ${entity?uncap_first}Dao.insert(${entity?uncap_first});
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
		
	<#if idIsExist == "true">
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modify(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			Integer result = ${entity?uncap_first}Dao.updateById(${entity?uncap_first});
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modifyById(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			Integer result = ${entity?uncap_first}Dao.updateById(${entity?uncap_first});
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	/**
	 * 修改(完全修改)
	 * @param entity
	 * @return
	 */
	public ResultData modifyComplete(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			Integer result = ${entity?uncap_first}Dao.updateCompleteById(${entity?uncap_first});
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	</#if>
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData delete(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			Integer result = ${entity?uncap_first}Dao.delete(${entity?uncap_first});
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	<#if idIsExist == "true">
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteById(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			Integer result = ${entity?uncap_first}Dao.deleteById(${entity?uncap_first});
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	</#if>
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteAll(){
		ResultData resultData = new ResultData();
		try {
			Integer result = ${entity?uncap_first}Dao.deleteAll();
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	<#if idIsExist == "true">
	/**
	 * 查询单条数据
	 * @param entity
	 * @return
	*/
	public ResultData single(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			${entity} ${entity?uncap_first}Temp = ${entity?uncap_first}Dao.selectOneById(${entity?uncap_first});
			if (${entity?uncap_first}Temp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("${entity?uncap_first}", ${entity?uncap_first}Temp);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
	</#if>
	
	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			List<${entity}> ${entity?uncap_first}List = ${entity?uncap_first}Dao.selectList(${entity?uncap_first});
			if (${entity?uncap_first}List != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("${entity?uncap_first}List", ${entity?uncap_first}List);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;			
	}
	
	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(${entity} ${entity?uncap_first}){
		ResultData resultData = new ResultData();
		try {
			List<${entity}> ${entity?uncap_first}List = ${entity?uncap_first}Dao.selectPaginatedList(${entity?uncap_first});
			Long ${entity?uncap_first}Count = ${entity?uncap_first}Dao.getCount(${entity?uncap_first});
			if (${entity?uncap_first}List != null){
				long record = ${entity?uncap_first}Count == null?0:${entity?uncap_first}Count;
				int pageCount = (int) Math.ceil(record / (double) ${entity?uncap_first}.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", ${entity?uncap_first}.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", ${entity?uncap_first}List);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {

	}
	
	public InitializeData getInitializeData() {
		return initializeData;
	}

	public void setInitializeData(InitializeData initializeData) {
		this.initializeData = initializeData;
	}
	
	public I${entity}Dao get${entity}Dao() {
		return ${entity?uncap_first}Dao;
	}

	public void set${entity}Dao(I${entity}Dao ${entity?uncap_first}Dao) {
		this.${entity?uncap_first}Dao = ${entity?uncap_first}Dao;
	}
}
