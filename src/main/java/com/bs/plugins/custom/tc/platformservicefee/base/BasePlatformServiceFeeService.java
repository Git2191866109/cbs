package com.bs.plugins.custom.tc.platformservicefee.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.platformservicefee.entity.PlatformServiceFee;
import com.bs.plugins.custom.tc.platformservicefee.dao.IPlatformServiceFeeDao;

public class BasePlatformServiceFeeService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IPlatformServiceFeeDao platformServiceFeeDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			Integer result = platformServiceFeeDao.insert(platformServiceFee);
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
	public ResultData modify(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			Integer result = platformServiceFeeDao.updateById(platformServiceFee);
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
	public ResultData modifyById(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			Integer result = platformServiceFeeDao.updateById(platformServiceFee);
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
	public ResultData modifyComplete(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			Integer result = platformServiceFeeDao.updateCompleteById(platformServiceFee);
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
	public ResultData delete(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			Integer result = platformServiceFeeDao.delete(platformServiceFee);
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
	public ResultData deleteById(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			Integer result = platformServiceFeeDao.deleteById(platformServiceFee);
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
			Integer result = platformServiceFeeDao.deleteAll();
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
	public ResultData single(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			PlatformServiceFee platformServiceFeeTemp = platformServiceFeeDao.selectOneById(platformServiceFee);
			if (platformServiceFeeTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("platformServiceFee", platformServiceFeeTemp);
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
	public ResultData list(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			List<PlatformServiceFee> platformServiceFeeList = platformServiceFeeDao.selectList(platformServiceFee);
			if (platformServiceFeeList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("platformServiceFeeList", platformServiceFeeList);
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
	public ResultData paginated(PlatformServiceFee platformServiceFee){
		ResultData resultData = new ResultData();
		try {
			List<PlatformServiceFee> platformServiceFeeList = platformServiceFeeDao.selectPaginatedList(platformServiceFee);
			Long platformServiceFeeCount = platformServiceFeeDao.getCount(platformServiceFee);
			if (platformServiceFeeList != null){
				long record = platformServiceFeeCount == null?0:platformServiceFeeCount;
				int pageCount = (int) Math.ceil(record / (double) platformServiceFee.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", platformServiceFee.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", platformServiceFeeList);
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
	
	public IPlatformServiceFeeDao getPlatformServiceFeeDao() {
		return platformServiceFeeDao;
	}

	public void setPlatformServiceFeeDao(IPlatformServiceFeeDao platformServiceFeeDao) {
		this.platformServiceFeeDao = platformServiceFeeDao;
	}
}
