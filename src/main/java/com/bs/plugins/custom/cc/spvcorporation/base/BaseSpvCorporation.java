package com.bs.plugins.custom.cc.spvcorporation.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;	
import com.bs.plugins.custom.tc.spvrechargerecords.entity.SpvRechargeRecords;	
import com.bs.plugins.custom.tc.spvwithdrawcashrecords.entity.SpvWithdrawCashRecords;	
import com.bs.plugins.custom.tc.subscription.entity.Subscription;	
import com.bs.plugins.custom.pc.basicproduct.entity.BasicProduct;	
import com.bs.plugins.custom.tc.productreturnmoney.entity.ProductReturnMoney;	
import com.bs.plugins.custom.tc.spvproductreturnmoney.entity.SpvProductReturnMoney;	
import com.bs.plugins.custom.tc.platformservicefee.entity.PlatformServiceFee;	
import java.util.ArrayList;

public class BaseSpvCorporation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-父机构ID：机构树状结构父节点标识**/
	private Long id;
	/**机构类型-1：Spv公司 2：平台方**/
	private Integer type;
	/**组织机构代码-机构代码**/
	private String code;
	/**托管账户号-**/
	private String umpayAccountNo;
	/**账户可用余额-包括但钱持有本金收益和已经返回的收益**/
	private BigDecimal availableAmount;
	/**账户冻结金额-包括但钱持有本金收益和已经返回的收益**/
	private BigDecimal frozenAmount;
	/**托管商户号-**/
	private String umpayMerchantNo;
	/**机构名称-机构名称：定义记录机构的名称。**/
	private String name;
	/**机构简称-**/
	private String shortName;
	/**银行名称-**/
	private String bankName;
	/**银行代码-**/
	private String bankCode;
	/**银行卡号-**/
	private String bankCardNumber;
	/**合同签章图片路径-**/
	private String signaturePicPath;
	/**机构电话-机构电话：机构的联系的电话。**/
	private String phone;
	/**机构传真-机构传真：机构的传真的号码。**/
	private String fax;
	/**机构邮政编码-机构邮政编码：机构所在地区的邮政编码。**/
	private String postCode;
	/**机构地址-机构地址：机构的具体的地址。**/
	private String address;
	/**机构描述-机构描述：机构相关信息的说明或者描述。**/
	private String description;
	/**机构状态-机构状态： 0.禁用 1.启用**/
	private Integer status;
	/**创建时间-创建时间：机构创建的时间，以备后来跟踪查询**/
	private String createTime;
	/**更新时间-**/
	private String modifyTime;
	/**用户中心-会员信息存储表**/
	private ArrayList<Member> members;
	/**交易中心-SPV公司充值记录存储表**/
	private ArrayList<SpvRechargeRecords> spvRechargeRecordss;
	/**交易中心-SPV公司提现记录存储表**/
	private ArrayList<SpvWithdrawCashRecords> spvWithdrawCashRecordss;
	/**交易中心-客户认购产品数据存储表**/
	private ArrayList<Subscription> subscriptions;
	/**产品中心-基础产品信息存储表**/
	private ArrayList<BasicProduct> basicProducts;
	/**交易中心-产品返款分账信息存储表**/
	private ArrayList<ProductReturnMoney> productReturnMoneys;
	/**交易中心-SPV产品还款信息存储表**/
	private ArrayList<SpvProductReturnMoney> spvProductReturnMoneys;
	/**交易中心-平台服务费信息存储表**/
	private ArrayList<PlatformServiceFee> platformServiceFees;

	public BaseSpvCorporation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getUmpayAccountNo() {
		return umpayAccountNo;
	}

	public void setUmpayAccountNo(String umpayAccountNo) {
		this.umpayAccountNo = umpayAccountNo;
	}
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}
	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}
	public String getUmpayMerchantNo() {
		return umpayMerchantNo;
	}

	public void setUmpayMerchantNo(String umpayMerchantNo) {
		this.umpayMerchantNo = umpayMerchantNo;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	public String getSignaturePicPath() {
		return signaturePicPath;
	}

	public void setSignaturePicPath(String signaturePicPath) {
		this.signaturePicPath = signaturePicPath;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public ArrayList<Member> getMember () {
		return members;
	}

	public void setMember(ArrayList<Member> members) {
		this.members = members;
	}	
	public ArrayList<SpvRechargeRecords> getSpvRechargeRecords () {
		return spvRechargeRecordss;
	}

	public void setSpvRechargeRecords(ArrayList<SpvRechargeRecords> spvRechargeRecordss) {
		this.spvRechargeRecordss = spvRechargeRecordss;
	}	
	public ArrayList<SpvWithdrawCashRecords> getSpvWithdrawCashRecords () {
		return spvWithdrawCashRecordss;
	}

	public void setSpvWithdrawCashRecords(ArrayList<SpvWithdrawCashRecords> spvWithdrawCashRecordss) {
		this.spvWithdrawCashRecordss = spvWithdrawCashRecordss;
	}	
	public ArrayList<Subscription> getSubscription () {
		return subscriptions;
	}

	public void setSubscription(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}	
	public ArrayList<BasicProduct> getBasicProduct () {
		return basicProducts;
	}

	public void setBasicProduct(ArrayList<BasicProduct> basicProducts) {
		this.basicProducts = basicProducts;
	}	
	public ArrayList<ProductReturnMoney> getProductReturnMoney () {
		return productReturnMoneys;
	}

	public void setProductReturnMoney(ArrayList<ProductReturnMoney> productReturnMoneys) {
		this.productReturnMoneys = productReturnMoneys;
	}	
	public ArrayList<SpvProductReturnMoney> getSpvProductReturnMoney () {
		return spvProductReturnMoneys;
	}

	public void setSpvProductReturnMoney(ArrayList<SpvProductReturnMoney> spvProductReturnMoneys) {
		this.spvProductReturnMoneys = spvProductReturnMoneys;
	}	
	public ArrayList<PlatformServiceFee> getPlatformServiceFee () {
		return platformServiceFees;
	}

	public void setPlatformServiceFee(ArrayList<PlatformServiceFee> platformServiceFees) {
		this.platformServiceFees = platformServiceFees;
	}	
}
