package com.bs.plugins.custom.eb.itemfield.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.eb.budgetcategory.dao.IBudgetCategoryDao;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.budgetitem.dao.IBudgetItemDao;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;
import com.bs.plugins.custom.eb.budgetitemdata.dao.IBudgetItemDataDao;
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;
import com.bs.plugins.custom.eb.greadeyear.dao.IGreadeYearDao;
import com.bs.plugins.custom.eb.greadeyear.entity.GreadeYear;
import com.bs.plugins.custom.eb.itemfield.base.BaseItemFieldService;
import com.bs.plugins.custom.eb.itemfield.entity.ItemField;
import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;
import com.bs.plugins.custom.sc.area.dao.IAreaDao;
import com.bs.plugins.custom.sc.area.entity.Area;
import com.bs.plugins.custom.sc.tablecolumn.dao.ITableColumnDao;
import com.bs.plugins.custom.sc.tablecolumn.entity.TableColumn;

@Service
public class ItemFieldService extends BaseItemFieldService<ItemField> {
	
	@Autowired
	private IBudgetItemDao iBudgetItemDao;
	
	@Autowired
	private IBudgetCategoryDao iBudgetCategoryDao;
	
	@Autowired
	private ITableColumnDao iTableColumnDao;
	@Autowired
	private IBudgetItemDataDao ibudgetItemDataDao;
	@Autowired 
	private IGreadeYearDao  iGreadeYearDao;
	@Autowired
	private IAreaDao iAreaDao;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData nameIndex(ItemField itemField){
		/**
		ResultData resultData = new ResultData();
		try {
			List<BudgetItem> budgetItemList = iBudgetItemDao.selectList(null);
			List<Map<String,Object>> treeList = new ArrayList<Map<String,Object>>();
			for(BudgetItem temp : budgetItemList){
				Map<String,Object> budgetItemMap = new HashMap<String,Object>();
				budgetItemMap.put("id", temp.getId());
				//和下面的("id", temp.getId()+"_pId")对应产生上下级关系，并且不会出现相同的id(楼上)
				budgetItemMap.put("pId", temp.getParentId()+"_pId");
				budgetItemMap.put("name", temp.getName());
				treeList.add(budgetItemMap);
			}
			
			List<BudgetCategory> list = iBudgetCategoryDao.selectList(null);
			for(BudgetCategory temp : list){
				Map<String,Object> budgetItemMap = new HashMap<String,Object>();
				budgetItemMap.put("id", temp.getId()+"_pId");
				budgetItemMap.put("pId",0);
				budgetItemMap.put("name", temp.getName());
				budgetItemMap.put("open", true);
				treeList.add(budgetItemMap);
			}
			//转json格式在页面树形展示
			String json = JSONArray.toJSONString(treeList).toString();
			resultData.addObject("treeJsonData", json);
			
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
		*/
		
		ResultData resultData = new ResultData();
		try {
			List<BudgetCategory> budgetCategoryList = iBudgetCategoryDao.selectList(null);
			resultData.addObject("budgetCategoryList", budgetCategoryList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(ItemField itemField){
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
	public ResultData jumpCreate(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("itemField", itemField);
		return resultData;	
	}
	
	public ResultData jumpSetValue(ItemField itemField){
		ResultData resultData = new ResultData();
		resultData.addObject("itemField",itemField);
		return resultData;
	}
	
	/**跳转到列表**/
	public ResultData jumpList(ItemField itemField){
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
	public ResultData jumpPaginated(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData paginated(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			List<ItemField> itemFieldList = super.getItemFieldDao().selectPaginatedListByItemId(itemField);
			Long itemFieldCount = super.getItemFieldDao().getCount(itemField);
			if (itemFieldList != null){
				long record = itemFieldCount == null?0:itemFieldCount;
				int pageCount = (int) Math.ceil(record / (double) itemField.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", itemField.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", itemFieldList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData getBudgetItemTree(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItem> budgetItemList = iBudgetItemDao.selectList(null);
			List<Map<String,Object>> treeList = new ArrayList<Map<String,Object>>();
			for(BudgetItem temp : budgetItemList){
				Map<String,Object> budgetItemMap = new HashMap<String,Object>();
				budgetItemMap.put("id", temp.getId());
				budgetItemMap.put("pId", temp.getParentId());
				budgetItemMap.put("name", temp.getName());
				treeList.add(budgetItemMap);
			}
			String json = JSONArray.toJSONString(treeList).toString();
			resultData.addObject("treeJsonData", json);
			
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	public ResultData create(ItemField itemField){
		
		ResultData resultData = new ResultData();
		TableColumn tableColumn = new TableColumn();
		tableColumn.setIds(itemField.getIds());
		try {
			
			List<TableColumn> tableColumnList = iTableColumnDao.selectListByIds(tableColumn);
			Integer result = 1;
			Integer resultTemp = 1;
			for(TableColumn temp :tableColumnList){
				ItemField itemFieldTemp = new ItemField();
				itemFieldTemp.setCategoryId(itemField.getCategoryId());
				itemFieldTemp.setTableName(itemField.getTableName());
				itemFieldTemp.setColumnName(temp.getName());
				itemFieldTemp.setColumnCode(temp.getCode());
				itemFieldTemp.setIsShow(1);
				resultTemp = super.getItemFieldDao().insert(itemFieldTemp);
				result *= resultTemp;
			}
			
			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
			
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	public ResultData getItemField(ItemField itemField) throws Exception{
		ResultData rd=new ResultData();
		try{
		Map<String,Object> m =new HashMap<String,Object>();
		itemField.setId(null);//确认显示
		//查询展示类型为下拉框更 复选框
		List<ItemField> ItemFieldone=super.getItemFieldDao().selectCollectionOne(itemField);
		BudgetItemData budgetItemData =new BudgetItemData();
		budgetItemData.setAreaCode(itemField.getAreaCode());
		budgetItemData.setCategoryId(itemField.getCategoryId());
		budgetItemData.setEduModeId(itemField.getEduModeId());
		budgetItemData.setGrowStagesId(itemField.getGrowStagesId());
		budgetItemData.setItemId(itemField.getItemId());
		Area area=new Area();
		area.setCode(itemField.getProvinceCode());
		String spell=iAreaDao.selectSpell(area);
		budgetItemData.setTableName("EB_BudgetItemData"+spell);;
		//查询配置的值
		List<BudgetItemData> BudgetItemDataList=ibudgetItemDataDao.selectListAll(budgetItemData);
		String yearList="";
		//year 重新配
		for(ItemField ItemFieldoneData:ItemFieldone)
		{
			 if("Years".equals(ItemFieldoneData.getColumnCode().toString())){
	            	//查询年数
	            		GreadeYear greadeYear=new  GreadeYear();
	            		greadeYear.setGrowStageId(itemField.getGrowStagesId());
	            		List<GreadeYear> greadeYearDaoList=iGreadeYearDao.selectList(greadeYear);
	            		ArrayList<ItemFieldValue>  itemFieldValueList=new ArrayList<ItemFieldValue>();
	            		for( int i=1;i<= greadeYearDaoList.size();i++)
		    			{
	            			ItemFieldValue itemFieldValue =new  ItemFieldValue();
		            		GreadeYear gy=greadeYearDaoList.get(i-1);
		            		if(i==greadeYearDaoList.size()){
		            			itemFieldValue.setFieldValue(gy.getStartYear().toString());
		            			itemFieldValue.setFieldName(gy.getStartYear().toString());
		            			itemFieldValueList.add(itemFieldValue);
		            			itemFieldValue=new ItemFieldValue();
		            			itemFieldValue.setFieldValue(gy.getEndYear().toString());
		            			itemFieldValue.setFieldName(gy.getEndYear().toString());
		            		}else{
		            			itemFieldValue.setFieldValue(gy.getStartYear().toString());
		            			itemFieldValue.setFieldName(gy.getStartYear().toString());
		            		}
		                itemFieldValueList.add(itemFieldValue);
		    			}
	            	//初始years
	                ItemFieldoneData.setItemFieldValue(itemFieldValueList);
			}
			if(BudgetItemDataList.size()>0){
				budgetItemData=BudgetItemDataList.get(0);
				//查询属性值
			    Method method = budgetItemData.getClass().getMethod("get"+ItemFieldoneData.getColumnCode());
	            Object value = (Object) method.invoke(budgetItemData);
	            //赋值
	            ItemFieldoneData.setVal(value);
	            //年数的特殊处理
                if("Years".equals(ItemFieldoneData.getColumnCode().toString())){
                	for(int j=0;j<BudgetItemDataList.size();j++)
        			{
                		BudgetItemData BudgetItemData=BudgetItemDataList.get(j);
        				yearList+=BudgetItemData.getYears().toString()+",";
        			}
                    ItemFieldoneData.setVal(yearList);
        			
                }
	            m.put("isAdded", true);
				m.put("id",budgetItemData.getId());
			}else{
				m.put("isAdded", false);
							
			}
       }
		//查询展示类型为 输入框
		String json=JSON.toJSONString(ItemFieldone);
		m.put("succ", json);
		rd.setStatus(SUCCESS);
		rd.setResultMap(m);
		}catch(Exception e){
			e.printStackTrace();
			rd.setStatus(FAIL);
			rd.setStatusException(e.getMessage());
		}
		return rd;
	}
	
	
	
}
