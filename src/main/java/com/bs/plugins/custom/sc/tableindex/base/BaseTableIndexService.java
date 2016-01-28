package com.bs.plugins.custom.sc.tableindex.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.tableindex.entity.TableIndex;
import com.bs.plugins.custom.sc.tableindex.dao.ITableIndexDao;

public class BaseTableIndexService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ITableIndexDao tableIndexDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableIndexDao.insert(tableIndex);
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
	public ResultData modify(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableIndexDao.updateById(tableIndex);
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
	public ResultData modifyById(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableIndexDao.updateById(tableIndex);
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
	public ResultData modifyComplete(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableIndexDao.updateCompleteById(tableIndex);
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
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData delete(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableIndexDao.delete(tableIndex);
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
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteById(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableIndexDao.deleteById(tableIndex);
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
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteAll(){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableIndexDao.deleteAll();
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
	 * 查询单条数据
	 * @param entity
	 * @return
	*/
	public ResultData single(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			TableIndex tableIndexTemp = tableIndexDao.selectOneById(tableIndex);
			if (tableIndexTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("tableIndex", tableIndexTemp);
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
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			List<TableIndex> tableIndexList = tableIndexDao.selectList(tableIndex);
			if (tableIndexList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("tableIndexList", tableIndexList);
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
	public ResultData paginated(TableIndex tableIndex){
		ResultData resultData = new ResultData();
		try {
			List<TableIndex> tableIndexList = tableIndexDao.selectPaginatedList(tableIndex);
			Long tableIndexCount = tableIndexDao.getCount(tableIndex);
			if (tableIndexList != null){
				long record = tableIndexCount == null?0:tableIndexCount;
				int pageCount = (int) Math.ceil(record / (double) tableIndex.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", tableIndex.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", tableIndexList);
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
	
	public ITableIndexDao getTableIndexDao() {
		return tableIndexDao;
	}

	public void setTableIndexDao(ITableIndexDao tableIndexDao) {
		this.tableIndexDao = tableIndexDao;
	}
}
