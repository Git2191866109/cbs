package com.bs.plugins.custom.tc.subscription.service;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.DateUtil;
import com.bs.core.utils.ExportExcel;
import com.bs.plugins.custom.cc.spvcorporation.dao.ISpvCorporationDao;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.pc.category.dao.ICategoryDao;
import com.bs.plugins.custom.pc.category.entity.Category;
import com.bs.plugins.custom.pc.product.dao.IProductDao;
import com.bs.plugins.custom.pc.productattributeconfig.dao.IProductAttributeConfigDao;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.pc.provider.constants.IProductConst;
import com.bs.plugins.custom.pc.provider.impl.ProductProxyServiceImpl;
import com.bs.plugins.custom.tc.loan.dao.ILoanDao;
import com.bs.plugins.custom.tc.loan.entity.Loan;
import com.bs.plugins.custom.tc.platformservicefee.dao.IPlatformServiceFeeDao;
import com.bs.plugins.custom.tc.platformservicefee.entity.PlatformServiceFee;
import com.bs.plugins.custom.tc.productreturnmoney.dao.IProductReturnMoneyDao;
import com.bs.plugins.custom.tc.subscription.base.BaseSubscriptionService;
import com.bs.plugins.custom.tc.subscription.dao.ISubscriptionDao;
import com.bs.plugins.custom.tc.subscription.entity.Subscription;
import com.bs.plugins.thirdparty.umpay.UmPayClient;
import com.bs.plugins.thirdparty.umpay.bean.PaymentData;
import com.bs.plugins.thirdparty.umpay.bean.RequestHelper;
import com.bs.plugins.thirdparty.umpay.constants.IParam;
import com.bs.plugins.thirdparty.umpay.constants.IServiceConst;
import com.umpay.api.common.ReqData;
import com.umpay.api.exception.ReqDataException;

@Service
public class SubscriptionService extends BaseSubscriptionService<Subscription> {
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private ISubscriptionDao subscriptionDao;
	
	@Autowired
	private IProductAttributeConfigDao productAttributeConfigDao;
	
	@Autowired
	private ProductProxyServiceImpl productProxyServiceImpl;
	
	@Autowired
	private IProductReturnMoneyDao productReturnMoneyDao;
	
	@Autowired
	private ILoanDao loanDao;
	
	@Autowired
	private IPlatformServiceFeeDao platformServiceFeeDao;
	
	@Autowired
	private ISpvCorporationDao spvCorporationDao;
	
	@Resource
	public DelegatingMessageSource messageSource;
	
