package com.bs.plugins.custom.cc.emailactivatevalid.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;	
import java.util.ArrayList;

public class BaseEmailActivateValid extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**会员表主键ID-**/
	private Long id;
	/**业务代码-**/
	private String bussinessCode;
	/**邮箱账号-**/
	private String emailAccount;
	/**登录密码-**/
	private String password;
	/**验证邮箱唯一序列号-**/
	private String serialNo;
	/**昵称-**/
	private String nickname;
	/**失效时间-**/
	private Long expiredTime;
	/**注册时间-**/
	private String registerTime;
	/**用户中心-会员信息存储表**/
	private ArrayList<Member> members;

	public BaseEmailActivateValid() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getBussinessCode() {
		return bussinessCode;
	}

	public void setBussinessCode(String bussinessCode) {
		this.bussinessCode = bussinessCode;
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
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Long getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Long expiredTime) {
		this.expiredTime = expiredTime;
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
