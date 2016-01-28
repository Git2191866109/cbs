package com.bs.plugins.system.entity;




public class ViewConfig extends Entity{
	
	private static final long serialVersionUID = 1L;
	/**字段名称**/
	private String name;
	/**字段别名**/
	private String alias;
	/**是否显示**/
	private String show;
	/**宽度**/
	private String width;
	/**高度**/
	private String height;
	/**居中属性**/
	private String align;
	/**是否为隐藏属性**/
	private String hidden;
	/**是否为排列字段**/
	private String sortable;
	/**排列顺序**/
	private Integer sort;
	/**是否为查询条件**/
	private String search;
	/**初始化值**/
	private String initializeValue;
	/**初模型值**/
	private String modelValue;
	
	public ViewConfig(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getSortable() {
		return sortable;
	}

	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getInitializeValue() {
		return initializeValue;
	}

	public void setInitializeValue(String initializeValue) {
		this.initializeValue = initializeValue;
	}

	public String getModelValue() {
		return modelValue;
	}

	public void setModelValue(String modelValue) {
		this.modelValue = modelValue;
	}
	
}

