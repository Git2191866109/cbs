package com.bs.plugins.custom.tc.productreturnmoney.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.DateUtil;
import com.bs.plugins.custom.cc.spvcorporation.dao.ISpvCorporationDao;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.pc.product.dao.IProductDao;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.productattributeconfig.dao.IProductAttributeConfigDao;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.pc.provider.constants.IProductConst;
import com.bs.plugins.custom.sm.businesssend.dao.IBusinessSendDao;
import com.bs.plugins.custom.tc.platformservicefee.dao.IPlatformServiceFeeDao;
import com.bs.plugins.custom.tc.platformservicefee.entity.PlatformServiceFee;
import com.bs.plugins.custom.tc.productreturnmoney.base.BaseProductReturnMoneyService;
import com.bs.plugins.custom.tc.productreturnmoney.dao.IProductReturnMoneyDao;
import com.bs.plugins.custom.tc.productreturnmoney.entity.ProductReturnMoney;
import com.bs.plugins.custom.tc.spvproductreturnmoney.dao.ISpvProductReturnMoneyDao;
import com.bs.plugins.custom.tc.spvproductreturnmoney.entity.SpvProductReturnMoney;
import com.bs.plugins.thirdparty.umpay.UmPayClient;
import com.bs.plugins.thirdparty.umpay.bean.PaymentData;
import com.bs.plugins.thirdparty.umpay.bean.RequestHelper;
import com.bs.plugins.thirdparty.umpay.constants.IParam;
import com.bs.plugins.thirdparty.umpay.constants.IServiceConst;
import com.umpay.api.common.ReqData;
import com.umpay.api.exception.ReqDataException;

@Service
public class ProductReturnMoneyService extends BaseProductReturnMoneyService<ProductReturnMoney> {
	
	@Autowired
	private IProductReturnMoneyDao productReturnMoneyDao;
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private IProductAttributeConfigDao productAttributeConfigDao;
	
	@Autowired
	private ISpvProductReturnMoneyDao spvProductReturnMoneyDao;
	
	@Autowired
	private IBusinessSendDao businessSendDao;
	
	@Autowired
	private ISpvCorporationDao spvCorporationDao;
	
