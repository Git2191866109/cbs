package com.bs.plugins.custom.cc.questionanswer.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseQuestionAnswer extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**问卷答案id-**/
	private Long id;
	/**用户ID-**/
	private Long memberId;
	/**问题-**/
	private String question;
	/**答案-**/
	private String answer;
	/**创建时间-**/
	private String createDate;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseQuestionAnswer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
