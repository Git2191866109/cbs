package com.bs.plugins.custom.sc.residentincomes.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.DateUtil;
import com.bs.plugins.custom.eb.budgetitemdata.dao.IBudgetItemDataDao;
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;
import com.bs.plugins.custom.sc.area.dao.IAreaDao;
import com.bs.plugins.custom.sc.area.entity.Area;
import com.bs.plugins.custom.sc.residentincomes.base.BaseResidentIncomesService;
import com.bs.plugins.custom.sc.residentincomes.entity.ResidentIncomes;

@Service
@Transactional
public class ResidentIncomesService extends BaseResidentIncomesService<ResidentIncomes> {
	
	@Autowired
	private IBudgetItemDataDao iBudgetItemDataDao;
	
	@Autowired
	private IAreaDao iAreaDao;
	@Autowired
	private  PlatformTransactionManager transactionManager;
	public void setTransactionManager(PlatformTransactionManager transactionManager){
		this.transactionManager=transactionManager;
	}

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData residentIncomesIndex(ResidentIncomes residentIncomes){
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
	public ResultData jumpModify(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			residentIncomes = super.getResidentIncomesDao().selectOneById(residentIncomes);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("residentIncomes", residentIncomes);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(ResidentIncomes residentIncomes){
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
	public ResultData jumpPaginated(ResidentIncomes residentIncomes){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	//分表一键生成
	public ResultData initBudgetItemDataByArea(ResidentIncomes residentIncomes) throws Exception{
		ResultData resultData = new ResultData();
		//查询基础数据对应的relationPath
		List<ResidentIncomes> relationPathList =  super.getResidentIncomesDao().selectRelationPathByBaseData();
		//查询所有地区的居民收入
		List<ResidentIncomes> residentIncomesList = super.getResidentIncomesDao().selectCreateDate(residentIncomes);
		//查询所有与居民收入相关的地区 
		List<ResidentIncomes> incomesAreaList = super.getResidentIncomesDao().selectCodeSpellingList();
		int i = 0;
		//重新组装incomesAreaList成Map<地区code,省份拼音> 修改为省份目前是地区拼音
		Map<String,Object> incomesAreaMap = new HashMap<String,Object>();
		for( int m=0;m<incomesAreaList.size();m++){
			ResidentIncomes incomesTemp=incomesAreaList.get(m);
			String[] relationPathArr = incomesTemp.getRelationPath().split(",");
				Area tempAreas = new Area();
				tempAreas.setCode(relationPathArr[1].toString());
				List<Area> tempAreaList = iAreaDao.selectList(tempAreas);
				if(tempAreaList.size()>0){
					tempAreas=tempAreaList.get(0);
					incomesAreaMap.put(incomesTemp.getAreaCode(), tempAreas.getSpelling());
					}
			
		}
		if(relationPathList.size() > 0){
			ResidentIncomes incomeRelationPath = relationPathList.get(0);
			String relationPath = incomeRelationPath.getArea().getRelationPath();
			String[] relationPathCodeArr = relationPath.split(",");
			if(relationPathCodeArr.length>=2){
				String code = relationPathCodeArr[1];
				Area tempArea = new Area();
				tempArea.setCode(code);
				List<Area> tempAreaList = iAreaDao.selectList(tempArea);
				
				if(tempAreaList.size() > 0){
					
					tempArea = tempAreaList.get(0);
					//以上代码只为获取此地区基础数据所在省份名称 方便查找对应所在表
					String spelling = tempArea.getSpelling();
					
					Map<String,Object> dataMap = new HashMap<String,Object>();
					
					dataMap.put("areaCode", incomeRelationPath.getAreaCode());
					dataMap.put("tableName", "EB_BudgetItemData"+spelling);
					for(int a=0;a<residentIncomesList.size();a++){
						ResidentIncomes incomesTemp=residentIncomesList.get(a);
						//查询该code是否有下级节点
						Area areatest = new Area();
						areatest.setParentCode(incomesTemp.getAreaCode());
						List<Area> areatestList = iAreaDao.selectList(areatest);
								if(areatestList.size()>0){
									continue;
								}
								//基础数据的集合
							List<BudgetItemData> baseBudgetItemDataList =  iBudgetItemDataDao.selectBudgetItemDataListByAreaCode(dataMap);
							System.out.println(incomesAreaMap.get(incomesTemp.getAreaCode()));
							System.out.println(incomesTemp.getAreaCode());
							i = insertGroupByArea(i, incomesAreaMap,incomeRelationPath, incomesTemp,baseBudgetItemDataList);
							baseBudgetItemDataList=null;
							incomesTemp=null;
					}
					
				}
			}
		}
		
		if(i > 0 ){
			resultData.setStatus(IBaseService.SUCCESS);
		}else{
			resultData.setStatus(IBaseService.FAIL);
		}
		
		return resultData;
	}
	/**批量添加地区所有基础数据。按地区**/
	public int insertGroupByArea(int i, Map<String, Object> incomesAreaMap,
			ResidentIncomes incomeRelationPath, ResidentIncomes incomesTemp,
			List<BudgetItemData> baseBudgetItemDataList) throws Exception{
		List<BudgetItemData> batch=new ArrayList<BudgetItemData>();
		Map<String,Object> batchMap=new HashMap<String, Object>();
		for(int b=0;b<baseBudgetItemDataList.size();b++){
		BudgetItemData itemDataTemp=baseBudgetItemDataList.get(b);
		
		//决定存哪张地区表									//取对应code的省份拼音
		itemDataTemp.setTableName("EB_BudgetItemData"+incomesAreaMap.get(incomesTemp.getAreaCode()));
		itemDataTemp.setAreaCode(incomesTemp.getAreaCode());
		if("10001".equals(incomesTemp.getAreaCode())){
			break;
		}
		if(itemDataTemp.getIsAreaTranslation() !=null&&itemDataTemp.getIsAreaTranslation() == 1){
			if(itemDataTemp.getLowAmount() != null){
				//根据地区换算：普通金额
				itemDataTemp.setLowAmount(itemDataTemp.getLowAmount().multiply(new BigDecimal(incomesTemp.getAmount()))
						.divide(new BigDecimal(incomeRelationPath.getAmount()),6,RoundingMode.HALF_UP));
			}
			if(itemDataTemp.getLowAmountTotal() != null){
				itemDataTemp.setLowAmountTotal(itemDataTemp.getLowAmountTotal().multiply(new BigDecimal(incomesTemp.getAmount()))
						.divide(new BigDecimal(incomeRelationPath.getAmount()),6,RoundingMode.HALF_UP));
			}
			
			if(itemDataTemp.getHighAmount() != null){
				itemDataTemp.setHighAmount(itemDataTemp.getHighAmount().multiply(new BigDecimal(incomesTemp.getAmount()))
						.divide(new BigDecimal(incomeRelationPath.getAmount()),6,RoundingMode.HALF_UP));
			}
			
			if(itemDataTemp.getHighAmountTotal() != null){
				itemDataTemp.setHighAmountTotal(itemDataTemp.getHighAmountTotal().multiply(new BigDecimal(incomesTemp.getAmount()))
						.divide(new BigDecimal(incomeRelationPath.getAmount()),6,RoundingMode.HALF_UP));
			}
			
		}
		itemDataTemp.setCreateDate(DateUtil.dateToStringWithTime());
				i++;
			batch.add(itemDataTemp);
		itemDataTemp=null;
		
}
		//更改地区收入的是否添加状态
		batchMap.put("tableName","EB_BudgetItemData"+incomesAreaMap.get(incomesTemp.getAreaCode()));
		batchMap.put("tableValue", batch);
 		try{
 		int a=	iBudgetItemDataDao.insertBatch(batchMap);
 		System.out.println("ccccc"+a);
 		}catch(Exception e){
 			e.printStackTrace();
 		}
		return i;
		}
	
	//根据不同地区按照收入比例初始化基础数据到EB_BudgetItemData表
	public void initResidentIncomesData(ResidentIncomes residentIncomes){
		
		try {
			//各个地区收入并且不存在基础数据表的地区收入
			
			List<ResidentIncomes> incomeList = super.getResidentIncomesDao().selectList(new ResidentIncomes());
			List<Area> areaList = iAreaDao.selectAll();
			
			List<String> codeList = new ArrayList<String>();
			for(Area areaTemp :areaList){
				codeList.add(areaTemp.getCode());
			}
			
			List<String> arerCodeList = new ArrayList<String>();
			for(ResidentIncomes incomesTemp :incomeList){
				arerCodeList.add(incomesTemp.getAreaCode());
			}
			
			for(String tempCode : codeList){
				if(!arerCodeList.contains(tempCode)){
					Area area = new Area();
					area.setCode(tempCode);
					area = iAreaDao.selectList(area).get(0);
					if(!arerCodeList.contains(area.getParentCode())){
						Area newarea = new Area();
						newarea.setCode(area.getParentCode());
						if(iAreaDao.selectList(newarea).size()!=0){
							newarea = iAreaDao.selectList(newarea).get(0);
							if(arerCodeList.contains(newarea.getCode())){
								ResidentIncomes income = new ResidentIncomes();
								income.setAreaCode(newarea.getCode());
								income = super.getResidentIncomesDao().selectList(income).get(0);
								income.setId(null);
								if(income != null){
									income.setAreaCode(tempCode);
									super.getResidentIncomesDao().insert(income);
								}
							}else{
								Area newareatemp = new Area();
								newareatemp.setCode(newarea.getParentCode());
								if(iAreaDao.selectList(newareatemp).size()!=0){
									newareatemp = iAreaDao.selectList(newareatemp).get(0);
									if(arerCodeList.contains(newareatemp.getCode())){
										ResidentIncomes income = new ResidentIncomes();
										income.setAreaCode(newareatemp.getCode());
										income = super.getResidentIncomesDao().selectList(income).get(0);
										income.setId(null);
										if(income != null){
											income.setAreaCode(tempCode);
											super.getResidentIncomesDao().insert(income);
										}
									}
								}
							}
						}
					}else{
						ResidentIncomes income = new ResidentIncomes();
						income.setAreaCode(area.getParentCode());
						income = super.getResidentIncomesDao().selectList(income).get(0);
						if(income != null){
							income.setAreaCode(tempCode);
							income.setId(null);
							super.getResidentIncomesDao().insert(income);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print("===================================成功=============================================");
	}
}
