package com.bs.plugins.custom.pc.product.dao;

import java.util.List;

import com.bs.plugins.custom.pc.product.base.BaseProductDao;
import com.bs.plugins.custom.pc.product.entity.Product;

public interface IProductDao extends BaseProductDao<Product>{
    /**
     * 查询单条记录
     * @param sqlid
     * @param t
     * @return list
     */
    public List<Product> selectNewPaginatedList(Product entity) throws Exception;

    /**
     * 计算满足条件条数
     * @param sqlid
     * @param t
     */
    public Long getNewPaginatedCount(Product entity) throws Exception;
    
    
    /**
     * 查询新手产品和普通产品可选择状态列表
     * @author 鹏
     * @return
     * @throws Exception
     */
    public List<Product> getNewOrSallingProductList(Product entity)throws Exception;

    /**
     * 查询新手产品和普通产品可选择状态列表
     * @author 鹏
     * @return
     * @throws Exception
     */
    public List<Product> getProductList(Product entity)throws Exception;


    /**
     * 验证是否是新手产品
     * @param entity
     * @return
     * @throws Exception
     */
    public Long validNewProduct(Product entity)throws Exception;
    
    /**
     * 获取基础产品的起息日期和产品表信息通过产品id
     * @param entity
     * @return
     * @throws Exception
     */
    public List<Product> selectBasicProductByProductId(Product entity)throws Exception;
    
    /**
     * 获取不同状态的产品或者回购类产品
     * @param entity  status
     * @return
     * @throws Exception
     */
    public List<Product> selectProductByCategory(Product entity)throws Exception;
    
}
