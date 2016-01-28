package com.bs.plugins.custom.eb.modeitemrelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;
import com.bs.plugins.custom.eb.modeitemrelation.dao.IModeItemRelationDao;

public class BaseModeItemRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IModeItemRelationDao modeItemRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = modeItemRelationDao.insert(modeItemRelation);
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
	public ResultData modify(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = modeItemRelationDao.updateById(modeItemRelation);
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
	public ResultData modifyById(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = modeItemRelationDao.updateById(modeItemRelation);
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
	public ResultData modifyComplete(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = modeItemRelationDao.updateCompleteById(modeItemRelation);
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
	public ResultData delete(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = modeItemRelationDao.delete(modeItemRelation);
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
	public ResultData deleteById(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = modeItemRelationDao.deleteById(modeItemRelation);
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
			Integer result = modeItemRelationDao.deleteAll();
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
	public ResultData single(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			ModeItemRelation modeItemRelationTemp = modeItemRelationDao.selectOneById(modeItemRelation);
			if (modeItemRelationTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("modeItemRelation", modeItemRelationTemp);
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
	public ResultData list(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			List<ModeItemRelation> modeItemRelationList = modeItemRelationDao.selectList(modeItemRelation);
			if (modeItemRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("modeItemRelationList", modeItemRelationList);
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
	public ResultData paginated(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			List<ModeItemRelation> modeItemRelationList = modeItemRelationDao.selectPaginatedList(modeItemRelation);
			Long modeItemRelationCount = modeItemRelationDao.getCount(modeItemRelation);
			if (modeItemRelationList != null){
				long record = modeItemRelationCount == null?0:modeItemRelationCount;
				int pageCount = (int) Math.ceil(record / (double) modeItemRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", modeItemRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", modeItemRelationList);
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
	
	public IModeItemRelationDao getModeItemRelationDao() {
		return modeItemRelationDao;
	}

	public void setModeItemRelationDao(IModeItemRelationDao modeItemRelationDao) {
		this.modeItemRelationDao = modeItemRelationDao;
	}
}
