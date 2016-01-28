package com.bs.plugins.custom.aa.assetcategory.entity;

import com.bs.plugins.custom.aa.assetcategory.base.BaseAssetCategory;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class AssetCategory extends BaseAssetCategory {

	private static final long serialVersionUID = 1L;

	/**资产分类编码-1：对冲型基金 2：股票型基金 3：股权类基金 4：短期理财 5：固收理财**/
	@Max(value = 10)
	@NotNull
	private Integer code;
	/**名称-**/
	@NotNull
	private String name;
	/**类型-**/
	@NotNull
	private Integer type;
	/**收益率-**/
	@Digits(integer = 2,fraction = 3)
	@NotNull
	private Double rateOfReturn;
	/**方差-**/
	@Digits(integer = 2,fraction = 4)
	@NotNull
	private Double variance;
	/**配置比例-**/
	@Digits(integer = 2,fraction = 3)
	@NotNull
	private Double rate;

	//类型名称
	private String typeName;

	public AssetCategory() {
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getType() {
		return type;
	}

	@Override
	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public Double getRateOfReturn() {
		return rateOfReturn;
	}

	@Override
	public void setRateOfReturn(Double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	@Override
	public Double getVariance() {
		return variance;
	}

	@Override
	public void setVariance(Double variance) {
		this.variance = variance;
	}

	@Override
	public Double getRate() {
		return rate;
	}

	@Override
	public void setRate(Double rate) {
		this.rate = rate;
	}
}
