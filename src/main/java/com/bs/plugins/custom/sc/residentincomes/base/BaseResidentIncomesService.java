package com.bs.plugins.custom.sc.residentincomes.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.residentincomes.entity.ResidentIncomes;
import com.bs.plugins.custom.sc.residentincomes.dao.IResidentIncomesDao;

public class BaseResidentIncomesService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IResidentIncomesDao residentIncomesDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			Integer result = residentIncomesDao.insert(residentIncomes);
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
	public ResultData modify(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			Integer result = residentIncomesDao.updateById(residentIncomes);
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
	public ResultData modifyById(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			Integer result = residentIncomesDao.updateById(residentIncomes);
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
	public ResultData modifyComplete(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			Integer result = residentIncomesDao.updateCompleteById(residentIncomes);
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
	public ResultData delete(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			Integer result = residentIncomesDao.delete(residentIncomes);
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
	public ResultData deleteById(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			Integer result = residentIncomesDao.deleteById(residentIncomes);
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
			Integer result = residentIncomesDao.deleteAll();
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
	public ResultData single(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			ResidentIncomes residentIncomesTemp = residentIncomesDao.selectOneById(residentIncomes);
			if (residentIncomesTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("residentIncomes", residentIncomesTemp);
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
	public ResultData list(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			List<ResidentIncomes> residentIncomesList = residentIncomesDao.selectList(residentIncomes);
			if (residentIncomesList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("residentIncomesList", residentIncomesList);
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
	public ResultData paginated(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			List<ResidentIncomes> residentIncomesList = residentIncomesDao.selectPaginatedList(residentIncomes);
			Long residentIncomesCount = residentIncomesDao.getCount(residentIncomes);
			if (residentIncomesList != null){
				long record = residentIncomesCount == null?0:residentIncomesCount;
				int pageCount = (int) Math.ceil(record / (double) residentIncomes.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", residentIncomes.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", residentIncomesList);
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
	
	public IResidentIncomesDao getResidentIncomesDao() {
		return residentIncomesDao;
	}

	public void setResidentIncomesDao(IResidentIncomesDao residentIncomesDao) {
		this.residentIncomesDao = residentIncomesDao;
	}
}
