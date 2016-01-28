package com.bs.plugins.custom.eb.greadeyear.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.greadeyear.entity.GreadeYear;
import com.bs.plugins.custom.eb.greadeyear.dao.IGreadeYearDao;

public class BaseGreadeYearService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IGreadeYearDao greadeYearDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeYearDao.insert(greadeYear);
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
	public ResultData modify(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeYearDao.updateById(greadeYear);
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
	public ResultData modifyById(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeYearDao.updateById(greadeYear);
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
	public ResultData modifyComplete(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeYearDao.updateCompleteById(greadeYear);
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
	public ResultData delete(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeYearDao.delete(greadeYear);
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
	public ResultData deleteById(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeYearDao.deleteById(greadeYear);
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
			Integer result = greadeYearDao.deleteAll();
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
	public ResultData single(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			GreadeYear greadeYearTemp = greadeYearDao.selectOneById(greadeYear);
			if (greadeYearTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("greadeYear", greadeYearTemp);
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
	public ResultData list(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			List<GreadeYear> greadeYearList = greadeYearDao.selectList(greadeYear);
			if (greadeYearList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("greadeYearList", greadeYearList);
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
	public ResultData paginated(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			List<GreadeYear> greadeYearList = greadeYearDao.selectPaginatedList(greadeYear);
			Long greadeYearCount = greadeYearDao.getCount(greadeYear);
			if (greadeYearList != null){
				long record = greadeYearCount == null?0:greadeYearCount;
				int pageCount = (int) Math.ceil(record / (double) greadeYear.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", greadeYear.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", greadeYearList);
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
	
	public IGreadeYearDao getGreadeYearDao() {
		return greadeYearDao;
	}

	public void setGreadeYearDao(IGreadeYearDao greadeYearDao) {
		this.greadeYearDao = greadeYearDao;
	}
}
