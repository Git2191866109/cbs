package com.bs.plugins.custom.cc.emailregistervalid.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;	
import java.util.ArrayList;

public class BaseEmailRegisterValid extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**会员表主键ID-**/
	private Long id;
	/**邮箱账号-**/
	private String emailAccount;
	/**登录密码-**/
	private String password;
	/**昵称-**/
	private String nickname;
	/**验证邮箱-**/
	private String validEmail;
	/**注册时间-**/
	private String registerTime;
	/**用户中心-会员信息存储表**/
	private ArrayList<Member> members;

	public BaseEmailRegisterValid() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getEmailAccount() {
		return emailAccount;
	}

	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(String validEmail) {
		this.validEmail = validEmail;
	}
	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	
	public ArrayList<Member> getMember () {
		return members;
	}

	public void setMember(ArrayList<Member> members) {
		this.members = members;
	}	
}
