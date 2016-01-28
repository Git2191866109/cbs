package com.bs.plugins.custom.eb.growstages.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.eb.budgetcategory.dao.IBudgetCategoryDao;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.budgetitem.dao.IBudgetItemDao;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;
import com.bs.plugins.custom.eb.budgetitemdata.dao.IBudgetItemDataDao;
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;
import com.bs.plugins.custom.eb.educationmode.dao.IEducationModeDao;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;
import com.bs.plugins.custom.eb.growstages.base.BaseGrowStagesService;
import com.bs.plugins.custom.eb.growstages.dao.IGrowStagesDao;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.modeitemrelation.dao.IModeItemRelationDao;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;
import com.bs.plugins.custom.sc.area.dao.IAreaDao;
import com.bs.plugins.custom.sc.area.entity.Area;

@Service
public class GrowStagesService extends BaseGrowStagesService<GrowStages> {
	
	@Autowired
	private IGrowStagesDao growStageDao;
	@Autowired
	private IAreaDao iAreaDao;
	@Autowired
	private IBudgetItemDao   IbudgetItemDao;
 	@Autowired
	private IEducationModeDao iEducationModeDao;
	@Autowired
	private IBudgetCategoryDao iBudgetCategoryDao;
	@Autowired 
	private IModeItemRelationDao iModeItemRelationDao;
	@Autowired 
	private  IBudgetItemDataDao iBudgetItemDataDao;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData growIndex(GrowStages growStages){
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
	public ResultData jumpModify(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			growStages = super.getGrowStagesDao().selectOneById(growStages);
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("growStages", growStages);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(GrowStages growStages){
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
	
	/**跳转到列表**/
	public ResultData jumpList(GrowStages growStages){
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
	public ResultData jumpPaginated(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData getGrowStages(GrowStages gs) throws Exception{
		//查询所有的大类（父节点）
		ResultData resultData = new ResultData();
		Map<String,Object> m = new HashMap<String,Object>();
		List<Map<String, Object>> allListGrowStages = getTreeGrowStages();
		String json=JSONArray.toJSONString(allListGrowStages);
		allListGrowStages.clear();
		{
			Area temp = new Area();
			temp.setTreeLevel(0);
			List<Area> areaList0 = iAreaDao.selectList(temp);
			for(Area g:areaList0){
				Map<String,Object> growStageMap = new HashMap<String,Object>();
				growStageMap.put("name",g.getName());
				growStageMap.put("id",g.getCode());
				growStageMap.put("Code",g.getCode());
				growStageMap.put("isParent", "true");
				growStageMap.put("pId", 0);
				growStageMap.put("parentCode",0);
				allListGrowStages.add(growStageMap);
			}
		}
		String configure=JSONArray.toJSONString(allListGrowStages);
		m.put("childNodes",json);
		m.put("configure",configure);
		resultData.setResultMap(m);
		return resultData;
	}

	private List<Map<String, Object>> getTreeGrowStages() {
		List<Map<String,Object>> allListGrowStages=new ArrayList<Map<String,Object>>();
		//得到
		{
			List<GrowStages>  allGrowStages=growStageDao.findParentNode();
				for(GrowStages g:allGrowStages){
					Map<String,Object> growStageMap = new HashMap<String,Object>();
					growStageMap.put("name",g.getName());
					growStageMap.put("id",g.getId());
					growStageMap.put("isParent", "true");
					growStageMap.put("pId",g.getId());
					allListGrowStages.add(growStageMap);
				}
		}
		return allListGrowStages;
	}
	
	
	public ResultData paginated(GrowStages growStages){
		ResultData resultData = new ResultData();
		try {
			List<GrowStages> growStagesList = super.getGrowStagesDao().selectPaginatedListOrderByCode(growStages);
			Long growStagesCount = super.getGrowStagesDao().getCount(growStages);
			if (growStagesList != null){
				long record = growStagesCount == null?0:growStagesCount;
				int pageCount = (int) Math.ceil(record / (double) growStages.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", growStages.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", growStagesList);
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
	public ResultData getTreeDate(GrowStages gs) throws Exception{
		ResultData rd=new ResultData();
		List<Map<String, Object>> allListGrowStages=new ArrayList<Map<String,Object>>();
		List<ModeItemRelation> lmodeItemRelation=new ArrayList<ModeItemRelation>();
		ModeItemRelation  mir=new ModeItemRelation();
	if(gs.getLevel()== null){
		 allListGrowStages = getTreeGrowStages();
	
	}	else if(gs.getLevel()==0){
			    //寻找二级标签
				EducationMode em=new EducationMode();
				em.setGrowStagesId(gs.getId());
				//找出所有为1的已关系好的节点
				ModeItemRelation mr=new ModeItemRelation();
				mr.setGrowStagesId(gs.getId());
				lmodeItemRelation=iModeItemRelationDao.findTreeData(mr);
	  			
				if(lmodeItemRelation.size()>0){
					for(ModeItemRelation m:lmodeItemRelation){
						em.setId(m.getEducationMode().getId());
						EducationMode listEducationMode=iEducationModeDao.getEducationMode(em).get(0);
						Map<String,Object> growStageMap = new HashMap<String,Object>();
						growStageMap.put("name"	,listEducationMode.getName());
						growStageMap.put("id",listEducationMode.getId());
						growStageMap.put("isParent", "true");
						growStageMap.put("parentId",listEducationMode.getId());
						//growStageMap.put("level", em.getGrowStagesId());
						allListGrowStages.add(growStageMap);
					}
				}
			}else if(gs.getLevel()==1){
				 //寻找三级
				 mir.setGrowStagesId(Long.parseLong(gs.getParentId()));//为跟节点ID
				 mir.setEduModeId(Long.parseLong(gs.getId().toString()));//上级节点
				 
				 //查询是否有链接
				 lmodeItemRelation=	iModeItemRelationDao.getTreeBudgetCategory(mir);
				 if(lmodeItemRelation.size()>0){
					 for(ModeItemRelation m:lmodeItemRelation){
						 //通过查询出来的ID查询三级菜单属性结构
						 	BudgetCategory b=	 new BudgetCategory();
						 	b.setId(m.getBudgetCategory().getId());
						    b= iBudgetCategoryDao.getBudgetCategory(b).get(0);
							Map<String, Object> mBudgetCategory=new HashMap<String, Object>();
							mBudgetCategory.put("name",b.getName());
							mBudgetCategory.put("parentId", m.getEduModeId());
							mBudgetCategory.put("id",b.getId());
							mBudgetCategory.put("isParent", true);
							//mBudgetCategory.put("level", gs.getLevel()+1);
							allListGrowStages.add(mBudgetCategory);
					 }
				 }
			}else if(gs.getLevel()==2){
				 //三四级标签
				 String [] arr=gs.getrId().split(",");
				 mir.setBudgetCategoryId(gs.getId()); //选择de子节点
			     mir.setEduModeId(Long.parseLong(arr[0]));//根节点紧挨的子节点
				 mir.setGrowStagesId(Long.parseLong(arr[1]));//根节点
				 //查询小类
				 lmodeItemRelation =  iModeItemRelationDao.getTreeBudgetItem(mir);
				 for(ModeItemRelation m:lmodeItemRelation){
					 Map<String, Object> mBudgetCategory=new HashMap<String, Object>();
					 BudgetItem bi=m.getBudgetItem();
					 //如果为父节点
					 if(bi.getParentId()==0){
						 mBudgetCategory.put("name", bi.getName());
						 mBudgetCategory.put("parentId", gs.getId());
						 mBudgetCategory.put("id",bi.getId() );
						 mBudgetCategory.put("rId",bi.getId());
						 mBudgetCategory.put("isParent", false);
//						 //查询是否配置过属性
						 BudgetItemData bd=new BudgetItemData();
						 bd.setAreaCode(gs.getAreaCode());
						 bd.setGrowStagesId(Long.parseLong(arr[1]));
						 bd.setEduModeId(Long.parseLong(arr[0]));
						 bd.setItemId(bi.getId());
						 bd.setCategoryId(gs.getId());
						 Area area=new Area();
						 area.setCode(gs.getProvinceCode());
						 String spell=iAreaDao.selectSpell(area);
						 bd.setTableName("EB_BudgetItemData"+spell);
						 Integer count =iBudgetItemDataDao.selectListforCount(bd);
						 if(count>0){
							 //页面星号图标亮
							 mBudgetCategory.put("established", true);
						 }else{
							 //页面星号图标暗
							 mBudgetCategory.put("established", false);
						 }
						 allListGrowStages.add(mBudgetCategory);
					 }else{
						 //先保存子节点信息
						 BudgetItem budgetItem1=new BudgetItem();
					     budgetItem1.setId(bi.getParentId());
						 Map<String,Object> child=new  HashMap<String, Object>();
						 budgetItem1=	IbudgetItemDao.selectOneById(budgetItem1);
						 child.put("name", budgetItem1.getName());
						 child.put("parentId",gs.getId());
						 child.put("id", budgetItem1.getId());
						 child.put("isParent", true);
						 allListGrowStages.add(child);
					 }
				 }
			}else {
				 BudgetItem bi =new BudgetItem();
				 bi.setId(gs.getId());
				 List<BudgetItem> BudgetItems =	IbudgetItemDao.getBudgetItemTwo(bi);
				 //三四级标签
				 String [] arr=gs.getrId().split(",");
				 mir.setBudgetCategoryId(Long.parseLong(arr[2])); //选择de子节点
				 mir.setEduModeId(Long.parseLong(arr[1]));//根节点紧挨的子节点
				 mir.setGrowStagesId(Long.parseLong(arr[0]));//根节点
				 //查询小类
				 lmodeItemRelation =  iModeItemRelationDao.getTreeBudgetItem(mir);
				 for(ModeItemRelation m:lmodeItemRelation){
					 for(BudgetItem bItem:BudgetItems){
						if( m.getBudgetItem().getId()==bItem.getId()){
							 Map<String,Object> child=new  HashMap<String, Object>();
							 child.put("name", bItem.getName());
							 child.put("parentId",bItem.getParentId());
							 child.put("id", bItem.getId());
							 child.put("isParent", false);
							 allListGrowStages.add(child);
						  }
					  }
				 }
			}
		String json =JSONObject.toJSONString(allListGrowStages);
		System.out.println(json);
		Map<String,Object> m =new HashMap<String, Object>();
		m.put("json", json);
		rd.setResultMap(m);
		return rd;
	}
	
	
}
