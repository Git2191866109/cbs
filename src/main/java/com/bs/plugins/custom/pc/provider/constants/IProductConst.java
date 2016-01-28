package com.bs.plugins.custom.pc.provider.constants;

/**
 * User: zhangqh6
 * Date: 2015/12/14 13:46:46
 */
public interface IProductConst {


    /**
     *预期收益率
     */
	public static final String ATTR_CODE_EXPECTED_YIDLD_RATE = "expectedYieldRate";
    
	
	/**
	 * 实际收益率
	 */
	public static final String ATTR_CODE_CASH_YIDLD_RATE = "cashYieldRate";
    
    /**
     * 预计止息日期
     */
    public static final String ATTR_CODE_EXPECTED_STOPINTEREST_DATE = "expectedStopInterestDate";
    
    /**
     * 实际止息日期
     */
    public static final String ATTR_CODE_CASH_STOPINTEREST_DATE = "cashStopInterestDate";
    
    /**
     * 第N个工作日
     */
    public static final String ATTR_CODE_CASHDELAY_DAYS = "cashDelayDays";
    
    public static final String ATTR_CODE_START_YIELDDELAY_DAYS = "startYieldDelayDays";
    /**
     * 是否是新手产品
     */
    public static final String ATTR_CODE_ISNEWBEEPRODUCT = "IsNewbeeProduct";
    //属性值
    public static final int ATTR_VALUE_ISNEWBEEPRODUCT_1 = 1;
    
    //延迟起息天数
    public static final String ATTR_CODE_STARTYIELDDELAY_DAYS = "startYieldDelayDays";

    /**
     * 销售截止日期
     */
    public static final String ABORT_SELL_DATE = "abortSellDate";


}
