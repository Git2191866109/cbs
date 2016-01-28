package com.bs.plugins.custom.sc.dictionary.service;

import com.bs.core.dao.RedisDao;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.sc.dictionary.base.BaseDictionaryService;
import com.bs.plugins.custom.sc.dictionary.dao.IDictionaryDao;
import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;
import com.bs.plugins.custom.sc.dictionarycategory.dao.IDictionaryCategoryDao;
import com.bs.plugins.custom.sc.dictionarycategory.entity.DictionaryCategory;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryService extends BaseDictionaryService<Dictionary> {

	private static final Logger logger = Logger.getLogger(DictionaryService.class);

	@Autowired
	private IDictionaryCategoryDao iDictionaryCategoryDao;
	@Autowired
	private IDictionaryDao dictionaryDao;
	@Autowired
	private RedisDao redisDao;

	@Override
	public void afterPropertiesSet() throws Exception {
//		logger.info("==> initializing  Dictionary info.....");
//		try {
//			List<Dictionary> list = this.getDictionaryDao().selectAll();
//			if(list.size() > 0) {
//				for (Dictionary dictionary : list) {
//					Long categoryId = dictionary.getDictCategoryId();
//					List<Dictionary> cache =DictionaryCache.getDictionaryByCategoryId(String.valueOf(categoryId));
//					if(cache == null) {
//						DictionaryCache.putDictionaryByCategoryId(String.valueOf(categoryId), new ArrayList<Dictionary>());
//					}
//					cache =DictionaryCache.getDictionaryByCategoryId(String.valueOf(categoryId));
//					cache.add(dictionary);
//				}
//			}
//			logger.info("initializing  Dictionary info success!");
//		} catch (Exception e) {
//			logger.info("initializing  Dictionary info fail!");
//			e.printStackTrace();
//		}
	}
	/**
	 * 将查询的结果放在redis中
	 */
	public ResultData redisTools(Dictionary dictionary){
		ResultData resultData = new ResultData();
		try {

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
	public ResultData create(Dictionary dictionary){
		ResultData resultData = new ResultData();
		try {
			Integer result = dictionaryDao.insert(dictionary);
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
//				DictionaryCache.removeAllCache();
//				this.afterPropertiesSet();

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
	public ResultData dictionaryIndex(Dictionary dictionary){
		ResultData resultData = new ResultData();
		try {
			List<DictionaryCategory> dictionaryCategoryList = iDictionaryCategoryDao.selectList(null);
			resultData.addObject("dictionaryCategoryList", dictionaryCategoryList);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(Dictionary dictionary){
		ResultData resultData = new ResultData();
		try {
			dictionary = super.getDictionaryDao().selectOneById(dictionary);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(IBaseService.FAIL);
			e.printStackTrace();
		}
		resultData.addObject("dictionary",dictionary);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Dictionary dictionary){
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
	public ResultData jumpList(Dictionary dictionary){
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
	public ResultData jumpPaginated(Dictionary dictionary){
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
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData getJqGridSelectStrByCode(Dictionary dictionary){
		ResultData result =  getByCode(dictionary);
		List<Dictionary> dictionaryList = (List<Dictionary>) result.getResultMap().get("dictionaryList");
//		Map<String, Object> gridMap = new Hashtable<String, Object>();
		try {
//			ServletOutputStream out = dictionary.getHttpServletResponse().getOutputStream();
			PrintWriter out = dictionary.getHttpServletResponse().getWriter();
			out.print("<select>");

			for (Dictionary dictionary1 : dictionaryList) {
				out.print("<option value = '" + dictionary1.getValue() + "'>" + dictionary1.getName() + "</option>");
//				gridMap.put(dictionary1.getValue(),dictionary1.getName());
			}
			out.print("</select>");
			out.flush();
			out.close();
		} catch (IOException e) {
//			e.printStackTrace();
		}

//		result.setResultMap(gridMap);
		return result;
	}


	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData getByCode(Dictionary dictionary){

		if(dictionary.getIsDynamic() == 1 && StringUtils.isNotBlank(dictionary.getName())) {
			String str = dictionary.getName();
			String[] split = str.split("\\.");
			dictionary.setTableName(split[0] + "_" + split[1] );
			dictionary.setKeyColumn(split[2]);
			dictionary.setValueColumn(split[3]);
			return selectDynamicTableDataList(dictionary);
		}
		;
		ResultData resultData = new ResultData();
		try {
//			List<Dictionary> dictionaryList = DictionaryCache.getDictionarysByCategoryCode(dictionary.getName());
			String mapKey = redisDao.getRedisMapKey(Dictionary.class);
			Map<Object, List<Dictionary>> dictionaryMap = redisDao.getMapList(mapKey, Dictionary.class);
			List<Dictionary> dictionaryList = dictionaryMap.get(dictionary.getName());
			if (dictionaryList != null){
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("dictionaryList", dictionaryList);
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
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData getByCategoryId(Dictionary dictionary){

		ResultData resultData = new ResultData();
		try {
			String mapKey = redisDao.getRedisMapKey(DictionaryCategory.class);
			Map<Object, DictionaryCategory> dictionaryMap = redisDao.getMap(mapKey, DictionaryCategory.class);
			DictionaryCategory dictionaryCategory = dictionaryMap.get(String.valueOf(dictionary.getDictCategoryId()));
			dictionary.setName(dictionaryCategory.getCode());
			return getByCode(dictionary);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData selectDynamicTableDataList(final Dictionary dictionary){
		;
		ResultData resultData = new ResultData();
		try {
			List<Dictionary> dictionaryList = this.getDictionaryDao().selectDynamicTableDataList(
					new HashMap<String, String>() {{
						put("keyColumn", dictionary.getKeyColumn());
						put("valueColumn", dictionary.getValueColumn());
						put("tableName", dictionary.getTableName());
						put("extColumn", dictionary.getExtColumn());
						put("condition", dictionary.getCondition());
					}});
			if (dictionaryList != null){
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("dictionaryList", dictionaryList);
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
	 * 自定义分页
	 */
	public ResultData paginated(Dictionary Dictionary){
		ResultData resultData = new ResultData();
		try {
			List<Dictionary> DictionaryList = super.getDictionaryDao().selectPaginatedByDictionaryCategoryIdList(Dictionary);
			Long DictionaryCount = super.getDictionaryDao().getCount(Dictionary);
			if (DictionaryList != null){
				long record = DictionaryCount == null?0:DictionaryCount;
				int pageCount = (int) Math.ceil(record / (double) Dictionary.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", Dictionary.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", DictionaryList);
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
