package com.bs.plugins.custom.cc.member.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.emailactivatevalid.entity.EmailActivateValid;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.eb.budgetbasicinfo.entity.BudgetBasicInfo;	
import com.bs.plugins.custom.cc.realnameauthenticate.entity.RealnameAuthenticate;	
import com.bs.plugins.custom.cc.loginrecord.entity.LoginRecord;	
import com.bs.plugins.custom.cc.memberchild.entity.MemberChild;	
import com.bs.plugins.custom.cc.feedback.entity.Feedback;	
import com.bs.plugins.custom.cc.accountingstatistics.entity.AccountingStatistics;	
import com.bs.plugins.custom.cc.questionanswer.entity.QuestionAnswer;	
import com.bs.plugins.custom.tc.accountingdetail.entity.AccountingDetail;	
import com.bs.plugins.custom.tc.productamountlock.entity.ProductAmountLock;	
import com.bs.plugins.custom.cc.bankcardbinding.entity.BankCardBinding;	
import com.bs.plugins.custom.cc.accounting.entity.Accounting;	
import com.bs.plugins.custom.tc.withdrawcashrecords.entity.WithdrawCashRecords;	
import com.bs.plugins.custom.tc.rechargerecords.entity.RechargeRecords;	
import com.bs.plugins.custom.cc.bankcardchangeapply.entity.BankCardChangeApply;	
import com.bs.plugins.custom.tc.appointment.entity.Appointment;	
import com.bs.plugins.custom.tc.spvproductreturnmoney.entity.SpvProductReturnMoney;	
import java.util.ArrayList;

