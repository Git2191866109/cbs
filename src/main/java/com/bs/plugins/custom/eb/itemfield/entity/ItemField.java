package com.bs.plugins.custom.eb.itemfield.entity;

import com.bs.plugins.custom.eb.itemfield.base.BaseItemField;

public class ItemField extends BaseItemField {

	private static final long serialVersionUID = 1L;

	/**地区代码-**/
	private String areaCode;
	/**成长阶段主键Id-**/
	private Long growStagesId;
	/**教育方式主键Id-**/
	private Long eduModeId;
	/**预算分类小项主键Id-**/
	private Long itemId;
	/**字段值**/
	private Object val;
	private String provinceCode;
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public Object getVal() {
		return val;
	}
	public void setVal(Object val) {
		this.val = val;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public ItemField() {
	}
	
	
	private String ids[];
	
	public String[] getIds() {
		return ids;
	}
	public void setIds(String ids[]) {
		this.ids = ids;
	}
}
