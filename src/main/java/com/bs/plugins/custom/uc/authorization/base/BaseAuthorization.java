package com.bs.plugins.custom.uc.authorization.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.uc.roleauthrelation.entity.RoleAuthRelation;	
import java.util.ArrayList;

public class BaseAuthorization extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**权限ID-**/
	private Long id;
	/**权限代码-**/
	private String code;
	/**父权限代码-父权限代码，编码也为数字，格式同上（code）。**/
	private String parentCode;
	/**父权限名称-父权限名称**/
	private String parentName;
	/**树形结构权限级别-此权限是否有效。1：有效 0：无效**/
	private Integer treeLevel;
	/**树形结构描述关系-树形结构描述关系**/
	private String relationPath;
	/**权限名称-权限名称，用2-6个汉字进行规整描述，以方便在页面显示。**/
	private String name;
	/**模型名称-**/
	private String modelName;
	/**实体bean名称-**/
	private String entityName;
	/**方法名称-**/
	private String methodName;
	/**视图类型-**/
	private String viewType;
	/**视图名称-视图名称**/
	private String viewName;
	/**页面模板名称-只有二级功能指定有效**/
	private String templateName;
	/**模型文件名称-**/
	private String modelFileName;
	/**菜单类型-**/
	private String menuType;
	/**是否子节点-0：否 1：是**/
	private String isChildNode;
	/**使用图标路径-功能使用图片**/
	private String iconPath;
	/**权限类型-1：开发可见 0：上线可见**/
	private Integer authType;
	/**权限描述-权限描述**/
	private String description;
	/**文件创建时间-创建时间：角色的创建时间，为以后进行跟踪查询。**/
	private String createTime;
	/**用户角色关系映射表**/
	private ArrayList<RoleAuthRelation> roleAuthRelations;

	public BaseAuthorization() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}
	public String getRelationPath() {
		return relationPath;
	}

	public void setRelationPath(String relationPath) {
		this.relationPath = relationPath;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getModelFileName() {
		return modelFileName;
	}

	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}
	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getIsChildNode() {
		return isChildNode;
	}

	public void setIsChildNode(String isChildNode) {
		this.isChildNode = isChildNode;
	}
	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	public Integer getAuthType() {
		return authType;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public ArrayList<RoleAuthRelation> getRoleAuthRelation () {
		return roleAuthRelations;
	}

	public void setRoleAuthRelation(ArrayList<RoleAuthRelation> roleAuthRelations) {
		this.roleAuthRelations = roleAuthRelations;
	}	
}
