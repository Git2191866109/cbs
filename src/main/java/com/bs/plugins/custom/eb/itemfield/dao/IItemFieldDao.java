package com.bs.plugins.custom.eb.itemfield.dao;

import java.util.List;

import com.bs.plugins.custom.eb.itemfield.base.BaseItemFieldDao;
import com.bs.plugins.custom.eb.itemfield.entity.ItemField;

public interface IItemFieldDao extends BaseItemFieldDao<ItemField>{
	
	public List<ItemField> selectPaginatedListByItemId(ItemField itemField)throws Exception;
	public List<ItemField> selectCollectionTwo(ItemField itemField)throws Exception;
	public List<ItemField> selectCollectionOne(ItemField itemField)throws Exception;
}
