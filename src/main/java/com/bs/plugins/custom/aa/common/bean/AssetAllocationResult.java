package com.bs.plugins.custom.aa.common.bean;

import com.bs.core.exception.BusinessException;
import com.bs.plugins.custom.aa.assetcategory.entity.AssetCategory;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 资产配置结果对象
 * User: zhangqh6
 * Date: 2015/11/16 11:41:41
 */
public class AssetAllocationResult {

    public static final Logger logger = Logger.getLogger(AssetAllocationResult.class);


    private double rateOfReturn = 0f;

    private List<AssetCategory> list;

    /**
     * 获取组合受益率
     * @return  组合受益率
     * @throws Exception
     */
    public double getRateOfReturn() throws Exception {

        if(rateOfReturn <= 0f && list != null && list.size() > 0) {
            float totalRate = 0f;
            for (AssetCategory assetCategory : list) {
                totalRate += assetCategory.getRate();
            }
            if(totalRate != 1f) {
                logger.error("资源配置计算出错！");
                throw new BusinessException("资源配置计算出错！");
            }

            for (AssetCategory assetCategory : list) {
                rateOfReturn += assetCategory.getRate() * assetCategory.getRateOfReturn();
            }

            rateOfReturn = new BigDecimal(rateOfReturn).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

            if(logger.isDebugEnabled()) {
                for (AssetCategory assetCategory : list) {
                    logger.debug("==> name = " + assetCategory.getName() + "; rate = " + assetCategory.getRate()
                            + "; rate of return =" + assetCategory.getRateOfReturn());
                }
                logger.debug("==> combined rate of return = " + rateOfReturn);
            }
        }

        return rateOfReturn;
    }

    /**
     * 添加资源分类明细
     * @param assetCategory 资源分类明细
     */
    public void addAssetCategory(AssetCategory assetCategory) {
        if(list == null) {
            list = new ArrayList<>();
        }

        list.add(assetCategory);
    }


    public List<AssetCategory> getList() {
        return list;
    }

}
