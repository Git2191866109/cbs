package com.bs.core.resource;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.bs.core.cache.TemplateCache;


public class MultipleReloadableResourceBundleTemplateSource{

	private ResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
	private static final String CLASS = "classes";
	private String[] basenames = new String[0];

	public String[] getBasenames() {
		return basenames;
	}

	public void setBasenames(String[] basenames) {
		if (basenames != null && basenames.length > 0) { 
    		ArrayList<String> resourceList = new ArrayList<String>();
    		for (String fileName:basenames){
    			try {
					Resource[] resources = resolver.getResources(fileName);
					for (Resource resource : resources) {  
		                String sourcePath = resource.getURI().toString();
		                int startIndex = sourcePath.indexOf(CLASS);
		                if (startIndex >= 0){
		                	String sourcePathTemp = sourcePath.substring(startIndex+CLASS.length() + 1,sourcePath.length());
		                	TemplateCache.putCache(sourcePathTemp,sourcePath);
		                }
		            }
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    		this.basenames = resourceList.toArray(new String[resourceList.size()]);
    	}
    	else{
    		this.basenames = new String[0];
    	}
	}
	
}
