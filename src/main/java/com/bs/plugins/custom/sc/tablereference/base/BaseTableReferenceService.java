package com.bs.plugins.custom.sc.tablereference.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.tablereference.entity.TableReference;
import com.bs.plugins.custom.sc.tablereference.dao.ITableReferenceDao;

public class BaseTableReferenceService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ITableReferenceDao tableReferenceDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableReferenceDao.insert(tableReference);
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
	public ResultData modify(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableReferenceDao.updateById(tableReference);
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
	public ResultData modifyById(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableReferenceDao.updateById(tableReference);
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
	public ResultData modifyComplete(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableReferenceDao.updateCompleteById(tableReference);
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
	public ResultData delete(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableReferenceDao.delete(tableReference);
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
	public ResultData deleteById(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			Integer result = tableReferenceDao.deleteById(tableReference);
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
			Integer result = tableReferenceDao.deleteAll();
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
	public ResultData single(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			TableReference tableReferenceTemp = tableReferenceDao.selectOneById(tableReference);
			if (tableReferenceTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("tableReference", tableReferenceTemp);
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
	public ResultData list(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			List<TableReference> tableReferenceList = tableReferenceDao.selectList(tableReference);
			if (tableReferenceList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("tableReferenceList", tableReferenceList);
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
	public ResultData paginated(TableReference tableReference){
		ResultData resultData = new ResultData();
		try {
			List<TableReference> tableReferenceList = tableReferenceDao.selectPaginatedList(tableReference);
			Long tableReferenceCount = tableReferenceDao.getCount(tableReference);
			if (tableReferenceList != null){
				long record = tableReferenceCount == null?0:tableReferenceCount;
				int pageCount = (int) Math.ceil(record / (double) tableReference.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", tableReference.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", tableReferenceList);
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
	
	public ITableReferenceDao getTableReferenceDao() {
		return tableReferenceDao;
	}

	public void setTableReferenceDao(ITableReferenceDao tableReferenceDao) {
		this.tableReferenceDao = tableReferenceDao;
	}
}
