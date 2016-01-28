package com.bs.plugins.custom.eb.greade.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.greade.entity.Greade;
import com.bs.plugins.custom.eb.greade.dao.IGreadeDao;

public class BaseGreadeService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IGreadeDao greadeDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Greade greade){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeDao.insert(greade);
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
	public ResultData modify(Greade greade){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeDao.updateById(greade);
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
	public ResultData modifyById(Greade greade){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeDao.updateById(greade);
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
	public ResultData delete(Greade greade){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeDao.delete(greade);
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
	public ResultData deleteById(Greade greade){
		ResultData resultData = new ResultData();
		try {
			Integer result = greadeDao.deleteById(greade);
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
			Integer result = greadeDao.deleteAll();
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
	public ResultData single(Greade greade){
		ResultData resultData = new ResultData();
		try {
			Greade greadeTemp = greadeDao.selectOneById(greade);
			if (greadeTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("greade", greadeTemp);
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
	public ResultData list(Greade greade){
		ResultData resultData = new ResultData();
		try {
			List<Greade> greadeList = greadeDao.selectList(greade);
			if (greadeList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("greadeList", greadeList);
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
	public ResultData paginated(Greade greade){
		ResultData resultData = new ResultData();
		try {
			List<Greade> greadeList = greadeDao.selectPaginatedList(greade);
			Long greadeCount = greadeDao.getCount(greade);
			if (greadeList != null){
				long record = greadeCount == null?0:greadeCount;
				int pageCount = (int) Math.ceil(record / (double) greade.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", greade.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", greadeList);
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
	
	public IGreadeDao getGreadeDao() {
		return greadeDao;
	}

	public void setGreadeDao(IGreadeDao greadeDao) {
		this.greadeDao = greadeDao;
	}
}
