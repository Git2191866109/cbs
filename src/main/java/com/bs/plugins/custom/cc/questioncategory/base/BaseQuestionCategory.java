package com.bs.plugins.custom.cc.questioncategory.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.securityquestion.entity.SecurityQuestion;	
import java.util.ArrayList;

public class BaseQuestionCategory extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**问卷类型主键id-**/
	private Long id;
	/**名称-**/
	private String name;
	/**创建人-创建人**/
	private Long creatorId;
	/**创建时间-创建时间**/
	private String createTime;
	/**修改人-修改人**/
	private Long modifierId;
	/**修改时间-修改时间**/
	private String modifyTime;
	/**删除标识-1：是 0：否**/
	private Integer isDelete;
	/**客户中心-密保问题信息存储表**/
	private ArrayList<SecurityQuestion> securityQuestions;

	public BaseQuestionCategory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getisDelete() {
		return isDelete;
	}

	public void setisDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	public ArrayList<SecurityQuestion> getSecurityQuestion () {
		return securityQuestions;
	}

	public void setSecurityQuestion(ArrayList<SecurityQuestion> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}	
}
