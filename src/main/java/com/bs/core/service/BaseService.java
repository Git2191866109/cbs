package com.bs.core.service;

import com.bs.core.dao.RedisDao;
import com.bs.core.utils.DateUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.initialize.InitializeData;

import java.util.Calendar;
import java.util.Date;


public abstract class BaseService<T extends Entity> implements InitializingBean{
	
	/**系统处理状态只有两种成功和失败，且对应success和fail两个视图**/
	public static String SUCCESS= "success";
	public static String FAIL= "fail";
	public static String VIEW_SUCCESS= "success";
	public static String VIEW_FAIL= "fail";
	
	@Autowired
	private InitializeData initializeData;

	@Autowired
	private RedisDao redisDao;

	public InitializeData getInitializeData() {
		return initializeData;
	}

	public void setInitializeData(InitializeData initializeData) {
		this.initializeData = initializeData;
	}


	/**
	 * 生成交易单号
	 * @return
	 */
	public String getTransactionNumber(String prefix){
		//获取昨天的交易单号key，并删除redis存储记录
		String yesterdayKey = DateUtil.dateIncrease(new Date(), DateUtil.DATE_PATTERN_yyMMdd, Calendar.DATE, -1);
		redisDao.delete(yesterdayKey);
		//获取当天的交易单号key
		String todayKey = DateUtil.dateToString(new Date(),DateUtil.DATE_PATTERN_yyMMdd);
		String newTradingNumberNumber = null;
		String tradeNumber = redisDao.getString(prefix + todayKey);
		if(tradeNumber == null || tradeNumber.equals("")){
			newTradingNumberNumber = todayKey +  String.format("%05d", 1);
		}else{
			Long tnumber = 0L;
			try{
				tnumber = Long.parseLong(tradeNumber);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			//加1
			tnumber += 1;
			newTradingNumberNumber = tnumber.toString();
		}
		redisDao.update(prefix + todayKey, newTradingNumberNumber);

		return prefix + newTradingNumberNumber;
	}

	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public abstract ResultData save(T entity);
	
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public abstract ResultData modify(T entity);
	
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public abstract ResultData modifyById(T entity);
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public abstract ResultData delete(T entity);
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public abstract ResultData deleteById(T entity);
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public abstract ResultData deleteAll();
	
	/**
	 * 查询单条数据
	 * @param entity
	 * @return
	*/
	public abstract ResultData single(T entity);
	
	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public abstract ResultData list(T entity);
	
	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public abstract ResultData paginated(T entity);
}
 