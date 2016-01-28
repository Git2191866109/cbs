package com.bs.plugins.custom.eb.budgetbasicinfo.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;
import com.bs.plugins.custom.eb.budgetselection.entity.BudgetSelection;	
import java.util.ArrayList;

public class BaseBudgetBasicInfo extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**会员主键Id-**/
	private Long memberId;
	/**教育目标-**/
	private Long eduGoalId;
	/**报告序列号-未注册时系统生成的序列号码，用于跟踪识别**/
	private String serialNumber;
	/**报告名称-**/
	private String name;
	/**投入水平-**/
	private Integer costLevel;
	/**填写时年龄-**/
	private Integer age;
	/**出生日期-**/
	private String birthday;
	/**省份拼音-确定数据存储到那个表中**/
	private String provinceSpelling;
	/**所在省份-**/
	private String provinceCode;
	/**所在省份名称-**/
	private String provinceName;
	/**所在城市-**/
	private String cityCode;
	/**所在城市名称-**/
	private String cityName;
	/**所在区县-**/
	private String countryCode;
	/**所在区县名称-**/
	private String countryName;
	/**报告头像图片-**/
	private String avatarPicture;
	/**预算总额-**/
	private BigDecimal budgetCost;
	/**资金满足率-**/
	private String financingAtisfiedRate;
	/**资金缺口/富余-**/
	private BigDecimal balance;
	/**是否欠缺-**/
	private Integer isLacking;
	/**准备金额-**/
	private BigDecimal reserves;
	/**月投入-**/
	private BigDecimal monthlyInvestment;
	/**降生年-0：明年9月1号前 1：后年9月1号前 2：大后年9月1号前**/
	private Integer birthYear;
	/**性别-0:女 1:男**/
	private Integer sex;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**是否有效-1：有效 0 ：无效 null ：未保存**/
	private Integer isValid;
	/**创建者-**/
	private Long creatorId;
	/**用户中心-会员信息存储表**/
	private Member member;
	/**教育期望信息存储表**/
	private EducationGoal educationGoal;
	/**教育预算-预算选择项**/
	private ArrayList<BudgetSelection> budgetSelections;

	public BaseBudgetBasicInfo() {
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
	public Long getEduGoalId() {
		return eduGoalId;
	}

	public void setEduGoalId(Long eduGoalId) {
		this.eduGoalId = eduGoalId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getCostLevel() {
		return costLevel;
	}

	public void setCostLevel(Integer costLevel) {
		this.costLevel = costLevel;
	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getProvinceSpelling() {
		return provinceSpelling;
	}

	public void setProvinceSpelling(String provinceSpelling) {
		this.provinceSpelling = provinceSpelling;
	}
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAvatarPicture() {
		return avatarPicture;
	}

	public void setAvatarPicture(String avatarPicture) {
		this.avatarPicture = avatarPicture;
	}
	public BigDecimal getBudgetCost() {
		return budgetCost;
	}

	public void setBudgetCost(BigDecimal budgetCost) {
		this.budgetCost = budgetCost;
	}
	public String getFinancingAtisfiedRate() {
		return financingAtisfiedRate;
	}

	public void setFinancingAtisfiedRate(String financingAtisfiedRate) {
		this.financingAtisfiedRate = financingAtisfiedRate;
	}
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getIsLacking() {
		return isLacking;
	}

	public void setIsLacking(Integer isLacking) {
		this.isLacking = isLacking;
	}
	public BigDecimal getReserves() {
		return reserves;
	}

	public void setReserves(BigDecimal reserves) {
		this.reserves = reserves;
	}
	public BigDecimal getMonthlyInvestment() {
		return monthlyInvestment;
	}

	public void setMonthlyInvestment(BigDecimal monthlyInvestment) {
		this.monthlyInvestment = monthlyInvestment;
	}
	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	public EducationGoal getEducationGoal () {
		return educationGoal;
	}

	public void setEducationGoal(EducationGoal educationGoal) {
		this.educationGoal = educationGoal;
	}
	public ArrayList<BudgetSelection> getBudgetSelection () {
		return budgetSelections;
	}

	public void setBudgetSelection(ArrayList<BudgetSelection> budgetSelections) {
		this.budgetSelections = budgetSelections;
	}	
}
