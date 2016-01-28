package com.bs.plugins.custom.tc.bankbasicinfo.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;


public class BaseBankBasicInfo extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**银行ID-**/
	private Long id;
	/**银行代码-**/
	private String code;
	/**银行名称-**/
	private String name;
	/**单笔限额-**/
	private BigDecimal singleLimit;
	/**单日限额-**/
	private BigDecimal singleDayLimit;
	/**是否有效-**/
	private Integer status;
	/**创建时间-**/
	private String createDate;

	public BaseBankBasicInfo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSingleLimit() {
		return singleLimit;
	}

	public void setSingleLimit(BigDecimal singleLimit) {
		this.singleLimit = singleLimit;
	}
	public BigDecimal getSingleDayLimit() {
		return singleDayLimit;
	}

	public void setSingleDayLimit(BigDecimal singleDayLimit) {
		this.singleDayLimit = singleDayLimit;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
