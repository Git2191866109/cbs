package com.bs.plugins.custom.pc.provider;

import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;

/**
 * User: zhangqh6
 * Date: 2015/12/10 11:26:26
 */
public interface ProductProxyService {


    public Product getProductInfoByProductId(Long productId);

    public Product getProductInfoByProductCode(Long productCode);

    public ProductAttributeConfig getProductAttributeInfo(Long productId,String attrCode);

}
