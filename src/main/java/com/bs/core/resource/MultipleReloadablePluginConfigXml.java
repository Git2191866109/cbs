package com.bs.core.resource;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;



public class MultipleReloadablePluginConfigXml{
	
	private String[] pluginNames = new String[0];
    private ResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
    private static final String CLASS = "classes";
	
	public String[] getPluginNames() {
		return pluginNames;
	}

	public void setPluginNames(String[] pluginNames) {
		if (pluginNames != null && pluginNames.length > 0) { 
    		ArrayList<String> resourceList = new ArrayList<String>();
    		for (String fileName:pluginNames){
    			try {
					Resource[] resources = resolver.getResources(fileName);
					for (Resource resource : resources) {  
		                String sourcePath = resource.getURI().toString();
		                int startIndex = sourcePath.indexOf(CLASS);
		                if (startIndex >= 0){
		                	String sourcePathTemp = sourcePath.substring(startIndex+CLASS.length() + 1,sourcePath.length());
		                	resourceList.add(sourcePathTemp);
		                }
		            }
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    		this.pluginNames = resourceList.toArray(new String[resourceList.size()]);
    	}
		else {
			this.pluginNames = new String[0];
		}
	}
}