	@Autowired
	private IPlatformServiceFeeDao platformServiceFeeDao;
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData productReturnMoneyIndex(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	public ResultData businessauditIndex(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Product product = new Product();
			product.setStatus(6);
			List<Product> productList = productDao.selectProductByCategory(product);

			resultData.addObject("productList", productList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	public ResultData financeauditIndex(ProductReturnMoney subscription){
		ResultData resultData = new ResultData();
		try {
			Product product = new Product();
			product.setStatus(6);
			List<Product> productList = productDao.selectProductByCategory(product);
			resultData.addObject("productList", productList);

		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	
	
	public ResultData paginated(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			//业务审核通过
			List<ProductReturnMoney> subscriptionList = productReturnMoneyDao.selectProductReturnMoneyList(productReturnMoney);
			Long subscriptionCount = productReturnMoneyDao.selectProductReturnMoneyCount(productReturnMoney);
			if (subscriptionList != null){
				DecimalFormat a = new DecimalFormat(".##");
				for(ProductReturnMoney temp : subscriptionList){
					String pattern="###,###.##";
					a.applyPattern(pattern);
					temp.setDistributeAmountStr(a.format(temp.getDistributeAmount()));
					temp.setDistributeInterestStr(a.format(temp.getDistributeInterest()));
					temp.setDistributePrincipalStr(a.format(temp.getDistributePrincipal()));
					temp.setActualReturnAmountStr(a.format(temp.getActualReturnAmount()));
				}
				long record = subscriptionCount == null?0:subscriptionCount;
				int pageCount = (int) Math.ceil(record / (double) productReturnMoney.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productReturnMoney.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", subscriptionList);
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
	
	public ResultData objectincomeIndex(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Product product = new Product();
			product.setStatus(6);
			List<Product> productList = productDao.selectProductByCategory(product);
			resultData.addObject("productList", productList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	public ResultData objectIncomePaginated(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			productReturnMoney.setBusinessCheckStatus(1);
			List<ProductReturnMoney> subscriptionList = productReturnMoneyDao.selectPaginatedList(productReturnMoney);
			Long subscriptionCount = productReturnMoneyDao.selectProductReturnMoneyCount(productReturnMoney);
			if (subscriptionList != null){
				DecimalFormat a = new DecimalFormat(".##");
				for(ProductReturnMoney temp : subscriptionList){
					String pattern="###,###.##";
					a.applyPattern(pattern);
					temp.setDistributeAmountStr(a.format(temp.getDistributeAmount()));
					temp.setDistributeInterestStr(a.format(temp.getDistributeInterest()));
					temp.setDistributePrincipalStr(a.format(temp.getDistributePrincipal()));
					temp.setActualReturnAmountStr(a.format(temp.getActualReturnAmount()));
				}
				long record = subscriptionCount == null?0:subscriptionCount;
				int pageCount = (int) Math.ceil(record / (double) productReturnMoney.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productReturnMoney.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", subscriptionList);
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
	
	//更新标的转入状态
	public ResultData modifyObjectIncomeStatus(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		String idStr = productReturnMoney.getIdStr();
		if(productReturnMoney.getId() != null){
			idStr = productReturnMoney.getId().toString();
		}
		boolean bool = false;
		if(idStr != null){
			String[] ids = idStr.split(",");
			if(ids != null && ids.length > 0){
				
				productReturnMoney.setIds(ids);
				List<ProductReturnMoney> subsList = null;
				try {
					subsList = productReturnMoneyDao.selectProductReturnMoneyByIdOrIds(productReturnMoney);
				} catch (Exception e2) {
					e2.printStackTrace();
					resultData.setStatus(IBaseService.FAIL);
					return resultData;
				}
				
				String orderId = "OBJECT"+DateUtil.dateToString(new Date(),DateUtil.DATE_PATTERN);
				String projectId = "";
				String particUserId = "";
				Long productId = 0L;
				Long spvId = 0L;
				String productName = "";
				String productCode = "";
				String interestRateDate = "";
				String paymentDate = "";
				String actualExpirationDate = "";
				BigDecimal expectedProfitRatio = BigDecimal.ZERO;
				BigDecimal actualProfitRatio = BigDecimal.ZERO;
				BigDecimal distributePrincipal = BigDecimal.ZERO;
				BigDecimal distributeInterest = BigDecimal.ZERO;
				BigDecimal distributeAmount = BigDecimal.ZERO;
				
				if(subsList != null && subsList.size() > 0){
					projectId = subsList.get(0).getProductCode();
					particUserId = subsList.get(0).getSpvUmpayMerchantNo();
					productId = subsList.get(0).getProductId();
					spvId = subsList.get(0).getSpvId();
					productName = subsList.get(0).getProductName();
					productCode = subsList.get(0).getProductCode();
					interestRateDate = subsList.get(0).getInterestRateDate();
					paymentDate = subsList.get(0).getPaymentDate();
					actualExpirationDate = subsList.get(0).getActualExpirationDate();
					expectedProfitRatio = subsList.get(0).getExpectedProfitRatio();
					actualProfitRatio = subsList.get(0).getActualProfitRatio();
					
					for(ProductReturnMoney temp : subsList){
						distributeAmount = distributeAmount.add(temp.getDistributeAmount());
						distributeInterest = distributeInterest.add(temp.getDistributeInterest());
						distributePrincipal = distributePrincipal.add(temp.getDistributePrincipal());
					}
				}else{
					resultData.setStatus(IBaseService.FAIL);
					return resultData;
				}
				
				RequestHelper requestHelper = RequestHelper.getInstance(IServiceConst.PROJECT_TRANSFER_NOPWD,"objectincome");
				
				requestHelper.put(IParam.ORDER.ORDER_ID, orderId);
				requestHelper.put(IParam.ORDER.MER_DATE, DateUtil.getCurrentDateString(DateUtil.ISO_DATE_FORMAT));
				requestHelper.put(IParam.PROJECT.PROJECT_ID,projectId);
				requestHelper.put(IParam.PROJECT.SERV_TYPE,"03");
				requestHelper.put(IParam.PROJECT.TRANS_ACTION,"01");
				requestHelper.put(IParam.PROJECT.PARTIC_TYPE,"02");
				requestHelper.put(IParam.PROJECT.PARTIC_ACC_TYPE,"02");
				requestHelper.put(IParam.PROJECT.PARTIC_USER_ID,particUserId);
				requestHelper.put(IParam.ORDER.AMOUNT,distributeAmount.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue()+"");
				
				ReqData reqData;
				try {
					reqData = requestHelper.makeReqDataByGet();
					if(reqData == null){
						resultData.setStatus(IBaseService.FAIL);
						return resultData;
					}
					Map<String,String> field = reqData.getField();
					PaymentData paymentData = UmPayClient.callPaymentPlant(reqData.getUrl(), field);
					if(paymentData != null && paymentData.getRetCode() != null ){
						if(paymentData.getRetCode().equals("0000")){
							bool = true;
							productReturnMoney.setObjectIncomeStatus(1);
						}else{
							productReturnMoney.setObjectIncomeStatus(3);
						}
					}else{
						//转入失败
						productReturnMoney.setObjectIncomeStatus(3);
					}
					
					SpvProductReturnMoney spvProductReturnMoney = new SpvProductReturnMoney();
					spvProductReturnMoney.setProductId(productId);
					spvProductReturnMoney.setSpvId(spvId);
					spvProductReturnMoney.setTransactionNumber(orderId);
					spvProductReturnMoney.setProductCode(productCode);
					spvProductReturnMoney.setProductName(productName);
					spvProductReturnMoney.setDistributeAmount(distributeAmount.setScale(2, RoundingMode.HALF_UP));
					spvProductReturnMoney.setDistributeInterest(distributeInterest);
					spvProductReturnMoney.setDistributePrincipal(distributePrincipal);
					spvProductReturnMoney.setActualExpirationDate(actualExpirationDate);
					spvProductReturnMoney.setActualProfitRatio(actualProfitRatio);
					spvProductReturnMoney.setInterestRateDate(interestRateDate);
					spvProductReturnMoney.setPaymentDate(paymentDate);
					spvProductReturnMoney.setExpectedProfitRatio(expectedProfitRatio);
					if(productReturnMoney.getObjectIncomeStatus() == 1){
						spvProductReturnMoney.setIntoObjectStatus(1);
					}else if(productReturnMoney.getObjectIncomeStatus() == 3){
						spvProductReturnMoney.setIntoObjectStatus(3);
					}
					try {
						spvProductReturnMoneyDao.insert(spvProductReturnMoney);
					} catch (Exception e1) {
						e1.printStackTrace();
						resultData.setStatus(IBaseService.FAIL);
						return resultData;
					}
					
					try {
						productReturnMoney.setObjectIncomeNumber(orderId);
						productReturnMoney.setSpvIntoObjectId(spvProductReturnMoney.getGeneratedKey());
						int result = productReturnMoneyDao.updateObjectIncomeStatusByIds(productReturnMoney);
						if(result == subsList.size() && bool){
							resultData.setStatus(IBaseService.SUCCESS);
							return resultData;
						}
					} catch (Exception e) {
						e.printStackTrace();
						resultData.setStatus(IBaseService.FAIL);
						return resultData;
					}
					
				} catch (ReqDataException e1) {
					e1.printStackTrace();
					resultData.setStatus(IBaseService.FAIL);
					return resultData;
				}
	
			}
		}
		resultData.setStatus(IBaseService.FAIL);
		return resultData;
		
	}
	
	/**
	 * 更新返款状态
	 * @param productReturnMoney
	 * @return
	 */
	public ResultData modifyReturnStatus(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		String idStr = productReturnMoney.getIdStr();
		if(productReturnMoney.getId() != null){
			idStr = productReturnMoney.getId().toString();
		}
		if(idStr != null){
			String[] ids = idStr.split(",");
			if(ids != null && ids.length > 0){
				
				productReturnMoney.setIds(ids);
				List<ProductReturnMoney> subsList = null;
				try {
					subsList = productReturnMoneyDao.selectProductReturnMoneyByIdOrIds(productReturnMoney);
				} catch (Exception e2) {
					e2.printStackTrace();
					resultData.setStatus(IBaseService.FAIL);
					return resultData;
				}
				
				if(subsList != null && subsList.size() > 0){
					for(ProductReturnMoney temp : subsList){
						String orderId = "RETURN"+DateUtil.dateToString(new Date(),DateUtil.DATE_PATTERN)+temp.getId();
						productReturnMoney = new ProductReturnMoney();
						
						RequestHelper requestHelper = RequestHelper.getInstance(IServiceConst.PROJECT_TRANSFER,"returnmoney");
						requestHelper.put(IParam.ORDER.ORDER_ID, orderId);
						requestHelper.put(IParam.ORDER.MER_DATE, DateUtil.getCurrentDateString(DateUtil.ISO_DATE_FORMAT));
						requestHelper.put(IParam.PROJECT.PROJECT_ID,temp.getProductCode());
						requestHelper.put(IParam.PROJECT.SERV_TYPE,"54");
						requestHelper.put(IParam.PROJECT.TRANS_ACTION,"02");
						requestHelper.put(IParam.PROJECT.PARTIC_TYPE,"01");
						requestHelper.put(IParam.PROJECT.PARTIC_ACC_TYPE,"01");
						requestHelper.put(IParam.PROJECT.PARTIC_USER_ID,temp.getUmpayUserNo());
						if(temp.getActualReturnAmount() != null){
							requestHelper.put(IParam.ORDER.AMOUNT,temp.getActualReturnAmount().setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue()+"");
						}
						
						ReqData reqData;
						try {
							reqData = requestHelper.makeReqDataByGet();
							if(reqData == null){
								resultData.setStatus(IBaseService.FAIL);
								return resultData;
							}
							Map<String,String> field = reqData.getField();
							PaymentData paymentData = UmPayClient.callPaymentPlant(reqData.getUrl(), field);
							if(paymentData != null && paymentData.getRetCode() != null ){
								if(paymentData.getRetCode().equals("0000")){
									productReturnMoney.setReturnStatus(1);;
									//返款支付学费帮服务费
									if(temp.getMemberServiceFee().compareTo(BigDecimal.ZERO) > 0){
										payReturnServiceFee(temp.getProductCode(), temp.getMemberServiceFee(), temp.getId(), temp.getDistributePrincipal(), temp.getSpvId(), temp.getProductId(), temp.getMemberServiceFeeRatio());
									}
								}else{
									productReturnMoney.setReturnStatus(3);
								}
							}else{
								//转入失败
								productReturnMoney.setReturnStatus(3);
							}
							
							try {
								productReturnMoney.setId(temp.getId());
								productReturnMoney.setReturnNumber(orderId);
								productReturnMoneyDao.updateReturnStatusById(productReturnMoney);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
						} catch (ReqDataException e1) {
							e1.printStackTrace();
							resultData.setStatus(IBaseService.FAIL);
							return resultData;
						}
					}
					resultData.setStatus(IBaseService.SUCCESS);
				}
			}else{
				resultData.setStatus(IBaseService.FAIL);
			}
			//通过
			return resultData;
		}else{
			resultData.setStatus(IBaseService.FAIL);
			return resultData;
		}
		
	}
	
	//返款支付手续费
	public void payReturnServiceFee(String projectId,BigDecimal serviceFee,Long returnMoneyId,BigDecimal investAmount,Long spvId,Long productId,BigDecimal serviceFeeRatio){
		String tradeNumber = "RETURNFEE"+DateUtil.dateToString(new Date(),DateUtil.DATE_PATTERN)+returnMoneyId;
		Long platformId = 0L;
		SpvCorporation corporation = new SpvCorporation();
		corporation.setType(2);
		try {
			List<SpvCorporation> corporationList = spvCorporationDao.selectList(corporation);
			if(corporationList.size() > 0){
				corporation = corporationList.get(0);
				platformId = corporation.getId();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		RequestHelper requestHelper = RequestHelper.getInstance(IServiceConst.PROJECT_TRANSFER,"returnfee");
		
		//放款交易号
		requestHelper.put(IParam.ORDER.ORDER_ID, tradeNumber);
		requestHelper.put(IParam.ORDER.MER_DATE, DateUtil.getCurrentDateString(DateUtil.ISO_DATE_FORMAT));
		requestHelper.put(IParam.PROJECT.PROJECT_ID, projectId);
		requestHelper.put(IParam.PROJECT.SERV_TYPE,"52");
		requestHelper.put(IParam.PROJECT.TRANS_ACTION,"02");
		requestHelper.put(IParam.PROJECT.PARTIC_TYPE,"03");
		requestHelper.put(IParam.PROJECT.PARTIC_ACC_TYPE,"02");
		requestHelper.put(IParam.PROJECT.PARTIC_USER_ID,RequestHelper.getProperty(IParam.PUB.MER_ID));
		requestHelper.put(IParam.ORDER.AMOUNT,serviceFee.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue()+"");
		ReqData reqData = null;
		try {
			reqData = requestHelper.makeReqDataByGet();
		} catch (ReqDataException e1) {
			e1.printStackTrace();
		}
		PaymentData paymentData = UmPayClient.callPaymentPlant(reqData.getUrl(), null);
		if(paymentData != null && paymentData.getRetCode() != null){
			PlatformServiceFee service = new PlatformServiceFee();
			if(paymentData.getRetCode().equals("0000")){
				service.setTakeStatus(1);
			}else{
				service.setTakeStatus(3);
			}
			service.setPlatformId(platformId);
			service.setReturnMoneyId(returnMoneyId);
			service.setTradeNumber(tradeNumber);
			service.setPrincipalAmount(investAmount);
			service.setProductId(productId);
			service.setServiceFee(serviceFee.setScale(2, RoundingMode.HALF_UP));
			service.setServiceFeeRatio(serviceFeeRatio);
			service.setSpvId(spvId);
			service.setTakeTime(DateUtil.getCurrentDateString());
			try {
				platformServiceFeeDao.insert(service);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public ResultData modify(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		String idStr = productReturnMoney.getIdStr();
		if(productReturnMoney.getId() != null){
			idStr = productReturnMoney.getId().toString();
		}
		if(idStr != null){
			String[] ids = idStr.split(",");
			productReturnMoney.setIds(ids);
			try {
				int result = productReturnMoneyDao.updateByIdOrIds(productReturnMoney);
				if(result > 0 ){
					resultData.setStatus(IBaseService.SUCCESS);
					return resultData;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resultData.setStatus(IBaseService.FAIL);
		return resultData;
	}
	
	public ResultData financeAuditPaginated(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			productReturnMoney.setObjectIncomeStatus(2);
			List<ProductReturnMoney> subscriptionList = productReturnMoneyDao.selectProductReturnMoneyList(productReturnMoney);
			Long subscriptionCount = productReturnMoneyDao.selectProductReturnMoneyCount(productReturnMoney);
			if (subscriptionList != null){
				DecimalFormat a = new DecimalFormat(".##");
				for(ProductReturnMoney temp : subscriptionList){
					String pattern="###,###.##";
					a.applyPattern(pattern);
					temp.setDistributeAmountStr(a.format(temp.getDistributeAmount()));
					temp.setDistributeInterestStr(a.format(temp.getDistributeInterest()));
					temp.setDistributePrincipalStr(a.format(temp.getDistributePrincipal()));
					temp.setActualReturnAmountStr(a.format(temp.getActualReturnAmount()));
				}
				long record = subscriptionCount == null?0:subscriptionCount;
				int pageCount = (int) Math.ceil(record / (double) productReturnMoney.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productReturnMoney.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", subscriptionList);
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
	
	public ResultData jumpProductReturnMoneyRemark(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			ProductReturnMoney subscriptionTemp = productReturnMoneyDao.selectOneById(productReturnMoney);
			if (subscriptionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productReturnMoney", subscriptionTemp);
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
	
	public ResultData ajaxSearch(ProductReturnMoney productReturnMoney){
		//实际总利息
		BigDecimal totalInterest = BigDecimal.ZERO;
		//实际总本息
		BigDecimal totalPrincipalAndInterest = BigDecimal.ZERO;
		//预计总本息
		BigDecimal totalExceptionPrincipalAndInterest = BigDecimal.ZERO;
		//本金
		BigDecimal totalInvestAmount = BigDecimal.ZERO;
		//产品总份额
		Integer total_amount = 0;
		//预期收益率
		String cash_profit_ratio = "";
		//基础产品起息日期
		String interestrate_date = "";
		//实际止息日期
		String cash_stopinterest_date = "";
		String start_yielddelay_days = "";
		ResultData resultData = new ResultData();
		productReturnMoney.setObjectIncomeStatus(2);
		try {
			List<ProductReturnMoney> subscriptionList = productReturnMoneyDao.selectProductReturnMoneyList(productReturnMoney);
			if (subscriptionList != null){
				//-------------------统计数据-------------------------------
				for(ProductReturnMoney temp : subscriptionList){
					if(temp.getDistributeAmount()!= null ){
						totalPrincipalAndInterest = totalPrincipalAndInterest.add(temp.getDistributeAmount());
					}else{
						System.out.print("======================存在投资金额为空的交易？=================WARNING");;
					}
					
					if(temp.getDistributePrincipal() != null && temp.getExpectedProfit() != null){
						totalExceptionPrincipalAndInterest = totalExceptionPrincipalAndInterest.add(temp.getDistributePrincipal()).add(temp.getExpectedProfit());
					}
					
					if(temp.getDistributeInterest() != null){
						totalInterest = totalInterest.add(temp.getDistributeInterest());
					}
					if(temp.getDistributePrincipal() != null){
						totalInvestAmount = totalInvestAmount.add(temp.getDistributePrincipal());
					}
				}
				
				Map<String,Object> resultMap = new HashMap<String, Object>();
				resultMap.put("totalInvestAmount", totalInvestAmount);
				resultMap.put("totalInterest", totalInterest);
				resultMap.put("totalPrincipalAndInterest", totalPrincipalAndInterest);
				resultMap.put("totalExceptionPrincipalAndInterest", totalExceptionPrincipalAndInterest);
				Long subscriptionCount = productReturnMoneyDao.selectProductReturnMoneyCount(productReturnMoney);
				resultMap.put("count", subscriptionCount);
				
				if(productReturnMoney.getProductId() != null){
					ProductAttributeConfig config = new ProductAttributeConfig();
					config.setProductId(productReturnMoney.getProductId());
					
					List<ProductAttributeConfig> productAttributeConfigList = productAttributeConfigDao.selectProductAttributeConfigInfoByProductId(config);
					
					Product basic = new Product();
					basic.setId(productReturnMoney.getProductId());
					List<Product> productList = productDao.selectBasicProductByProductId(basic);
					if(productList != null && productList.size() > 0){
						basic = productList.get(0);
						interestrate_date = basic.getInterestRateData();
						total_amount = basic.getTotalAmount();
					}
					//循环取产品属性对应的值
					for(ProductAttributeConfig temp : productAttributeConfigList){
						//实际收益率
						if(temp.getCode().equals(IProductConst.ATTR_CODE_CASH_YIDLD_RATE)){
							cash_profit_ratio = temp.getAttributeValue();
						}
						//延迟起息天数
						if(temp.getCode().equals(IProductConst.ATTR_CODE_STARTYIELDDELAY_DAYS)){
							start_yielddelay_days = temp.getAttributeValue();
						}
						//实际止息日期
						if(temp.getCode().equals(IProductConst.ATTR_CODE_CASH_STOPINTEREST_DATE)){
							cash_stopinterest_date = temp.getAttributeValue();
						}
					}
					if(cash_profit_ratio == null || cash_profit_ratio.equals("")){
						cash_profit_ratio = "0";
					}
					if(interestrate_date == null || interestrate_date.equals("")){
						interestrate_date = DateUtil.dateToString(new Date());
					}
					if(cash_stopinterest_date == null || cash_stopinterest_date.equals("")){
						cash_stopinterest_date = DateUtil.dateToString(new Date());
					}
					int days = DateUtil.daysBetween(DateUtil.stringToDate(interestrate_date),DateUtil.stringToDate(cash_stopinterest_date)) - Integer.valueOf(start_yielddelay_days);
					BigDecimal totalAmount = (new BigDecimal(cash_profit_ratio)).multiply(new BigDecimal(total_amount))
							.multiply(new BigDecimal(days)).divide(new BigDecimal(365), 2, RoundingMode.HALF_UP).add(new BigDecimal(total_amount));
					
					resultMap.put("totalAmount", totalAmount);
	
				}
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.setResultMap(resultMap);
			}
		} catch (Exception e) {
			resultData.setStatus(IBaseService.FAIL);
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(ProductReturnMoney productReturnMoney){
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
	public ResultData jumpCreate(ProductReturnMoney productReturnMoney){
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
	public ResultData jumpList(ProductReturnMoney productReturnMoney){
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
	public ResultData jumpPaginated(ProductReturnMoney productReturnMoney){
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
