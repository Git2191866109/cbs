package com.bs.plugins.custom.pc.product.service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import com.bs.core.service.CommonService;
import com.bs.plugins.custom.pc.category.entity.Category;
import com.bs.plugins.custom.pc.productcontract.dao.IProductContractDao;
import com.bs.plugins.custom.pc.productcontract.entity.ProductContract;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.bs.core.dao.RedisDao;
import com.bs.core.entity.ResultData;
import com.bs.core.entity.ValidInfo;
import com.bs.core.service.IBaseService;
import com.bs.core.utils.ValidationUtil;
import com.bs.plugins.custom.cc.spvcorporation.dao.ISpvCorporationDao;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.pc.attribute.dao.IAttributeDao;
import com.bs.plugins.custom.pc.attribute.entity.Attribute;
import com.bs.plugins.custom.pc.attributedataconfig.dao.IAttributeDataConfigDao;
import com.bs.plugins.custom.pc.attributedataconfig.entity.AttributeDataConfig;
import com.bs.plugins.custom.pc.basicproduct.dao.IBasicProductDao;
import com.bs.plugins.custom.pc.basicproduct.entity.BasicProduct;
import com.bs.plugins.custom.pc.product.IProductConst;
import com.bs.plugins.custom.pc.product.base.BaseProductService;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.productattributeconfig.dao.IProductAttributeConfigDao;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.pc.structureconfig.dao.IStructureConfigDao;
import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;
import com.bs.plugins.custom.pc.structurekindrelation.entity.StructureKindRelation;
import com.bs.plugins.custom.pc.structurekindrelation.service.StructureKindRelationService;
import com.bs.plugins.custom.pc.structurerulerelation.entity.StructureRuleRelation;
import com.bs.plugins.custom.pc.validationrule.dao.IValidationRuleDao;
import com.bs.plugins.custom.pc.validationrule.entity.ValidationRule;
import com.bs.plugins.custom.sc.dictionary.dao.IDictionaryDao;
import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;
import com.bs.plugins.custom.sc.dictionary.service.DictionaryService;
import com.bs.plugins.thirdparty.umpay.UmPayClient;
import com.bs.plugins.thirdparty.umpay.bean.PaymentData;
import com.bs.plugins.thirdparty.umpay.bean.RequestHelper;
import com.bs.plugins.thirdparty.umpay.constants.IParam;
import com.bs.plugins.thirdparty.umpay.constants.IServiceConst;
import com.umpay.api.common.ReqData;
import com.umpay.api.exception.ReqDataException;

@Service
public class ProductService extends BaseProductService<Product> {

	private static final Logger logger = Logger.getLogger(ProductService.class);

	@Autowired
	private IDictionaryDao dictionaryDao;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private IStructureConfigDao structureConfigDao;

	@Autowired
	private IAttributeDataConfigDao iAttributeDataConfigDao;

	@Autowired
	private IProductAttributeConfigDao iProductAttributeConfigDao;

	@Autowired
	private IValidationRuleDao iValidationRuleDao;

	@Autowired
	private IAttributeDao iAttributeDao;

	@Autowired
	private StructureKindRelationService structureKindRelationService;

	@Autowired
	private IBasicProductDao iBasicProductDao;

	@Autowired
	private RedisDao redisDao;

	@Autowired
	private ISpvCorporationDao spvCorporationDao;

	@Autowired
	private CommonService commonService;

