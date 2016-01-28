package com.bs.plugins.custom.cc.member.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bs.core.entity.ResultData;
import com.bs.core.initialize.InitializeData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.DateUtil;
import com.bs.core.utils.Encrypt;
import com.bs.core.utils.PasswordUtil;
import com.bs.plugins.custom.cc.member.base.BaseMemberService;
import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.cc.spvcorporation.dao.ISpvCorporationDao;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.uc.user.entity.User;
import com.bs.plugins.custom.uc.user.service.UserService;

@Service
public class MemberService extends BaseMemberService<Member> {
	@Autowired
	private ISpvCorporationDao spvCorporationDao;
	/**
	 * 禁用用户:软删除
	 * @param member
	 * @return
	 */
	public ResultData forbiddenMember(Member member){
		ResultData resultData = new ResultData();
		try {
			Integer result = super.getMemberDao().updateMember(member);
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(IBaseService.FAIL);
			e.printStackTrace();
		}
		return resultData;
	}
	/**
	 * 跳转到重置密码页面
	 * @param member
	 * @return
	 */
	public ResultData jumpResetpwd(Member member){
		ResultData resultData = new ResultData();
		try {
			member = super.getMemberDao().selectOneById(member);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("member", member);
		return resultData;		
	}
	/**
	 * 重置密码:此功能用于强制修改会员的密码,不管什么，重置为默认密码为123456
	 * @param member
	 * @return
	 */
	public ResultData resetpwd(Member member){
		ResultData resultData = new ResultData();
		Member existMember = null;
		try {
			if(null != member){
				existMember = super.getMemberDao().selectOneById(member);
				if(null != existMember){
					existMember.setPassword(PasswordUtil.entryptPassword("123456"));
					existMember.setModifyTime(DateUtil.dateToStringWithTime(new Date()));
					super.getMemberDao().resetpwd(existMember);
					resultData.setStatus(IBaseService.SUCCESS);
				}
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("existMember", existMember);
		return resultData;		
	}
	
	/**
	 * 统计所有会员模块
	 */
	public ResultData totalAllMembers(Member member){
		ResultData resultData = new ResultData();
		long allMembers = 0l;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			allMembers = super.getMemberDao().totalAllMembers(member);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.addObject("status", "fail");
			e.printStackTrace();
		}
		resultMap.put("allMembers", allMembers);
		resultData.setResultMap(resultMap);
		return resultData;
	}
	
	/**
	 * 统计每天新增会员模块
	public ResultData totalDailyMembers(String startTime,String endTime){
		ResultData resultData = new ResultData();
		int dailyMembers = 0;
		try {
			dailyMembers = super.getMemberDao().totalDailyMembers(startTime,endTime);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("dailyMembers", dailyMembers);
		return resultData;
	}
	*/
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData accountIndex(Member member){
		ResultData resultData = new ResultData();
		long allMembers = 0l;//所有的会员
		long dailyMembers = 0l;//当天的会员
		try {
			allMembers = super.getMemberDao().totalAllMembers(member);
			member.setStartTime(DateUtil.dateToString(new Date()));
			dailyMembers = super.getMemberDao().totalAllMembers(member);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("allMembers",allMembers);
		resultData.addObject("dailyMembers",dailyMembers);
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpDetail(Member member){
		ResultData resultData = new ResultData();
		try {
			member = super.getMemberDao().selectOneById(member);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("member", member);
		return resultData;	
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(Member member){
		ResultData resultData = new ResultData();
		try {
			member = super.getMemberDao().selectOneById(member);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("member", member);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Member member){
		ResultData resultData = new ResultData();
		try {
			//查询所有的spv信息供创建时选择
			List<SpvCorporation>  spvCorporationList = spvCorporationDao.selectAll();
			resultData.addObject("spvCorporationList", spvCorporationList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(Member member){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(Member member){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**
	 * 分页
	 */
	public ResultData paginated(Member member) {
		ResultData resultData = new ResultData();
		try {
			List<Member> feedbackList = super.getMemberDao().paginated(member);
			Long growStagesCount = super.getMemberDao().getMemberCount(member);
			if (feedbackList != null) {
				long record = growStagesCount == null ? 0 : growStagesCount;
				int pageCount = (int) Math.ceil(record/ (double) member.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", member.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", feedbackList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			} else {
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	/**
	 * 创建管理员
	 * @param user
	 * @return
	 */
	public ResultData create(Member member){
		ResultData resultData = new ResultData();
		try {
			BindingResult bindingResult = member.getBindingResult();
			if (bindingResult != null){
				String password = member.getPassword();
				if (password == null || password.equals("")){
					bindingResult.rejectValue("password", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				String confirmPassword = member.getConfirmPassword();
				if (confirmPassword == null || confirmPassword.equals("")){
					bindingResult.rejectValue("confirmPassword", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				if (!password.equals(confirmPassword)){
					bindingResult.rejectValue("confirmPassword", "Disaccord");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				//姓名
				String  name = member.getName();
				if (name == null && "".equals(name)){
					bindingResult.rejectValue("name", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
				//spv
				Long  spvId = member.getSpvId();
				if (spvId == null && "".equals(spvId)){
					bindingResult.rejectValue("spvId", "NotEmpty");
					resultData.setBindingResult(bindingResult);
					return resultData;
				}
			}
			
			//密码加密
			//账户类型
			member.setType(2);
			//是否实名
			member.setIsRealname(1);
			//是否开户
			member.setIsOpenAccount(1);
			//是否绑卡
			member.setIsBindingCard(1);
			//开户时间
			member.setOpenAccountTime(DateUtil.dateToStringWithTime());
			String password = member.getPassword();
			member.setRegisterTime(DateUtil.dateToStringWithTime());
			password = PasswordUtil.entryptPassword(password);
			member.setPassword(password);
			//根据spvId查询企业账户号商户号
			SpvCorporation spv = new SpvCorporation();
			spv.setId(member.getSpvId());
			spv = spvCorporationDao.selectOneById(spv);
			//账户号
			member.setUmpayAccountNo(spv.getUmpayAccountNo());
			//商户号
			member.setUmpayUserNo(spv.getUmpayMerchantNo());
			int returValue = super.getMemberDao().insert(member);
			if (returValue > 0){
				resultData.setStatus(SUCCESS);
			}
			else{
				resultData.setStatus(FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(FAIL);
			e.printStackTrace();
		}
		return resultData;		
	}
	
	private static Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("initializing  xuefeibang info.....");
		InitializeData initializeData = super.getInitializeData();
		Long spvId = 0L;
		if (initializeData != null){
			Map<String, List<Object>> data = initializeData.getConfigFileData();
			if (data != null){
				try{
					//-----------------学费帮机构初始化----
					List<Object> spvCorList = data.get("spvCorporation");
					if (spvCorList != null){
						for (Object obj:spvCorList){
							if (obj instanceof SpvCorporation){
								SpvCorporation spv = (SpvCorporation)obj;
								SpvCorporation spvTemp = spvCorporationDao.selectByType(spv);
								if (spvTemp == null){
									spvCorporationDao.insert(spv);
									spvId = spv.getGeneratedKey();
								}else{
									spvId = spvTemp.getId();
									spvCorporationDao.updateByType(spv);
								}
								logger.info("initializing  spvCorporation info success!");
							}
						}
					}
					//-----------------学费帮会员初始化---
					List<Object> memberList = data.get("member");
					if (memberList != null){
						for (Object obj:memberList){
							if (obj instanceof Member){
								Member member = (Member)obj;
								String password  = member.getPassword();
								Member memberTemp = super.getMemberDao().selectByAccount(member);
								if (memberTemp == null){
									member.setPassword(PasswordUtil.entryptPassword(password));
									int result = super.getMemberDao().updateByAccount(member);
									if (result <= 0 ){
										member.setSpvId(spvId);
										member.setPassword(PasswordUtil.entryptPassword(password));
										super.getMemberDao().insert(member);
									}
								}else{
									member.setPassword(PasswordUtil.entryptPassword(password));
									super.getMemberDao().updateByAccount(member);
								}
								logger.info("initializing  xuefeibang info success!");
							}
						}
					}
				}
				catch(Exception e){
					logger.info("initializing  xuefeibang info fail!");
				}
			}
		}
	}
	
}
