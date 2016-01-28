package com.bs.plugins.custom.pc.productcontractrelation.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.pc.productcontractrelation.entity.ProductContractRelation;
import com.bs.plugins.custom.pc.productcontractrelation.base.BaseProductContractRelationService;

@Service
public class ProductContractRelationService extends BaseProductContractRelationService<ProductContractRelation> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData productContractRelationIndex(ProductContractRelation productContractRelation){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("productId", productContractRelation.getProductId());
			resultData.setViewName("pc/productmanager/product_newplayerproduct_contract");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(ProductContractRelation productContractRelation){
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
	public ResultData jumpCreate(ProductContractRelation productContractRelation){
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
	public ResultData jumpList(ProductContractRelation productContractRelation){
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
	public ResultData jumpPaginated(ProductContractRelation productContractRelation){
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
