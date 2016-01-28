package com.bs.plugins.custom.pc.attribute.service;

import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.pc.attributedataconfig.entity.AttributeDataConfig;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.pc.attribute.entity.Attribute;
import com.bs.plugins.custom.pc.attribute.base.BaseAttributeService;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class AttributeService extends BaseAttributeService<Attribute> {

	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			List<Attribute> attributeList = super.getAttributeDao().selectNewPaginatedList(attribute);
			Long attributeCount = super.getAttributeDao().getCount(attribute);
			if (attributeList != null){
				long record = attributeCount == null?0:attributeCount;
				int pageCount = (int) Math.ceil(record / (double) attribute.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", attribute.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", attributeList);
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
	public ResultData attributeIndex(Attribute attribute){
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
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData attrmanageIndex(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("attributeDataConfig", new AttributeDataConfig());
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("attribute", this.getAttributeDao().selectOneById(attribute));
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("attribute", new Attribute());
			resultData.addObject("attributeDataConfig", new AttributeDataConfig());
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(Attribute attribute){
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
	public ResultData jumpPaginated(Attribute attribute){
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
