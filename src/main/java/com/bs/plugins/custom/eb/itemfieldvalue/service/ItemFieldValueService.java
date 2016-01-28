package com.bs.plugins.custom.eb.itemfieldvalue.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;
import com.bs.plugins.custom.eb.itemfieldvalue.base.BaseItemFieldValueService;

@Service
public class ItemFieldValueService extends BaseItemFieldValueService<ItemFieldValue> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData itemFieldValueIndex(ItemFieldValue itemFieldValue){
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
	public ResultData jumpModify(ItemFieldValue itemFieldValue){
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
	public ResultData jumpCreate(ItemFieldValue itemFieldValue){
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
	public ResultData jumpList(ItemFieldValue itemFieldValue){
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
	public ResultData jumpPaginated(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData paginated(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			List<ItemFieldValue> itemFieldValueList = super.getItemFieldValueDao().selectList(itemFieldValue);
			if (itemFieldValueList != null){
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("rows", itemFieldValueList);
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
}
