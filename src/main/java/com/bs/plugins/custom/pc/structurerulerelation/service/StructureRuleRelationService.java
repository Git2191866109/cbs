package com.bs.plugins.custom.pc.structurerulerelation.service;

import com.bs.core.service.IBaseService;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.pc.structurerulerelation.entity.StructureRuleRelation;
import com.bs.plugins.custom.pc.structurerulerelation.base.BaseStructureRuleRelationService;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class StructureRuleRelationService extends BaseStructureRuleRelationService<StructureRuleRelation> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData structureRuleRelationIndex(StructureRuleRelation structureRuleRelation){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("productStructureId", structureRuleRelation.getProductStructureId());
			resultData.setViewName("pc/basecfg/categorycfg_rule");



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
	public ResultData paginated(StructureRuleRelation structureRuleRelation){
		ResultData resultData = new ResultData();
		try {
			List<StructureRuleRelation> structureRuleRelationList = this.getStructureRuleRelationDao().selectStructureRuleRelationValidationRule(structureRuleRelation);
			Long structureRuleRelationCount = this.getStructureRuleRelationDao().getCount(structureRuleRelation);
			if (structureRuleRelationList != null){
				long record = structureRuleRelationCount == null?0:structureRuleRelationCount;
				int pageCount = (int) Math.ceil(record / (double) structureRuleRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", structureRuleRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", structureRuleRelationList);
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
	
	/**跳转到修改页**/
	public ResultData jumpModify(StructureRuleRelation structureRuleRelation){
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
	public ResultData jumpCreate(StructureRuleRelation structureRuleRelation){
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
	public ResultData jumpList(StructureRuleRelation structureRuleRelation){
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
	public ResultData jumpPaginated(StructureRuleRelation structureRuleRelation){
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
