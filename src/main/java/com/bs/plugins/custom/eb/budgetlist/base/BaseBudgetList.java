package com.bs.plugins.custom.eb.budgetlist.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;


public class BaseBudgetList extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**预算基础信息主键Id-**/
	private Long basicInfoId;
	/**客户表主键Id-**/
	private Long memberId;
	/**预算分类主键Id-**/
	private Long categoryId;
	/**预算项主键Id-**/
	private Long itemId;
	/**预算项数据主键Id-**/
	private Long itemDataId;
	/**成长阶段主键Id-**/
	private Long growStagesId;
	/**教育方式主键Id-**/
	private Long eduModeId;
	/**报告序列号-未注册时系统生成的序列号码，用于跟踪识别**/
	private String serialNumber;
	/**省份-**/
	private String provinceCode;
	/**省份名称-**/
	private String provinceName;
	/**城市-**/
	private String cityCode;
	/**城市名称-**/
	private String cityName;
	/**区县-**/
	private String countryCode;
	/**区县名称-**/
	private String countryName;
	/**是否自定义-**/
	private Integer isCustom;
	/**是否有效-**/
	private Integer isValid;
	/**创建者-**/
	private Long creatorId;
	/**小项低档金额总计-**/
	private BigDecimal lowAmountTotal;
	/**小项高档金额总计-**/
	private BigDecimal highAmountTotal;
	/**普通金额合计-**/
	private BigDecimal lowAmount;
	/**高档金额合计-**/
	private BigDecimal highAmount;
	/**系统每年次数-**/
	private Integer systemYearCount;
	/**每年次数-**/
	private Double yearCount;
	/**年数-**/
	private Integer years;
	/**支出年级-**/
	private Integer paymentGrade;
	/**是否分档-1：是 0：否**/
	private Integer isGrading;
	/**档次类型-1：普通 2：高档**/
	private Integer gradingType;
	/**付费方式-1：月 2：学期 3：年**/
	private Integer paymentMethod;
	/**支付月份-**/
	private Integer paymentMonth;
	/**是否计算通胀-**/
	private Integer isInflation;
	/**是否按地区换算-0：不换算 1：换算**/
	private Integer isAreaTranslation;
	/**备注-**/
	private String comment;
	/**数据来源-**/
	private String dataSources;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**小项通胀金额年总计-**/
	private BigDecimal inflationAmountTotal;
	/**当前普通金额-**/
	private BigDecimal currentAmount;
	/**当前普通金额总计-**/
	private BigDecimal currentAmountTotal;
	/**教育机构-**/
	private String trainingAgencyName;
	/**每次最大费用-**/
	private BigDecimal maxAmount;
	/**年次数最大值-**/
	private Integer maxYearCount;

	public BaseBudgetList() {
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
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getItemDataId() {
		return itemDataId;
	}

	public void setItemDataId(Long itemDataId) {
		this.itemDataId = itemDataId;
	}
	public Long getGrowStagesId() {
		return growStagesId;
	}

	public void setGrowStagesId(Long growStagesId) {
		this.growStagesId = growStagesId;
	}
	public Long getEduModeId() {
		return eduModeId;
	}

	public void setEduModeId(Long eduModeId) {
		this.eduModeId = eduModeId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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
	public Integer getIsCustom() {
		return isCustom;
	}

	public void setIsCustom(Integer isCustom) {
		this.isCustom = isCustom;
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
	public BigDecimal getLowAmountTotal() {
		return lowAmountTotal;
	}

	public void setLowAmountTotal(BigDecimal lowAmountTotal) {
		this.lowAmountTotal = lowAmountTotal;
	}
	public BigDecimal getHighAmountTotal() {
		return highAmountTotal;
	}

	public void setHighAmountTotal(BigDecimal highAmountTotal) {
		this.highAmountTotal = highAmountTotal;
	}
	public BigDecimal getLowAmount() {
		return lowAmount;
	}

	public void setLowAmount(BigDecimal lowAmount) {
		this.lowAmount = lowAmount;
	}
	public BigDecimal getHighAmount() {
		return highAmount;
	}

	public void setHighAmount(BigDecimal highAmount) {
		this.highAmount = highAmount;
	}
	public Integer getSystemYearCount() {
		return systemYearCount;
	}

	public void setSystemYearCount(Integer systemYearCount) {
		this.systemYearCount = systemYearCount;
	}
	public Double getYearCount() {
		return yearCount;
	}

	public void setYearCount(Double yearCount) {
		this.yearCount = yearCount;
	}
	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getPaymentGrade() {
		return paymentGrade;
	}

	public void setPaymentGrade(Integer paymentGrade) {
		this.paymentGrade = paymentGrade;
	}
	public Integer getIsGrading() {
		return isGrading;
	}

	public void setIsGrading(Integer isGrading) {
		this.isGrading = isGrading;
	}
	public Integer getGradingType() {
		return gradingType;
	}

	public void setGradingType(Integer gradingType) {
		this.gradingType = gradingType;
	}
	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Integer getPaymentMonth() {
		return paymentMonth;
	}

	public void setPaymentMonth(Integer paymentMonth) {
		this.paymentMonth = paymentMonth;
	}
	public Integer getIsInflation() {
		return isInflation;
	}

	public void setIsInflation(Integer isInflation) {
		this.isInflation = isInflation;
	}
	public Integer getIsAreaTranslation() {
		return isAreaTranslation;
	}

	public void setIsAreaTranslation(Integer isAreaTranslation) {
		this.isAreaTranslation = isAreaTranslation;
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDataSources() {
		return dataSources;
	}

	public void setDataSources(String dataSources) {
		this.dataSources = dataSources;
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
	public BigDecimal getInflationAmountTotal() {
		return inflationAmountTotal;
	}

	public void setInflationAmountTotal(BigDecimal inflationAmountTotal) {
		this.inflationAmountTotal = inflationAmountTotal;
	}
	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}
	public BigDecimal getCurrentAmountTotal() {
		return currentAmountTotal;
	}

	public void setCurrentAmountTotal(BigDecimal currentAmountTotal) {
		this.currentAmountTotal = currentAmountTotal;
	}
	public String getTrainingAgencyName() {
		return trainingAgencyName;
	}

	public void setTrainingAgencyName(String trainingAgencyName) {
		this.trainingAgencyName = trainingAgencyName;
	}
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}
	public Integer getMaxYearCount() {
		return maxYearCount;
	}

	public void setMaxYearCount(Integer maxYearCount) {
		this.maxYearCount = maxYearCount;
	}
	
}
