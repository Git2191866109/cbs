package com.bs.plugins.system.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.bs.plugins.system.entity.Pdm;
import com.bs.plugins.system.entity.Reference;
import com.bs.plugins.system.entity.Table;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;



public class CreaterClassService  extends BaseCreaterService{
	
	static Logger logger = Logger.getLogger(CreaterClassService.class);
	
	private ResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
	
	public CreaterClassService(){
	}
	
	
	/**
	 * 生成开发类
	 * @param pdm
	 */
	public void createTemplate(Pdm pdm,String projectType){
		logger.debug("开始进行系统开发文件生成...");
		String ptype = "src";
		if (projectType != null && projectType.equals("maven")){
			ptype = "java";
		}
		ArrayList<Table> tables = pdm.getTables();
		for (Table table:tables){
			//开发文件存放目录
			String customAbsolutePath = null;
			//模板文件存放目录
			String templateAbsolutePath = null;
			Resource resourceTemplate = resolver.getResource(resourceTemplateFilePath);
			if (resourceTemplate != null){
				try {
					String absolutePathTemp = resourceTemplate.getFile().getAbsolutePath();
					//获取java类实际存放路径
					templateAbsolutePath = super.getAbsolutePath(absolutePathTemp,ptype);
					if (templateAbsolutePath == null ){
						logger.debug("获取系统开发文件存放路径错误，请重新检查.");
						System.exit(1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//类文件存放目录
			Resource resourceCustom = resolver.getResource(entityClassFilePath);
			if (resourceCustom != null){
				try {
					String absolutePathTemp = resourceCustom.getFile().getAbsolutePath();
					//获取java类实际存放路径
					customAbsolutePath = getAbsolutePath(absolutePathTemp,ptype);	
					if (customAbsolutePath == null ){
						logger.debug("获取系统开发配置文件路径错误，请重新检查.");
						System.exit(1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//表关系
			ArrayList<Reference> references = pdm.getReferences();
			//生成基类实体bean
			this.createBaseEntity(templateAbsolutePath,customAbsolutePath,table,references);
			//生成实体 sub bean
			this.createSubEntity(templateAbsolutePath,customAbsolutePath,table);
			//生成实体basedao
			this.createBaseDao(templateAbsolutePath,customAbsolutePath,table,references);
			//生成实体 sub dao
			this.createSubDao(templateAbsolutePath,customAbsolutePath,table);
			//生成实体base mybatis
			this.createBaseMybatis(templateAbsolutePath,customAbsolutePath,table,references);
			//生成实体 sub mybatis
			this.createSubMybatis(templateAbsolutePath,customAbsolutePath,table);
			//生成实体 sub service
			this.createBaseService(templateAbsolutePath,customAbsolutePath,table);
			//生成实体 sub service
			this.createSubService(templateAbsolutePath,customAbsolutePath,table);
//			//生成实体 sub service
//			this.createController(templateAbsolutePath,customAbsolutePath,table);
			//生成message文件
			this.createMessage(templateAbsolutePath,customAbsolutePath,table);
			
		}
		logger.debug("系统开发模板文件生成完成.");
	}
	
	/** 
	 * 生成BaseEntity基类
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createBaseEntity(String templateAbsolutePath,String customAbsolutePath,Table table,ArrayList<Reference> references){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的BaseEntity文件生成.");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("base-entity.ftl",ENCODING);
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ BASE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + BASE_CLASS_PREFIX + entityName + JAVA;
				File entityFileNameFile = new File(entityFileName);
				if (entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//表关系
					model.put("references", references);
					//设置table对象
					model.put("table", table);
					//设置列对象
					model.put("columns", table.getColumns());
					//设置列对象
					model.put("entityPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + BASE);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					logger.debug("生成名称为："+entityName + JAVA + " 的类文件.");
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的BaseEntity文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的BaseEntity文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成entity文件
	 * @param pdm
	 */
	private void createSubEntity(String templateAbsolutePath,String customAbsolutePath,Table table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的Entity文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ ENTITY;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + entityName + JAVA;
				File  classFile = new File(entityFileName);
				if (classFile.exists()){
					logger.debug("名称为："+entityName + JAVA + " 的子类文件已经存在，不在进行生成.");
					return ;
				}
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("entity.ftl",ENCODING);
				//输出文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//设置列对象
					model.put("entityPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + ENTITY);
					//设置列对象
					model.put("baseEntityImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + BASE + "." + BASE_CLASS_PREFIX + entityName);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					logger.debug("生成名称为："+entityName + JAVA + " 的类文件.");
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Entity文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Entity文件生成失败.");
			}
		}
	}
	
	/**
	 * 创建基类DAO
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createBaseDao(String templateAbsolutePath,String customAbsolutePath,Table table,ArrayList<Reference> references){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的BaseDao文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("base-dao.ftl",ENCODING);
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ BASE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + BASE_CLASS_PREFIX + entityName + DAO_CLASS_PREFIX + JAVA;
				File entityFileNameFile = new File(entityFileName);
				//文件存在，删除在生成
				if (entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//表关系
					model.put("references", references);
					//设置table对象
					model.put("table", table);
					//设置列对象
					model.put("columns", table.getColumns());
					//设置包路径
					model.put("daoPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + BASE);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					logger.debug("生成名称为："+entityName + JAVA + " 的类文件.");
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的BaseDao文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的BaseDao文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成dao文件
	 * @param pdm
	 */
	private void createSubDao(String templateAbsolutePath,String customAbsolutePath,Table table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的DAO文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ "dao";
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + "I" + entityName + DAO_CLASS_PREFIX + JAVA;
				File  classFile = new File(entityFileName);
				if (classFile.exists()){
					logger.debug("名称为："+entityName + JAVA + " 的子类文件已经存在，不在进行生成.");
					return ;
				}
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("dao.ftl",ENCODING);
				//输出文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//设置table对象
					model.put("table", table);
					//设置列对象
					model.put("columns", table.getColumns());
					//设置包路径
					model.put("baseDaoImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + BASE + "." + BASE_CLASS_PREFIX + entityName + DAO_CLASS_PREFIX);
					//设置包路径
					model.put("daoPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + DAO);
					//设置实体bean路径
					model.put("entityImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + ENTITY + "." + entityName);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					logger.debug("生成名称为："+entityName + JAVA + " 的类文件.");
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的DAO文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的DAO文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成基础配置文件
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createBaseMybatis(String templateAbsolutePath,String customAbsolutePath,Table table,ArrayList<Reference> references){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的BaseMybatis文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("base-sql-mapper.ftl",ENCODING);
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ BASE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + "mysql-" + BASE + "-" + entityName.toLowerCase() + "-sql-mapper.xml";
				File entityFileNameFile = new File(entityFileName);
				//文件存在，删除在生成
				if (entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//表关系
					model.put("references", references);
					//设置table对象
					model.put("table", table);
					//设置列对象
					model.put("columns", table.getColumns());
					//设置dao包路径
					model.put("daoImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + DAO + ".I" + entityName + DAO_CLASS_PREFIX);
					//设置实体bean路径
					model.put("entityImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + ENTITY + "." + entityName);
					//设置包路径
					model.put("servicePackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + SERVICE);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					logger.debug("生成名称为："+ "mysql-" + BASE + "-" + entityName.toLowerCase() + "-sql-mapper" + XML + " 的Mybatis文件.");
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Mybatis文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Mybatis文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成mybatis配置文件
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createSubMybatis(String templateAbsolutePath,String customAbsolutePath,Table table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的Mybatis文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ MYBATIS;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + "mysql-" + entityName.toLowerCase() + "-sql-mapper.xml";
				File  classFile = new File(entityFileName);
				if (classFile.exists()){
					logger.debug("名称为："+entityName + JAVA + " 的子类文件已经存在，不在进行生成.");
					return ;
				}
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("sql-mapper.ftl",ENCODING);
				//生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//设置dao包路径
					model.put("daoImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + DAO + "." + "I" + entityName + DAO_CLASS_PREFIX);
					//设置实体bean路径
					model.put("entityImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + ENTITY + "." + entityName);
					//设置包路径
					model.put("servicePackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + SERVICE);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					logger.debug("生成名称为："+ "mysql-" + BASE + "-" + entityName.toLowerCase() + "-sql-mapper" + XML + " 的Mybatis文件.");
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Mybatis文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Mybatis文件生成失败.");
			}
		}
	}
	
	/**  
	 * 生成基类service
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createBaseService(String templateAbsolutePath,String customAbsolutePath,Table table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的BaseService文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("base-service.ftl",ENCODING);
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ BASE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + BASE_CLASS_PREFIX + entityName + SERVICE_CLASS_PREFIX + JAVA;
				File entityFileNameFile = new File(entityFileName);
				//文件存在，删除在生成
				if (entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//设置table对象
					model.put("table", table);
					//设置列对象
					model.put("columns", table.getColumns());
					//设置dao包路径
					model.put("daoImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + DAO + "." + "I" + entityName + DAO_CLASS_PREFIX);
					//设置实体bean路径
					model.put("entityImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + ENTITY + "." + entityName);
					//设置包路径
					model.put("baseServicePackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + BASE);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Service文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Service文件生成失败.");
			}
		}
	}
	/**
	 * 生成service文件
	 * @param pdm
	 */
	private void createSubService(String templateAbsolutePath,String customAbsolutePath,Table table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的Service文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ SERVICE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + entityName + SERVICE_CLASS_PREFIX + JAVA;
				File  classFile = new File(entityFileName);
				if (classFile.exists()){
					logger.debug("名称为："+entityName + JAVA + " 的子类文件已经存在，不在进行生成.");
					return ;
				}
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("service.ftl",ENCODING);
				//生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//设置dao包路径
					model.put("daoImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + DAO + "." + "I" + entityName + DAO_CLASS_PREFIX);
					//设置dao包路径
					model.put("baseServiceImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + BASE + "." + BASE_CLASS_PREFIX + entityName + SERVICE_CLASS_PREFIX);
					//设置实体bean路径
					model.put("entityImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + ENTITY + "." + entityName);
					//设置包路径
					model.put("servicePackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + SERVICE);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Service文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Service文件生成失败.");
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void createController(String templateAbsolutePath,String customAbsolutePath,Table table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表的Service文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ CONTROLLER;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + entityName + CONTROLLER_CLASS_PREFIX + JAVA;
				File  classFile = new File(entityFileName);
				if (classFile.exists()){
					logger.debug("名称为："+entityName + JAVA + " 的子类文件已经存在，不在进行生成.");
					return ;
				}
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("controller.ftl",ENCODING);
				//生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//设置dao包路径
					model.put("daoImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + DAO + "." + "I" + entityName + DAO_CLASS_PREFIX);
					//设置dao包路径
					model.put("serviceImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + SERVICE + "." + entityName + SERVICE_CLASS_PREFIX);
					//设置实体bean路径
					model.put("entityImportPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + ENTITY + "." + entityName);
					//设置包路径
					model.put("controllerPackage", subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + CONTROLLER);
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Service文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Service文件生成失败.");
			}
		}
	}
	 
	/**
	 * 生成消息文件
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createMessage(String templateAbsolutePath,String customAbsolutePath,Table table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行" + tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = customAbsolutePath 
						+ File.separator 
						+ subsEntityPath.toLowerCase() 
						+ File.separator 
						+ entityName.toLowerCase()
						+ File.separator 
						+ MESSAGE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				//收字母小写
				String  firstChar = entityName.substring(0,1).toLowerCase();
				String entityNameTemp = firstChar + entityName.substring(1,entityName.length());
				String entityFileName = entityPath + File.separator + entityNameTemp + MESSAGE_LOCAL + PROPERTIES;
				File  classFile = new File(entityFileName);
				if (classFile.exists()){
					logger.debug("名称为：" + entityNameTemp + MESSAGE_LOCAL + PROPERTIES + " 的" + MESSAGE_LOCAL + "文件已经存在，不在进行生成.");
					return ;
				}
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(daoTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("messages.ftl",ENCODING);
				//生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), ENCODING)); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					//设置列对象
					model.put("columns", table.getColumns());
					//实体名称
					model.put("entity", entityName);
					//生成文件
					template.process(model, out);
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成失败.");
			}
		}
	}
	
	
}