	public ResultData modify(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.updateRemarkById(subscription);
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
	
	public ResultData modifyPaymentNote(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Integer result = subscriptionDao.updateRemarkById(subscription);
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
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData subscriptionIndex(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			List<Category> categoryList = categoryDao.selectList(new Category());
			resultData.addObject("categoryList", categoryList);

			if(subscription.getProductId() != null ) {
				resultData.addObject("productId",subscription.getProductId());
			}
			if(subscription.getOrderTime() != null ) {
				resultData.addObject("orderTime",subscription.getOrderTime());
			}
			//add your code
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
	public ResultData statisticsIndex(Subscription subscription){
		ResultData resultData = new ResultData();
		final String categoryId = subscription.getRemark();
		try {
			List<Map<String, Object>> subscriptionList = this.getSubscriptionDao().statisticsSubscriptionRecord(new HashMap<String, String>() {{
				put("categoryId", categoryId);
				put("condition", "CategoryId, ProductId");
			}});

			if(subscriptionList != null && subscriptionList.size() > 0) {
				resultData.addObject("newProductInvestAmount",subscriptionList.get(0).get("InvestAmount"));
				resultData.addObject("newProductorderCount",subscriptionList.get(0).get("orderCount"));
			}

			if("1".equals(categoryId)) {
				subscriptionList.clear();
				List<Map<String, Object>> newplayerInfoList = this.getSubscriptionDao().statisticsSubscriptionRecord(new HashMap<String, String>() {{
					put("categoryId", categoryId);
					put("condition", "CategoryId, ProductId, orderDate");
				}});

				if(newplayerInfoList != null && newplayerInfoList.size() > 0) {
					if (StringUtils.isNotBlank((String) newplayerInfoList.get(0).get("OrderDate"))) {
						subscriptionList.addAll(newplayerInfoList);
					}
				}
			}

//
//			long record = subscriptionCount == null?0:subscriptionCount;
//			int pageCount = (int) Math.ceil(record / (double) subscription.getRows());
			Map<String, Object> gridMap = new Hashtable<String, Object>();
			gridMap.put("page", subscription.getPage());
//			gridMap.put("total", "订单数");
//			gridMap.put("records", record);
			gridMap.put("rows", subscriptionList);
			resultData.setResultMap(gridMap);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}


	
	//交易列表
	public ResultData paginated(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			List<Subscription> subscriptionList = subscriptionDao.selectSubscriptionPaginated(subscription);
			Long subscriptionCount = subscriptionDao.selectSubscriptionCount(subscription);
			if (subscriptionList != null){
				DecimalFormat a = new DecimalFormat(".##");
				for(Subscription temp : subscriptionList){
					String pattern="###,###.##";
					a.applyPattern(pattern);
					temp.setInvestAmountStr(a.format(temp.getInvestAmount()));
				}
				long record = subscriptionCount == null?0:subscriptionCount;
				int pageCount = (int) Math.ceil(record / (double) subscription.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", subscription.getPage());
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
	
	//交易查询
	public ResultData ajaxSubscriptionSearch(Subscription subscription){
		ResultData resultData = new ResultData();
		BigDecimal totalExpectedProfit = BigDecimal.ZERO;
		BigDecimal totalInvestAmount = BigDecimal.ZERO;
		BigDecimal actualLoanAmount = BigDecimal.ZERO;
		String averageExpectedProfitRatio = "";
		try {
			List<Subscription> subscriptionList = subscriptionDao.selectSubscriptionPaginated(subscription);
			Long subscriptionCount = subscriptionDao.selectSubscriptionCount(subscription);
			if (subscriptionList != null){
				
				for(Subscription temp :subscriptionList){
					
					if(temp.getExpectedProfit() != null){
						totalExpectedProfit = totalExpectedProfit.add(temp.getExpectedProfit());
					}
					if(temp.getInvestAmount() != null){
						totalInvestAmount = totalInvestAmount.add(temp.getInvestAmount());
					}
					if(temp.getActualLoanAmount() != null){
						actualLoanAmount = actualLoanAmount.add(temp.getActualLoanAmount());
					}
				}
				if(totalInvestAmount.compareTo(BigDecimal.ZERO) > 0){
					averageExpectedProfitRatio = totalExpectedProfit.multiply(new BigDecimal(100))
							.divide(totalInvestAmount, 2, RoundingMode.HALF_UP)+"%";
				}else{
					averageExpectedProfitRatio = 0.00+"%";
				}
				DecimalFormat a = new DecimalFormat(".##");
				String pattern="###,###.##";
				a.applyPattern(pattern);
				Map<String, Object> resultMap = new Hashtable<String, Object>();
				resultMap.put("totalExpectedProfit", a.format(totalExpectedProfit));
				resultMap.put("totalInvestAmount", a.format(totalInvestAmount));
				resultMap.put("averageExpectedProfitRatio", averageExpectedProfitRatio);
				resultMap.put("totalActualLoanAmount", a.format(actualLoanAmount));
				resultMap.put("totalAmount", a.format(totalExpectedProfit.add(totalInvestAmount)));
				resultMap.put("count", subscriptionCount);
				resultData.setResultMap(resultMap);
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
	
	//标的账户转账到spv公司账户  手续费转到学费帮账户
	public ResultData modifyLoanTransfer(Subscription subscription){
		ResultData resultData = new ResultData();
		String idStr = subscription.getIdStr();
		if(idStr != null){
			String[] ids = idStr.split(",");
			if(ids != null && ids.length > 0){
				subscription.setIds(ids);
				List<Subscription> subsList = null;
				try {
					subsList = subscriptionDao.selectSubscriptionByIdOrIds(subscription);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				String projectId = "";
				String particUserId = "";
				Long spvId;
				Long productId;
				String productName = "";
				String productCode = "";
				BigDecimal serviceFeeRatio = BigDecimal.ZERO;
				BigDecimal loanAmount = BigDecimal.ZERO;
				BigDecimal loanCommissionFee = BigDecimal.ZERO;
				BigDecimal totalInvestAmount = BigDecimal.ZERO;
				if(subsList != null && subsList.size() > 0){
					projectId = subsList.get(0).getProductCode();
					particUserId = subsList.get(0).getSpvUmpayMerchantNo();
					spvId = subsList.get(0).getSpvId();
					productId = subsList.get(0).getProductId();
					productName = subsList.get(0).getProductName();
					productCode = subsList.get(0).getProductCode();
					serviceFeeRatio = subsList.get(0).getSpvServiceFeeRatio();
					String[] idsArr = new String[subsList.size()];
					for(int i = 0;i < subsList.size();i++){
						if(productId != subsList.get(i).getProductId()){
							break;
						}
						idsArr[i] = subsList.get(i).getId().toString();
						if(subsList.get(i).getActualLoanAmount() != null){
							loanAmount = loanAmount.add(subsList.get(i).getActualLoanAmount());
						}
						if(subsList.get(i).getSpvServiceFee() != null){
							loanCommissionFee = loanCommissionFee.add(subsList.get(i).getSpvServiceFee());
						}
						if(subsList.get(i).getInvestAmount() != null){
							totalInvestAmount = totalInvestAmount.add(subsList.get(i).getInvestAmount());
						}
					}
					subscription.setIds(idsArr);
				}else{
					resultData.setStatus(IBaseService.FAIL);
					return resultData;
				}
				
				String tradeNumber = "LOAN"+DateUtil.dateToString(new Date(),DateUtil.DATE_PATTERN);
				RequestHelper requestHelper = RequestHelper.getInstance(IServiceConst.PROJECT_TRANSFER,"loan");
				//放款交易号
				requestHelper.put(IParam.ORDER.ORDER_ID, tradeNumber);
				requestHelper.put(IParam.ORDER.MER_DATE, DateUtil.getCurrentDateString(DateUtil.ISO_DATE_FORMAT));
				requestHelper.put(IParam.PROJECT.PROJECT_ID, projectId);
				requestHelper.put(IParam.PROJECT.SERV_TYPE,"53");
				requestHelper.put(IParam.PROJECT.TRANS_ACTION,"02");
				requestHelper.put(IParam.PROJECT.PARTIC_TYPE,"02");
				requestHelper.put(IParam.PROJECT.PARTIC_ACC_TYPE,"02");
				requestHelper.put(IParam.PROJECT.PARTIC_USER_ID,particUserId);
				requestHelper.put(IParam.ORDER.AMOUNT,loanAmount.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue()+"");
				ReqData reqData = null;
				try {
					reqData = requestHelper.makeReqDataByGet();
					if(reqData == null){
						resultData.setStatus(IBaseService.FAIL);
						return resultData;
					}
				} catch (ReqDataException e1) {
					e1.printStackTrace();
				}
				Map<String,String> field = reqData.getField();
				PaymentData paymentData = UmPayClient.callPaymentPlant(reqData.getUrl(), null);
				Long loanId = 0L;
				if(paymentData != null && paymentData.getRetCode() != null){
					if(paymentData.getRetCode().equals("0000")){
						//存放款表一条记录
						Loan loan = new Loan();
						loan.setTotalLoanAmount(loanAmount.setScale(2, RoundingMode.HALF_UP));
						loan.setSpvId(spvId);
						loan.setProductId(productId);
						loan.setTradeNumber(tradeNumber);
						loan.setLoanStatus(1);
						loan.setProductName(productName);
						loan.setProductCode(productCode);
						loan.setSpvServiceFee(loanCommissionFee);
						loan.setSpvServiceFeeRatio(serviceFeeRatio);
						loan.setRemark("放款总额："+totalInvestAmount.setScale(2, RoundingMode.HALF_UP)+"元,其中收取服务费："+loanCommissionFee.setScale(2, RoundingMode.HALF_UP)+"元");
						try {
							int result = loanDao.insert(loan);
							if(result > 0){
								subscription.setLoanStatus(1);
								loanId = loan.getGeneratedKey();
							}else{
								subscription.setLoanStatus(3);
							}
						} catch (Exception e) {
							resultData.setStatus(IBaseService.FAIL);
							e.printStackTrace();
						}
						//手续费
						if(loanCommissionFee.compareTo(BigDecimal.ZERO) > 0){
							
							String serviceTradeNumber = "LOANFEE"+DateUtil.dateToString(new Date(),DateUtil.DATE_PATTERN);
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
							RequestHelper serviceRequestHelper = RequestHelper.getInstance(IServiceConst.PROJECT_TRANSFER,"loanfee");
							//放款交易号
							serviceRequestHelper.put(IParam.ORDER.ORDER_ID, serviceTradeNumber);
							serviceRequestHelper.put(IParam.ORDER.MER_DATE, DateUtil.getCurrentDateString(DateUtil.ISO_DATE_FORMAT));
							serviceRequestHelper.put(IParam.PROJECT.PROJECT_ID, projectId.toString());
							serviceRequestHelper.put(IParam.PROJECT.SERV_TYPE,"52");
							serviceRequestHelper.put(IParam.PROJECT.TRANS_ACTION,"02");
							serviceRequestHelper.put(IParam.PROJECT.PARTIC_TYPE,"03");
							serviceRequestHelper.put(IParam.PROJECT.PARTIC_ACC_TYPE,"02");
							serviceRequestHelper.put(IParam.PROJECT.PARTIC_USER_ID,RequestHelper.getProperty(IParam.PUB.MER_ID));
							serviceRequestHelper.put(IParam.ORDER.AMOUNT,loanCommissionFee.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue()+"");
							ReqData reqDataService = null;
							try {
								reqDataService = serviceRequestHelper.makeReqDataByGet();
							} catch (ReqDataException e1) {
								e1.printStackTrace();
							}
							PaymentData paymentDataService = UmPayClient.callPaymentPlant(reqDataService.getUrl(), null);
							if(paymentDataService != null && paymentDataService.getRetCode() != null){
								PlatformServiceFee service = new PlatformServiceFee();
								if(paymentDataService.getRetCode().equals("0000")){
									service.setTakeStatus(1);
								}else{
									service.setTakeStatus(3);
								}
								service.setPlatformId(platformId);
								service.setSpvLoanId(loanId);
								service.setTradeNumber(serviceTradeNumber);
								service.setPrincipalAmount(totalInvestAmount);
								service.setProductId(productId);
								service.setServiceFee(loanCommissionFee.setScale(2, RoundingMode.HALF_UP));
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
					}else{
						subscription.setLoanStatus(3);
					}
				}else{
					subscription.setLoanStatus(3);
				}
				
				try {
					subscription.setLoanNumber(tradeNumber);
					if(loanId != 0){
						subscription.setLoanId(loanId);
					}
					int result = subscriptionDao.updateLoanStatusByIds(subscription);
					if(result == subsList.size() && paymentData.getRetCode().equals("0000")){
						resultData.setStatus(IBaseService.SUCCESS);
					}else{
						resultData.setStatus(IBaseService.FAIL);
					}
				} catch (Exception e) {
					resultData.setStatus(IBaseService.FAIL);
					e.printStackTrace();
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
	
	//学费帮服务费支付业务
	public void payLoanServiceFee(Long projectId,BigDecimal serviceFee,BigDecimal investAmount,BigDecimal serviceFeeRatio,Long loanId,Long productId,Long spvId){
		String tradeNumber = "LOANFEE"+DateUtil.dateToString(new Date(),DateUtil.DATE_PATTERN);
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
		RequestHelper requestHelper = RequestHelper.getInstance(IServiceConst.PROJECT_TRANSFER,"53-1");
		//放款交易号
		requestHelper.put(IParam.ORDER.ORDER_ID, tradeNumber);
		requestHelper.put(IParam.ORDER.MER_DATE, DateUtil.getCurrentDateString(DateUtil.ISO_DATE_FORMAT));
		requestHelper.put(IParam.PROJECT.PROJECT_ID, projectId.toString());
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
			service.setSpvLoanId(loanId);
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
	
	public ResultData refuseLoan(Subscription subscription){
		ResultData resultData = new ResultData();
		String idStr = subscription.getIdStr();
		if(idStr != null){
			String[] ids = idStr.split(",");
			if(ids != null && ids.length > 0){
				subscription.setLoanStatus(4);
				subscription.setLoanTime(DateUtil.getCurrentDateString());
				subscription.setIds(ids);
				try {
					Integer count = subscriptionDao.updateLoanStatusByIds(subscription);
					if(count == ids.length){
						resultData.setStatus(IBaseService.SUCCESS);
					}else{
						resultData.setStatus(IBaseService.FAIL);
					}
				} catch (Exception e) {
					resultData.setStatusException(e.getMessage());
					resultData.setStatus(IBaseService.FAIL);
					e.printStackTrace();
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
	
	public ResultData ajaxSearch(Subscription subscription){
		//实际总本金
		BigDecimal totalPrincipal = BigDecimal.ZERO;
		//实际总利息
		BigDecimal totalInterest = BigDecimal.ZERO;
		//实际总本息
		BigDecimal totalPrincipalAndInterest = BigDecimal.ZERO;
		//预计总利息
		BigDecimal totalExpectedInterest = BigDecimal.ZERO;
		//预计总本息
		BigDecimal totalExceptionPrincipalAndInterest = BigDecimal.ZERO;
		
		//产品总份额
		Integer total_amount = 0;
		//预期收益率
		String cash_profit_ratio = "";
		//基础产品起息日期
		String interestrate_date = "";
		//实际止息日期
		String cash_stopinterest_date = "";
		//起息延迟天数
		String start_yielddelay_days = "";
		
		ResultData resultData = new ResultData();
		try {
			List<Subscription> subscriptionList = subscriptionDao.selectBusinessauditPaginated(subscription);
			if (subscriptionList != null){
				//-------------------统计数据-------------------------------
				for(Subscription temp : subscriptionList){
					if(temp.getInvestAmount() != null){
						totalPrincipal = totalPrincipal.add(temp.getInvestAmount());
//						totalInterest = totalInterest.add(temp.getActualProfit());
						totalExpectedInterest = totalExpectedInterest.add(temp.getExpectedProfit());
					}else{
						System.out.print("======================存在投资金额为空的交易？=================WARNING");;
					}
				}
				
				totalPrincipalAndInterest = totalPrincipal.add(totalInterest);
				totalExceptionPrincipalAndInterest = totalExpectedInterest.add(totalPrincipal);
				Map<String,Object> resultMap = new HashMap<String, Object>();
				resultMap.put("totalPrincipal", totalPrincipal);
				resultMap.put("totalInterest", totalInterest);
				resultMap.put("totalPrincipalAndInterest", totalPrincipalAndInterest);
				resultMap.put("totalExceptionPrincipalAndInterest", totalExceptionPrincipalAndInterest);
				Long subscriptionCount = subscriptionDao.selectBusinessauditCount(subscription);
				resultMap.put("count", subscriptionCount);
				
				ProductAttributeConfig config = new ProductAttributeConfig();
				config.setProductId(subscription.getProductId());
				
				List<ProductAttributeConfig> productAttributeConfigList = productAttributeConfigDao.selectProductAttributeConfigInfoByProductId(config);
				
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
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.setResultMap(resultMap);
			}
		} catch (Exception e) {
			resultData.setStatus(IBaseService.FAIL);
			e.printStackTrace();
		}
		return resultData;
	}
	
	public ResultData businessauditPaginated(Subscription subscription){
		
		ResultData resultData = new ResultData();
		try {
			List<Subscription> subscriptionList = subscriptionDao.selectBusinessauditPaginated(subscription);
			Long subscriptionCount = subscriptionDao.selectBusinessauditCount(subscription);
			if (subscriptionList != null){
				long record = subscriptionCount == null?0:subscriptionCount;
				int pageCount = (int) Math.ceil(record / (double) subscription.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", subscription.getPage());
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
	
	
	/**跳转到修改页**/
	public ResultData jumpModify(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Subscription subscriptionTemp = subscriptionDao.selectOneById(subscription);
			if (subscriptionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subscription", subscriptionTemp);
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
	
	public ResultData jumpBusinessauditRemark(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Subscription subscriptionTemp = subscriptionDao.selectOneById(subscription);
			if (subscriptionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subscription", subscriptionTemp);
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
	
	public ResultData jumpDetail(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			Subscription subscriptionTemp = subscriptionDao.selectOneSubscriptionById(subscription);
			if (subscriptionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				if(subscriptionTemp.getiDCard() != null){
					subscriptionTemp.setiDCard(subscriptionTemp.getiDCard().substring(0, 4)+"**********"+subscriptionTemp.getiDCard().substring(14));
				}
				resultData.addObject("subscription", subscriptionTemp);
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
	
	/**跳转到创建页**/
	public ResultData jumpCreate(Subscription subscription){
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
	public ResultData jumpList(Subscription subscription){
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
	public ResultData jumpPaginated(Subscription subscription){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData export(Subscription subscription){
		
		ResultData resultData = new ResultData();
		HttpServletRequest request = subscription.getHttpServletRequest();
		Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		String colName = messageSource.getMessage("subscription.colName", null, locale);
		String colModel = messageSource.getMessage("subscription.colModel", null, locale);
		String[] colNames = colName.split(",");
		String[] colModels = colModel.split(",");
		int colNameNum = colNames.length;
		int colModelNum = colModels.length;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String temp = sdf.format(new Date());
		String fileName =temp+ "Excel.xls";
		String realPath = subscription.getHttpServletRequest().getSession().getServletContext().getRealPath("/");
		String excelPath = realPath +"WEB-INF"+ File.separator+ "exportfile";
		File file = new File(excelPath+File.separator+fileName);
		
		WritableWorkbook excel = null;
		String[] ids = subscription.getIdStr().split(",");
		subscription.setIds(ids);
		List<Map<String, Object>> objList = null;
		try {
			objList = subscriptionDao.financeauditExport(subscription);
			if(objList != null && objList.size() == 0){
				return null;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String excelName = objList.get(0).get("productName").toString()+"的交易列表";
		ExportExcel exportExcel = new ExportExcel();
		try {
			
			excel = Workbook.createWorkbook(file);
			excel = exportExcel.createExcel(excelName, colNames, colNameNum,
					colModels, colModelNum, objList, excel);
			excel.write();
			excel.close();
			
			resultData.setDownloadFileName(fileName);
			resultData.setDownloadFilePath(excelPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}

	public ResultData statisticsSubscriptionRecord(Subscription subscription){
		ResultData resultData = new ResultData();
		return resultData;
	}
	
}
