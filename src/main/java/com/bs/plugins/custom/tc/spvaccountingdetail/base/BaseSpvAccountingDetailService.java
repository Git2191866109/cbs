package com.bs.plugins.custom.tc.spvaccountingdetail.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.spvaccountingdetail.entity.SpvAccountingDetail;
import com.bs.plugins.custom.tc.spvaccountingdetail.dao.ISpvAccountingDetailDao;

public class BaseSpvAccountingDetailService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISpvAccountingDetailDao spvAccountingDetailDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvAccountingDetailDao.insert(spvAccountingDetail);
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
	public ResultData modify(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvAccountingDetailDao.updateById(spvAccountingDetail);
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
	public ResultData modifyById(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvAccountingDetailDao.updateById(spvAccountingDetail);
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
	public ResultData modifyComplete(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvAccountingDetailDao.updateCompleteById(spvAccountingDetail);
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
	public ResultData delete(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvAccountingDetailDao.delete(spvAccountingDetail);
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
	public ResultData deleteById(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = spvAccountingDetailDao.deleteById(spvAccountingDetail);
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
			Integer result = spvAccountingDetailDao.deleteAll();
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
	public ResultData single(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			SpvAccountingDetail spvAccountingDetailTemp = spvAccountingDetailDao.selectOneById(spvAccountingDetail);
			if (spvAccountingDetailTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvAccountingDetail", spvAccountingDetailTemp);
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
	public ResultData list(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			List<SpvAccountingDetail> spvAccountingDetailList = spvAccountingDetailDao.selectList(spvAccountingDetail);
			if (spvAccountingDetailList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("spvAccountingDetailList", spvAccountingDetailList);
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
	public ResultData paginated(SpvAccountingDetail spvAccountingDetail){
		ResultData resultData = new ResultData();
		try {
			List<SpvAccountingDetail> spvAccountingDetailList = spvAccountingDetailDao.selectPaginatedList(spvAccountingDetail);
			Long spvAccountingDetailCount = spvAccountingDetailDao.getCount(spvAccountingDetail);
			if (spvAccountingDetailList != null){
				long record = spvAccountingDetailCount == null?0:spvAccountingDetailCount;
				int pageCount = (int) Math.ceil(record / (double) spvAccountingDetail.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvAccountingDetail.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", spvAccountingDetailList);
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
	
	public ISpvAccountingDetailDao getSpvAccountingDetailDao() {
		return spvAccountingDetailDao;
	}

	public void setSpvAccountingDetailDao(ISpvAccountingDetailDao spvAccountingDetailDao) {
		this.spvAccountingDetailDao = spvAccountingDetailDao;
	}
}
