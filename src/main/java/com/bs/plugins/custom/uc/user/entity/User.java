package com.bs.plugins.custom.uc.user.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.uc.user.base.BaseUser;

public class User extends BaseUser {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String orgCode;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9_]{1,20}")
	private String account;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z\\u4e00-\\u9fa5]{1,20}")
	private String name;
	
	private String confirmPassword;
	
	private String oldPassword;
	
	private String newPassword;

	private String disable;//是否禁用(供展示用)
	
	private String userType;
	
	public User() {
	}
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
