package com.bs.plugins.custom.pc.product.entity;

import com.bs.plugins.custom.pc.product.base.BaseProduct;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;

import java.util.ArrayList;
import java.util.Map;

public class Product extends BaseProduct {

	private static final long serialVersionUID = 1L;

	private String firstPublishTimeStartTime;
	private String firstPublishTimeEndTime;

	private Map<String, String> attrMap ;

	private String categoryCode;
	
	private String attributeCode;
	
	private Integer attributeValue;
	
	//起息日期（基础产品）
	private String interestRateData;
	
	/**产品中心-产品属性信息表**/
	private ArrayList<ProductAttributeConfig> productAttributeConfigs;

	public String getFirstPublishTimeStartTime() {
		return firstPublishTimeStartTime;
	}

	public void setFirstPublishTimeStartTime(String firstPublishTimeStartTime) {
		this.firstPublishTimeStartTime = firstPublishTimeStartTime;
	}

	public String getFirstPublishTimeEndTime() {
		return firstPublishTimeEndTime;
	}

	public void setFirstPublishTimeEndTime(String firstPublishTimeEndTime) {
		this.firstPublishTimeEndTime = firstPublishTimeEndTime;
	}

	public ArrayList<ProductAttributeConfig> getProductAttributeConfigs() {
		return productAttributeConfigs;
	}

	public void setProductAttributeConfigs(ArrayList<ProductAttributeConfig> productAttributeConfigs) {
		this.productAttributeConfigs = productAttributeConfigs;
	}

	public Product() {
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Map<String, String> getAttrMap() {
		return attrMap;
	}

	public void setAttrMap(Map<String, String> attrMap) {
		this.attrMap = attrMap;
	}

	public String getAttributeCode() {
		return attributeCode;
	}

	public void setAttrbuteCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}

	public Integer getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(Integer attributeValue) {
		this.attributeValue = attributeValue;
	}

	public String getInterestRateData() {
		return interestRateData;
	}

	public void setInterestRateData(String interestRateData) {
		this.interestRateData = interestRateData;
	}
}
