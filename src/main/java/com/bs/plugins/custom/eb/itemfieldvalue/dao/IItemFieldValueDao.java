package com.bs.plugins.custom.eb.itemfieldvalue.dao;

import java.util.List;

import com.bs.plugins.custom.eb.itemfieldvalue.base.BaseItemFieldValueDao;
import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;

public interface IItemFieldValueDao extends BaseItemFieldValueDao<ItemFieldValue>{
	public List<ItemFieldValue> selectAllItemFieldValueItemField()throws Exception;
}
