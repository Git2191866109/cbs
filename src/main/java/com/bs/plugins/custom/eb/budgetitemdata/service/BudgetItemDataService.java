package com.bs.plugins.custom.eb.budgetitemdata.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bs.core.entity.ResultData;
import com.bs.core.utils.DateUtil;
import com.bs.plugins.custom.eb.budgetitemdata.base.BaseBudgetItemDataService;
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;
import com.bs.plugins.custom.sc.area.dao.IAreaDao;
import com.bs.plugins.custom.sc.area.entity.Area;

@Service
public class BudgetItemDataService extends BaseBudgetItemDataService<BudgetItemData> {
	
	@Autowired
	IAreaDao iAreaDao;

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData budgetItemDataIndex(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(BudgetItemData budgetItemData){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	public ResultData saveItemDate(BudgetItemData budgetItemData)throws Exception{
		ResultData rs=new ResultData();
		Area a=new Area();
		a.setCode(budgetItemData.getProvinceCode());
		String Spell=iAreaDao.selectSpell(a);
		budgetItemData.setTableName("EB_BudgetItemData"+Spell);
		budgetItemData.setCreateDate(DateUtil.dateToStringWithTime());
		saveItemData(budgetItemData);
		Map<String,Object> m=new HashMap<String, Object>();
		m.put("succ", true);
		rs.setResultMap(m);
		return rs;
	}
	public ResultData getItemDate(BudgetItemData budgetItemData)throws Exception{
		ResultData rs=new ResultData();
		Area a=new Area();
		a.setCode(budgetItemData.getProvinceCode());
		String Spell=iAreaDao.selectSpell(a);
		budgetItemData.setTableName("EB_BudgetItemData"+Spell);
		List<BudgetItemData> BudgetItemDataList=super.getBudgetItemDataDao().selectListOut(budgetItemData);
		if(BudgetItemDataList.size()>0){
			
			budgetItemData =BudgetItemDataList.get(0);
			
		}
		String json=JSON.toJSONString(budgetItemData);
		Map<String,Object> m=new HashMap<String, Object>();
		m.put("data", json);
		rs.setResultMap(m);
		return rs;
	}
	public ResultData deleteItemDate(BudgetItemData budgetItemData)throws Exception{
		ResultData rs=new ResultData();
		int count =0;
		Area a=new Area();
		a.setCode(budgetItemData.getProvinceCode());
		String Spell=iAreaDao.selectSpell(a);
		budgetItemData.setTableName("EB_BudgetItemData"+Spell);
		count =super.getBudgetItemDataDao().deleteByParam(budgetItemData);
		Map<String,Object> m=new HashMap<String, Object>();
		if(count>0){
			m.put("succ", true);
		}else{
			m.put("succ", false);	
		}
		rs.setResultMap(m);
		return rs;
	}
	
	
	public ResultData updateItemDate(BudgetItemData budgetItemData)throws Exception{
		ResultData rs=new ResultData();
		int count =0;
		Area a=new Area();
		a.setCode(budgetItemData.getProvinceCode());
		String Spell=iAreaDao.selectSpell(a);
		budgetItemData.setTableName("EB_BudgetItemData"+Spell);
		count =super.getBudgetItemDataDao().deleteByParam(budgetItemData);
		budgetItemData.setUpdateDate(DateUtil.dateToStringWithTime());
		saveItemData(budgetItemData);
		Map<String,Object> m=new HashMap<String, Object>();
		if(count>0){
			m.put("succ", true);
		}else{
			m.put("succ", false);	
		}
		rs.setResultMap(m);
		return rs;
	}

	private void saveItemData(BudgetItemData budgetItemData) throws Exception {
		String [] yearList=budgetItemData.getYearsArray().split(",");
		BigDecimal lowAmount=BigDecimal.ZERO;
		BigDecimal highAmount=BigDecimal.ZERO;;
		BigDecimal lowAmountcopy=BigDecimal.ZERO;
		BigDecimal highAmountcopy=BigDecimal.ZERO;;
		if(budgetItemData.getLowAmount()!=null){
			 lowAmount=budgetItemData.getLowAmount();
			 lowAmountcopy=budgetItemData.getLowAmount();
		}
		if(budgetItemData.getHighAmount()!=null){
			 highAmount=budgetItemData.getHighAmount();
			 highAmountcopy=budgetItemData.getHighAmount();
					
		}
		int yearCount=budgetItemData.getSystemYearCount()==null?0:budgetItemData.getSystemYearCount();
		double yearCounts=Double.parseDouble(String.valueOf(yearCount));
		if(yearList.length==1){
			BudgetItemData bit=new BudgetItemData();
			budgetItemData.setYearCount(yearCounts);
			bit=budgetItemData;
			int year=Integer.parseInt(yearList[0].toString());
			bit.setYears(year);
			bit.setId(null);
			bit.setYearCount(yearCounts);
			bit.setLowAmount(lowAmount);
			bit.setHighAmount(highAmount);
			bit.setLowAmountTotal(lowAmount.multiply(new BigDecimal(bit.getYearCount())));
			bit.setHighAmountTotal(highAmount.multiply(new BigDecimal(bit.getYearCount())));
			super.getBudgetItemDataDao().insertOut(bit);
		}else{
		for(int i=0;i<yearList.length;i++){
			BudgetItemData bit=new BudgetItemData();
			budgetItemData.setYearCount(yearCounts);
			bit=budgetItemData;
			int year=Integer.parseInt(yearList[i].toString());
			bit.setYears(year);
			bit.setId(null);
			DecimalFormat   df   =   new   DecimalFormat("#####0.00");   
			
			if(i==0){
				if(bit.getPaymentMethod()==2){
					//月付
					bit.setYearCount(Double.parseDouble(df.format(yearCounts/3)));
				}
				if(bit.getPaymentMethod()==1){
					//半年付
					bit.setYearCount(Double.parseDouble(df.format(yearCounts/2)));
				}
				bit.setLowAmount(lowAmount);
				bit.setHighAmount(highAmount);
				bit.setLowAmountTotal(lowAmount.multiply(new BigDecimal(bit.getYearCount())));
				bit.setHighAmountTotal(highAmount.multiply(new BigDecimal(bit.getYearCount())));
				super.getBudgetItemDataDao().insertOut(bit);
			}else{	
				budgetItemData.setLowAmount(lowAmountcopy);
				budgetItemData.setHighAmount(highAmountcopy);
				if(i==(yearList.length-1)){
					if(bit.getPaymentMethod()==2){
						//月付
						bit.setYearCount(Double.parseDouble(df.format(yearCounts/3*2)));
						bit.setLowAmountTotal(bit.getLowAmount().multiply(new BigDecimal(bit.getYearCount())));
						bit.setHighAmountTotal(bit.getHighAmount().multiply(new BigDecimal(bit.getYearCount())));
						super.getBudgetItemDataDao().insertOut(bit);
					}else if(bit.getPaymentMethod()==1){
						//半年付
						bit.setYearCount(Double.parseDouble(df.format(yearCounts/2)));
						bit.setLowAmountTotal(bit.getLowAmount().multiply(new BigDecimal(bit.getYearCount())));
						bit.setHighAmountTotal(bit.getHighAmount().multiply(new BigDecimal(bit.getYearCount())));
						super.getBudgetItemDataDao().insertOut(bit);
					}else{
						bit.setLowAmountTotal(lowAmountcopy.multiply(new BigDecimal(bit.getYearCount())));
						bit.setHighAmountTotal(highAmountcopy.multiply(new BigDecimal(bit.getYearCount())));
						super.getBudgetItemDataDao().insertOut(budgetItemData);
			
					}
				}else{
					bit.setLowAmountTotal(lowAmountcopy.multiply(new BigDecimal(bit.getYearCount())));
					bit.setHighAmountTotal(highAmountcopy.multiply(new BigDecimal(bit.getYearCount())));
					super.getBudgetItemDataDao().insertOut(budgetItemData);
				}
			}
		
		}
		}
	}
	


}
