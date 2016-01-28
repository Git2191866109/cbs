package com.bs.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bs.core.cache.TemplateCache;
import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;


@Service
public class CommonService extends BaseService<Entity>{

	
	/**
	 * 获取系统模板文件路径
	 * @param key
	 * @return
	 */
	public ResultData tpath(String key){
		 Collection<String> collPaths = TemplateCache.getAllCache();
		 Map<String, Object> resultMap = new HashMap<String,Object>();
		 ArrayList<String> arrayList = new ArrayList<String>();
		 for (String path:collPaths){
			 if (path.startsWith(key)){
				 arrayList.add(path);
			 }
		 }
		 ResultData resultData = new ResultData();
		 resultMap.put("paths", arrayList);
		 resultData.setResultMap(resultMap);
		 return resultData;
	}
	
	/**
	 * 根据KEY获取初始化数据
	 * @param key
	 * @return
	 */
	public  ResultData  initData(String key){
		 Map<String, Object> resultMap = new HashMap<String,Object>();
		 ResultData resultData = new ResultData();
		 Map<String, List<Object>> datamap = super.getInitializeData().getConfigFileData();
		 if (datamap != null){
			 List<Object> datas =  datamap.get(key);
			 if (datas != null){
				 resultMap.put(key, datas);
			 }
			 resultData.setResultMap(resultMap);
		 }
		 return resultData;
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public ResultData save(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData modify(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData delete(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData single(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData list(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData paginated(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData modifyById(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData deleteById(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
 