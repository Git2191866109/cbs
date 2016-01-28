package com.bs.plugins.custom.sc.dictionarycategory.service;

import com.bs.core.cache.DictionaryCache;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.sc.dictionarycategory.base.BaseDictionaryCategoryService;
import com.bs.plugins.custom.sc.dictionarycategory.entity.DictionaryCategory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryCategoryService extends BaseDictionaryCategoryService<DictionaryCategory> {

	private static final Logger logger = Logger.getLogger(DictionaryCategoryService.class);


	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("==> initializing  Dictionary info.....");
		try {
			List<DictionaryCategory> list = this.getDictionaryCategoryDao().selectAll();
			if(list.size() > 0) {
				for (DictionaryCategory dictionaryCategory : list) {
					DictionaryCache.putCategoryByCode(dictionaryCategory.getCode(),dictionaryCategory);
					DictionaryCache.putCategoryById(String.valueOf(dictionaryCategory.getId()),dictionaryCategory);
				}
			}
			logger.info("initializing  Dictionary info success!");
		} catch (Exception e) {
			logger.info("initializing  Dictionary info fail!");
			e.printStackTrace();
		}
	}

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData dictionarycategoryIndex(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
			resultData.setStatus(IBaseService.FAIL);
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			dictionaryCategory = super.getDictionaryCategoryDao().selectOneById(dictionaryCategory);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("dictionaryCategory", dictionaryCategory);
		return resultData;
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
}
