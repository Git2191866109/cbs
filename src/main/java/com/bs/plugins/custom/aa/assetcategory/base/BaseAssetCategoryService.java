package com.bs.plugins.custom.aa.assetcategory.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.aa.assetcategory.entity.AssetCategory;
import com.bs.plugins.custom.aa.assetcategory.dao.IAssetCategoryDao;

public class BaseAssetCategoryService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAssetCategoryDao assetCategoryDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = assetCategoryDao.insert(assetCategory);
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
	public ResultData modify(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = assetCategoryDao.updateById(assetCategory);
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
	public ResultData modifyById(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = assetCategoryDao.updateById(assetCategory);
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
	public ResultData modifyComplete(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = assetCategoryDao.updateCompleteById(assetCategory);
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
	public ResultData delete(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = assetCategoryDao.delete(assetCategory);
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
	public ResultData deleteById(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = assetCategoryDao.deleteById(assetCategory);
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
			Integer result = assetCategoryDao.deleteAll();
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
	public ResultData single(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			AssetCategory assetCategoryTemp = assetCategoryDao.selectOneById(assetCategory);
			if (assetCategoryTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("assetCategory", assetCategoryTemp);
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
	public ResultData list(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			List<AssetCategory> assetCategoryList = assetCategoryDao.selectList(assetCategory);
			if (assetCategoryList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("assetCategoryList", assetCategoryList);
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
	public ResultData paginated(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			List<AssetCategory> assetCategoryList = assetCategoryDao.selectPaginatedList(assetCategory);
			Long assetCategoryCount = assetCategoryDao.getCount(assetCategory);
			if (assetCategoryList != null){
				long record = assetCategoryCount == null?0:assetCategoryCount;
				int pageCount = (int) Math.ceil(record / (double) assetCategory.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", assetCategory.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", assetCategoryList);
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
	
	public IAssetCategoryDao getAssetCategoryDao() {
		return assetCategoryDao;
	}

	public void setAssetCategoryDao(IAssetCategoryDao assetCategoryDao) {
		this.assetCategoryDao = assetCategoryDao;
	}
}
