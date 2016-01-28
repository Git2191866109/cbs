package com.bs.plugins.custom.sc.dictionary.dao;

import java.util.List;
import java.util.Map;

import com.bs.plugins.custom.sc.dictionary.base.BaseDictionaryDao;
import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;

public interface IDictionaryDao extends BaseDictionaryDao<Dictionary>{
    public List<Dictionary> selectPaginatedByDictionaryCategoryIdList(Dictionary Dictionary) throws Exception;


    /**
     * 查询列表
     * @param sqlid
     * @param t
     * @return List
     */
    public List<Dictionary> selectDynamicTableDataList(Map entity) throws Exception;
}
