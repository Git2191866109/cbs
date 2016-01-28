package com.bs.core.cache;

import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;
import com.bs.plugins.custom.sc.dictionarycategory.entity.DictionaryCategory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.dao.DataRetrievalFailureException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 系统级参数缓存
 * @author new
 *
 */
public class DictionaryCache {
	
	private static final String DICTIONARY_DATA = "dictionary_data";

	private static final String CATEGORY_ID_ = "CATEGORY_ID$";
	private static final String DIC_CATEGORY_ID_ = "DIC_CATEGORY_ID$";
	private static final String DIC_CATEGORY_CODE_ = "DIC_CATEGORY_CODE$";

	private static Cache cache = CacheManager.getInstance().getCache(DICTIONARY_DATA);


	/**
	 * 按照字典分类存放字典信息
	 * @param key
	 * @param dictionaryList
	 */
	public static synchronized void putDictionaryByCategoryId(String key,List<Dictionary> dictionaryList) {
		putCache(CATEGORY_ID_ + key, dictionaryList);
	}

	/**
	 * 根据分类ID存放分类信息
	 * @param key
	 * @param dictionaryCategory
	 */
	public static synchronized void putCategoryById(String key,DictionaryCategory dictionaryCategory) {
		putCache(DIC_CATEGORY_ID_ + key, dictionaryCategory);
	}


	/**
	 * 根据分类编码存放分类信息
	 * @param key
	 * @param dictionaryCategory
	 */
	public static synchronized void putCategoryByCode(String key,DictionaryCategory dictionaryCategory) {
		putCache(DIC_CATEGORY_CODE_ + key, dictionaryCategory);
	}

	/**
	 * 通过分类编码获取字典信息
	 * @param categoryCode
	 * @return
	 */
	public static synchronized List<Dictionary> getDictionarysByCategoryCode(String categoryCode) {
		DictionaryCategory category = getCategoryByCode(categoryCode);
		if(category != null) {
			return getDictionaryByCategoryId(String.valueOf(category.getId()));
		}
		return null;
	}

	/**
	 * 通过分类编码与字典值获取字典信息
	 * @param categoryCode
	 * @return
	 */
	public static synchronized Dictionary getDictionarysByCategoryCodeAndKey(String categoryCode,String key) {
		DictionaryCategory category = getCategoryByCode(categoryCode);
		if(category != null) {
			List<Dictionary> dictionaryList = getDictionaryByCategoryId(String.valueOf(category.getId()));
			if(dictionaryList != null && dictionaryList.size() > 0) {
				for (Dictionary dictionary : dictionaryList) {
					if(dictionary.getValue().equals(key)) {
						return dictionary;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 根据分类ID获取字典信息
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static synchronized List<Dictionary> getDictionaryByCategoryId(String key) {
		return (List<Dictionary>) getCache(CATEGORY_ID_ + key);
	}

	/**
	 * 根据分类ID获取分类信息
	 * @param key
	 * @return
	 */
	public static synchronized DictionaryCategory getCategoryById(String key) {
		return (DictionaryCategory) getCache(DIC_CATEGORY_ID_ + key);
	}

	/**
	 * 根据分类编码获取分类信息
	 * @param key
	 * @return
	 */
	public static synchronized DictionaryCategory getCategoryByCode(String key) {
		return (DictionaryCategory) getCache(DIC_CATEGORY_CODE_ + key);
	}

	private static synchronized void putCache(String key,Object object) {
		if (key != null && !"".equals(key)){
			Element element = new Element(key, object);
			cache.put(element);
		}
	}
	
	private static synchronized Object getCache(String key) {
		Element element = null;
		try {
			element = cache.get(key);
		} catch (CacheException cacheException) {
			throw new DataRetrievalFailureException("ResourceCache failure: "
					+ cacheException.getMessage(), cacheException);
		}
		if (element == null)
			return null;

		return element.getValue();
	}
	
	@SuppressWarnings("unchecked")
	public static synchronized Collection<String> getAllCache() {
		Collection<String> resources;
		List<String> resclist = new ArrayList<String>();
		try {
			resources = cache.getKeys();
		} catch (IllegalStateException e) {
			throw new IllegalStateException(e.getMessage(), e);
		} catch (CacheException e) {
			throw new UnsupportedOperationException(e.getMessage(), e);
		}
		for (Iterator<String> localIterator = resources.iterator(); localIterator.hasNext();) {
			String key = localIterator.next();
			if (key != null){
				resclist.add(key);
			}
		}
		return resclist;
	}
	
	public static synchronized void removeCache(String key) {
		cache.remove(key);
	}

	public static synchronized void removeAllCache() {
		cache.removeAll();
		cache.clearStatistics();
		cache.flush();
	}
}