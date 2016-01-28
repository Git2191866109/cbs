package com.bs.plugins.custom.eb.budgetitem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.eb.budgetcategory.dao.IBudgetCategoryDao;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.budgetitem.base.BaseBudgetItemService;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;
import com.bs.plugins.custom.eb.modeitemrelation.dao.IModeItemRelationDao;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;

@Service
public class BudgetItemService extends BaseBudgetItemService<BudgetItem> {
	
	@Autowired
	private IBudgetCategoryDao iBudgetCategoryDao;
	@Autowired
	private IModeItemRelationDao iModeItemRelationDao;
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData itemIndex(BudgetItem budgetItem){
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
	public ResultData jumpModify(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			budgetItem = super.getBudgetItemDao().selectOneById(budgetItem);
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("budgetItem", budgetItem);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			//add your code	
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData jumpChild(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			//add your code	
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("budgetItem", budgetItem);
		return resultData;	
	}
	
	
	/**跳转到列表**/
	public ResultData jumpList(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	public ResultData jumpPaginated(BudgetItem budgetItem) {
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData paginated(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			List<BudgetItem> budgetItemList = super.getBudgetItemDao().selectPaginatedByCategoryIdList(budgetItem);
			Long budgetItemCount = super.getBudgetItemDao().getCount(budgetItem);
			if (budgetItemList != null){
				long record = budgetItemCount == null?0:budgetItemCount;
				int pageCount = (int) Math.ceil(record / (double) budgetItem.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", budgetItem.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", budgetItemList);
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
	
	public ResultData modify(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		if(budgetItem.getIsDifferInputLevel() == null || budgetItem.getIsDifferInputLevel() == 0){
			budgetItem.setInputLevel(0);
		}
		try {
			Integer result = super.getBudgetItemDao().updateById(budgetItem);
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
	
	public ResultData create(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		if(budgetItem.getIsDifferInputLevel() == null || budgetItem.getIsDifferInputLevel() == 0){
			budgetItem.setInputLevel(0);
		}
		try {
			Integer result = super.getBudgetItemDao().insert(budgetItem);
			if (result > 0){
				BudgetItem isChildNodeItem = new BudgetItem();
				//将父级isChildNode状态改变是不是子节点
				isChildNodeItem.setId(budgetItem.getParentId());
				isChildNodeItem.setIsChildNode(0);
				super.getBudgetItemDao().updateById(isChildNodeItem);
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
	
	public ResultData selectSubLevel(BudgetItem budgetItem){
		ResultData resultData = new ResultData();
		try {
			Long count = super.getBudgetItemDao().selectSubLevel(budgetItem);
			if(count >0){
				resultData.setStatus(IBaseService.FAIL);
			}else{
				resultData.setStatus(IBaseService.SUCCESS);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultData;
	
	}
		public ResultData getBudgetItem(BudgetItem budgetItem) throws Exception{
			String [] idList=budgetItem.getrId().split(",");
			List<BudgetItem> lbi=new ArrayList<BudgetItem>();
			//控制获得节点的代码块
			{
				if(budgetItem.getBudgetCategoryId()==null){
				budgetItem.setBudgetCategoryId(budgetItem.getId());
				 lbi=super.getBudgetItemDao().getBudgetItemOne(budgetItem);
				}else{
				budgetItem.setBudgetCategoryId(null);
				 lbi=super.getBudgetItemDao().getBudgetItemTwo(budgetItem);
				}
			}	
			ResultData resultData = new ResultData();
			List<Map<String,Object>> lBudgetItem=new ArrayList<Map<String,Object>>();
			for(BudgetItem bgi:lbi)
			{
				Map<String,Object> mBudgetItem=new HashMap<String, Object>();
				ModeItemRelation modeItemRelation=new ModeItemRelation();
				mBudgetItem.put("id", bgi.getId());
				mBudgetItem.put("name", bgi.getName());
				mBudgetItem.put("parentId",bgi.getParentId());
				mBudgetItem.put("pId", bgi.getId());
				mBudgetItem.put("budgetCategoryId", bgi.getBudgetCategoryId());
				Long count = super.getBudgetItemDao().selectSubLevel(bgi);
				Integer lv=Integer.parseInt(count.toString());
				if(lv>0){
					//是否为父节点
					mBudgetItem.put("isParent",true);
				}else{
					modeItemRelation.setGrowStagesId(Long.parseLong(idList[1].toString()));
					modeItemRelation.setEduModeId(Long.parseLong(idList[0].toString()));
					modeItemRelation.setBudgetItemId(bgi.getId());
				    int size=iModeItemRelationDao.getModeItemRelation(modeItemRelation);
				    if(size>0){
				    	//禁止选用
				    	mBudgetItem.put("checked", true);
				    	mBudgetItem.put("established", true);
				    }else{
						//默认没有建立关系（节点图片灰色）
				    	mBudgetItem.put("established", false);
				    }
				}
				lBudgetItem.add(mBudgetItem);
			}
			String json=JSON.toJSONString(lBudgetItem);
			System.out.println(json);
			Map<String, Object> m=new HashMap<String, Object>();
			m.put("childNodes", json);
			resultData.setResultMap(m);	
			return resultData;
		}
}
