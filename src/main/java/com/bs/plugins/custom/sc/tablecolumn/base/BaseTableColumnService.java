package com.bs.plugins.custom.sc.tablecolumn.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.tablecolumn.entity.TableColumn;
import com.bs.plugins.custom.sc.tablecolumn.dao.ITableColumnDao;

public class BaseTableColumnService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ITableColumnDao tableColumnDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableColumnDao.insert(tableColumn);
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
	public ResultData modify(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableColumnDao.updateById(tableColumn);
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
	public ResultData modifyById(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableColumnDao.updateById(tableColumn);
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
	public ResultData modifyComplete(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableColumnDao.updateCompleteById(tableColumn);
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
	public ResultData delete(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableColumnDao.delete(tableColumn);
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
	public ResultData deleteById(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableColumnDao.deleteById(tableColumn);
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
			Integer result = tableColumnDao.deleteAll();
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
	public ResultData single(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			TableColumn tableColumnTemp = tableColumnDao.selectOneById(tableColumn);
			if (tableColumnTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("tableColumn", tableColumnTemp);
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
	public ResultData list(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			List<TableColumn> tableColumnList = tableColumnDao.selectList(tableColumn);
			if (tableColumnList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("tableColumnList", tableColumnList);
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
	public ResultData paginated(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			List<TableColumn> tableColumnList = tableColumnDao.selectPaginatedList(tableColumn);
			Long tableColumnCount = tableColumnDao.getCount(tableColumn);
			if (tableColumnList != null){
				long record = tableColumnCount == null?0:tableColumnCount;
				int pageCount = (int) Math.ceil(record / (double) tableColumn.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", tableColumn.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", tableColumnList);
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
	
	public ITableColumnDao getTableColumnDao() {
		return tableColumnDao;
	}

	public void setTableColumnDao(ITableColumnDao tableColumnDao) {
		this.tableColumnDao = tableColumnDao;
	}
}
