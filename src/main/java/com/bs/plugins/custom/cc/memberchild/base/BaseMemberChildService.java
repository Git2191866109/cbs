package com.bs.plugins.custom.cc.memberchild.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.memberchild.entity.MemberChild;
import com.bs.plugins.custom.cc.memberchild.dao.IMemberChildDao;

public class BaseMemberChildService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IMemberChildDao memberChildDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			Integer result = memberChildDao.insert(memberChild);
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
		
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modify(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			Integer result = memberChildDao.updateById(memberChild);
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
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modifyById(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			Integer result = memberChildDao.updateById(memberChild);
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
	/**
	 * 修改(完全修改)
	 * @param entity
	 * @return
	 */
	public ResultData modifyComplete(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			Integer result = memberChildDao.updateCompleteById(memberChild);
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

	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData delete(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			Integer result = memberChildDao.delete(memberChild);
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
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteById(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			Integer result = memberChildDao.deleteById(memberChild);
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
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteAll(){
		ResultData resultData = new ResultData();
		try {
			Integer result = memberChildDao.deleteAll();
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
	
	/**
	 * 查询单条数据
	 * @param entity
	 * @return
	*/
	public ResultData single(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			MemberChild memberChildTemp = memberChildDao.selectOneById(memberChild);
			if (memberChildTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("memberChild", memberChildTemp);
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
	
	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			List<MemberChild> memberChildList = memberChildDao.selectList(memberChild);
			if (memberChildList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("memberChildList", memberChildList);
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
	
	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(MemberChild memberChild){
		ResultData resultData = new ResultData();
		try {
			List<MemberChild> memberChildList = memberChildDao.selectPaginatedList(memberChild);
			Long memberChildCount = memberChildDao.getCount(memberChild);
			if (memberChildList != null){
				long record = memberChildCount == null?0:memberChildCount;
				int pageCount = (int) Math.ceil(record / (double) memberChild.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", memberChild.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", memberChildList);
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
	
	
	@Override
	public void afterPropertiesSet() throws Exception {

	}
	
	public InitializeData getInitializeData() {
		return initializeData;
	}

	public void setInitializeData(InitializeData initializeData) {
		this.initializeData = initializeData;
	}
	
	public IMemberChildDao getMemberChildDao() {
		return memberChildDao;
	}

	public void setMemberChildDao(IMemberChildDao memberChildDao) {
		this.memberChildDao = memberChildDao;
	}
}
