package com.bs.plugins.custom.pc.productcontract.service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.pc.contracttemplate.entity.ContractTemplate;
import com.bs.plugins.custom.pc.product.dao.IProductDao;
import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.productcontract.base.BaseProductContractService;
import com.bs.plugins.custom.pc.productcontract.entity.ProductContract;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class ProductContractService extends BaseProductContractService<ProductContract> {

	@Autowired
	private IProductDao productDao;


	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			if(productContract.getContent() != null) {
				productContract.setContent(StringEscapeUtils.unescapeHtml(productContract.getContent().replaceAll("& ", "&")));
			}
			Integer result = super.getProductContractDao().insert(productContract);
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
	public ResultData modify(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			if(productContract.getContent() != null) {
				productContract.setContent(StringEscapeUtils.unescapeHtml(productContract.getContent().replaceAll("& ", "&")));
			}
			Integer result = super.getProductContractDao().updateById(productContract);
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
	public ResultData modifyComplete(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			if(productContract.getContent() != null) {
				productContract.setContent(StringEscapeUtils.unescapeHtml(productContract.getContent().replaceAll("& ", "&")));
			}
			Integer result = super.getProductContractDao().updateCompleteById(productContract);
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
	public ResultData single(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			ProductContract productContractTemp = this.getProductContractDao().selectOneById(productContract);
			if (productContractTemp != null){
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("productContract", productContractTemp);
				resultData.setResultMap(gridMap);
//				resultData.addObject("productContract", productContractTemp);
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
	public ResultData productContractIndex(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("productId", productContract.getProductId());
			resultData.addObject("categoryId", productContract.getProduct().getCategoryId());

			resultData.setViewName("pc/productmanager/product_newplayerproduct_contract");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/**跳转到修改页**/
	public ResultData jumpModify(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("productContract",this.getProductContractDao().selectOneById(productContract));
			resultData.setViewName("pc/productmanager/product_newplayerproduct_contract_modify");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/**跳转到创建页**/
	public ResultData jumpCreate(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("productContract",productContract);
			resultData.addObject("productId",productContract.getProductId());
			resultData.setViewName("pc/productmanager/product_newplayerproduct_contract_create");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/**跳转到列表**/
	public ResultData jumpList(ProductContract productContract){
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
	public ResultData jumpPaginated(ProductContract productContract){
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
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			List<ProductContract> productContractList = this.getProductContractDao().selectList(productContract);
			Long productContractCount = this.getProductContractDao().getCount(productContract);
			if (productContractList != null){
				long record = productContractCount == null?0:productContractCount;
				int pageCount = (int) Math.ceil(record / (double) productContract.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productContract.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", productContractList);
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


	//传模版id和产品id用户信息写死作为模版展示用
	public ResultData contractPreview(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			productContract = super.getProductContractDao().selectOneById(productContract);
			if(productContract != null){
				Configuration cfg = new Configuration();
				// 字符串作为freemarker模板
				StringTemplateLoader stringLoader = new StringTemplateLoader();
				String templateContent = productContract.getContent();
				stringLoader.putTemplate("myTemplate",templateContent);

				cfg.setTemplateLoader(stringLoader);
				Template template = cfg.getTemplate("myTemplate","utf-8");
	            Map<String,Object> root = new HashMap<String,Object>();

	            Map<String,String> map = new HashMap<String,String>();
				// 甲方（受让方）
				map.put("firstParty", "甲方名称");
				// 甲方身份证
				map.put("firstPartyIdCard", "110114187010234210");
				// 乙方（转让方）
				map.put("secondParty", "乙方名称");
				// 丙方（服务方）
				map.put("thirdParty", "丙方名称");
				// 日期
				map.put("subDate", "2016-01-16");
				// 基础产品名称
				map.put("basicProductName", "某某基础产品名称");
				// 收益权产品名称
				map.put("productName", "某某产品名称");
				// 产品收益权转让价款
				map.put("subAmount", "10000.00");
				// 预期年化收益率
				map.put("prospectiveEarningsRate", "9.8%");
				// 收益权转让基准日 (起息日期时间)
				map.put("transferTime", "2016-02-29");
				// 收益权预计到期清算日(到期时间)
				map.put("expirationTime", "2017-03-28");
				// 产品代码
				map.put("productCode", "PC-001");
				// 资产管理人
				map.put("assetManager", "某某资产管理人");

	            root.put("map", map);
	            StringWriter out = new StringWriter();
	            template.process(root, out);
                System.out.println(out.toString());
                resultData.setResultString(out.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultData;
	}

	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}
}
