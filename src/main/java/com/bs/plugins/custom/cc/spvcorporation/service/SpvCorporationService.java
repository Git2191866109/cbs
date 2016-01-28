package com.bs.plugins.custom.cc.spvcorporation.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.cc.spvcorporation.base.BaseSpvCorporationService;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.tc.bankbasicinfo.dao.IBankBasicInfoDao;
import com.bs.plugins.custom.tc.bankbasicinfo.entity.BankBasicInfo;

@Service
public class SpvCorporationService extends BaseSpvCorporationService<SpvCorporation> {
	
	@Autowired
	private IBankBasicInfoDao bankBasicInfoDao;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData spvcorporationIndex(SpvCorporation spvCorporation){
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
	public ResultData jumpModify(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			spvCorporation = super.getSpvCorporationDao().selectOneById(spvCorporation);
			//add your code
			//查询银行信息
			BankBasicInfo bankBasicInfo = new BankBasicInfo();
			bankBasicInfo.setStatus(1);
			List<BankBasicInfo> bankBasicInfoList = bankBasicInfoDao.selectList(bankBasicInfo);
			resultData.addObject("bankBasicInfoList", bankBasicInfoList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("spvCorporation", spvCorporation);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			//add your code
			//查询银行信息
			BankBasicInfo bankBasicInfo = new BankBasicInfo();
			bankBasicInfo.setStatus(1);
			List<BankBasicInfo> bankBasicInfoList = bankBasicInfoDao.selectList(bankBasicInfo);
			resultData.addObject("bankBasicInfoList", bankBasicInfoList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(SpvCorporation spvCorporation){
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
	public ResultData jumpPaginated(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**
	 * 分页
	 */
	public ResultData paginated(SpvCorporation spvCorporation) {
		ResultData resultData = new ResultData();
		try {
			//查询状态
			List<SpvCorporation> feedbackList = super.getSpvCorporationDao().selectPaginatedListByStatus(spvCorporation);
			Long growStagesCount = super.getSpvCorporationDao().getCountByStatus(spvCorporation);
			if (feedbackList != null) {
				long record = growStagesCount == null ? 0 : growStagesCount;
				int pageCount = (int) Math.ceil(record/ (double) spvCorporation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvCorporation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", feedbackList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			} else {
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**
	 * 创建spv机构
	 * @param user
	 * @return
	 */
	public ResultData create(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try {
			spvCorporation.setAvailableAmount(new BigDecimal(0));
			spvCorporation.setFrozenAmount(new BigDecimal(0));
			spvCorporation.setType(1);
			int returValue = super.getSpvCorporationDao().insert(spvCorporation);
			if (returValue > 0){
				resultData.setStatus(SUCCESS);
			}
			else{
				resultData.setStatus(FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(FAIL);
			e.printStackTrace();
		}
		return resultData;		
	}
	/**
	 * 修改spv机构
	 * @param user
	 * @return
	 */
	public ResultData modify(SpvCorporation spvCorporation){
		ResultData resultData = new ResultData();
		try{
			int returValue = super.getSpvCorporationDao().updateSpvById(spvCorporation);
			if (returValue > 0){
				resultData.setStatus(SUCCESS);
			}
			else{
				resultData.setStatus(FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(FAIL);
			e.printStackTrace();
		}
		return resultData;		
	}
}
