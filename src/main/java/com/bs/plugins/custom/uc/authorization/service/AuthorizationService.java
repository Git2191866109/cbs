package com.bs.plugins.custom.uc.authorization.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.bs.core.common.Constant;
import com.bs.core.entity.AuthMapping;
import com.bs.core.entity.ResultData;
import com.bs.core.resource.MultipleReloadablePluginConfigXml;
import com.bs.plugins.custom.uc.authorization.base.BaseAuthorizationService;
import com.bs.plugins.custom.uc.authorization.entity.Authorization;
import com.bs.plugins.custom.uc.roleauthrelation.dao.IRoleAuthRelationDao;
import com.bs.plugins.custom.uc.roleauthrelation.entity.RoleAuthRelation;

@Service
public class AuthorizationService extends BaseAuthorizationService<Authorization> {
	public static Logger logger = Logger.getLogger(AuthorizationService.class);
	@Autowired
	private  MultipleReloadablePluginConfigXml pluginConfig;
	
	private ResourcePatternResolver  resolver = new PathMatchingResourcePatternResolver();
	@Autowired
	private IRoleAuthRelationDao iRoleAuthRelationDao;
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData authorizationIndex(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Authorization authorization){
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
	public ResultData jumpList(Authorization authorization){
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
	public ResultData jumpPaginated(Authorization authorization){
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
	 * 根据用户登录账号获取权限信息
	 * @param account
	 * @return
	 */
	public List<Authorization> getAuthsByRoleIds(Authorization authorization){
		List<Authorization> listAuthorizations = super.getAuthorizationDao().selectAuthsByRoleIds(authorization);
		return listAuthorizations;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {

		String pluginNameArr[] = pluginConfig.getPluginNames();
		String  pdmFilePath = null;
		for (String path:pluginNameArr){
			if (path != null){
				try{
					//spring 解析工具进行文件查找
					Resource resources = resolver.getResource(path);
					if (resources != null){
						//读取文件绝对路径
						pdmFilePath = resources.getFile().getAbsolutePath();
						File parentFile = resources.getFile().getParentFile();
						//临时文件目录
						String parentPath = parentFile.getPath()
								+ File.separator
								+ "tmp";
						//若临时文件目录不存在，则创建目录
						File tmpFilePath = new File(parentPath);
						if (!tmpFilePath.exists()){
							tmpFilePath.mkdirs();
						}
						//插件文件名称
						String pluginFileName = resources.getFile().getName();
						//替换后的临时文件前缀
						String tmpFileName = pluginFileName.replaceAll(".xml","");
						tmpFileName = tmpFileName
									+ "_"
									+ resources.getFile().lastModified()
									+ ".tmp";
						//临时文件名称
						String pluginFile = parentPath
								+ File.separator
								+ tmpFileName;
						File tmpFile = new File(pluginFile);
						//判断临时文件是否存在
						if (!tmpFile.exists()){
							//若不存在则创建或代表文件已经被修改
							//被修改的文件要进行重新加载
							tmpFile.createNewFile();
							logger.debug("开始解析名称为["+path +"]的文件,并解析内容入库.");
							this.parserXml(pdmFilePath);
							File files[] = tmpFilePath.listFiles();
							if (files != null){
								for(File fileTemp:files){
									String fileTempName = fileTemp.getName();
									int index = fileTempName.indexOf(pluginFileName);
									if (index >= 0 && !fileTempName.equals(tmpFileName)){
										fileTemp.delete();
									}
								}
							}
						}
					}
				}
				catch(Exception e){
					logger.debug("开始解析名称为["+path +"]的文件为找到或解析失败.");
					System.exit(0);
				}
			}
		}
		logger.debug("开始初始化权限视图名称信息……");
		//设置初始化数据
		Map<String,Object> authMap = super.getInitializeData().getDatabaseData();
		Map<String,AuthMapping> map = new HashMap<String,AuthMapping>();
		List<Authorization> listAll = super.getAuthorizationDao().selectAll();
		if (listAll != null){
			for (Authorization authorization:listAll){
				String code = authorization.getCode();
				String path = authorization.getViewName();
				AuthMapping auth = new AuthMapping();
				String tempPath = path.replaceAll("/", "_");
				auth.setKey(tempPath);
				auth.setCode(code);
				auth.setViewName(path);
				map.put(code, auth);
			}
			authMap.put(Constant.AUTH_MAPPING, map);
		}
		logger.debug("权限视图名称信息初始化完成！");
	}
	
	/**
	 * dom4j 解析xml 文件
	 * 
	 * @param fileName
	 * @throws Exception
	 */
	public void parserXml(String pfile) throws Exception {
		try {
			SAXReader saxReader = new SAXReader();
			// 把文件读入到文档
			Document document = saxReader.read(pfile);
			// 获取文档根节点
			Element node = document.getRootElement();
			// 递归计数器
			int index = 1;
			//树形结构描述关系
			String relationPath = ",0,";
			if (node != null){
				String nodeName = node.getName();
				// 系统权限信息
				Authorization authorization = new Authorization();
				//代码
				String code = this.getNodeAttrValue(node, "code");
				if (code != null){
					authorization.setCode(code);
				}
				//中文名称
				String name = this.getNodeAttrValue(node, "name");
				if (name != null){
					authorization.setName(name);
				}
				//权限类型 开发可见权限，上线可见权限
				String type = this.getNodeAttrValue(node, "auth-type");
				if (type != null){
					authorization.setAuthType(Integer.parseInt(type));
				}
				else{
					authorization.setAuthType(0);
				}
				//菜单类型 目前分top和shortcut两类
				String menuType = this.getNodeAttrValue(node, "menu-type");
				if (menuType != null){
					authorization.setMenuType(menuType);
				}
				//设置调用方法名称（service层方法）
				String methodName = this.getNodeAttrValue(node, "method-name");
				if (methodName != null && !methodName.equals("")){
					authorization.setMethodName(methodName);
				}
				else{
					authorization.setMethodName(nodeName);
				}
				//设置调用方法名称（service层方法）
				String modelFileName = this.getNodeAttrValue(node, "model-file-name");
				if (modelFileName != null){
					authorization.setModelFileName(modelFileName);
				}
				//设置模型名称（表名称）
				String modelName = this.getNodeAttrValue(node, "model-name");
				if (modelName != null){
					authorization.setModelName(modelName);
					//解析对应实体bean名称
					int idx = modelName.indexOf("_");
					if (idx > -1){
						String modelNameSuffix = modelName.substring(idx + 1, modelName.length());
						String firstChar = modelNameSuffix.substring(0, 1);
						String lastChar = modelNameSuffix.substring(1, modelNameSuffix.length());
						String entityName = firstChar + lastChar;
						authorization.setEntityName(entityName);
					}
				}
				//设置模型名称,开发者自定义模板（一旦设置此值，系统不在调用默认的模板）
				String templateName = this.getNodeAttrValue(node, "template-name");
				if (templateName != null){
					authorization.setTemplateName(templateName);
				}
				authorization.setParentCode("0");
				//树形结构描述关系
				authorization.setRelationPath(relationPath);
				// 设置级别
				authorization.setTreeLevel(index);
				authorization.setViewName(nodeName);
				if (node.elementIterator().hasNext()) {
					authorization.setIsChildNode("0") ;
				}else {
					authorization.setIsChildNode("1") ;
				}
				try{
					Authorization authorizationTemp = super.getAuthorizationDao().selectOneByCode(authorization);
					if (authorizationTemp != null){
						authorization.setId(authorizationTemp.getId());
						super.getAuthorizationDao().updateById(authorization);
					}else{
						super.getAuthorizationDao().insert(authorization);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				this.recursionParser(nodeName,nodeName,code,name,code,relationPath, ++index, node);
			}
		} catch (DocumentException e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 递归方式解析
	 * 
	 * @param ele
	 */
	@SuppressWarnings({ "unchecked"})
	private int recursionParser(String parentController, String parentNodeName, String parentCode,String parentName, String parentOrder, String codeRelation, int index, Element ele) {
		int childCount = 0 ;
		for (Iterator<Element> iterator = ele.elementIterator(); iterator.hasNext();) {
			Element node = iterator.next();
			String nodeName = node.getName();
			String tempParentNodeName = null;
			String tempController = null;
			String tempOrderBy = null;
			if (parentNodeName == null || "".equals(parentNodeName)) {
				tempParentNodeName = nodeName;
			} else {
				if (index > 3){
					tempParentNodeName = parentNodeName + "_" + nodeName;
				}
				else{
					tempParentNodeName = parentNodeName + "/" + nodeName;
				}
			}
			// 系统权限信息
			Authorization authorization = new Authorization();
			authorization.setParentCode(parentCode);
			authorization.setParentName(parentName);
			authorization.setViewName(tempParentNodeName);
			//设置权限代码
			String code = this.getNodeAttrValue(node, "code");
			if (code != null){
				authorization.setCode(code);
			}
			//中文名称
			String name = this.getNodeAttrValue(node, "name");
			if (name != null){
				authorization.setName(name);
			}
			//权限类型 开发可见权限，上线可见权限
			String type = this.getNodeAttrValue(node, "auth-type");
			if (type != null){
				authorization.setAuthType(Integer.parseInt(type));
			}
			else{
				authorization.setAuthType(0);
			}
			//菜单类型 目前分top和shortcut两类
			String menuType = this.getNodeAttrValue(node, "menu-type");
			if (menuType != null){
				authorization.setMenuType(menuType);
			}
			//设置调用方法名称（service层方法）
			String methodName = this.getNodeAttrValue(node, "method-name");
			if (methodName != null && !methodName.equals("")){
				authorization.setMethodName(methodName);
			}
			else{
				authorization.setMethodName(nodeName);
			}
			//设置调用方法名称（service层方法）
			String modelFileName = this.getNodeAttrValue(node, "model-file-name");
			if (modelFileName != null){
				authorization.setModelFileName(modelFileName);
			}
			//设置模型名称（表名称）
			String modelName = this.getNodeAttrValue(node, "model-name");
			if (modelName != null){
				authorization.setModelName(modelName);
				//解析对应实体bean名称
				int idx = modelName.indexOf("_");
				if (idx > -1){
					String modelNameSuffix = modelName.substring(idx + 1, modelName.length());
					String firstChar = modelNameSuffix.substring(0, 1).toLowerCase();
					String lastChar = modelNameSuffix.substring(1, modelNameSuffix.length());
					String entityName = firstChar + lastChar;
					authorization.setEntityName(entityName);
				}
			}
			//设置模型名称,开发者自定义模板（一旦设置此值，系统不在调用默认的模板）
			String templateName = this.getNodeAttrValue(node, "template-name");
			if (templateName != null){
				authorization.setTemplateName(templateName);
			}
			//树形结构描述关系
			String tempCodeRelation = codeRelation + code + ",";
			authorization.setRelationPath(tempCodeRelation);
			// 设置级别
			authorization.setTreeLevel(index);
			if (node.elementIterator().hasNext()) {
				authorization.setIsChildNode("0") ;
			}else {
				authorization.setIsChildNode("1") ;
			}
			try {
				Authorization authorizationTemp = super.getAuthorizationDao().selectOneByCode(authorization);
				if (authorizationTemp != null){
					authorization.setId(authorizationTemp.getId());
					super.getAuthorizationDao().updateById(authorization);
				}else{
					super.getAuthorizationDao().insert(authorization);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.recursionParser(tempController, tempParentNodeName, code,name, tempOrderBy, tempCodeRelation, index + 1, node);
			childCount++ ;
		}
		return childCount ;
	}
	/**
	 * 根据属性名称获取值
	 * @param node
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String getNodeAttrValue(Element node,String name){
		String rval = null;
		if (node.attributes() != null && node.attributes().size() > 0) {
			for (Iterator subiterator = node.attributeIterator(); subiterator.hasNext();) {
				Attribute item = (Attribute) subiterator.next();
				String attrName = item.getName();
				String attrValue = item.getValue();
				if (attrName != null && attrName.equals(name)) {
					if("true".equals(attrValue.trim())){
						attrValue = "1";
					}
					else if("false".equals(attrValue.trim())){
						attrValue = "0";
					}
					rval = attrValue;
				}
			}
		}
		return rval;
	}
	
	/**
	 * 查询子权限列表
	 * @param authorization
	 * @return
	 */
	public ResultData jumpLeft(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			String parentCode = authorization.getParentCode();
			if (parentCode == null){
				authorization.setParentCode("0");
			}
			List<Authorization> subAuthList = super.getAuthorizationDao().selectSubAuthByParentCode(authorization);
			resultData.addObject("subAuthList", subAuthList);
			authorization.setTreeLevel(3);
			List<Authorization> subAuthLevelList = super.getAuthorizationDao().selectSubAuthByLevel(authorization);
			resultData.addObject("subAuthLevelList", subAuthLevelList);
			//设置视图名称为left
			resultData.setViewName(LEFT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**
	 * 查询子权限列表
	 * @param authorization
	 * @return
	 */
	public ResultData jumpTop(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			String parentCode = authorization.getParentCode();
			if (parentCode == null){
				authorization.setParentCode("0");
			}
			List<Authorization> subAuthList = super.getAuthorizationDao().selectSubAuthByParentCode(authorization);
			resultData.addObject("subAuthList", subAuthList);
			//设置视图名称为left
			resultData.setViewName(TOP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**
	 * 跳入绑定权限页面
	 * @param authorization
	 * @return
	 */
	public ResultData bindingauthority(Authorization authorization){
		ResultData resultData = new ResultData();
		try {
			if(null!=authorization){
			//查询所有的功能以树形展示
			List<Authorization> authorizationList = super.getAuthorizationDao().selectAll();
			RoleAuthRelation roleAuthRelation = new RoleAuthRelation();
			roleAuthRelation.setRoleId(authorization.getId());
			//查询角色已经拥有的权限
			List<Authorization> authorizationArray=super.getAuthorizationDao().selectAuthorizationRoleList(authorization);
			//遍历所有权限
			List<Map<String, Object>>  authorizationListMap=new ArrayList<Map<String,Object>>();
			for(Authorization authority:authorizationList){
				Map<String, Object> authorityMap = new HashMap<String,  Object>();
				//遍历所有用户拥有的权限	
				for(Authorization relation:authorizationArray){
					if(relation.getCode().equals(authority.getCode())){
						//是否选过
						authorityMap.put("checked", true);
					}
				}
				//id
				authorityMap.put("id", authority.getCode());
				//id
				authorityMap.put("code", authority.getId());
				//pid
				authorityMap.put("pId", authority.getParentCode());
				//name
				authorityMap.put("name", authority.getName());
				//isparent
				if("0".equals(authority.getIsChildNode())){
					authorityMap.put("open", true);
				}else{
					authorityMap.put("open", false);
				}
				authorizationListMap.add(authorityMap);
			}
			String json = JSONArray.toJSONString(authorizationListMap).toString();
			resultData.addObject("node", json);
			resultData.addObject("roleId",authorization.getId());
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;		
	}
}
