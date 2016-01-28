package com.bs.plugins.custom.pc.structurekindrelation.service;

import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.pc.product.IProductConst;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.pc.structurekindrelation.entity.StructureKindRelation;
import com.bs.plugins.custom.pc.structurekindrelation.base.BaseStructureKindRelationService;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class StructureKindRelationService extends BaseStructureKindRelationService<StructureKindRelation> {



	public Map<Long, StructureKindRelation> getStructureKindRelationMapByKindId(Long kindId) throws Exception {
		Map<Long, StructureKindRelation> map = new HashMap<>();
		StructureKindRelation structureKindRelation = new StructureKindRelation();
		structureKindRelation.setKindId(IProductConst.KIND_ID_PRODUCT_CREATE_DISPLAY);
		List<StructureKindRelation> structureKindRelations = this.getStructureKindRelationDao().selectList(structureKindRelation);
		if(structureKindRelations != null) {
			for (StructureKindRelation kindRelation : structureKindRelations) {
				map.put(kindRelation.getProductStructureId(),kindRelation);
			}
		}
		return map;
	}

	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(StructureKindRelation structureKindRelation){
		ResultData resultData = new ResultData();
		try {
			List<StructureKindRelation> structureKindRelationList = this.getStructureKindRelationDao().selectList(structureKindRelation);
			Long structureKindRelationCount = this.getStructureKindRelationDao().getCount(structureKindRelation);
			if (structureKindRelationList != null){
				long record = structureKindRelationCount == null?0:structureKindRelationCount;
				int pageCount = (int) Math.ceil(record / (double) structureKindRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", structureKindRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", structureKindRelationList);
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
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData structureKindRelationIndex(StructureKindRelation structureKindRelation){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("productStructureId", structureKindRelation.getProductStructureId());
			resultData.setViewName("pc/basecfg/categorycfg_kind");

		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(StructureKindRelation structureKindRelation){
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
	public ResultData jumpCreate(StructureKindRelation structureKindRelation){
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
	public ResultData jumpList(StructureKindRelation structureKindRelation){
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
	public ResultData jumpPaginated(StructureKindRelation structureKindRelation){
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
