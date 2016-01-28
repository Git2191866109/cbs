package com.bs.plugins.custom.pc.attributedataconfig.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.pc.attributedataconfig.base.BaseAttributeDataConfigService;
import com.bs.plugins.custom.pc.attributedataconfig.entity.AttributeDataConfig;
import com.bs.plugins.custom.sc.dictionary.dao.IDictionaryDao;

@Service
public class AttributeDataConfigService extends BaseAttributeDataConfigService<AttributeDataConfig> {

	@Autowired
	private IDictionaryDao dictionaryDao;

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData attributeDataConfigIndex(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {

			List<AttributeDataConfig> attributeDataConfigs = this.getAttributeDataConfigDao().selectList(attributeDataConfig);

			if(CollectionUtils.isNotEmpty(attributeDataConfigs)) {
				if(attributeDataConfig.getDataSource() == null) {
					attributeDataConfig.setDataSource(0);
				}
				resultData.addObject("attributeDataConfig",attributeDataConfigs.get(0));
			}
//			else {
//				attributeDataConfig.setDataSource(1);
//				attributeDataConfig.setDictCategoryId(1L);
//				attributeDataConfig.setTableName("UC_User");
//				attributeDataConfig.setKeyColumn("Id");
//				attributeDataConfig.setValueColumn("Name");
//				resultData.addObject("attributeDataConfig", attributeDataConfig);
//
//			}

			resultData.addObject("attributeDataConfigs",attributeDataConfigs);
			resultData.setViewName("pc/basecfg/attrmanage_datacfg");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(AttributeDataConfig attributeDataConfig){
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
	public ResultData jumpPaginated(AttributeDataConfig attributeDataConfig){
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
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData createOrUpdate(AttributeDataConfig attributeDataConfig){
		if(attributeDataConfig.getId() != null &&  attributeDataConfig.getId()> 0) {
			return super.modify(attributeDataConfig);
		}else {
			return super.create(attributeDataConfig);
		}
	}

	public IDictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(IDictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
}
