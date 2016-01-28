package com.bs.plugins.custom.eb.budgetitem.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;	
import java.util.ArrayList;

public class BaseBudgetItem extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**预算分类主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long budgetCategoryId;
	/**上级主键ID-**/
	private Long parentId;
	/**级别-**/
	private Integer itemLevel;
	/**是否是子节点-**/
	private Integer isChildNode;
	/**开支项名称-**/
	private String name;
	/**开支项代码-**/
	private String code;
	/**年级-**/
	private String grade;
	/**年龄-**/
	private Integer age;
	/**费用计算公式-**/
	private String costFormula;
	/**是否计算通胀-**/
	private Integer isInflation;
	/**是否按地区换算-0：不换算 1：换算**/
	private Integer isTranslation;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**投入水平-**/
	private Integer inputLevel;
	/**是否区分投入水平-**/
	private Integer isDifferInputLevel;
	/**预算分类信息存储表**/
	private BudgetCategory budgetCategory;
	/**教育方式与预算项目关系信息存储表**/
	private ArrayList<ModeItemRelation> modeItemRelations;

	public BaseBudgetItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getBudgetCategoryId() {
		return budgetCategoryId;
	}

	public void setBudgetCategoryId(Long budgetCategoryId) {
		this.budgetCategoryId = budgetCategoryId;
	}
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(Integer itemLevel) {
		this.itemLevel = itemLevel;
	}
	public Integer getIsChildNode() {
		return isChildNode;
	}

	public void setIsChildNode(Integer isChildNode) {
		this.isChildNode = isChildNode;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCostFormula() {
		return costFormula;
	}

	public void setCostFormula(String costFormula) {
		this.costFormula = costFormula;
	}
	public Integer getIsInflation() {
		return isInflation;
	}

	public void setIsInflation(Integer isInflation) {
		this.isInflation = isInflation;
	}
	public Integer getIsTranslation() {
		return isTranslation;
	}

	public void setIsTranslation(Integer isTranslation) {
		this.isTranslation = isTranslation;
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
	public Integer getInputLevel() {
		return inputLevel;
	}

	public void setInputLevel(Integer inputLevel) {
		this.inputLevel = inputLevel;
	}
	public Integer getIsDifferInputLevel() {
		return isDifferInputLevel;
	}

	public void setIsDifferInputLevel(Integer isDifferInputLevel) {
		this.isDifferInputLevel = isDifferInputLevel;
	}
	
	public BudgetCategory getBudgetCategory () {
		return budgetCategory;
	}

	public void setBudgetCategory(BudgetCategory budgetCategory) {
		this.budgetCategory = budgetCategory;
	}
	public ArrayList<ModeItemRelation> getModeItemRelation () {
		return modeItemRelations;
	}

	public void setModeItemRelation(ArrayList<ModeItemRelation> modeItemRelations) {
		this.modeItemRelations = modeItemRelations;
	}	
}
