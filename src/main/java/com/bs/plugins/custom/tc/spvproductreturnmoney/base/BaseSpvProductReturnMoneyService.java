package com.bs.plugins.custom.tc.spvproductreturnmoney.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.spvproductreturnmoney.entity.SpvProductReturnMoney;
import com.bs.plugins.custom.tc.spvproductreturnmoney.dao.ISpvProductReturnMoneyDao;

public class BaseSpvProductReturnMoneyService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISpvProductReturnMoneyDao spvProductReturnMoneyDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvProductReturnMoneyDao.insert(spvProductReturnMoney);
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
	public ResultData modify(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvProductReturnMoneyDao.updateById(spvProductReturnMoney);
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
	public ResultData modifyById(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvProductReturnMoneyDao.updateById(spvProductReturnMoney);
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
	public ResultData modifyComplete(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvProductReturnMoneyDao.updateCompleteById(spvProductReturnMoney);
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
	public ResultData delete(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvProductReturnMoneyDao.delete(spvProductReturnMoney);
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
	public ResultData deleteById(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvProductReturnMoneyDao.deleteById(spvProductReturnMoney);
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
			Integer result = spvProductReturnMoneyDao.deleteAll();
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
	public ResultData single(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			SpvProductReturnMoney spvProductReturnMoneyTemp = spvProductReturnMoneyDao.selectOneById(spvProductReturnMoney);
			if (spvProductReturnMoneyTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvProductReturnMoney", spvProductReturnMoneyTemp);
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
	public ResultData list(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			List<SpvProductReturnMoney> spvProductReturnMoneyList = spvProductReturnMoneyDao.selectList(spvProductReturnMoney);
			if (spvProductReturnMoneyList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvProductReturnMoneyList", spvProductReturnMoneyList);
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
	public ResultData paginated(SpvProductReturnMoney spvProductReturnMoney){
		ResultData resultData = new ResultData();
		try {
			List<SpvProductReturnMoney> spvProductReturnMoneyList = spvProductReturnMoneyDao.selectPaginatedList(spvProductReturnMoney);
			Long spvProductReturnMoneyCount = spvProductReturnMoneyDao.getCount(spvProductReturnMoney);
			if (spvProductReturnMoneyList != null){
				long record = spvProductReturnMoneyCount == null?0:spvProductReturnMoneyCount;
				int pageCount = (int) Math.ceil(record / (double) spvProductReturnMoney.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvProductReturnMoney.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", spvProductReturnMoneyList);
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
	
	public ISpvProductReturnMoneyDao getSpvProductReturnMoneyDao() {
		return spvProductReturnMoneyDao;
	}

	public void setSpvProductReturnMoneyDao(ISpvProductReturnMoneyDao spvProductReturnMoneyDao) {
		this.spvProductReturnMoneyDao = spvProductReturnMoneyDao;
	}
}
