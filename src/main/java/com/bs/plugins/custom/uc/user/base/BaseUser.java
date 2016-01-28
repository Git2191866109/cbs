package com.bs.plugins.custom.uc.user.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.uc.organization.entity.Organization;
import com.bs.plugins.custom.uc.userrolerelation.entity.UserRoleRelation;	
import java.util.ArrayList;

public class BaseUser extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**用户ID-用户随机编号：系统生成**/
	private Long id;
	/**机构代码-机构代码**/
	private String orgCode;
	/**用户登录帐号-用户登录ID：用户登录系统的标识，一般是英文字符或者数字。**/
	private String account;
	/**用户姓名-用户名称：登录系统的用户的姓名。**/
	private String name;
	/**用户类型-0.超级管理员 1.其他管理员**/
	private Integer type;
	/**用户岗位-**/
	private String position;
	/**用户密码-用户密码：用户登录系统的验证密码。**/
	private String password;
	/**用户性别-用户性别 1:男性 2:女性 3:其他**/
	private Integer gender;
	/**生日-**/
	private String birthday;
	/**头像-附件通过UUID在MongoDB中获取文件 为了支持WEB应用集群部署，防止应用之间文件不同步。文件以二进制方式保存在MongoDB中。**/
	private String head;
	/**个性签名-**/
	private String individualitySignature;
	/**用户移动电话-用户移动电话：用户移动电话号码。**/
	private String mobilePhone;
	/**用户办公电话-用户办公电话：用户办公电话号码。**/
	private String officePhone;
	/**用户邮件-用户邮件：用户的邮箱地址。**/
	private String email;
	/**用户描述-用户描述：用户一些相关的备注信息**/
	private String description;
	/**用户状态-用户状态： 1.启用 0.禁用**/
	private Integer status;
	/**用户风格-**/
	private String style;
	/**创建时间-创建时间：记录用户的创建时间。**/
	private String createTime;
	/**更新时间-**/
	private String modifyTime;
	/**数据访问角色-创建者：记录用户的创建人员的名称。**/
	private String roleIds;
	/**机构信息表**/
	private Organization organization;
	/**用户角色关系映射表**/
	private ArrayList<UserRoleRelation> userRoleRelations;

	public BaseUser() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
	public String getIndividualitySignature() {
		return individualitySignature;
	}

	public void setIndividualitySignature(String individualitySignature) {
		this.individualitySignature = individualitySignature;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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
	
	public Organization getOrganization () {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public ArrayList<UserRoleRelation> getUserRoleRelation () {
		return userRoleRelations;
	}

	public void setUserRoleRelation(ArrayList<UserRoleRelation> userRoleRelations) {
		this.userRoleRelations = userRoleRelations;
	}	
}
