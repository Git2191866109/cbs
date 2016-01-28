package com.bs.plugins.custom.uc.log.base;

import com.bs.core.entity.Entity;


public class BaseLog extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**日志ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**用户ID-**/
	private Long userId;
	/**操作用户帐号-**/
	private String userAccount;
	/**操作时间-操作时间：日志记录的详细时间。**/
	private String operateTime;
	/**操作用户名称-**/
	private String userName;
	/**操作类别-1：创建操作 2：修改操作 3：删除操作 4：其他操作**/
	private String type;
	/**操作内容-操作内容：系统用户操作的具体功能步骤的记录。**/
	private String content;
	/**访问IP-访问IP：系统用户远端访问的IP地址。**/
	private String accessIP;
	/**创建时间-**/
	private String createTime;

	public BaseLog() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getAccessIP() {
		return accessIP;
	}

	public void setAccessIP(String accessIP) {
		this.accessIP = accessIP;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
