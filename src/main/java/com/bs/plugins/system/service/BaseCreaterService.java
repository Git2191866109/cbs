package com.bs.plugins.system.service;

import java.io.File;
import java.io.IOException;




public abstract class BaseCreaterService{
	
	/**数据库设计文件存放目录**/
	public static String pdmFilePath = "classpath:com/bs/plugins/system/database/";
	/**系统功能插件配置文件路径**/
	public static String pluginConfigFilePath = "classpath:com/bs/plugins/custom/_config/*plugin-config.xml";
	/**视图模板文件存放目录**/
	public static String resourceTemplateFilePath = "classpath:com/bs/plugins/system/template/resource/";
	/**临时文件存放目录**/
	public static String tmpFilePath = "classpath:com/bs/plugins/system/template/tmp/";
	/**视图模板文件存放目录**/
	public static String viewConfigFilePath = "classpath:com/bs/plugins/custom/_config/model/";
	/**实体bean存放目录**/
	public static String entityClassFilePath = "classpath:com/bs/plugins/custom/";
	/**视图页面模板存放目录**/
	public static String viewTemplateFilePath = "classpath:com/bs/plugins/system/template/view/";
	/**视图文件存放目录**/
	public static String viewFilePath = "WebContent/WEB-INF/view/";
	/**视图文件存放目录**/
	public static String viewFilePathMaven = "webapp/WEB-INF/view/";
	/**类过滤属性**/
	public static String filterAttributes [] = {"serialVersionUID"};
	/**模板编码**/
	public static String ENCODING = "utf-8";
	/**基类目录**/
	public static String BASE = "base";
	/**类前缀**/
	public static String BASE_CLASS_PREFIX = "Base";
	public static String DAO_CLASS_PREFIX = "Dao";
	public static String SERVICE_CLASS_PREFIX = "Service";
	public static String CONTROLLER_CLASS_PREFIX = "Controller";
	/**java文件后缀**/
	public static String JAVA = ".java";
	/**jsp文件后缀**/
	public static String JSP = ".jsp";
	/**ftl文件后缀**/
	public static String FTL = ".ftl";
	/**xml文件后缀**/
	public static String XML = ".xml";
	/**properties文件后缀**/
	public static String PROPERTIES = ".properties";
	/**entity存放目录**/
	public static String ENTITY = "entity";
	/**model存放目录**/
	public static String MODEL = "model";
	/**dao存放目录**/
	public static String DAO = "dao";
	/**service存放目录**/
	public static String SERVICE = "service";
	/**controller存放目录**/
	public static String CONTROLLER = "controller";
	/**mybatis存放目录**/
	public static String MYBATIS = "mybatis";
	/**message存放目录**/
	public static String MESSAGE = "message";
	/**message存放目录**/
	public static String MESSAGE_LOCAL = "Messages_zh_CN";
	
