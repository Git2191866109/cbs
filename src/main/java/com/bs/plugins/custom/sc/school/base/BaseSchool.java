package com.bs.plugins.custom.sc.school.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.area.entity.Area;

public class BaseSchool extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**地区代码-**/
	private String areaCode;
	/**学校代码-**/
	private String code;
	/**学校名称-**/
	private String name;
	/**学校类型-1：公立 2：私立 3：国外**/
	private Integer type;
	/**学校等级-1：大学 2：高中 3：初中 4：小学 5：幼儿园**/
	private Integer level;
	/**学校地址-**/
	private String address;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**地区信息存储表**/
	private Area area;

	public BaseSchool() {
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
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
