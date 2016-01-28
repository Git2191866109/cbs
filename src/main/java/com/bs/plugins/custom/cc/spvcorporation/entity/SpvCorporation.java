package com.bs.plugins.custom.cc.spvcorporation.entity;




import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.cc.spvcorporation.base.BaseSpvCorporation;

public class SpvCorporation extends BaseSpvCorporation {

	private static final long serialVersionUID = 1L;

	public SpvCorporation() {
	}
	/**组织机构代码-机构代码**/
	@NotEmpty
	private String code;
	/**托管账户号-**/
	@NotEmpty
	private String umpayAccountNo;
	/**托管商户号-**/
	@NotEmpty
	private String umpayMerchantNo;
	/**机构名称-机构名称：定义记录机构的名称。**/
	@NotEmpty
	private String name;
	/**银行名称-**/
	@NotEmpty
	private String bankName;
	/**银行卡号-**/
	@NotEmpty
	private String bankCardNumber;
	/**银行代码-**/
	@NotEmpty
	private String bankCode;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getUmpayAccountNo() {
		return umpayAccountNo;
	}
	public void setUmpayAccountNo(String umpayAccountNo) {
		this.umpayAccountNo = umpayAccountNo;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCardNumber() {
		return bankCardNumber;
	}
	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

}