	public BaseCreaterService(){
	}
	
	
	/**
	 * 判断文件是否有修改
	 * @param fileAbsolutePath
	 * @return
	 */
	public boolean fileIsModify(String fileAbsolutePath){
		File file = new File(fileAbsolutePath);
		boolean isModify = false;
		if (file.exists()){
			//当前文件的最后一次修改时间
			long currentLastModifyTime = file.lastModified();
			String fileName = file.getName();
			String tmpFilePath = file.getParent() 
					+ File.separator 
					+ "tmp";
			File filePath = new File(tmpFilePath);
			//判断文件目录是否存在
			if (!filePath.exists()){
				filePath.mkdirs();
			}
			String tmpFilePathName = tmpFilePath
					+ File.separator 
					+ fileName+"_"+currentLastModifyTime
					+ ".tmp";
			File tmpFile = new File(tmpFilePathName);
			//判断文件是否存在，若干不存在生成新的临时文件
			if (!tmpFile.exists()){
				try {
					tmpFile.createNewFile();
					isModify = true;
					//删除历史临时文件，可能存在也可能不存在
					File fileList[] = filePath.listFiles();
					if (fileList != null){
						for(File fileTemp:fileList){
							String fileTempName = fileTemp.getName();
							if (fileTempName.startsWith(fileName)){
								fileTemp.delete();
								break;
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				isModify = false;
			}
		}
		return isModify;
	}
	
	/**
	 * 判断文件是否有修改
	 * @param fileAbsolutePath
	 * @param fileTmpAbsolutePath
	 * @return
	 */
	public boolean fileIsModify(String fileAbsolutePath,String fileTmpAbsolutePath,String type){
		File file = new File(fileAbsolutePath);
		boolean isModify = false;
		if (file.exists()){
			//当前文件的最后一次修改时间
			long currentLastModifyTime = file.lastModified();
			String fileName = file.getName();
			String tmpFilePath = fileTmpAbsolutePath + File.separator + type;
			File filePath = new File(tmpFilePath);
			//判断文件目录是否存在
			if (!filePath.exists()){
				filePath.mkdirs();
			}
			String tmpFilePathName = tmpFilePath
					+ File.separator 
					+ fileName+"_"+currentLastModifyTime
					+ ".tmp";
			File tmpFile = new File(tmpFilePathName);
			//判断文件是否存在，若干不存在生成新的临时文件
			if (!tmpFile.exists()){
				try {
					tmpFile.createNewFile();
					isModify = true;
					//删除历史临时文件，可能存在也可能不存在
					File fileList[] = filePath.listFiles();
					if (fileList != null){
						for(File fileTemp:fileList){
							String fileTempName = fileTemp.getName();
							if (fileTempName.startsWith(fileName)){
								fileTemp.delete();
								break;
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				isModify = false;
			}
		}
		return isModify;
	}
	
	
	/**
	 * 获取工程的绝对路径
	 * @param absolutePathTemp
	 * @return
	 */
	public String getAbsolutePath(String absolutePathTemp,String type){
		String absolutePath = null;
		int index = -1;
		if (absolutePathTemp.indexOf("build") > 0){
			//类编译在build目录下
			index = absolutePathTemp.indexOf("build");
		}
		else if (absolutePathTemp.indexOf("WebContent") > 0){
			//类编译在WEB-INF目录下
			index = absolutePathTemp.indexOf("WebContent");
		}
		else if (absolutePathTemp.indexOf("WebRoot") > 0){
			//类编译在WEB-INF目录下
			index = absolutePathTemp.indexOf("WebRoot");
		}
		else if (absolutePathTemp.indexOf("webapp") > 0){
			//类编译在WEB-INF目录下
			index = absolutePathTemp.indexOf("webapp");
		}
		else {
			return null;
		}
		int indexClasses = absolutePathTemp.indexOf("classes");
		if (index >= 0){
			String startAbsolutePath = absolutePathTemp.substring(0, index);
			String endAbsolutePath = absolutePathTemp.substring(indexClasses + 7, absolutePathTemp.length());
			absolutePath = startAbsolutePath + type + endAbsolutePath;
		}
		return absolutePath;
	}
	
	

	
	/**
	 * 视图文件存放目录
	 * @param absolutePathTemp
	 * @return
	 */
	public String getViewAbsolutePath(String absolutePathTemp,String type){
		String absolutePath = null;
		int index = -1;
		if (absolutePathTemp.indexOf("build") > 0){
			//类编译在build目录下
			index = absolutePathTemp.indexOf("build");
		}
		else if (absolutePathTemp.indexOf("WebContent") > 0){
			//类编译在WEB-INF目录下
			index = absolutePathTemp.indexOf("WebContent");
		}
		else if (absolutePathTemp.indexOf("WebRoot") > 0){
			//类编译在WEB-INF目录下
			index = absolutePathTemp.indexOf("WebRoot");
		}
		else if (absolutePathTemp.indexOf("webapp") > 0){
			//类编译在WEB-INF目录下
			index = absolutePathTemp.indexOf("webapp");
		}
		else {
			return null;
		}
		String startAbsolutePath = absolutePathTemp.substring(0, index);
		if (type.equals("maven")){
			absolutePath  = startAbsolutePath + viewFilePathMaven;
		}
		else{
			absolutePath  = startAbsolutePath + viewFilePath;
		}
		return absolutePath;
	}
	
}