public class BaseMember extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**会员表主键ID-**/
	private Long id;
	/**Spv主键Id-**/
	private Long spvId;
	/**邮箱验证主键Id-**/
	private Long emailRegisterValidId;
	/**会员类型-1：个人 2：企业**/
	private Integer type;
	/**会员代码-**/
	private String code;
	/**用户账号-**/
	private String account;
	/**手机号账号-**/
	private String phoneAccount;
	/**邮箱账号-**/
	private String emailAccount;
	/**登录密码-**/
	private String password;
	/**托管用户号-**/
	private String umpayUserNo;
	/**托管账户号-**/
	private String umpayAccountNo;
	/**交易密码-**/
	private String payPassword;
	/**昵称-**/
	private String nickname;
	/**头像-**/
	private String avatar;
	/**验证邮箱-**/
	private String validEmail;
	/**手机号码-**/
	private String mobilePhone;
	/**办公电话-**/
	private String officePhone;
	/**证件类型-1：身份证 2：警官证 3：护照 4：驾驶证 5：其他**/
	private Integer certificateType;
	/**证件号码-**/
	private String certificateNo;
	/**姓名-**/
	private String name;
	/**性别-1：男 2：女 3：其他**/
	private Integer male;
	/**生日-**/
	private String birthday;
	/**家庭角色-**/
	private Integer familyRole;
	/**风险厌恶系数-**/
	private Integer rrac;
	/**风险评分-**/
	private Integer riskScore;
	/**省份拼写-用于按照省份分表存储**/
	private String provinceSpell;
	/**所在省份-**/
	private Integer provinceCode;
	/**所在城市-**/
	private Integer cityCode;
	/**所在区县-**/
	private Integer countryCode;
	/**省份名称-**/
	private String provinceName;
	/**城市名称-**/
	private String cityName;
	/**区县名称-**/
	private String countryName;
	/**家庭地址-**/
	private String address;
	/**家庭收入区间-**/
	private Integer income;
	/**所属职业-**/
	private Integer job;
	/**学历-**/
	private Integer education;
	/**子女数量-**/
	private Integer childrenCount;
	/**是否签署免密协议-**/
	private Integer isFreePassword;
	/**是否邮箱认证-**/
	private Integer isEmailValid;
	/**是否实名认证-1：是 2：否**/
	private Integer isRealname;
	/**是否激活-1：是 0：否**/
	private Integer isActivate;
	/**是否开户-**/
	private Integer isOpenAccount;
	/**是否绑定银行卡-1：是 0：否**/
	private Integer isBindingCard;
	/**是否授权电子签章-**/
	private Integer isSignature;
	/**授权电子签章时间-**/
	private String signatureTime;
	/**开户时间-**/
	private String openAccountTime;
	/**注册时间-**/
	private String registerTime;
	/**修改时间-**/
	private String modifyTime;
	/**重置密码唯一序列号-**/
	private String serialNo;
	/**重置时间-**/
	private Long resetTime;
	/**个人推荐码-**/
	private String referralCode;
	/**推荐识别码-**/
	private String recommendIdcode;
	/**客户中心-会员邮箱注册验证信息存储表，如果注册时未验证邮箱，该信息不会存入到会员信息表中，若该邮箱验证通过，将此信息存储的会员信息表，完成注册。同时如果有子女教育预算报告，预算报告会员ID为此表主键ID，成功注册后修改成会员表主键ID**/
	private EmailActivateValid emailActivateValid;
	/**用户中心-SPV公司信息表**/
	private SpvCorporation spvCorporation;
	/**预算表基础信息存储表**/
	private ArrayList<BudgetBasicInfo> budgetBasicInfos;
	/**会员实名验证信息存储表**/
	private ArrayList<RealnameAuthenticate> realnameAuthenticates;
	/**会员登录记录信息存储表**/
	private ArrayList<LoginRecord> loginRecords;
	/**职业信息存储表**/
	private ArrayList<MemberChild> memberChilds;
	/**意见反馈记录表**/
	private ArrayList<Feedback> feedbacks;
	/**客户中心-会员账户统计信息存储表**/
	private ArrayList<AccountingStatistics> accountingStatisticss;
	/****/
	private ArrayList<QuestionAnswer> questionAnswers;
	/**交易中心-进出账明细信息存储表**/
	private ArrayList<AccountingDetail> accountingDetails;
	/****/
	private ArrayList<ProductAmountLock> productAmountLocks;
	/**客户中心-会员银行卡绑定信息存储表**/
	private ArrayList<BankCardBinding> bankCardBindings;
	/**客户中心-会员账户信息表**/
	private ArrayList<Accounting> accountings;
	/**交易中心-客户提现记录存储表**/
	private ArrayList<WithdrawCashRecords> withdrawCashRecordss;
	/**交易中心-客户充值记录存储表**/
	private ArrayList<RechargeRecords> rechargeRecordss;
	/**客户中心-会员银行卡更换申请信息存储表**/
	private ArrayList<BankCardChangeApply> bankCardChangeApplys;
	/**交易中心-客户预约产品数据存储表**/
	private ArrayList<Appointment> appointments;
	/**交易中心-SPV产品还款信息存储表**/
	private ArrayList<SpvProductReturnMoney> spvProductReturnMoneys;

	public BaseMember() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getSpvId() {
		return spvId;
	}

	public void setSpvId(Long spvId) {
		this.spvId = spvId;
	}
	public Long getEmailRegisterValidId() {
		return emailRegisterValidId;
	}

	public void setEmailRegisterValidId(Long emailRegisterValidId) {
		this.emailRegisterValidId = emailRegisterValidId;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public String getPhoneAccount() {
		return phoneAccount;
	}

	public void setPhoneAccount(String phoneAccount) {
		this.phoneAccount = phoneAccount;
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
	public String getUmpayUserNo() {
		return umpayUserNo;
	}

	public void setUmpayUserNo(String umpayUserNo) {
		this.umpayUserNo = umpayUserNo;
	}
	public String getUmpayAccountNo() {
		return umpayAccountNo;
	}

	public void setUmpayAccountNo(String umpayAccountNo) {
		this.umpayAccountNo = umpayAccountNo;
	}
	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(String validEmail) {
		this.validEmail = validEmail;
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
	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getFamilyRole() {
		return familyRole;
	}

	public void setFamilyRole(Integer familyRole) {
		this.familyRole = familyRole;
	}
	public Integer getRrac() {
		return rrac;
	}

	public void setRrac(Integer rrac) {
		this.rrac = rrac;
	}
	public Integer getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(Integer riskScore) {
		this.riskScore = riskScore;
	}
	public String getProvinceSpell() {
		return provinceSpell;
	}

	public void setProvinceSpell(String provinceSpell) {
		this.provinceSpell = provinceSpell;
	}
	public Integer getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}
	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}
	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}
	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}
	public Integer getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(Integer childrenCount) {
		this.childrenCount = childrenCount;
	}
	public Integer getIsFreePassword() {
		return isFreePassword;
	}

	public void setIsFreePassword(Integer isFreePassword) {
		this.isFreePassword = isFreePassword;
	}
	public Integer getIsEmailValid() {
		return isEmailValid;
	}

	public void setIsEmailValid(Integer isEmailValid) {
		this.isEmailValid = isEmailValid;
	}
	public Integer getIsRealname() {
		return isRealname;
	}

	public void setIsRealname(Integer isRealname) {
		this.isRealname = isRealname;
	}
	public Integer getIsActivate() {
		return isActivate;
	}

	public void setIsActivate(Integer isActivate) {
		this.isActivate = isActivate;
	}
	public Integer getIsOpenAccount() {
		return isOpenAccount;
	}

	public void setIsOpenAccount(Integer isOpenAccount) {
		this.isOpenAccount = isOpenAccount;
	}
	public Integer getIsBindingCard() {
		return isBindingCard;
	}

	public void setIsBindingCard(Integer isBindingCard) {
		this.isBindingCard = isBindingCard;
	}
	public Integer getIsSignature() {
		return isSignature;
	}

	public void setIsSignature(Integer isSignature) {
		this.isSignature = isSignature;
	}
	public String getSignatureTime() {
		return signatureTime;
	}

	public void setSignatureTime(String signatureTime) {
		this.signatureTime = signatureTime;
	}
	public String getOpenAccountTime() {
		return openAccountTime;
	}

	public void setOpenAccountTime(String openAccountTime) {
		this.openAccountTime = openAccountTime;
	}
	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public Long getResetTime() {
		return resetTime;
	}

	public void setResetTime(Long resetTime) {
		this.resetTime = resetTime;
	}
	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}
	public String getRecommendIdcode() {
		return recommendIdcode;
	}

	public void setRecommendIdcode(String recommendIdcode) {
		this.recommendIdcode = recommendIdcode;
	}
	
	public EmailActivateValid getEmailActivateValid () {
		return emailActivateValid;
	}

	public void setEmailActivateValid(EmailActivateValid emailActivateValid) {
		this.emailActivateValid = emailActivateValid;
	}
	public SpvCorporation getSpvCorporation () {
		return spvCorporation;
	}

	public void setSpvCorporation(SpvCorporation spvCorporation) {
		this.spvCorporation = spvCorporation;
	}
	public ArrayList<BudgetBasicInfo> getBudgetBasicInfo () {
		return budgetBasicInfos;
	}

	public void setBudgetBasicInfo(ArrayList<BudgetBasicInfo> budgetBasicInfos) {
		this.budgetBasicInfos = budgetBasicInfos;
	}	
	public ArrayList<RealnameAuthenticate> getRealnameAuthenticate () {
		return realnameAuthenticates;
	}

	public void setRealnameAuthenticate(ArrayList<RealnameAuthenticate> realnameAuthenticates) {
		this.realnameAuthenticates = realnameAuthenticates;
	}	
	public ArrayList<LoginRecord> getLoginRecord () {
		return loginRecords;
	}

	public void setLoginRecord(ArrayList<LoginRecord> loginRecords) {
		this.loginRecords = loginRecords;
	}	
	public ArrayList<MemberChild> getMemberChild () {
		return memberChilds;
	}

	public void setMemberChild(ArrayList<MemberChild> memberChilds) {
		this.memberChilds = memberChilds;
	}	
	public ArrayList<Feedback> getFeedback () {
		return feedbacks;
	}

	public void setFeedback(ArrayList<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}	
	public ArrayList<AccountingStatistics> getAccountingStatistics () {
		return accountingStatisticss;
	}

	public void setAccountingStatistics(ArrayList<AccountingStatistics> accountingStatisticss) {
		this.accountingStatisticss = accountingStatisticss;
	}	
	public ArrayList<QuestionAnswer> getQuestionAnswer () {
		return questionAnswers;
	}

	public void setQuestionAnswer(ArrayList<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}	
	public ArrayList<AccountingDetail> getAccountingDetail () {
		return accountingDetails;
	}

	public void setAccountingDetail(ArrayList<AccountingDetail> accountingDetails) {
		this.accountingDetails = accountingDetails;
	}	
	public ArrayList<ProductAmountLock> getProductAmountLock () {
		return productAmountLocks;
	}

	public void setProductAmountLock(ArrayList<ProductAmountLock> productAmountLocks) {
		this.productAmountLocks = productAmountLocks;
	}	
	public ArrayList<BankCardBinding> getBankCardBinding () {
		return bankCardBindings;
	}

	public void setBankCardBinding(ArrayList<BankCardBinding> bankCardBindings) {
		this.bankCardBindings = bankCardBindings;
	}	
	public ArrayList<Accounting> getAccounting () {
		return accountings;
	}

	public void setAccounting(ArrayList<Accounting> accountings) {
		this.accountings = accountings;
	}	
	public ArrayList<WithdrawCashRecords> getWithdrawCashRecords () {
		return withdrawCashRecordss;
	}

	public void setWithdrawCashRecords(ArrayList<WithdrawCashRecords> withdrawCashRecordss) {
		this.withdrawCashRecordss = withdrawCashRecordss;
	}	
	public ArrayList<RechargeRecords> getRechargeRecords () {
		return rechargeRecordss;
	}

	public void setRechargeRecords(ArrayList<RechargeRecords> rechargeRecordss) {
		this.rechargeRecordss = rechargeRecordss;
	}	
	public ArrayList<BankCardChangeApply> getBankCardChangeApply () {
		return bankCardChangeApplys;
	}

	public void setBankCardChangeApply(ArrayList<BankCardChangeApply> bankCardChangeApplys) {
		this.bankCardChangeApplys = bankCardChangeApplys;
	}	
	public ArrayList<Appointment> getAppointment () {
		return appointments;
	}

	public void setAppointment(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}	
	public ArrayList<SpvProductReturnMoney> getSpvProductReturnMoney () {
		return spvProductReturnMoneys;
	}

	public void setSpvProductReturnMoney(ArrayList<SpvProductReturnMoney> spvProductReturnMoneys) {
		this.spvProductReturnMoneys = spvProductReturnMoneys;
	}	
}