	@Autowired
	private IProductContractDao productContractDao;

	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Product product){
		ResultData resultData = new ResultData();
		try {
			BindingResult bindingResult = product.getBindingResult();

			//检验属性的有效性
			ArrayList<ProductAttributeConfig> productAttributeConfigs = product.getProductAttributeConfigs();
			Map<Long, StructureConfig> attrRuleRelateMap  = getAttrRuleRelateMapByProductCategoryId(product.getCategoryId());
			Map<Long, ValidationRule> validationRuleMap  = getValidationRuleMap();
			if(productAttributeConfigs  != null) {
				for (ProductAttributeConfig productAttributeConfig : productAttributeConfigs) {
					Long attributeId = productAttributeConfig.getAttributeId();
					String attributeValue = productAttributeConfig.getAttributeValue();
					ValidInfo validInfo = checkAttrValue(attributeValue, attrRuleRelateMap.get(attributeId), validationRuleMap);
					if (!validInfo.isResult()) {
						Attribute attribute = new Attribute();
						attribute.setId(attributeId);
						Attribute attribute1 = iAttributeDao.selectOneById(attribute);

						FieldError fe = new FieldError("product", "productAttributeConfigs["
								+ productAttributeConfigs.indexOf(productAttributeConfig) + "].attributeValue",
								attributeValue, false, null, null, attribute1.getName() + validInfo.getResultMessage());
						bindingResult.addError(fe);
					}
				}
			}

			Integer totalAmount = product.getTotalAmount();
			Long basicProductId = product.getBasicProductId();
			String checkResult = checkAmount(product.getId(), totalAmount, basicProductId);
			if(StringUtils.isNotBlank(checkResult)) {
				FieldError fe = new FieldError("product", "totalAmount",totalAmount, false, null, null, checkResult);
				bindingResult.addError(fe);
			}

			resultData.setBindingResult(bindingResult);

			if(bindingResult.hasErrors()) {
				return resultData;
			}

			product.setStatus(1);
			product.setCode(commonService.getTransactionNumber("P"));
			product.setSurplusAmount(product.getTotalAmount());
			Integer result = super.getProductDao().insert(product);

			if(result > 0) {
				Long productId = product.getGeneratedKey();
				productAttributeConfigs = product.getProductAttributeConfigs();
				if(productAttributeConfigs  != null) {
					for (ProductAttributeConfig productAttributeConfig : productAttributeConfigs) {
						productAttributeConfig.setProductId(productId);
						productAttributeConfig.setAttributeValue(StringEscapeUtils.unescapeHtml(productAttributeConfig.getAttributeValue().replaceAll("& ", "&")));
						iProductAttributeConfigDao.insert(productAttributeConfig);
					}
				}
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

	private String checkAmount(Long productId, Integer planUseAmount, Long basicProductId) throws Exception {

		if(planUseAmount == null) {
			return "不能为空！";
		}

		BasicProduct basicProduct = new BasicProduct();
		basicProduct.setId(basicProductId);
		basicProduct = iBasicProductDao.selectOneById(basicProduct);

		Integer leaveAmount = basicProduct.getTotalAmount();

		Product tempProduct = new Product();
		tempProduct.setBasicProductId(basicProductId);
		List<Product> products = super.getProductDao().selectList(tempProduct);

		if(products != null) {
			for (Product product : products) {
				if(productId != product.getId()) {
					leaveAmount -= product.getTotalAmount();
				}
			}
		}
		if(planUseAmount > leaveAmount ) {
			return "基础产品剩余【" + leaveAmount + "】，份额不足！";
		}

		return null;
	}



	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData updateStatus(Product product){
		ResultData resultData = new ResultData();
		System.out.println("产品[ ]状态更改开始!");
		logger.debug("产品[ ]状态更改开始!");
		try {
			//判断合同不为空
			if(product.getStatus() == 2L) {
				Product origProduct = getProductDao().selectOneById(product);
				//判断是否为线下产品
				boolean isOffLineProduct = getIsOfflineProduct(origProduct);
				//线下产品在发布时合同不能为空
				if(!isOffLineProduct) {
					ProductContract pc = new ProductContract();
					pc.setProductId(product.getId());
					List<ProductContract> productContracts = productContractDao.selectList(pc);
					if(productContracts == null || productContracts.size() == 0) {
						resultData.setStatus("contract.required");
						return resultData;
					}
				}

				//判断该产品是否为新手产品
				boolean isNewbeeProduct = getIsNewBeeProduct(product);
				if(isNewbeeProduct || isOffLineProduct) {
					origProduct.setCode(null);
					product.setCode(null);
				}

				System.out.println("isNewbeeProduct= " + isNewbeeProduct + "; isOffLineProduct" + isOffLineProduct);
				logger.debug("isNewbeeProduct= " + isNewbeeProduct + "; isOffLineProduct" + isOffLineProduct);

				//非新手与非线下产品需要及时同步至联动平台
				if(!isNewbeeProduct && !isOffLineProduct) {
					logger.debug("产品[ " +  origProduct.getName()  + "]同步至联动平台.. ");
					//同步产品至联动平台
					PaymentData paymentData = syncProduct2UMPay(origProduct);
					if(!"0000".equals(paymentData.getRetCode())) {
						resultData.setStatus("umpay.connnect.fail");
						resultData.setPromptMessage(paymentData.getRetMsg());
						return resultData;
					}
					if(!"92".equals(paymentData.getProjectState())) {
						resultData.setStatus("umpay.create.fail");
						return resultData;
					}

					String projectAccountId = paymentData.getProjectAccountId();

					logger.debug("产品[ " +  origProduct.getName()  + "]开标.. ");
					//开标
					paymentData = updateProduct2UMPay(origProduct,"0");
					if(!"0000".equals(paymentData.getRetCode())) {
//					resultData.setStatus("umpay.publish.fail");
						resultData.setPromptMessage(paymentData.getRetMsg());
						return resultData;
					}

					logger.debug("产品[ " +  origProduct.getName()  + "]发布.. ");
					//发布产品至联动平台
					paymentData = updateProduct2UMPay(origProduct,"1");
					if(!"0000".equals(paymentData.getRetCode())) {
						resultData.setStatus("umpay.publish.fail");
						resultData.setPromptMessage(paymentData.getRetMsg());
						return resultData;
					}
					//同步产品值联动平台
					product.setUmpayAccountNo(projectAccountId);

					logger.debug("产品[ " + origProduct.getName() + "]发布完成!");
				}
			}

			Integer result = this.getProductDao().updateById(product);

			if (result > 0){
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
			logger.debug("产品[ ]状态更改完成!");

		} catch (Exception e) {
			logger.error("产品状态更改出现异常！",e);
			resultData.setStatusException(e.getMessage());
			resultData.setStatus(IBaseService.FAIL);
			e.printStackTrace();
		}
		return resultData;
	}

	private boolean getIsOfflineProduct(Product product)  {
		Set<String> offlineProductCategoryCodeSet = new HashSet<>();
		offlineProductCategoryCodeSet.add("3");
		offlineProductCategoryCodeSet.add("4");

		Long categoryId = product.getCategoryId();
		Map<String, Category> map = redisDao.getMap(redisDao.getRedisMapKey(Category.class), Category.class);
		Category category = map.get(String.valueOf(categoryId));
		return offlineProductCategoryCodeSet.contains(category.getCode());
	}

	/**
	 * 是否是新手产品
	 * @param product
	 * @return
	 */
	private boolean getIsNewBeeProduct(Product product) {
		//新手产品此时不需要发送联动平台，有定时任务根据生成子产品发送联动平台
		String mapKey = redisDao.getRedisMapKey(ProductAttributeConfig.class);
		Map<String, Map<String, ProductAttributeConfig>>  redisMap = redisDao.getMapCollection(mapKey, ProductAttributeConfig.class);
		Map<String, ProductAttributeConfig> stringProductAttributeConfigMap = redisMap.get(String.valueOf(product.getId()));
		ProductAttributeConfig productAttributeConfig =
				stringProductAttributeConfigMap.get(com.bs.plugins.custom.pc.provider.constants.IProductConst.ATTR_CODE_ISNEWBEEPRODUCT);
		if(productAttributeConfig != null && "1".equals(productAttributeConfig.getAttributeValue())) {
			return true;
		}

		return false;
	}

	/**
	 * 修改产品
	 * @param tempProduct
	 * @return
	 * @throws ReqDataException
	 */
	public PaymentData updateProduct2UMPay(Product tempProduct, String projectState) throws ReqDataException {
		RequestHelper request = RequestHelper.getInstance(IServiceConst.MER_UPDATE_PROJECT);
		request.put(IParam.PROJECT.CHANGE_TYPE, "01");
		request.put(IParam.PROJECT.PROJECT_STATE, projectState);
		request.put(IParam.PROJECT.PROJECT_ID, tempProduct.getCode());
//		request.put(IParam.PROJECT.PROJECT_NAME, tempProduct.getName());//投标中不能传项目名称
		ReqData reqData = request.makeReqDataByGet();
		return UmPayClient.callPaymentPlant(reqData.getUrl(), reqData.getField());
	}


	public PaymentData syncProduct2UMPay(Product tempProduct) throws Exception {
		RequestHelper request = RequestHelper.getInstance(IServiceConst.MER_BIND_PROJECT);
		request.put(IParam.PROJECT.PROJECT_ID, tempProduct.getCode());
		request.put(IParam.PROJECT.PROJECT_NAME, tempProduct.getName());
		request.put(IParam.PROJECT.PROJECT_AMOUNT, String.valueOf(tempProduct.getTotalAmount()));
		String mapKey = redisDao.getRedisMapKey(ProductAttributeConfig.class);
		Map<String, Map<String, ProductAttributeConfig>>  redisMap = redisDao.getMapCollection(mapKey, ProductAttributeConfig.class);
		Map<String, ProductAttributeConfig> stringProductAttributeConfigMap = redisMap.get(String.valueOf(tempProduct.getId()));
		ProductAttributeConfig productAttributeConfig =
				stringProductAttributeConfigMap.get(com.bs.plugins.custom.pc.provider.constants.IProductConst.ABORT_SELL_DATE);
		request.put(IParam.PROJECT.PROJECT_EXPIRE_DATE, productAttributeConfig.getAttributeValue().replaceAll("-", ""));

		SpvCorporation spvCorporation = new SpvCorporation();
		spvCorporation.setId(tempProduct.getSpvId());
		SpvCorporation spvCorporation1 = spvCorporationDao.selectOneById(spvCorporation);
		request.put(IParam.PROJECT.LOAN_USER_ID, spvCorporation1.getUmpayMerchantNo());
//				request.put(IParam.PROJECT.LOAN_ACCOUNT_ID, "");
		request.put(IParam.PROJECT.LOAN_ACC_TYPE, "02");
//				request.put(IParam.PROJECT.WARRANTY_USER_ID, "");
//				request.put(IParam.PROJECT.WARRANTY_ACCOUNT_ID, "");
//				request.put(IParam.PROJECT.RECEIVE_ACCOUNT_ID, "");
//				request.put(IParam.PROJECT.RECEIVE_ACC_TYPE, "");
		System.out.println("begin...,");
		ReqData reqData = request.makeReqDataByGet();
		System.out.println("doing...,");
		PaymentData paymentData = UmPayClient.callPaymentPlant(reqData.getUrl(), reqData.getField());
		System.out.println("done?");
		return paymentData;
	}

	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modify(Product product){
		ResultData resultData = new ResultData();
		try {
			//检查基础产品是否存在足够份额供拆分！
			BindingResult bindingResult = product.getBindingResult();
			if(product.getStatus() != 6) {//发动到联动平台
				Integer totalAmount = product.getTotalAmount();
				Long basicProductId = product.getBasicProductId();
				String checkResult = checkAmount(product.getId(), totalAmount, basicProductId);
				if(StringUtils.isNotBlank(checkResult)) {
					FieldError fe = new FieldError("product", "totalAmount",totalAmount, false, null, null, checkResult);
					bindingResult.addError(fe);
				}
			}else {
				product.setDistributeStatus(0);
			}

			//只有待售产品才能够修改总金额，且剩余金额需要联动修改
			if(product.getStatus() == 1L) {
				product.setSurplusAmount(product.getTotalAmount());
			}

			//检验属性的有效性
			ArrayList<ProductAttributeConfig> productAttributeConfigs = product.getProductAttributeConfigs();
			Map<Long, StructureConfig> attrRuleRelateMap  = getAttrRuleRelateMapByProductCategoryId(product.getCategoryId());
			Map<Long, ValidationRule> validationRuleMap  = getValidationRuleMap();
			if(productAttributeConfigs  != null) {
				for (ProductAttributeConfig productAttributeConfig : productAttributeConfigs) {
					Long attributeId = productAttributeConfig.getAttributeId();
					String attributeValue = productAttributeConfig.getAttributeValue();
					ValidInfo validInfo = checkAttrValue(attributeValue, attrRuleRelateMap.get(attributeId), validationRuleMap);
					if (!validInfo.isResult()) {
						Attribute attribute = new Attribute();
						attribute.setId(attributeId);
						Attribute attribute1 = iAttributeDao.selectOneById(attribute);

						FieldError fe = new FieldError("product", "productAttributeConfigs["
								+ productAttributeConfigs.indexOf(productAttributeConfig) + "].attributeValue",
								attributeValue, false, null, null, attribute1.getName() + validInfo.getResultMessage());
						bindingResult.addError(fe);
					}
				}
				resultData.setBindingResult(bindingResult);
				if(bindingResult.hasErrors()) {
					return resultData;
				}
			}

			Integer result = this.getProductDao().updateById(product);
			Long productId = product.getId();


			if(productAttributeConfigs  != null) {
				for (ProductAttributeConfig productAttributeConfig : productAttributeConfigs) {
					if(productAttributeConfig.getAttributeValue() != null) {
						productAttributeConfig.setAttributeValue(StringEscapeUtils.unescapeHtml(productAttributeConfig.getAttributeValue().replaceAll("& ", "&")));
					}
					if(productAttributeConfig.getId() == null || productAttributeConfig.getId() < 0L) {
						productAttributeConfig.setProductId(productId);
						iProductAttributeConfigDao.insert(productAttributeConfig);
					}else {


						iProductAttributeConfigDao.updateById(productAttributeConfig);
					}

				}
			}
			if (result > 0){
				//发布产品至联动平台
				if(product.getStatus() == 6) {
					PaymentData paymentData = updateProduct2UMPay(product,"2");
					if(!"0000".equals(paymentData.getRetCode())) {
						resultData.setStatus("umpay.publish.fail");
						resultData.setPromptMessage(paymentData.getRetMsg());
						return resultData;
					}
				}
				
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

	private ValidInfo checkAttrValue(String attributeValue, StructureConfig structureConfig, Map<Long, ValidationRule> validationRuleMap) {

		String rule = "true";
		if(structureConfig == null) {
			ValidInfo validInfo = new ValidInfo();
			validInfo.setResult(true);
			return validInfo;
		}

		ArrayList<StructureRuleRelation> structureRuleRelation = structureConfig.getStructureRuleRelation();
		if(structureRuleRelation != null) {
			for (StructureRuleRelation ruleRelation : structureRuleRelation) {
				ValidationRule validationRule = validationRuleMap.get(ruleRelation.getValidationRuleId());
				rule += ("&&" + validationRule.getCode());
			}
		}

		rule = rule.replaceAll("ne\\[NUll\\]","ne[]");
		if(!rule.contains("ne[NUll]") && !rule.contains("ne[]")) {
			rule = "(" + rule + ")||eq[]";
		}
		ValidInfo validInfo = ValidationUtil.validate(attributeValue, rule);

		return validInfo;// ;

	}

	private Map<Long, ValidationRule> getValidationRuleMap() throws Exception {

		Map<Long, ValidationRule> map = new HashMap<>();

		List<ValidationRule> validationRules = iValidationRuleDao.selectAll();
		if(validationRules != null) {
			for (ValidationRule validationRule : validationRules) {
				map.put(validationRule.getId(),validationRule);
			}
		}
		return map;
	}

	private Map<Long, StructureConfig> getAttrRuleRelateMapByProductCategoryId(Long categoryId) throws Exception {
		StructureConfig sc = new StructureConfig();
		sc.setCategoryId(categoryId);
		sc.setisDelete(0);
		List<StructureConfig> structureConfigs = structureConfigDao.selectStructureConfigStructureRuleRelation(sc);
		Map<Long, StructureConfig> attrRuleRelateMap = new HashMap<>();
		if(structureConfigs != null) {
			for (StructureConfig structureConfig : structureConfigs) {
				attrRuleRelateMap.put(structureConfig.getAttributeId(),structureConfig);
			}
		}
		return attrRuleRelateMap;
	}

	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData delete(Product product){
		ResultData resultData = new ResultData();
		try {
			ProductAttributeConfig productAttributeConfig = new ProductAttributeConfig();
			productAttributeConfig.setProductId(product.getId());
			Integer delete = iProductAttributeConfigDao.delete(productAttributeConfig);
			Integer result = this.getProductDao().delete(product);
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
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(Product product){
		ResultData resultData = new ResultData();
		try {
			List<Product> productList = this.getProductDao().selectNewPaginatedList(product);
			List<Map<String, String>> list = new ArrayList<>();


			Long productCount = this.getProductDao().getCount(product);
			if (productList != null){

				for (Product product1 : productList) {
					StructureConfig sc = new StructureConfig();
					sc.setCategoryId(product1.getCategoryId());
					sc.setisDelete(0);
					ProductAttributeConfig productAttributeConfig = new ProductAttributeConfig();
					productAttributeConfig.setProductId(product1.getId());
					List<ProductAttributeConfig> curProductAttributeConfigs = iProductAttributeConfigDao.selectList(productAttributeConfig);
					List<ProductAttributeConfig> productAttributeConfigs  = new ArrayList<>();
					List<StructureConfig> structureConfigs = structureConfigDao.selectStructureConfigAttributeNew(sc);
//					Map<String, String> attrMap = new HashMap<>();
//					putProductAttr2AttrMap(attrMap,product1);
//					list.add(attrMap);
					if(structureConfigs != null) {
						for (StructureConfig structureConfig : structureConfigs) {
							if(structureConfig.getIsHeader() != 1) {
								continue;
							}
							ProductAttributeConfig pc = getProductAttrConfig(curProductAttributeConfigs,structureConfig.getAttributeId());
							if(pc == null) {
								pc = new ProductAttributeConfig();
								pc.setAttributeId(structureConfig.getAttributeId());
								pc.setAttributeValue(structureConfig.getDefaultValue());
							}
//							attrMap.put("productattr_" + pc.getAttributeId(),pc.getAttributeValue());
							pc.setAttribute(structureConfig.getAttribute());
							pc.setStructureConfig(structureConfig);

							productAttributeConfigs.add(pc);
						}
					}

//					product1.setAttrMap(attrMap);
					product1.setProductAttributeConfigs((ArrayList<ProductAttributeConfig>) productAttributeConfigs);
//					break;
				}

				long record = productCount == null?0:productCount;
				int pageCount = (int) Math.ceil(record / (double) product.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", product.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
//				gridMap.put("rows", list);
				gridMap.put("rows", productList);
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

	private void putProductAttr2AttrMap(Map<String, String> attrMap, Product product) {
		attrMap.put("id", String.valueOf(product.getId()));
		attrMap.put("name", String.valueOf(product.getName()));
		attrMap.put("code", String.valueOf(product.getCode()));
		attrMap.put("basicProductId", String.valueOf(product.getBasicProductId()));
		attrMap.put("spvId", String.valueOf(product.getSpvId()));
		attrMap.put("firstPublishTime", String.valueOf(product.getFirstPublishTime()));
		attrMap.put("status", String.valueOf(product.getStatus()));
		attrMap.put("description", String.valueOf(product.getDescription()));
		attrMap.put("createTime", String.valueOf(product.getCreateTime()));
		attrMap.put("modifyTime", String.valueOf(product.getModifyTime()));

	}

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData productIndex(Product product){
		ResultData resultData = new ResultData();
		try {
			List<Dictionary> dictionaryList = this.getDictionaryDao().selectDynamicTableDataList(
					new HashMap<String, String>() {{
						put("tableName", "PC_Category");
						put("keyColumn", "Id");
						put("valueColumn", "Name");
					}});
			resultData.addObject("categoryList", dictionaryList);
			resultData.setViewName("pc/productmanager/product_frame");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			resultData.setViewName("pc/productmanager/product_frame");
			e.printStackTrace();
		}
		return resultData;
	}

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData productItemIndex(Product product){
		ResultData resultData = new ResultData();
		try {

			long categoryId = product.getCategoryId();
			StructureConfig sc = new StructureConfig();
			sc.setCategoryId(categoryId);
			sc.setisDelete(0);
			List<ProductAttributeConfig> productAttributeConfigs  = new ArrayList<>();
			List<StructureConfig> structureConfigs = structureConfigDao.selectStructureConfigAttributeNew(sc);
			if(structureConfigs != null) {
				for (StructureConfig structureConfig : structureConfigs) {
					if(structureConfig.getIsHeader() != 1) {
						continue;
					}
					ProductAttributeConfig pc = new ProductAttributeConfig();
					pc.setAttributeId(structureConfig.getAttributeId());
					pc.setAttributeValue(structureConfig.getDefaultValue());
					pc.setAttribute(structureConfig.getAttribute());
					pc.setStructureConfig(structureConfig);
					try{
						pc.setOptions(getOptionsMap(structureConfig.getAttributeId()));
					}catch (Exception e) {
						e.printStackTrace();
					}
					productAttributeConfigs.add(pc);

				}
			}
			product.setProductAttributeConfigs((ArrayList<ProductAttributeConfig>) productAttributeConfigs);



			Map<String, List<Object>> data = super.getInitializeData().getConfigFileData();
			if (data != null) {
				List<Object> websiteDomain = data.get("websiteDomain");
				resultData.addObject("websiteDomain", String.valueOf(websiteDomain.get(0)));
			}


			resultData.setViewName("pc/productmanager/product_newplayerproduct");
			resultData.addObject("product", product);
			resultData.addObject("categoryId", product.getCategoryId());
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(Product product){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("categoryId", product.getCategoryId());
			Product product1 = this.getProductDao().selectOneById(product);
			StructureConfig sc = new StructureConfig();
			sc.setCategoryId(product.getCategoryId());
			sc.setisDelete(0);

			ProductAttributeConfig productAttributeConfig = new ProductAttributeConfig();
			productAttributeConfig.setProductId(product.getId());
			List<ProductAttributeConfig> curProductAttributeConfigs = iProductAttributeConfigDao.selectList(productAttributeConfig);

			Map<Long, StructureKindRelation> structureKindRelationMap
					= structureKindRelationService.getStructureKindRelationMapByKindId(IProductConst.KIND_ID_PRODUCT_CREATE_DISPLAY);

			List<ProductAttributeConfig> productAttributeConfigs  = new ArrayList<>();
			List<StructureConfig> structureConfigs = structureConfigDao.selectStructureConfigAttributeNew(sc);

			if(structureConfigs != null) {
				for (StructureConfig structureConfig : structureConfigs) {
					if(structureKindRelationMap.get(structureConfig.getId()) != null) {
						continue;
					}
					ProductAttributeConfig pc = getProductAttrConfig(curProductAttributeConfigs,structureConfig.getAttributeId());
					if(pc == null) {
						pc = new ProductAttributeConfig();
						pc.setAttributeId(structureConfig.getAttributeId());
						pc.setAttributeValue(structureConfig.getDefaultValue());
					}
//					pc.setAttributeValue(StringEscapeUtils.unescapeHtml(pc.getAttributeValue().replaceAll("& ", "&")));
					pc.setAttribute(structureConfig.getAttribute());
					pc.setStructureConfig(structureConfig);
					try{
						pc.setOptions(getOptionsMap(structureConfig.getAttributeId()));
					}catch (Exception e) {
						e.printStackTrace();
					}
					productAttributeConfigs.add(pc);

				}
			}
			product1.setProductAttributeConfigs((ArrayList<ProductAttributeConfig>) productAttributeConfigs);
			resultData.addObject("product", product1);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}

	/**跳转到修改页**/
	public ResultData jumpProductCash(Product product){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("categoryId", product.getCategoryId());
			Product product1 = this.getProductDao().selectOneById(product);
			StructureConfig sc = new StructureConfig();
			sc.setCategoryId(product.getCategoryId());
			sc.setisDelete(0);

			ProductAttributeConfig productAttributeConfig = new ProductAttributeConfig();
			productAttributeConfig.setProductId(product.getId());
			List<ProductAttributeConfig> curProductAttributeConfigs = iProductAttributeConfigDao.selectList(productAttributeConfig);

			Map<Long, StructureKindRelation> structureKindRelationMap
					= structureKindRelationService.getStructureKindRelationMapByKindId(IProductConst.KIND_ID_PRODUCT_CASH_DISPLAY);

			product1.setStatus(6);//兑换中
			List<ProductAttributeConfig> productAttributeConfigs  = new ArrayList<>();
			List<StructureConfig> structureConfigs = structureConfigDao.selectStructureConfigAttributeNew(sc);

			if(structureConfigs != null) {
				for (StructureConfig structureConfig : structureConfigs) {
					if(structureKindRelationMap.get(structureConfig.getId()) == null) {
						continue;
					}
					ProductAttributeConfig pc = getProductAttrConfig(curProductAttributeConfigs,structureConfig.getAttributeId());
					if(pc == null) {
						pc = new ProductAttributeConfig();
						pc.setAttributeId(structureConfig.getAttributeId());
						pc.setAttributeValue(structureConfig.getDefaultValue());
					}
//					pc.setAttributeValue(StringEscapeUtils.unescapeHtml(pc.getAttributeValue().replaceAll("& ", "&")));
					pc.setAttribute(structureConfig.getAttribute());
					pc.setStructureConfig(structureConfig);
					try{
						pc.setOptions(getOptionsMap(structureConfig.getAttributeId()));
					}catch (Exception e) {
						e.printStackTrace();
					}
					productAttributeConfigs.add(pc);

				}
			}
			product1.setProductAttributeConfigs((ArrayList<ProductAttributeConfig>) productAttributeConfigs);
			resultData.addObject("product", product1);
			resultData.setViewName("pc/productmanager/product_newplayerproduct_cash");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}


	private ProductAttributeConfig getProductAttrConfig(List<ProductAttributeConfig> curProductAttributeConfigs, Long attributeId) {
		if(curProductAttributeConfigs != null) {
			for (ProductAttributeConfig curProductAttributeConfig : curProductAttributeConfigs) {
				if(curProductAttributeConfig.getAttributeId() == attributeId) {
					try {
						return (ProductAttributeConfig) BeanUtils.cloneBean(curProductAttributeConfig);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	/**跳转到创建页**/
	public ResultData jumpCreate(Product product){
		ResultData resultData = new ResultData();
		try {
			long categoryId = product.getCategoryId();
			StructureConfig sc = new StructureConfig();
			sc.setCategoryId(categoryId);
			sc.setisDelete(0);
			List<ProductAttributeConfig> productAttributeConfigs  = new ArrayList<>();
			List<StructureConfig> structureConfigs = structureConfigDao.selectStructureConfigAttributeNew(sc);
			Map<Long, StructureKindRelation> structureKindRelationMap
					= structureKindRelationService.getStructureKindRelationMapByKindId(IProductConst.KIND_ID_PRODUCT_CREATE_DISPLAY);
			if(structureConfigs != null) {
				for (StructureConfig structureConfig : structureConfigs) {
					if(structureKindRelationMap.get(structureConfig.getId()) != null) {
						continue;
					}
					ProductAttributeConfig pc = new ProductAttributeConfig();
					pc.setAttributeId(structureConfig.getAttributeId());
					pc.setAttributeValue(structureConfig.getDefaultValue());
					pc.setAttribute(structureConfig.getAttribute());
					pc.setStructureConfig(structureConfig);
					try{
						pc.setOptions(getOptionsMap(structureConfig.getAttributeId()));
					}catch (Exception e) {
						e.printStackTrace();
					}
					productAttributeConfigs.add(pc);

				}
			}

			product.setProductAttributeConfigs((ArrayList<ProductAttributeConfig>) productAttributeConfigs);
//			resultData.addObject("productAttributeConfigs",productAttributeConfigs);
			resultData.addObject("product", product);
			resultData.addObject("categoryId",categoryId);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}

	private Map<String, String> getOptionsMap(Long attributeId) throws Exception {
		Map<String, String> map = new HashMap<>();
		AttributeDataConfig attributeDataConfig = new AttributeDataConfig();
		attributeDataConfig.setAttributeId(attributeId);
		List<AttributeDataConfig> attributeDataConfigs = iAttributeDataConfigDao.selectList(attributeDataConfig);
		if(attributeDataConfigs == null) {
			return null;
		}

		for (AttributeDataConfig dataConfig : attributeDataConfigs) {
			if(dataConfig.getDataSource() == 1) {//来源于字典
				Long dictCategoryId = dataConfig.getDictCategoryId();
//				List<Dictionary> dictionaryList = DictionaryCache.getDictionaryByCategoryId(String.valueOf(dictCategoryId));
				Dictionary qryDictionary = new Dictionary();
				qryDictionary.setDictCategoryId(dictCategoryId);
				ResultData resultData = dictionaryService.getByCategoryId(qryDictionary);
				List<Dictionary> dictionaryList = (List<Dictionary>) resultData.getResultMap().get("dictionaryList");
				if(dictionaryList != null) {
					for (Dictionary dictionary : dictionaryList) {
						map.put(dictionary.getValue(),dictionary.getName());
					}
				}
			}else if(dataConfig.getDataSource() == 2) {//来源于模型
				final String tableName = dataConfig.getTableName();
				final String keyColumn = dataConfig.getKeyColumn();
				final String valueColumn = dataConfig.getValueColumn();
				List<Dictionary> dictionaryList = this.getDictionaryDao().selectDynamicTableDataList(
						new HashMap<String, String>() {{
							put("keyColumn", keyColumn);
							put("valueColumn", valueColumn);
							put("tableName", tableName);
						}});
				if(dictionaryList != null) {
					for (Dictionary dictionary : dictionaryList) {
						map.put(dictionary.getValue(),dictionary.getName());
					}
				}
			} else {//自定义
				String customKey = dataConfig.getCustomKey();
				String customValue = dataConfig.getCustomValue();
				map.put(customKey, customValue);
			}
		}
		return map;
	}

	/**跳转到列表**/
	public ResultData jumpList(Product product){
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
	public ResultData jumpPaginated(Product product){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}

	public IDictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(IDictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	public IStructureConfigDao getStructureConfigDao() {
		return structureConfigDao;
	}

	public void setStructureConfigDao(IStructureConfigDao structureConfigDao) {
		this.structureConfigDao = structureConfigDao;
	}

	public IAttributeDataConfigDao getiAttributeDataConfigDao() {
		return iAttributeDataConfigDao;
	}

	public void setiAttributeDataConfigDao(IAttributeDataConfigDao iAttributeDataConfigDao) {
		this.iAttributeDataConfigDao = iAttributeDataConfigDao;
	}

	public IProductAttributeConfigDao getiProductAttributeConfigDao() {
		return iProductAttributeConfigDao;
	}

	public void setiProductAttributeConfigDao(IProductAttributeConfigDao iProductAttributeConfigDao) {
		this.iProductAttributeConfigDao = iProductAttributeConfigDao;
	}

	public IValidationRuleDao getiValidationRuleDao() {
		return iValidationRuleDao;
	}

	public void setiValidationRuleDao(IValidationRuleDao iValidationRuleDao) {
		this.iValidationRuleDao = iValidationRuleDao;
	}

	public IAttributeDao getiAttributeDao() {
		return iAttributeDao;
	}

	public void setiAttributeDao(IAttributeDao iAttributeDao) {
		this.iAttributeDao = iAttributeDao;
	}

	public StructureKindRelationService getStructureKindRelationService() {
		return structureKindRelationService;
	}

	public void setStructureKindRelationService(StructureKindRelationService structureKindRelationService) {
		this.structureKindRelationService = structureKindRelationService;
	}

	public IBasicProductDao getiBasicProductDao() {
		return iBasicProductDao;
	}

	public void setiBasicProductDao(IBasicProductDao iBasicProductDao) {
		this.iBasicProductDao = iBasicProductDao;
	}
}
