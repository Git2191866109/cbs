package com.bs.plugins.custom.aa.assetcategory.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.product.entity.Product;	
import java.util.ArrayList;

public class BaseAssetCategory extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-**/
	private Long id;
	/**资产分类编码-1：对冲型基金 2：股票型基金 3：股权类基金 4：短期理财 5：固收理财**/
	private Integer code;
	/**名称-**/
	private String name;
	/**类型-**/
	private Integer type;
	/**收益率-**/
	private Double rateOfReturn;
	/**方差-**/
	private Double variance;
	/**配置比例-**/
	private Double rate;
	/**描述-**/
	private String description;
	/**创建时间-**/
	private String createTime;
	/**修改时间-**/
	private String modifyTime;
	/**产品管理-产品信息存储表**/
	private ArrayList<Product> products;

	public BaseAssetCategory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
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
	public Double getRateOfReturn() {
		return rateOfReturn;
	}

	public void setRateOfReturn(Double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}
	public Double getVariance() {
		return variance;
	}

	public void setVariance(Double variance) {
		this.variance = variance;
	}
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public ArrayList<Product> getProduct () {
		return products;
	}

	public void setProduct(ArrayList<Product> products) {
		this.products = products;
	}	
}
