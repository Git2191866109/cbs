package com.bs.plugins.custom.pc.productattributeconfig.dao;

import java.util.List;

import com.bs.plugins.custom.pc.productattributeconfig.base.BaseProductAttributeConfigDao;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;

public interface IProductAttributeConfigDao extends BaseProductAttributeConfigDao<ProductAttributeConfig>{
	//根据产品Id和产品属性code查询value
	public ProductAttributeConfig selectProductAttributeConfigByProductIdAndCode(ProductAttributeConfig entity)throws Exception;
	
	public List<ProductAttributeConfig> selectProductAttributeConfigInfoByProductId(ProductAttributeConfig entity)throws Exception;
}
