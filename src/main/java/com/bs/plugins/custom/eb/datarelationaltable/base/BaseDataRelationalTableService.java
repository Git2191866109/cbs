package com.bs.plugins.custom.eb.datarelationaltable.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.datarelationaltable.entity.DataRelationalTable;
import com.bs.plugins.custom.eb.datarelationaltable.dao.IDataRelationalTableDao;

public class BaseDataRelationalTableService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IDataRelationalTableDao dataRelationalTableDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			Integer result = dataRelationalTableDao.insert(dataRelationalTable);
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
	public ResultData modify(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			Integer result = dataRelationalTableDao.updateById(dataRelationalTable);
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
	public ResultData modifyById(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			Integer result = dataRelationalTableDao.updateById(dataRelationalTable);
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
	public ResultData delete(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			Integer result = dataRelationalTableDao.delete(dataRelationalTable);
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
	public ResultData deleteById(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			Integer result = dataRelationalTableDao.deleteById(dataRelationalTable);
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
			Integer result = dataRelationalTableDao.deleteAll();
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
	public ResultData single(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			DataRelationalTable dataRelationalTableTemp = dataRelationalTableDao.selectOneById(dataRelationalTable);
			if (dataRelationalTableTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("dataRelationalTable", dataRelationalTableTemp);
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
	public ResultData list(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			List<DataRelationalTable> dataRelationalTableList = dataRelationalTableDao.selectList(dataRelationalTable);
			if (dataRelationalTableList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("dataRelationalTableList", dataRelationalTableList);
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
	public ResultData paginated(DataRelationalTable dataRelationalTable){
		ResultData resultData = new ResultData();
		try {
			List<DataRelationalTable> dataRelationalTableList = dataRelationalTableDao.selectPaginatedList(dataRelationalTable);
			Long dataRelationalTableCount = dataRelationalTableDao.getCount(dataRelationalTable);
			if (dataRelationalTableList != null){
				long record = dataRelationalTableCount == null?0:dataRelationalTableCount;
				int pageCount = (int) Math.ceil(record / (double) dataRelationalTable.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", dataRelationalTable.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", dataRelationalTableList);
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
	
	public IDataRelationalTableDao getDataRelationalTableDao() {
		return dataRelationalTableDao;
	}

	public void setDataRelationalTableDao(IDataRelationalTableDao dataRelationalTableDao) {
		this.dataRelationalTableDao = dataRelationalTableDao;
	}
}
