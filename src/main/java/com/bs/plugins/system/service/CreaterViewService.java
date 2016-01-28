package com.bs.plugins.system.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.bs.plugins.system.entity.Config;
import com.bs.plugins.system.entity.FieldAttribute;
import com.bs.plugins.system.entity.ViewConfig;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;



public class CreaterViewService  extends BaseCreaterService{
	
	static Logger logger = Logger.getLogger(CreaterClassService.class);

	/**插件配置存储列表**/
	private ArrayList<Config> configList = new ArrayList<Config>();
	/**Spring Resource 解析类**/
	private ResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
	
	public CreaterViewService(){
	}
	
	/**
	 * 生成视图文件
	 * @param 
	 */
	public void createViewConfigFile(String projectType){
		logger.debug("开始进行系统视图文件的生成...");
		String ptype = "src";
		if (projectType != null && projectType.equals("maven")){
			ptype = "java";
		}
		//模板或配置文件存放目录
		String templateAbsolutePath = null;
		try {
			Resource pluginConfigs [] = resolver.getResources(pluginConfigFilePath);
			if (pluginConfigs != null){
				for (Resource pluginConfig:pluginConfigs){
					if (pluginConfig != null){
						String absolutePathTemp = pluginConfig.getFile().getAbsolutePath();
						templateAbsolutePath = getAbsolutePath(absolutePathTemp,ptype);
						SAXReader saxReader = new SAXReader();
						try {
							Document document = saxReader.read(templateAbsolutePath);
							// 获取文档根节点
							Element elementNode = document.getRootElement();
							if (elementNode != null){
								//清楚list
								configList.clear();
								logger.debug("开始进行名称为：" + pluginConfig.getFile().getName() + "系统功能配置文件的解析.");
								this.recursionParser(1, elementNode,elementNode.getName(),templateAbsolutePath,pluginConfig.getFile().getName());
								logger.debug("名称为：" + pluginConfig.getFile().getName() + "系统功能配置文件的解析完成.");
								//功能配置模板存放路径
								String pluginConfigTemplatePath = null;
								Resource resourceTemplate = resolver.getResource(resourceTemplateFilePath);
								if (resourceTemplate != null){
									String absolutePath = resourceTemplate.getFile().getAbsolutePath();
									pluginConfigTemplatePath = getAbsolutePath(absolutePath,ptype);
								} 
								//功能配置文件生成路径
//								String pluginConfigStorePath = null;
//								Resource resourceStore = resolver.getResource(viewConfigFilePath);
//								if (resourceStore != null){
//									String absolutePath = resourceStore.getFile().getAbsolutePath();
//									pluginConfigStorePath = getAbsolutePath(absolutePath,ptype);
//								}
								//功能配置文件生成路径
								String viewPageTemplatePath = null;
								String viewPageFilePath = null;
								Resource resourceView = resolver.getResource(viewTemplateFilePath);
								if (resourceView != null){
									String absolutePath = resourceView.getFile().getAbsolutePath();
									viewPageTemplatePath = getAbsolutePath(absolutePath,ptype);
									viewPageFilePath = getViewAbsolutePath(absolutePath,"maven");
								}
								//实体bean存放路径
								String entityClassPath = null;
								Resource resourceEntityClass = resolver.getResource(entityClassFilePath);
								if (resourceView != null){
									String absolutePath = resourceEntityClass.getFile().getAbsolutePath();
									entityClassPath = getAbsolutePath(absolutePath,ptype);
								}
								//临时文件存放目录
								String tmpFilePathTemp = null;
								Resource resourceTmp = resolver.getResource(tmpFilePath);
								if (resourceView != null){
									String absolutePath = resourceTmp.getFile().getAbsolutePath();
									tmpFilePathTemp = getAbsolutePath(absolutePath,ptype);
								}
								
								//生成功能配置文件和视图文件
								this.createPluginConfigAndJspFile(pluginConfigTemplatePath, null,viewPageTemplatePath,viewPageFilePath,entityClassPath,tmpFilePathTemp);
							}
						} catch (DocumentException e) {
							e.printStackTrace();
						}
						
					}
				}
				if (templateAbsolutePath == null ){
					logger.debug("获取系统模板文件路径错误，请重新检查.");
					System.exit(1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("系统视图文件生成完成.");
	}
	
	/**
	 * 生成功能配置文件
	 */
	public void createPluginConfigAndJspFile(String pluginConfigTemplatePath,String pluginConfigStorePath,String viewPageTemplatePath,String viewPageFilePath,String entityClassFilePath,String tmpFilePath){
		//生成功能配置文件,配置模型的节点才能生成配置文件
		for (Config config:configList){
			String modelName = config.getModelName();
			if (modelName != null && !modelName.equals("")){
				String modelNamePrefix = config.getModelNamePrefix();
				String modelNameSuffix =config.getModelNameSuffix();
				String entityClassFilePathName = entityClassFilePath 
							+ File.separator 
							+ modelNamePrefix.toLowerCase() 
							+ File.separator 
							+ modelNameSuffix.toLowerCase()
							+ File.separator
							+ ENTITY
							+ File.separator
							+ modelNameSuffix
							+ JAVA;
				boolean boo = super.fileIsModify(entityClassFilePathName,tmpFilePath,ENTITY);
				//如果实体文件被修改进行功能配置文件（xml）的生成
				if (boo){
					try{
						ArrayList<FieldAttribute> fieldList = null; 
						logger.debug("开始进行名称为：com.bs.plugins.custom." + modelNamePrefix.toLowerCase() + "." + modelNameSuffix.toLowerCase() + "." + ENTITY + "." + modelNameSuffix + " 的实体类反射解析.");
						//查找类对象
						Class<?> cls = Class.forName("com.bs.plugins.custom." + modelNamePrefix.toLowerCase() + "." + modelNameSuffix.toLowerCase() + "." + ENTITY + "." + modelNameSuffix);
						Field fields [] = cls.getDeclaredFields();
						if (fields.length > 0){
							fieldList = new ArrayList<FieldAttribute>();
						}
						for (Field field:fields){
							String fieldName = field.getName();
							boolean isExist = false;
							for (String filter:filterAttributes){
								if (fieldName.equals(filter)){
									isExist = true;
									break;
								}
							}
							if (!isExist){
								FieldAttribute fieldAttribute = new FieldAttribute();
								String typeName = field.getType().getName();
								//判断是否为引用类
								if (typeName != null && typeName.indexOf("com.bs.plugins.custom") > -1){
									String simpleName = field.getType().getSimpleName();
									//首字母小写转换
									String firstChar = simpleName.substring(0,1).toLowerCase();
									String lastChars = simpleName.substring(1,simpleName.length());
									fieldAttribute.setName(firstChar + lastChars + "." + fieldName);
								}
								else{
									fieldAttribute.setName(fieldName);
								}
								fieldAttribute.setName(fieldName);
								fieldAttribute.setType(field.getType());
								fieldList.add(fieldAttribute);
								//logger.debug("类字段名称为：" + fieldName + "  字段类型为：" +field.getType());
							}
						}
						Field parentFields [] = cls.getSuperclass().getDeclaredFields();
						if (fields.length > 0 && fieldList == null){
							fieldList = new ArrayList<FieldAttribute>();
						}
						int idx = 0;
						for (Field field:parentFields){
							String fieldName = field.getName();
							boolean isExist = false;
							for (String filter:filterAttributes){
								if (fieldName.equals(filter)){
									isExist = true;
									break;
								}
							}
							boolean fieldIsExist = false;
							if (!isExist){
								for (Field subField:fields){
									String subFieldName = subField.getName();
									if (fieldName.equals(subFieldName)){
										fieldIsExist = true;
										break;
									}
								}
							}
							System.out.println("fieldName===>"+(++idx)+"===="+fieldName);
							if (!fieldIsExist){
								FieldAttribute fieldAttribute = new FieldAttribute();
								String typeName = field.getType().getName();
								//判断是否为引用类
								if (typeName != null && typeName.indexOf("com.bs.plugins.custom") > -1){
									String simpleName = field.getType().getSimpleName();
									//首字母小写转换
									String firstChar = simpleName.substring(0,1).toLowerCase();
									String lastChars = simpleName.substring(1,simpleName.length());
									fieldAttribute.setName(firstChar + lastChars + "." + fieldName);
								}
								else{
									fieldAttribute.setName(fieldName);
								}
								fieldAttribute.setName(fieldName);
								fieldAttribute.setType(field.getType());
								fieldList.add(fieldAttribute);
							}
						} 
						logger.debug("名称为：com.bs.plugins.custom." + modelNamePrefix.toLowerCase() + "." + modelNameSuffix.toLowerCase() + "." + ENTITY + "." + modelNameSuffix + " 的实体类反射解析完成.");
						
						logger.debug("开始进行" + config.getPluginConfigFileName() + " 配置文件的 " + config.getNodeName() + " 功能的JSP视图的生成.");
						//生成jsp文件 viewPageFilePath  viewPageTemplatePath
						String viewType = config.getViewType();
						if (viewType == null || viewType.equals("")){
							viewType = "form";
						}
						//类型为空 不生成jsp文件
						if (viewType != null && !viewType.equals("")){
							try {
								//ftl文件名称
								String ftlFileName = config.getViewName() +  FTL;
								File ftlFile = new File(ftlFileName);
								//freemarker 配置对象
								Configuration configuration = new Configuration();
								//模板文件名称
								String useFtlName = viewType + FTL;
								//加载模板文件
								if (ftlFile.exists()){
									useFtlName = ftlFileName;
									logger.debug("开始进行自定义模板[" + ftlFileName + "] 功能的JSP视图的文件的生成.");
									//自定义模板文件目录
									File file = new File(viewPageFilePath);
									configuration.setDirectoryForTemplateLoading(file);
								}
								else{
									logger.debug("开始进行系统默认模板[" + useFtlName + "]JSP视图的文件的生成.");
									//模板文件目录
									File file = new File(viewPageTemplatePath);
									configuration.setDirectoryForTemplateLoading(file);
								}
								
								//设置包装对象
								configuration.setObjectWrapper(new DefaultObjectWrapper());
								//加载模板文件
								Template template = null;
								try {
									template = configuration.getTemplate(useFtlName,ENCODING);
								}
								catch(Exception e){
									continue;
								}
								//jsp文件名称
								String jspFileName = config.getViewName();
								int index = jspFileName.lastIndexOf("/");
								String jspFileNameTemp = null;
								if (index >= 0){
									jspFileNameTemp = jspFileName.substring(0,index);
								}
								else{
									jspFileNameTemp = jspFileName;
								}
								File jspFile = new File(viewPageFilePath + jspFileNameTemp);
								if (!jspFile.exists()){
									jspFile.mkdirs();
								}
								String jspFilePathName = viewPageFilePath + jspFileName+  JSP;
								File jspTempFile = new File(jspFilePathName);
								//文件存在不在生成
								if (jspTempFile.exists()){
									continue;
								}
								System.out.println("jspFilePathName:"+jspFilePathName);
								Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jspFilePathName), "UTF-8")); 
								try { 
									//上文数据存储对象
									Map<String, Object> model = new HashMap<String, Object>();
									ArrayList<ViewConfig> fileds = new ArrayList<ViewConfig>();
									int i=0;
									for (FieldAttribute fieldAttribute :fieldList){
										System.out.println("fieldAttribute.getName()===>"+(++i)+ "-----" + fieldAttribute.getName());
										ViewConfig viewConfig = new ViewConfig();
			        					viewConfig.setName(fieldAttribute.getName());
			        					viewConfig.setShow("1");
			        					viewConfig.setAlias(fieldAttribute.getName());
			        					viewConfig.setWidth("");
			        					viewConfig.setHeight("");
			        					viewConfig.setAlign("center");
			        					viewConfig.setHidden("0");
			        					viewConfig.setSort(0);
			        					viewConfig.setSortable("0");
			        					fileds.add(viewConfig);
									}
						            //按照排序字段进行排序
						            Collections.sort(fileds,comparator); 
									//设置字段描述信息到上文
									model.put("fileds", fileds);
									//config
									model.put("config", config);
									//生成文件
									template.process(model, out);
									logger.debug("生成名称为："+ jspFileName + " 的JSP文件.");
									if (out != null){
										out.flush();  
							            out.close(); 
									}
								} catch (TemplateException e) {
									logger.debug("名称为："+ jspFileName + " 的JSP文件生成失败.");
									e.printStackTrace();
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						logger.debug(config.getPluginConfigFileName() + " 配置文件的 " + config.getNodeName() + " 功能的JSP视图的生成完成.");
//						try{
//							logger.debug("开始进行名称为：" + modelName.toLowerCase() + XML + " 的视图配置文件的生成.");
//							//声明写XML的对象
//							XMLWriter writer = null;
//							SAXReader reader = new SAXReader();
//							OutputFormat format = OutputFormat.createPrettyPrint();
//				            format.setEncoding(ENCODING);
//				            //转换root名称
//							String rootElementName = modelName.toLowerCase();
//				            //文件名称
//							String modelPath = pluginConfigStorePath 
//									+ File.separator 
//									+ modelName.toLowerCase() + XML;
//							File modelFile = new File(modelPath);
//							//设置模型配置文件路径
//							config.setModelPathName(modelPath);
//							rootElementName = rootElementName.replaceAll("_","//");
//							//判断文件是否存在
//							if (modelFile.exists()){
//								//读取XML文件
//								Document document = reader.read(modelFile);
//								//得到根节点
//					            Element root = document.getRootElement();
//					            for (FieldAttribute fieldAttribute :fieldList){
//					            	//判断该属性的list节点是否存在
//					            	Node listNode = root.selectSingleNode("//"+rootElementName+"//list//field[@name = '"+fieldAttribute.getName()+"']");
//					            	if (listNode == null){
//					            		logger.debug("名称为：" + fieldAttribute.getName() + "属性不存在创建该list子节点.");
//					            		//添加列表节点
//						                Element nodeList = root.addElement("list");
//						                //添加Field
//					                	Element nodeListField = nodeList.addElement("field");
//					                	nodeListField.addAttribute("name", fieldAttribute.getName());
//					                	nodeListField.addAttribute("alias", fieldAttribute.getName());
//					                	nodeListField.addAttribute("width","");
//					                	nodeListField.addAttribute("height","");
//					                	nodeListField.addAttribute("align","");
//					                	nodeListField.addAttribute("hidden","0");
//					                	nodeListField.addAttribute("search","0");
//					                	nodeListField.addAttribute("sort","");
//					                	nodeListField.addAttribute("sortable","0");
//					                	nodeListField.addAttribute("show", "1");
//					                	nodeListField.addAttribute("page-type", "");
//					                	nodeListField.addAttribute("initialize-value","");
//					                	nodeListField.addAttribute("model-value","");
//					            	}
//					            	//判断该属性的create节点是否存在
//					            	Node createNode = root.selectSingleNode("//"+rootElementName+"//create//field[@name = '"+fieldAttribute.getName()+"']");
//					            	if (createNode == null){
//					            		logger.debug("名称为：" + fieldAttribute.getName() + "属性不存在创建该create子节点.");
//					            		//添加列表节点
//						                Element nodeCreate = root.addElement("create");
//						                //添加Field
//					                	Element nodeCreateField = nodeCreate.addElement("field");
//					                	nodeCreateField.addAttribute("name", fieldAttribute.getName());
//					                	nodeCreateField.addAttribute("alias", fieldAttribute.getName());
//					                	nodeCreateField.addAttribute("width","");
//					                	nodeCreateField.addAttribute("height","");
//					                	nodeCreateField.addAttribute("align","");
//					                	nodeCreateField.addAttribute("hidden","0");
//					                	nodeCreateField.addAttribute("search","0");
//					                	nodeCreateField.addAttribute("sort","");
//					                	nodeCreateField.addAttribute("sortable","0");
//					                	nodeCreateField.addAttribute("show", "1");
//					                	nodeCreateField.addAttribute("page-type", "");
//					                	nodeCreateField.addAttribute("initialize-value","");
//					                	nodeCreateField.addAttribute("model-value","");
//					            	}				            	
//					            	//判断该属性的modify节点是否存在
//					            	Node modifyNode = root.selectSingleNode("//"+rootElementName+"//modify//field[@name = '"+fieldAttribute.getName()+"']");
//					            	if (modifyNode == null){
//					            		logger.debug("名称为：" + fieldAttribute.getName() + "属性不存在创建该modify子节点.");
//					            		//添加列表节点
//						                Element nodeModify = root.addElement("modify");
//						                //添加Field
//					                	Element nodeModifyField = nodeModify.addElement("field");
//					                	nodeModifyField.addAttribute("name", fieldAttribute.getName());
//					                	nodeModifyField.addAttribute("alias", fieldAttribute.getName());
//					                	nodeModifyField.addAttribute("width","");
//					                	nodeModifyField.addAttribute("height","");
//					                	nodeModifyField.addAttribute("align","");
//					                	nodeModifyField.addAttribute("hidden","0");
//					                	nodeModifyField.addAttribute("search","0");
//					                	nodeModifyField.addAttribute("sort","");
//					                	nodeModifyField.addAttribute("sortable","0");
//					                	nodeModifyField.addAttribute("show", "1");
//					                	nodeModifyField.addAttribute("page-type", "");
//					                	nodeModifyField.addAttribute("initialize-value","");
//					                	nodeModifyField.addAttribute("model-value","");
//					            	}				            	
//					            	//判断该属性的detail节点是否存在
//					            	Node detailNode = root.selectSingleNode("//"+rootElementName+"//detail//field[@name = '"+fieldAttribute.getName()+"']");
//					            	if (detailNode == null){
//					            		logger.debug("名称为：" + fieldAttribute.getName() + "属性不存在创建该detail子节点.");
//					            		//添加列表节点
//						                Element nodeDetail = root.addElement("detail");
//						                //添加Field
//					                	Element nodeDetailField = nodeDetail.addElement("field");
//					                	nodeDetailField.addAttribute("name", fieldAttribute.getName());
//					                	nodeDetailField.addAttribute("alias", fieldAttribute.getName());
//					                	nodeDetailField.addAttribute("width","");
//					                	nodeDetailField.addAttribute("height","");
//					                	nodeDetailField.addAttribute("align","");
//					                	nodeDetailField.addAttribute("hidden","0");
//					                	nodeDetailField.addAttribute("search","0");
//					                	nodeDetailField.addAttribute("sort","");
//					                	nodeDetailField.addAttribute("sortable","0");
//					                	nodeDetailField.addAttribute("show", "1");
//					                	nodeDetailField.addAttribute("page-type", "");
//					                	nodeDetailField.addAttribute("initialize-value","");
//					                	nodeDetailField.addAttribute("model-value","");
//					            	}				            	
//				                }
//					            writer = new XMLWriter(new FileWriter(modelFile), format);
//			                    writer.write(document);
//			                    if (writer != null){
//				                	writer.close();
//				                }
//							}
//							else{
//								//文件不存在
//								Document document = DocumentHelper.createDocument();
//				                Element root = document.addElement(rootElementName);
//				                //添加列表节点
//				                Element nodeList = root.addElement("list");
//				                //添加Field
//				                for (FieldAttribute fieldAttribute :fieldList){
//				                	Element nodeListField = nodeList.addElement("field");
//				                	nodeListField.addAttribute("name", fieldAttribute.getName());
//				                	nodeListField.addAttribute("alias", fieldAttribute.getName());
//				                	nodeListField.addAttribute("width","");
//				                	nodeListField.addAttribute("height","");
//				                	nodeListField.addAttribute("align","");
//				                	nodeListField.addAttribute("hidden","0");
//				                	nodeListField.addAttribute("search","0");
//				                	nodeListField.addAttribute("sort","");
//				                	nodeListField.addAttribute("sortable","0");
//				                	nodeListField.addAttribute("show", "1");
//				                	nodeListField.addAttribute("page-type", "");
//				                	nodeListField.addAttribute("initialize-value","");
//				                	nodeListField.addAttribute("model-value","");
//				                }
//				                // fieldList
//				                //添加创建节点
//				                Element nodeCreate = root.addElement("create");
//				                //添加Field
//				                for (FieldAttribute fieldAttribute :fieldList){
//				                	Element nodeCreateField = nodeCreate.addElement("field");
//				                	nodeCreateField.addAttribute("name", fieldAttribute.getName());
//				                	nodeCreateField.addAttribute("alias", fieldAttribute.getName());
//				                	nodeCreateField.addAttribute("width","");
//				                	nodeCreateField.addAttribute("height","");
//				                	nodeCreateField.addAttribute("align","");
//				                	nodeCreateField.addAttribute("hidden","0");
//				                	nodeCreateField.addAttribute("search","0");
//				                	nodeCreateField.addAttribute("sort","");
//				                	nodeCreateField.addAttribute("sortable","0");
//				                	nodeCreateField.addAttribute("show", "1");
//				                	nodeCreateField.addAttribute("page-type", "");
//				                	nodeCreateField.addAttribute("initialize-value","");
//				                	nodeCreateField.addAttribute("model-value","");
//				                }
//				                //添加修改节点
//				                Element nodeModify = root.addElement("modify");
//				                //添加Field
//				                for (FieldAttribute fieldAttribute :fieldList){
//				                	Element nodeModifyField = nodeModify.addElement("field");
//				                	nodeModifyField.addAttribute("name", fieldAttribute.getName());
//				                	nodeModifyField.addAttribute("alias", fieldAttribute.getName());
//				                	nodeModifyField.addAttribute("width","");
//				                	nodeModifyField.addAttribute("height","");
//				                	nodeModifyField.addAttribute("align","");
//				                	nodeModifyField.addAttribute("hidden","0");
//				                	nodeModifyField.addAttribute("search","0");
//				                	nodeModifyField.addAttribute("sort","");
//				                	nodeModifyField.addAttribute("sortable","0");
//				                	nodeModifyField.addAttribute("show", "1");
//				                	nodeModifyField.addAttribute("page-type", "");
//				                	nodeModifyField.addAttribute("initialize-value","");
//				                	nodeModifyField.addAttribute("model-value","");
//				                }			                
//				                //添加明细节点
//				                Element nodeDetail = root.addElement("detail");
//				                //添加Field
//				                for (FieldAttribute fieldAttribute :fieldList){
//				                	Element nodeDetailField = nodeDetail.addElement("field");
//				                	nodeDetailField.addAttribute("name", fieldAttribute.getName());
//				                	nodeDetailField.addAttribute("alias", fieldAttribute.getName());
//				                	nodeDetailField.addAttribute("width","");
//				                	nodeDetailField.addAttribute("height","");
//				                	nodeDetailField.addAttribute("align","");
//				                	nodeDetailField.addAttribute("hidden","0");
//				                	nodeDetailField.addAttribute("search","0");
//				                	nodeDetailField.addAttribute("sort","");
//				                	nodeDetailField.addAttribute("sortable","0");
//				                	nodeDetailField.addAttribute("show", "1");
//				                	nodeDetailField.addAttribute("page-type", "");
//				                	nodeDetailField.addAttribute("initialize-value","");
//				                	nodeDetailField.addAttribute("model-value","");
//				                }	
//				                //生成文件
//				                writer = new XMLWriter(new FileWriter(modelFile), format);
//				                writer.write(document);
//				                if (writer != null){
//				                	writer.close();
//				                }
//							}
//							logger.debug("名称为：" + modelName.toLowerCase() + XML + "功能视图配置文件生成完成.");						
//						}
//						catch(Exception e){
//							e.printStackTrace();
//						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					//设置功能配置文件引用的配置文件
					//声明写XML的对象
//					XMLWriter writer = null;
//					SAXReader reader = new SAXReader();
//					try {
//						OutputFormat format = OutputFormat.createPrettyPrint();
//			            format.setEncoding(ENCODING);
//			            //文件名称
//						String modelPath = config.getPluginConfigAbsolutePath();
//						File modelFile = new File(modelPath);
//						//判断文件是否存在
//						if (modelFile.exists()){
//							//读取XML文件
//							Document document = reader.read(modelFile);
//							//得到根节点
//				            Element root = document.getRootElement();
//			            	//判断该属性的节点是否存在
//				            String viewName = config.getViewName();
//				            //转换root名称
//							String rootElementName = viewName.replaceAll("_","//");
//							rootElementName = viewName.replaceAll("/","//");
//							//节点名称
//							String nodeName = config.getNodeName();
//			            	Node eltNode = root.selectSingleNode("//"+rootElementName);
//			            	if (eltNode != null){
//			            		logger.debug("更新：" + modelFile.getName() + "功能配置文件的model-file-name属性值.");
//			            		Element modifyElement = (Element)eltNode;
//			            		boolean isExistAttr = false;
//			            		List<Attribute> attributeList = modifyElement.attributes();
//			            		for (Attribute attribute:attributeList){
//			            			String attrName = attribute.getName();
//			        				String attrValue = attribute.getValue();
//			        				if (attrName.equals("model-file-name")){
//			        					isExistAttr = true;
//			        					//存在修改值
//			        					attribute.setValue("model/" + modelName.toLowerCase() + ".xml");
//			        					break;
//			        				}
//			            		}
//			            		//不存在添加值
//			            		if (!isExistAttr){
//					                //添加属性
//					                modifyElement.addAttribute("model-file-name","model/" + modelName.toLowerCase() + ".xml");
//			            		}
//			            	}
//							writer = new XMLWriter(new FileWriter(modelFile), format);
//							writer.write(document);
//		                    if (writer != null){
//			                	writer.close();
//			                }
//						}
//					}catch (Exception e) {
//						e.printStackTrace();
//					}
				}
				//文件名称
//				String modelPath = pluginConfigStorePath 
//						+ File.separator 
//						+ modelName.toLowerCase() + XML;
//				boolean booModel = super.fileIsModify(modelPath,tmpFilePath,MODEL);
//				if (booModel){
//					logger.debug("开始进行" + config.getPluginConfigFileName() + " 配置文件的 " + config.getNodeName() + " 功能的JSP视图的生成.");
//					//生成jsp文件 viewPageFilePath  viewPageTemplatePath
//					String viewType = config.getViewType();
//					if (viewType == null || viewType.equals("")){
//						viewType = "form";
//					}
//					//类型为空 不生成jsp文件
//					if (viewType != null && !viewType.equals("")){
//						try {
//							//ftl文件名称
//							String ftlFileName = config.getViewName() +  FTL;
//							String ftlFilePathName = viewPageFilePath + ftlFileName;
//							File ftlFile = new File(ftlFileName);
//							//freemarker 配置对象
//							Configuration configuration = new Configuration();
//							//模板文件名称
//							String useFtlName = viewType + FTL;
//							//加载模板文件
//							if (ftlFile.exists()){
//								useFtlName = ftlFileName;
//								logger.debug("开始进行自定义模板[" + ftlFileName + "] 功能的JSP视图的文件的生成.");
//								//自定义模板文件目录
//								File file = new File(viewPageFilePath);
//								configuration.setDirectoryForTemplateLoading(file);
//							}
//							else{
//								logger.debug("开始进行系统默认模板[" + useFtlName + "]JSP视图的文件的生成.");
//								//模板文件目录
//								File file = new File(viewPageTemplatePath);
//								configuration.setDirectoryForTemplateLoading(file);
//							}
//							
//							//设置包装对象
//							configuration.setObjectWrapper(new DefaultObjectWrapper());
//							//加载模板文件
//							Template template = null;
//							try {
//								template = configuration.getTemplate(useFtlName,ENCODING);
//							}
//							catch(Exception e){
//								continue;
//							}
//							//jsp文件名称
//							String jspFileName = config.getViewName();
//							int index = jspFileName.lastIndexOf("/");
//							String jspFileNameTemp = null;
//							if (index >= 0){
//								jspFileNameTemp = jspFileName.substring(0,index);
//							}
//							else{
//								jspFileNameTemp = jspFileName;
//							}
//							File jspFile = new File(viewPageFilePath + jspFileNameTemp);
//							if (!jspFile.exists()){
//								jspFile.mkdirs();
//							}
//							String jspFilePathName = viewPageFilePath + jspFileName+  JSP;
//							File jspTempFile = new File(jspFilePathName);
							//文件存在不在生成
//							if (jspTempFile.exists()){
//								continue;
//							}
//							System.out.println("jspFilePathName:"+jspFilePathName);
//							Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jspFilePathName), "UTF-8")); 
//							try { 
//								//上文数据存储对象
//								Map<String, Object> model = new HashMap<String, Object>();
//								SAXReader reader = new SAXReader();
//								String pluginConfigStorePathName = pluginConfigStorePath
//										+ File.separator
//										+ modelName.toLowerCase()
//										+ XML;
								//读取XML文件
//								try {
//									Document document = reader.read(pluginConfigStorePathName);
//									//得到根节点
//						            Element root = document.getRootElement();
//						            ArrayList<ViewConfig> fileds = new ArrayList<ViewConfig>();
//						            for (Iterator<Element> iterator = root.elementIterator(); iterator.hasNext();) {
//						            	Element subNode = iterator.next();
//						    			String subName = subNode.getName();
//						    			if (subName != null && viewType.indexOf(subName) > -1){
//						    				for (Iterator<Element> subIterator = subNode.elementIterator(); subIterator.hasNext();) {
//						    					Element subNodeTemp = subIterator.next();	
//						    					List<Attribute> attributeList = subNodeTemp.attributes();
//						    					boolean booAttrs = false;
//						    					for (Attribute attribute:attributeList){
//						    						String attrName = attribute.getName();
//							        				String attrValue = attribute.getValue();
//							        				if (attrName != null && attrName.equals("show")){
//							        					if (attrValue != null && attrValue.equals("1")){
//							        						booAttrs = true;
//							        					}
//							        					break;
//							        				}
//						    					}
//												if (booAttrs){
//													ViewConfig viewConfig = new ViewConfig();
//								            		for (Attribute attribute:attributeList){
//								            			String attrName = attribute.getName();
//								        				String attrValue = attribute.getValue();
//								        				if (attrName != null && attrName.equals("name")){
//								        					viewConfig.setName(attrValue);
//								        				}
//								        				if (attrName != null && attrName.equals("show")){
//								        					viewConfig.setShow(attrValue);
//								        				}
//								        				if (attrName != null && attrName.equals("alias")){
//								        					viewConfig.setAlias(attrValue);
//								        				}
//								        				if (attrName != null && attrName.equals("width")){
//								        					viewConfig.setWidth(attrValue);
//								        				}
//								        				if (attrName != null && attrName.equals("height")){
//								        					viewConfig.setHeight(attrValue);
//								        				}
//								        				if (attrName != null && attrName.equals("align")){
//								        					viewConfig.setAlign(attrValue);
//								        				}
//								        				if (attrName != null && attrName.equals("hidden")){
//								        					viewConfig.setHidden(attrValue);
//								        				}
//								        				if (attrName != null && attrName.equals("sort")){
//								        					int sort = 0;
//								        					try{
//								        						sort = Integer.parseInt(attrValue);
//								        					}
//								        					catch(Exception e){}
//								        					viewConfig.setSort(sort);
//								        				}
//								        				if (attrName != null && attrName.equals("sortable")){
//								        					viewConfig.setSortable(attrName);;
//								        				}
////								        				if (attrName != null && attrName.equals("initialize-value")){
////								        					viewConfig.setInitializeValue(attrValue);
////								        				}
////								        				if (attrName != null && attrName.equals("model-value")){
////								        					viewConfig.setModelValue(attrValue);
////								        				}
//								            		}
//								            		fileds.add(viewConfig);
//												}
//						    				}
//						    			}
//						            }
//						            //按照排序字段进行排序
//						            Collections.sort(fileds,comparator); 
//									//设置字段描述信息到上文
//									model.put("fileds", fileds);
//									//config
//									model.put("config", config);
//								} catch (DocumentException e) {
//									e.printStackTrace();
//								}
								
								//生成文件
//								template.process(model, out);
//								logger.debug("生成名称为："+ jspFileName + " 的JSP文件.");
//								if (out != null){
//									out.flush();  
//						            out.close(); 
//								}
//							} catch (TemplateException e) {
//								logger.debug("名称为："+ jspFileName + " 的JSP文件生成失败.");
//								e.printStackTrace();
//							}
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
//					}
//					logger.debug(config.getPluginConfigFileName() + " 配置文件的 " + config.getNodeName() + " 功能的JSP视图的生成完成.");
//				}
			}
		}
	}
	 
	/**
	 * 列表排序
	 */
	Comparator<ViewConfig> comparator = new Comparator<ViewConfig>() {
		public int compare(ViewConfig vc1, ViewConfig vc2) {
			// 先排年龄
			if (vc1.getSort() > vc2.getSort()) {
				return 1;
			} else {
				return 0;
			}
		}
	};

	/**
	 * 读取单个节点的属性
	 * @param elementNode
	 */
	@SuppressWarnings("unchecked")
	public void readAttributes(Element elementNode,String parentNodeName,Integer nodeLevel,String templateAbsolutePath,String pluginConfigFileName){
		String parentNodeNameTemp = parentNodeName.replaceAll("/", "//");
		parentNodeNameTemp = parentNodeNameTemp.replaceAll("_", "//");
		Node node = elementNode.selectSingleNode("//" + parentNodeNameTemp + "[@model-name != '']");
		//不存在model属性不存储属性
		if (node == null){
			return ;
		}
		Config config = new Config();
		//读取属性
		if (elementNode.attributes() != null && elementNode.attributes().size() > 0) {
			for (Iterator<Attribute> subiterator = elementNode.attributeIterator(); subiterator.hasNext();) {
				Attribute item = (Attribute) subiterator.next();
				String attrName = item.getName();
				String attrValue = item.getValue();
				//值为空也不生成视图配置文件
				if (attrValue != null && !attrValue.equals("")){
					if (attrName != null && attrName.equals("model-name")) {
						int index = attrValue.indexOf("_");
						if (index >= 0){
							String entityStartPath = attrValue.substring(0,index);
							String modelNameSuffix = attrValue.substring(index+1,attrValue.length());
							config.setModelNamePrefix(entityStartPath);
							config.setModelNameSuffix(modelNameSuffix);
							config.setModelName(attrValue);
						}
						else{
							logger.debug("名称为："+pluginConfigFileName+" 系统功能配置文件 model-name 属性格式错误.");
							return ;
						}
					}
					if (attrName != null && attrName.equals("name")) {
						config.setName(attrValue);
					}
					if (attrName != null && attrName.equals("code")) {
						config.setCode(attrValue);
					}
					if (attrName != null && attrName.equals("method-name")) {
						config.setMethodName(attrValue);
					}
					if (attrName != null && attrName.equals("view-type")) {
						config.setViewType(attrValue);
					}
					if (attrName != null && attrName.equals("template-name")) {
						config.setTemplateName(attrValue);
					}
				}
			}
		}
		//设置视图名称
		config.setViewName(parentNodeName);
		//设置视图名称
		String codeKey = parentNodeName.replaceAll("/", "_");
		System.out.println("parentNodeName:"+codeKey);
		config.setCodeKey(codeKey);
		//设置级别
		config.setLevel(nodeLevel);
		//设置文件绝对路径
		config.setPluginConfigAbsolutePath(templateAbsolutePath);
		//设置节点名称
		config.setNodeName(elementNode.getName());
		//插件功能配置文件名称
		config.setPluginConfigFileName(pluginConfigFileName);
		ArrayList<Config> shortcuts = new ArrayList<Config>();
		//当前节点的下级节点
		for (Iterator<Element> iterator = elementNode.elementIterator(); iterator.hasNext();) {
			Element subNode = iterator.next();
			String subName = subNode.getName();
			//判断是否配置快捷菜单
			Node subNodeSelect = subNode.selectSingleNode("//" + parentNodeNameTemp + "//" + subName + "[@menu-type != '']");
			if (subNodeSelect != null){
				Config shortcut = new Config();
				if (subNode.attributes() != null && subNode.attributes().size() > 0) {
					for (Iterator<Attribute> subiterator = subNode.attributeIterator(); subiterator.hasNext();) {
						Attribute item = (Attribute) subiterator.next();
						String attrName = item.getName();
						String attrValue = item.getValue();
						if (attrName != null && attrName.equals("model-name")) {
							int index = attrValue.indexOf("_");
							if (index >= 0){
								String entityStartPath = attrValue.substring(0,index);
								String modelNameSuffix = attrValue.substring(index+1,attrValue.length());
								shortcut.setModelNamePrefix(entityStartPath);
								shortcut.setModelNameSuffix(modelNameSuffix);
								shortcut.setModelName(attrValue);
							}
							else{
								logger.debug("名称为："+pluginConfigFileName+" 系统功能配置文件 model-name 属性格式错误.");
								return ;
							}
						}
						if (attrName != null && attrName.equals("name")) {
							shortcut.setName(attrValue);
						}
						if (attrName != null && attrName.equals("code")) {
							shortcut.setCode(attrValue);
						}
						if (attrName != null && attrName.equals("method-name")) {
							shortcut.setMethodName(attrValue);
						}
						if (attrName != null && attrName.equals("view-type")) {
							shortcut.setViewType(attrValue);
						}
						if (attrName != null && attrName.equals("template-name")) {
							shortcut.setTemplateName(attrValue);
						}
						if (attrName != null && attrName.equals("menu-type")){
							if (!attrValue.equals("")){
								shortcut.setMenuType(attrValue);
							}
						}
					}
					if (nodeLevel >= 3){
						//设置视图名称
						shortcut.setViewName(parentNodeName + "_" + subNode.getName());
					}
					else{
						//设置视图名称
						shortcut.setViewName(parentNodeName + "/" + subNode.getName());
					}
					//设置级别
					shortcut.setLevel(nodeLevel);
					//设置文件绝对路径
					shortcut.setPluginConfigAbsolutePath(templateAbsolutePath);
					//设置节点名称
					shortcut.setNodeName(subNode.getName());
					//插件功能配置文件名称
					shortcut.setPluginConfigFileName(pluginConfigFileName);
					//添加快捷菜单到数组
					shortcuts.add(shortcut);
				}
			}
		}
		//添加子功能的快捷菜单
		config.setShortcuts(shortcuts);
		//添加配置到列表
		configList.add(config);
	}
	
	/**
	 * 递归解析xml节点
	 * @param index
	 * @param elementNode
	 * @param parentNodeNames
	 */
	@SuppressWarnings("unchecked")
	private void recursionParser(int nodeLevel, Element elementNode,String parentNodeName,String templateAbsolutePath,String pluginConfigFileName) {
		
		//读取节点属性
		this.readAttributes(elementNode,parentNodeName,nodeLevel,templateAbsolutePath,pluginConfigFileName);
		//当前节点的下级节点
		for (Iterator<Element> iterator = elementNode.elementIterator(); iterator.hasNext();) {
			Element node = iterator.next();
			String nodeName = node.getName();
			String parentNodeNameTemp = null;
			if (nodeLevel>= 3){
				parentNodeNameTemp = parentNodeName + "_" + nodeName;
			}
			else{
				parentNodeNameTemp = parentNodeName + "/" + nodeName;
			}
			this.recursionParser(nodeLevel+1,node,parentNodeNameTemp,templateAbsolutePath,pluginConfigFileName);
		}
	}
}