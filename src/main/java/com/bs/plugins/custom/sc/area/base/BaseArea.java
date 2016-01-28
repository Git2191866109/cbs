package com.bs.plugins.custom.sc.area.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.school.entity.School;	
import com.bs.plugins.custom.sc.residentincomes.entity.ResidentIncomes;	
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;	
import java.util.ArrayList;

public class BaseArea extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**地区代码-**/
	private String code;
	/**父主键ID-**/
	private String parentCode;
	/**地区名称-**/
	private String name;
	/**级别-**/
	private Integer treeLevel;
	/**地区上下级关系-**/
	private String relationPath;
	/**地区拼写-用于确定分表表名称**/
	private String spelling;
	/**地区类型-1：国家 2：省份 3：城市 4：区县**/
	private Integer type;
	/**连连支付地区编码-**/
	private String payAreaCode;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**学校信息存储表**/
	private ArrayList<School> schools;
	/**居民收入信息存储表**/
	private ArrayList<ResidentIncomes> residentIncomess;
	/**预算项数据信息存储表**/
	private ArrayList<BudgetItemData> budgetItemDatas;

	public BaseArea() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}
	public String getRelationPath() {
		return relationPath;
	}

	public void setRelationPath(String relationPath) {
		this.relationPath = relationPath;
	}
	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public String getPayAreaCode() {
		return payAreaCode;
	}

	public void setPayAreaCode(String payAreaCode) {
		this.payAreaCode = payAreaCode;
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
	
	public ArrayList<School> getSchool () {
		return schools;
	}

	public void setSchool(ArrayList<School> schools) {
		this.schools = schools;
	}	
	public ArrayList<ResidentIncomes> getResidentIncomes () {
		return residentIncomess;
	}

	public void setResidentIncomes(ArrayList<ResidentIncomes> residentIncomess) {
		this.residentIncomess = residentIncomess;
	}	
	public ArrayList<BudgetItemData> getBudgetItemData () {
		return budgetItemDatas;
	}

	public void setBudgetItemData(ArrayList<BudgetItemData> budgetItemDatas) {
		this.budgetItemDatas = budgetItemDatas;
	}	
}
