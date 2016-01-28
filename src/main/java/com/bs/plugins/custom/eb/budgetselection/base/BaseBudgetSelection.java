package com.bs.plugins.custom.eb.budgetselection.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.budgetbasicinfo.entity.BudgetBasicInfo;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;

public class BaseBudgetSelection extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**报告主键ID-**/
	private Long basicInfoId;
	/**成长阶段ID-**/
	private Long growStagesId;
	/**投入水平-1：普通 2：中高**/
	private Integer costLevel;
	/**教育方式ID-**/
	private Long eduModelId;
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
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**是否有效-1：有效 0 ：无效 null ：未保存**/
	private Integer isValid;
	/**创建者-**/
	private Long creatorId;
	/**预算表基础信息存储表**/
	private BudgetBasicInfo budgetBasicInfo;
	/**年龄阶段信息存储表**/
	private GrowStages growStages;
	/**教育方式信息存储表**/
	private EducationMode educationMode;

	public BaseBudgetSelection() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getBasicInfoId() {
		return basicInfoId;
	}

	public void setBasicInfoId(Long basicInfoId) {
		this.basicInfoId = basicInfoId;
	}
	public Long getGrowStagesId() {
		return growStagesId;
	}

	public void setGrowStagesId(Long growStagesId) {
		this.growStagesId = growStagesId;
	}
	public Integer getCostLevel() {
		return costLevel;
	}

	public void setCostLevel(Integer costLevel) {
		this.costLevel = costLevel;
	}
	public Long getEduModelId() {
		return eduModelId;
	}

	public void setEduModelId(Long eduModelId) {
		this.eduModelId = eduModelId;
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
	
	public BudgetBasicInfo getBudgetBasicInfo () {
		return budgetBasicInfo;
	}

	public void setBudgetBasicInfo(BudgetBasicInfo budgetBasicInfo) {
		this.budgetBasicInfo = budgetBasicInfo;
	}
	public GrowStages getGrowStages () {
		return growStages;
	}

	public void setGrowStages(GrowStages growStages) {
		this.growStages = growStages;
	}
	public EducationMode getEducationMode () {
		return educationMode;
	}

	public void setEducationMode(EducationMode educationMode) {
		this.educationMode = educationMode;
	}
}
