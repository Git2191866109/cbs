package com.bs.plugins.custom.aa.common.util;

import com.bs.core.exception.BusinessException;
import com.bs.plugins.custom.aa.assetcategory.consts.AssetAllocationConst;
import com.bs.plugins.custom.aa.assetcategory.entity.AssetCategory;
import com.bs.plugins.custom.aa.common.bean.AssetAllocationResult;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 资产配置工具类
 * User: zhangqh6
 * Date: 2015/11/16 10:49:49
 */
public class AssetAllocationUtils {

    public static final Logger logger = Logger.getLogger(AssetAllocationUtils.class);

    private static boolean initialized = false;

    //风险测试问卷总分数
    public static  int QUESTIONNAIRE_TOTAL_SCORE = 30;
    //风险测试问卷答题数
    public static  int QUESTIONNAIRE_TOTAL_NUMBER = 6;

    //无风险&低风险利率(XX.XX%,小数点后保留两位）
    public static  double RISK_FREE_INTEREST_RATE = 0.0325d;
    //风险利率组合方差(XX.X%,小数点后保留一位）
    public static  double RISK_ASSET_VARIANCE = 0.037d;

    //风险资产
    private static List<AssetCategory> raskAssetList = new ArrayList<>();
    //无风险&低风险资产
    private static List<AssetCategory> raskFeeAssetList = new ArrayList<>();

    /**
     * 参数初始化
     * @throws Exception
     */
    private static synchronized void init() throws Exception {
        if(!initialized) {
//            //从asset-allocation.properties获取配置项
//            QUESTIONNAIRE_TOTAL_SCORE = Integer.parseInt(
//                    PropertiesUtils.getProperty("risk.preference.questionnaire.total.score"));
//            QUESTIONNAIRE_TOTAL_NUMBER = Integer.parseInt(
//                    PropertiesUtils.getProperty("risk.preference.questionnaire.total.number"));
//
//            RISK_FREE_INTEREST_RATE = Double.parseDouble(PropertiesUtils.getProperty("risk.free.interest.rate"));
//            RISK_ASSET_VARIANCE = Double.parseDouble(PropertiesUtils.getProperty("risk.asset.variance"));
//
//            //从数据库中获取所有资产分类并分组
//            BaseAssetCategoryDao<AssetCategory> baseAssetCategoryDao =
//                    (BaseAssetCategoryDao<AssetCategory>) SpringContextUtil.getBean("assetCategoryDao");
//            List<AssetCategory> assetCategories = baseAssetCategoryDao.selectAll();
//            if(assetCategories != null) {
//                for (AssetCategory assetCategory : assetCategories) {
//                    if(assetCategory.getType() == AssetAllocationConst.ASSET_CATEGORY_TYPE_1) {
//                        raskAssetList.add(assetCategory);
//                    }else {
//                        raskFeeAssetList.add(assetCategory);
//                    }
//                }
//            }

            initialized = true;

            AssetCategory ac = new AssetCategory();
            ac.setCode(AssetAllocationConst.ASSET_CATEGORY_CODE_1);
            ac.setName("对冲型基金");
            ac.setType(AssetAllocationConst.ASSET_CATEGORY_TYPE_1);
            ac.setRate(0.40d);
            ac.setRateOfReturn(0.115d);
            ac.setVariance(0.031d);
            raskAssetList.add(ac);

            ac = new AssetCategory();
            ac.setCode(AssetAllocationConst.ASSET_CATEGORY_CODE_2);
            ac.setName("股票型基金");
            ac.setType(AssetAllocationConst.ASSET_CATEGORY_TYPE_1);
            ac.setRate(0.36d);
            ac.setRateOfReturn(0.231d);
            ac.setVariance(0.101d);
            raskAssetList.add(ac);

            ac = new AssetCategory();
            ac.setCode(AssetAllocationConst.ASSET_CATEGORY_CODE_3);
            ac.setName("股权类基金");
            ac.setType(AssetAllocationConst.ASSET_CATEGORY_TYPE_1);
            ac.setRate(0.24d);
            ac.setRateOfReturn(0.171d);
            ac.setVariance(0.091d);
            raskAssetList.add(ac);

            ac = new AssetCategory();
            ac.setCode(AssetAllocationConst.ASSET_CATEGORY_CODE_4);
            ac.setName("短期理财");
            ac.setType(AssetAllocationConst.ASSET_CATEGORY_TYPE_2);
            ac.setRate(0.10d);
            ac.setRateOfReturn(0.031d);
            ac.setVariance(0.000d);
            raskFeeAssetList.add(ac);

            ac = new AssetCategory();
            ac.setCode(AssetAllocationConst.ASSET_CATEGORY_CODE_5);
            ac.setName("固收理财");
            ac.setType(AssetAllocationConst.ASSET_CATEGORY_TYPE_2);
            ac.setRate(0.90d);
            ac.setRateOfReturn(0.081d);
            ac.setVariance(0.000d);
            raskFeeAssetList.add(ac);


        }
    }


