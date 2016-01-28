package com.bs.core.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.dao.DataRetrievalFailureException;

/**
 * 系统级参数缓存
 * @author new
 *
 */
public class PageParamCache {
	
	private static final String PAGE_PARAM_NAME = "page_param_config";
	
	private static Cache cache = CacheManager.getInstance().getCache(PAGE_PARAM_NAME);

	public static synchronized void putAuthCache(String url,Object obj) {
		if (url != null && !"".equals(url)){
			Element element = new Element(url, obj);
			cache.put(element);
		}
	}
	
	public static synchronized Object getCache(String url) {
		Element element = null;
		try {
			element = cache.get(url);
		} catch (CacheException cacheException) {
			throw new DataRetrievalFailureException("ResourceCache failure: "
					+ cacheException.getMessage(), cacheException);
		}
		if (element == null)
			return null;

		return element.getValue();
	}

	public static synchronized void removeCache(String url) {
		cache.remove(url);
	}

	public static synchronized void removeAllCache() {
		cache.removeAll();
		cache.clearStatistics();
		cache.flush();
	}
}