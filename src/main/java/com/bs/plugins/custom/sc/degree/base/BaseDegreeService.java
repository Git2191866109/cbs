package com.bs.plugins.custom.sc.degree.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.degree.entity.Degree;
import com.bs.plugins.custom.sc.degree.dao.IDegreeDao;

public class BaseDegreeService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IDegreeDao degreeDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Degree degree){
		ResultData resultData = new ResultData();
		try {
			Integer result = degreeDao.insert(degree);
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
	public ResultData modify(Degree degree){
		ResultData resultData = new ResultData();
		try {
			Integer result = degreeDao.updateById(degree);
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
	public ResultData modifyById(Degree degree){
		ResultData resultData = new ResultData();
		try {
			Integer result = degreeDao.updateById(degree);
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
	public ResultData modifyComplete(Degree degree){
		ResultData resultData = new ResultData();
		try {
			Integer result = degreeDao.updateCompleteById(degree);
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
	public ResultData delete(Degree degree){
		ResultData resultData = new ResultData();
		try {
			Integer result = degreeDao.delete(degree);
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
	public ResultData deleteById(Degree degree){
		ResultData resultData = new ResultData();
		try {
			Integer result = degreeDao.deleteById(degree);
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
			Integer result = degreeDao.deleteAll();
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
	public ResultData single(Degree degree){
		ResultData resultData = new ResultData();
		try {
			Degree degreeTemp = degreeDao.selectOneById(degree);
			if (degreeTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("degree", degreeTemp);
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
	public ResultData list(Degree degree){
		ResultData resultData = new ResultData();
		try {
			List<Degree> degreeList = degreeDao.selectList(degree);
			if (degreeList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("degreeList", degreeList);
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
	public ResultData paginated(Degree degree){
		ResultData resultData = new ResultData();
		try {
			List<Degree> degreeList = degreeDao.selectPaginatedList(degree);
			Long degreeCount = degreeDao.getCount(degree);
			if (degreeList != null){
				long record = degreeCount == null?0:degreeCount;
				int pageCount = (int) Math.ceil(record / (double) degree.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", degree.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", degreeList);
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
	
	public IDegreeDao getDegreeDao() {
		return degreeDao;
	}

	public void setDegreeDao(IDegreeDao degreeDao) {
		this.degreeDao = degreeDao;
	}
}
