package com.bs.plugins.custom.cc.member.dao;

import java.util.List;

import com.bs.plugins.custom.cc.member.base.BaseMemberDao;
import com.bs.plugins.custom.cc.member.entity.Member;

public interface IMemberDao extends BaseMemberDao<Member> {
	/**
	 * 根据开始时间和结束时间查询用户数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public Long totalAllMembers(Member member);

	/**
	 * 分页查询
	 * 
	 * @param member
	 * @return
	 */
	public List<Member> paginated(Member member);

	/**
	 * 更新
	 * @param member
	 * @return
	 */
	public Integer updateMember(Member member);

	/**
	 * 根据用户是否激活查询
	 * @param member
	 * @return
	 */
	Long getMemberCount(Member member);

	/**
	 * 重置密码
	 * @param member
	 * @return
	 */
	public Integer resetpwd (Member member);
	
	public Member selectByAccount(Member member);
	
	public Integer updateByAccount(Member member);
}
