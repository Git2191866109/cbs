package com.bs.plugins.custom.pc.category.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;	
import java.util.ArrayList;

public class BaseCategory extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**名称-名称 收益权转让 收益权转让回购 新手产品**/
	private String name;
	/**编码-编码**/
	private String code;
	/**描述-描述**/
	private String description;
	/**创建人-创建人**/
	private Long creatorId;
	/**创建时间-创建时间**/
	private String createTime;
	/**修改人-修改人**/
	private Long modifierId;
	/**修改时间-修改时间**/
	private String modifyTime;
	/**删除标识-1：是 0：否**/
	private Integer isDelete;
	/**产品中心--产品结构配置表**/
	private ArrayList<StructureConfig> structureConfigs;

	public BaseCategory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getisDelete() {
		return isDelete;
	}

	public void setisDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	public ArrayList<StructureConfig> getStructureConfig () {
		return structureConfigs;
	}

	public void setStructureConfig(ArrayList<StructureConfig> structureConfigs) {
		this.structureConfigs = structureConfigs;
	}	
}
