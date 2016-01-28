package com.bs.plugins.custom.sc.area.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.Cn2Spell;
import com.bs.plugins.custom.sc.area.base.BaseAreaService;
import com.bs.plugins.custom.sc.area.entity.Area;

@Service
public class AreaService extends BaseAreaService<Area> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData areaIndex(Area area){
		ResultData resultData = new ResultData();
		try {
			//add your code
			//进入地区页面首先加载0，1级地区	
			Area temp = new Area();
			temp.setTreeLevel(1);
			List<Area> areaList0 = super.getAreaDao().selectList(temp);
			
			temp.setTreeLevel(2);
			List<Area> areaList1 = super.getAreaDao().selectList(temp);
			
			resultData.addObject("areaList0", areaList0);
			resultData.addObject("areaList1", areaList1);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(Area area){
		ResultData resultData = new ResultData();
		try {
			area = super.getAreaDao().selectOneById(area);
			resultData.addObject("area", area);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Area area){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("area", area);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(Area area){
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
	public ResultData jumpPaginated(Area area){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	
	public ResultData create(Area area){
		ResultData resultData = new ResultData();
		try {
			
			Cn2Spell cn2Spell = new Cn2Spell();
			try {
				String spelling = cn2Spell.toPinYin(area.getName(),"",Cn2Spell.Type.FIRSTUPPER);
				area.setSpelling(spelling);
				String relationPath = super.getAreaDao().selectRelationPathByParentCode(area);
				if(relationPath != null){
					area.setRelationPath(relationPath+","+area.getCode());
				}else{
					area.setRelationPath(area.getParentCode()+","+area.getCode());
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
			Integer result = super.getAreaDao().insert(area);
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
	
	public ResultData list(Area area){
		ResultData resultData = new ResultData();
		try {
			List<Area> areaList = super.getAreaDao().selectListByCode(area);
			if (areaList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("areaList", areaList);
				resultData.addObject("area", area);
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
	
	public ResultData selectSubLevel(Area area){
		ResultData resultData = new ResultData();
		try {
			Long result = super.getAreaDao().selectSubLevel(area);
			if (result > 0){
				resultData.setStatus(IBaseService.FAIL);
			}
			else{
				resultData.setStatus(IBaseService.SUCCESS);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	public ResultData getArea(Area area){
		ResultData resultData = new ResultData();
		try {
			List<Area> areaList = super.getAreaDao().getArea(area);
			List<Map<String,Object>> lm=new ArrayList<Map<String,Object>>();
			for(Area ar:areaList)
			{
				 Map<String,Object> m=new HashMap<String, Object>();
				 m.put("id",ar.getCode() );
				 m.put("name", ar.getName());
				 m.put("parentCode",area.getParentCode());
				 m.put("code", ar.getCode());
				 int l=super.getAreaDao().selectChildNote(ar);
				 if(l>0){
					 m.put("isParent", true);
				 }else{
					 m.put("isParent", false);
				 }
				 lm.add(m);
			}
			String json=JSONObject.toJSONString(lm);
			System.out.println(json);
			Map<String,Object> mjson = new HashMap<String,Object>();
			mjson.put("json", json);
			resultData.setResultMap(mjson);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		
		return resultData;
	}
}
