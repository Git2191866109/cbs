package com.bs.plugins.custom.uc.organization.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.uc.user.entity.User;	
import java.util.ArrayList;

public class BaseOrganization extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**机构ID-父机构ID：机构树状结构父节点标识**/
	private Long id;
	/**父机构ID-**/
	private Long parentId;
	/**父机构名称-**/
	private String parentName;
	/**机构类型-1：运营机构 2：SPV公司**/
	private Integer type;
	/**机构代码-机构代码**/
	private String code;
	/**机构名称-机构名称：定义记录机构的名称。**/
	private String name;
	/**机构简称-**/
	private String shortName;
	/**机构电话-机构电话：机构的联系的电话。**/
	private String phone;
	/**机构传真-机构传真：机构的传真的号码。**/
	private String fax;
	/**机构邮政编码-机构邮政编码：机构所在地区的邮政编码。**/
	private String postCode;
	/**机构地址-机构地址：机构的具体的地址。**/
	private String address;
	/**机构描述-机构描述：机构相关信息的说明或者描述。**/
	private String description;
	/**机构状态-机构状态： 0.禁用 1.启用**/
	private Integer status;
	/**树形结构机构级别-**/
	private Integer treeLevel;
	/**树形结构描述关系-**/
	private String treePath;
	/**是否为子结点-**/
	private Integer isChildNode;
	/**创建时间-创建时间：机构创建的时间，以备后来跟踪查询**/
	private String createTime;
	/**更新时间-**/
	private String modifyTime;
	/**数据访问角色-创建者：机构信息创建者名称的记录。**/
	private String roleIds;
	/**用户信息表**/
	private ArrayList<User> users;

	public BaseOrganization() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}
	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public Integer getIsChildNode() {
		return isChildNode;
	}

	public void setIsChildNode(Integer isChildNode) {
		this.isChildNode = isChildNode;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
	public ArrayList<User> getUser () {
		return users;
	}

	public void setUser(ArrayList<User> users) {
		this.users = users;
	}	
}
