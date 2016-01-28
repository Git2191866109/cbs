package com.bs.plugins.custom.aa.assetcategory.service;

import com.bs.core.cache.DictionaryCache;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.aa.assetcategory.entity.AssetCategory;
import com.bs.plugins.custom.aa.assetcategory.base.BaseAssetCategoryService;

import java.util.List;

@Service
public class AssetCategoryService extends BaseAssetCategoryService<AssetCategory> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData assetCategoryIndex(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("assetCategory", this.getAssetCategoryDao().selectOneById(assetCategory));
//			resultData.addObject("DicTypeList", DictionaryCache.getDictionarysByCategoryCode("AA.AssetCategory.Type"));
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
//			resultData.addObject("DicTypeList", DictionaryCache.getDictionarysByCategoryCode("AA.AssetCategory.Type"));
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(AssetCategory assetCategory){
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
	public ResultData jumpPaginated(AssetCategory assetCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
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
	@SuppressWarnings("unchecked")
	public ResultData paginated(AssetCategory assetCategory){
		ResultData resultData = super.paginated(assetCategory);
		if(resultData.getResultMap() != null) {
			List<AssetCategory> list = (List<AssetCategory>) resultData.getResultMap().get("rows");
			if(list != null) {
				for (AssetCategory category : list) {
					if(DictionaryCache.getDictionarysByCategoryCodeAndKey("AA.AssetCategory.Type", String.valueOf(category.getType()))!= null) {
						category.setTypeName(DictionaryCache.getDictionarysByCategoryCodeAndKey("AA.AssetCategory.Type", String.valueOf(category.getType())).getName());
					}else {
						category.setTypeName(String.valueOf(category.getType()));
					}
				}
			}
		}
		return resultData;
	}

}
