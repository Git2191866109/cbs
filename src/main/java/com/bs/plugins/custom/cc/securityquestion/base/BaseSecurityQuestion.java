package com.bs.plugins.custom.cc.securityquestion.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.questioncategory.entity.QuestionCategory;

public class BaseSecurityQuestion extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**密保问题标题id-**/
	private Long id;
	/**密保问题类型Id-**/
	private Long questionCategoryId;
	/**名称-**/
	private String name;
	/**是否有效-**/
	private Integer status;
	/**创建时间-**/
	private String createDate;
	/****/
	private QuestionCategory questionCategory;

	public BaseSecurityQuestion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionCategoryId() {
		return questionCategoryId;
	}

	public void setQuestionCategoryId(Long questionCategoryId) {
		this.questionCategoryId = questionCategoryId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public QuestionCategory getQuestionCategory () {
		return questionCategory;
	}

	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}
}
