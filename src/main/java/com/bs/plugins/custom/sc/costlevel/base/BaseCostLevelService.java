package com.bs.plugins.custom.sc.costlevel.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.costlevel.entity.CostLevel;
import com.bs.plugins.custom.sc.costlevel.dao.ICostLevelDao;

public class BaseCostLevelService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ICostLevelDao costLevelDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			Integer result = costLevelDao.insert(costLevel);
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
	public ResultData modify(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			Integer result = costLevelDao.updateById(costLevel);
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
	public ResultData modifyById(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			Integer result = costLevelDao.updateById(costLevel);
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
	public ResultData modifyComplete(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			Integer result = costLevelDao.updateCompleteById(costLevel);
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
	public ResultData delete(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			Integer result = costLevelDao.delete(costLevel);
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
	public ResultData deleteById(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			Integer result = costLevelDao.deleteById(costLevel);
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
			Integer result = costLevelDao.deleteAll();
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
	public ResultData single(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			CostLevel costLevelTemp = costLevelDao.selectOneById(costLevel);
			if (costLevelTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("costLevel", costLevelTemp);
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
	public ResultData list(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			List<CostLevel> costLevelList = costLevelDao.selectList(costLevel);
			if (costLevelList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("costLevelList", costLevelList);
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
	public ResultData paginated(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			List<CostLevel> costLevelList = costLevelDao.selectPaginatedList(costLevel);
			Long costLevelCount = costLevelDao.getCount(costLevel);
			if (costLevelList != null){
				long record = costLevelCount == null?0:costLevelCount;
				int pageCount = (int) Math.ceil(record / (double) costLevel.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", costLevel.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", costLevelList);
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
	
	public ICostLevelDao getCostLevelDao() {
		return costLevelDao;
	}

	public void setCostLevelDao(ICostLevelDao costLevelDao) {
		this.costLevelDao = costLevelDao;
	}
}
