package com.bs.plugins.custom.sc.residentincomes.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.sc.area.entity.Area;

public class BaseResidentIncomes extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**地区代码-**/
	private String areaCode;
	/**收入金额-**/
	private String amount;
	/**是否为基础数据-1：是 0：否**/
	private Integer isBaseData;
	/**收入占比-1：大学 2：高中 3：小学 4：幼儿园**/
	private BigDecimal ratio;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**地区信息存储表**/
	private Area area;

	public BaseResidentIncomes() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Integer getIsBaseData() {
		return isBaseData;
	}

	public void setIsBaseData(Integer isBaseData) {
		this.isBaseData = isBaseData;
	}
	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
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
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public Area getArea () {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