    /**
     * 通过问卷得分获取风险厌恶系数
     * @param score 答题得分
     * @return 风险厌恶系数
     * @throws Exception 参数不合法
     */
    public static int calcRRAC(int score) throws Exception {
        logger.debug("==>  score : " + score);
        //如果相关参数为空，加载参数
        if(!initialized) {
            init();
        }
        if(score < 1 || score > QUESTIONNAIRE_TOTAL_SCORE) {
            throw new BusinessException("【风险厌恶系数计算】参数不合法：score=" + score);
        }

        int result = Math.round((float)(QUESTIONNAIRE_TOTAL_SCORE - score)/(
                QUESTIONNAIRE_TOTAL_SCORE - QUESTIONNAIRE_TOTAL_NUMBER) * (10 - 2) + 2);
        logger.debug("<== result : " + result);
        return result;
    }

    /**
     * 通过风险厌恶系数获取最佳资产配置方案
     * @param rRAC 风险厌恶系数
     * @return 资产配置方案
     */
    public static AssetAllocationResult getAssetAllocationInfo(int rRAC) throws Exception {

        AssetAllocationResult result = new AssetAllocationResult();
        if(rRAC < 0) {
            throw new BusinessException("【获取资源配置方案】参数不合法：RRAC=" + rRAC);
        }

        //如果相关参数为空，加载参数
        if(!initialized) {
            init();
        }

        //风险资产组合利率
        double riskAssetCombinedRetrunRate = 0d;
        for (AssetCategory assetCategory : raskAssetList) {
            riskAssetCombinedRetrunRate += assetCategory.getRateOfReturn() * assetCategory.getRate();
        }

        //风险资产占比
//        double assetRate1 = (riskAssetCombinedRetrunRate - RISK_FREE_INTEREST_RATE)/(0.01d*rRAC*RISK_ASSET_VARIANCE);
        double assetRate = (BigDecimal.valueOf(riskAssetCombinedRetrunRate).subtract(BigDecimal.valueOf(RISK_FREE_INTEREST_RATE)))
                .divide(
                        /*BigDecimal.valueOf(0.01d).multiply*/(BigDecimal.valueOf(rRAC)).multiply(BigDecimal.valueOf(RISK_ASSET_VARIANCE))
                        , 2, RoundingMode.HALF_UP).doubleValue();

        if(assetRate > 0.50d) {
            assetRate = 0.50d;
        }
        for (AssetCategory assetCategory : raskAssetList) {
            AssetCategory tempAssetCategory = (AssetCategory) BeanUtils.cloneBean(assetCategory);
            tempAssetCategory.setRate(BigDecimal.valueOf(assetCategory.getRate()).multiply(BigDecimal.valueOf(assetRate)).doubleValue());
            result.addAssetCategory(tempAssetCategory);
        }

        Double shortTermRate = 0d;
        for (AssetCategory assetCategory : raskFeeAssetList) {
            if(assetCategory.getCode() == 4) {
                AssetCategory tempAssetCategory = (AssetCategory) BeanUtils.cloneBean(assetCategory);
                shortTermRate = tempAssetCategory.getRate();
                result.addAssetCategory(tempAssetCategory);
            }else {
                double rate = 1 - assetRate - shortTermRate;
                AssetCategory tempAssetCategory = (AssetCategory) BeanUtils.cloneBean(assetCategory);
                tempAssetCategory.setRate(rate);
                result.addAssetCategory(tempAssetCategory);
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
//        calcRRAC(2,28);
        AssetAllocationResult assetAllocationResult = getAssetAllocationInfo(8);
        System.out.println(assetAllocationResult.getRateOfReturn());
    }
}
