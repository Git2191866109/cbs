package com.bs.plugins.custom.pc.provider.impl;

import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.product.service.ProductService;
import com.bs.plugins.custom.pc.productattributeconfig.dao.IProductAttributeConfigDao;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.pc.provider.ProductProxyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: zhangqh6
 * Date: 2015/12/10 11:32:32
 */
@Service("ProductProxyService")
public class ProductProxyServiceImpl implements ProductProxyService{

    @Autowired
    private ProductService productService;
    
    @Autowired
    private IProductAttributeConfigDao productAttributeConfigDao;
    
    @Override
    public Product getProductInfoByProductId(Long productId) {
        return null;
    }

    @Override
    public Product getProductInfoByProductCode(Long productCode) {
        return null;
    }

    @Override
    public ProductAttributeConfig getProductAttributeInfo(Long productId, String attrCode){
    	ProductAttributeConfig config = new ProductAttributeConfig();
    	config.setProductId(productId);
    	config.setCode(attrCode);
		try {
			config = productAttributeConfigDao.selectProductAttributeConfigByProductIdAndCode(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return config;
    }
}
