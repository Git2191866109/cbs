package com.bs.plugins.custom.pc.structureconfig.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.pc.structureconfig.base.BaseStructureConfigService;
import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;
import com.bs.plugins.custom.sc.dictionary.dao.IDictionaryDao;
import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;

@Service
public class StructureConfigService extends BaseStructureConfigService<StructureConfig> {

	@Autowired
	private IDictionaryDao dictionaryDao;
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData structureConfigIndex(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("categoryId", structureConfig.getCategoryId());
			resultData.setViewName("pc/basecfg/categorycfg");
			resultData.addObject("categoryId", structureConfig.getCategoryId());
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData categorycfgIndex(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			List<Dictionary> dictionaryList = this.getDictionaryDao().selectDynamicTableDataList(
					new HashMap<String, String>() {{
						put("tableName", "PC_Category");
						put("keyColumn", "Id");
						put("valueColumn", "Name");
					}});
			resultData.addObject("categoryList", dictionaryList);
			resultData.setViewName("pc/basecfg/categorycfg_frame");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}


	
	/**跳转到修改页**/
	public ResultData jumpModify(StructureConfig structureConfig){
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
	public ResultData jumpCreate(StructureConfig structureConfig){
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
	public ResultData jumpList(StructureConfig structureConfig){
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
	public ResultData jumpPaginated(StructureConfig structureConfig){
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
	public ResultData getStructureConfigHomeList(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			List<StructureConfig> structureConfigList = super.getStructureConfigDao().getStructureConfigHomeList(structureConfig);

			Long structureConfigCount = super.getStructureConfigDao().getCount(structureConfig);
			if (structureConfigList != null){
				for (StructureConfig config : structureConfigList) {
					if(config.getId() == null) {
						config.setId(-config.getAttributeId());
					}
				}
				long record = structureConfigCount == null?0:structureConfigCount;
				int pageCount = (int) Math.ceil(record / (double) structureConfig.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", structureConfig.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", structureConfigList);
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

	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData save(StructureConfig structureConfig){
		if(structureConfig.getId()<=0) {
			structureConfig.setId(null);
			return create(structureConfig);
		}else {
			if(structureConfig.getisDelete() != null && structureConfig.getisDelete() == 1) {
				return super.modify(structureConfig);
			}else {
				return super.modifyComplete(structureConfig);
			}

		}
	}

	public IDictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(IDictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
}
