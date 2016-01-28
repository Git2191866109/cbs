package com.bs.plugins.custom.cc.spvcorporation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.cc.spvcorporation.dao.ISpvCorporationDao;

public class BaseSpvCorporationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISpvCorporationDao spvCorporationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvCorporationDao.insert(spvCorporation);
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
	public ResultData modify(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvCorporationDao.updateById(spvCorporation);
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
	public ResultData modifyById(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvCorporationDao.updateById(spvCorporation);
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
	public ResultData modifyComplete(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvCorporationDao.updateCompleteById(spvCorporation);
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
	public ResultData delete(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvCorporationDao.delete(spvCorporation);
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
	public ResultData deleteById(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvCorporationDao.deleteById(spvCorporation);
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
			Integer result = spvCorporationDao.deleteAll();
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
	public ResultData single(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			SpvCorporation spvCorporationTemp = spvCorporationDao.selectOneById(spvCorporation);
			if (spvCorporationTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvCorporation", spvCorporationTemp);
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
	public ResultData list(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			List<SpvCorporation> spvCorporationList = spvCorporationDao.selectList(spvCorporation);
			if (spvCorporationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvCorporationList", spvCorporationList);
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
	public ResultData paginated(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			List<SpvCorporation> spvCorporationList = spvCorporationDao.selectPaginatedList(spvCorporation);
			Long spvCorporationCount = spvCorporationDao.getCount(spvCorporation);
			if (spvCorporationList != null){
				long record = spvCorporationCount == null?0:spvCorporationCount;
				int pageCount = (int) Math.ceil(record / (double) spvCorporation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvCorporation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", spvCorporationList);
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
	
	public ISpvCorporationDao getSpvCorporationDao() {
		return spvCorporationDao;
	}

	public void setSpvCorporationDao(ISpvCorporationDao spvCorporationDao) {
		this.spvCorporationDao = spvCorporationDao;
	}
}
