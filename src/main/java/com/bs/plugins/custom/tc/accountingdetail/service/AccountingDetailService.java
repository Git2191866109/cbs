package com.bs.plugins.custom.tc.accountingdetail.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.pc.product.dao.IProductDao;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.provider.constants.IProductConst;
import com.bs.plugins.custom.tc.accountingdetail.dao.IAccountingDetailDao;
import com.bs.plugins.custom.tc.accountingdetail.entity.AccountingDetail;
import com.bs.plugins.custom.tc.accountingdetail.base.BaseAccountingDetailService;
import com.bs.plugins.custom.uc.organization.dao.IOrganizationDao;
import com.bs.plugins.custom.uc.organization.entity.Organization;

@Service
public class AccountingDetailService extends BaseAccountingDetailService<AccountingDetail> {
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private IOrganizationDao organizationDao;
	
	@Autowired
	private IAccountingDetailDao accountingDetailDao;
	
	public ResultData selectClientPaginated(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			List<AccountingDetail> accountingDetailList = accountingDetailDao.selectClientPaginated(accountingDetail);
			Long accountingDetailCount = accountingDetailDao.selectClientCount(accountingDetail);
			if (accountingDetailList != null){
				
				long record = accountingDetailCount == null?0:accountingDetailCount;
				int pageCount = (int) Math.ceil(record / (double) accountingDetail.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", accountingDetail.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", accountingDetailList);
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
	
	public ResultData searchStaticesFlow(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		BigDecimal totalFlowIn = BigDecimal.ZERO;
		BigDecimal totalFlowOut = BigDecimal.ZERO;
		BigDecimal totalFlow = BigDecimal.ZERO;
		try {
			List<AccountingDetail> accountingDetailList = accountingDetailDao.selectClientPaginated(accountingDetail);
			
			for(AccountingDetail temp : accountingDetailList){
				if(temp.getFlowTo() != null){
					if(temp.getFlowTo() == 0){
						totalFlowOut = totalFlowOut.add(temp.getAmount());
					}else if(temp.getFlowTo() == 1){
						totalFlowIn = totalFlowIn.add(temp.getAmount());
					}
					totalFlow = totalFlow.add(temp.getAmount());
				}else{
					System.out.print("============存在为空的资金流向？===========WARNING");
				}
			}
			Map<String,Object> sqlMap = new HashMap<String,Object>();
			sqlMap.put("totalFlow", totalFlow);
			sqlMap.put("totalFlowIn", totalFlowIn);
			sqlMap.put("totalFlowOut", totalFlowOut.multiply(new BigDecimal(-1)));
			resultData.setResultMap(sqlMap);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData accountingDetailIndex(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	public ResultData clientflowIndex(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Product product = new Product();
			//兑付完成的产品和新手产品
			product.setStatus(5);
			List<Product> productList = productDao.selectProductByCategory(product);
			resultData.addObject("productList", productList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	public ResultData spvflowIndex(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Product product = new Product();
			product.setStatus(5);
			List<Product> productList = productDao.selectProductByCategory(product);
			List<Organization> orgList = organizationDao.selectAll();
			resultData.addObject("productList", productList);
			resultData.addObject("orgList", orgList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(AccountingDetail accountingDetail){
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
	public ResultData jumpCreate(AccountingDetail accountingDetail){
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
	public ResultData jumpList(AccountingDetail accountingDetail){
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
	public ResultData jumpPaginated(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
}
