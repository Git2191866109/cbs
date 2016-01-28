package com.bs.core.service;

import com.bs.core.dao.RedisDao;
import com.bs.core.entity.Merger;
import com.bs.core.utils.CollectionUtils;
import com.bs.plugins.custom.aa.assetcategory.dao.IAssetCategoryDao;
import com.bs.plugins.custom.aa.assetcategory.entity.AssetCategory;
import com.bs.plugins.custom.aa.riskpreferencedefinition.dao.IRiskPreferenceDefinitionDao;
import com.bs.plugins.custom.aa.riskpreferencedefinition.entity.RiskPreferenceDefinition;
import com.bs.plugins.custom.cc.spvcorporation.dao.ISpvCorporationDao;
import com.bs.plugins.custom.cc.spvcorporation.entity.SpvCorporation;
import com.bs.plugins.custom.eb.budgetcategory.dao.IBudgetCategoryDao;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;
import com.bs.plugins.custom.eb.educationgoal.dao.IEducationGoalDao;
import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;
import com.bs.plugins.custom.eb.educationmode.dao.IEducationModeDao;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;
import com.bs.plugins.custom.eb.goalitemrelation.dao.IGoalItemRelationDao;
import com.bs.plugins.custom.eb.goalitemrelation.entity.GoalItemRelation;
import com.bs.plugins.custom.eb.greadeyear.dao.IGreadeYearDao;
import com.bs.plugins.custom.eb.greadeyear.entity.GreadeYear;
import com.bs.plugins.custom.eb.growstages.dao.IGrowStagesDao;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.itemfield.dao.IItemFieldDao;
import com.bs.plugins.custom.eb.itemfield.entity.ItemField;
import com.bs.plugins.custom.eb.itemfieldvalue.dao.IItemFieldValueDao;
import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;
import com.bs.plugins.custom.pc.attribute.dao.IAttributeDao;
import com.bs.plugins.custom.pc.attribute.entity.Attribute;
import com.bs.plugins.custom.pc.category.dao.ICategoryDao;
import com.bs.plugins.custom.pc.category.entity.Category;
import com.bs.plugins.custom.pc.productattributeconfig.dao.IProductAttributeConfigDao;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.sc.area.dao.IAreaDao;
import com.bs.plugins.custom.sc.area.entity.Area;
import com.bs.plugins.custom.sc.dictionary.dao.IDictionaryDao;
import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;
import com.bs.plugins.custom.sc.dictionarycategory.dao.IDictionaryCategoryDao;
import com.bs.plugins.custom.sc.dictionarycategory.entity.DictionaryCategory;
import com.bs.plugins.custom.sc.parameter.dao.IParameterDao;
import com.bs.plugins.custom.sc.parameter.entity.Parameter;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * User: zhangqh6
 * Date: 2015/12/29 10:21:21
 */
public class RedisService implements InitializingBean {
    public static Logger logger = Logger.getLogger(RedisService.class);

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private IAreaDao areaDao;
    @Autowired
    private IAssetCategoryDao assetCategoryDao;

    @Autowired
    private IBudgetCategoryDao budgetCategoryDao;

    @Autowired
    private ICategoryDao categoryDao;

    @Autowired
    private IDictionaryDao dictionaryDao;

    @Autowired
    private IDictionaryCategoryDao dictionaryCategoryDao;

    @Autowired
    private IEducationGoalDao educationGoalDao;

    @Autowired
    private IEducationModeDao educationModeDao;

    @Autowired
    private IItemFieldDao itemFieldDao;
    
    @Autowired
    private IItemFieldValueDao itemFieldValueDao;
    
    @Autowired
    private IGoalItemRelationDao goalItemRelationDao;

    @Autowired
    private IGreadeYearDao greadeYearDao;

    @Autowired
    private IGrowStagesDao growStagesDao;

    @Autowired
    private IParameterDao parameterDao;

    @Autowired
    private IRiskPreferenceDefinitionDao riskPreferenceDefinitionDao;

    @Autowired
    private ISpvCorporationDao spvCorporationDao;

    @Autowired
    private IAttributeDao attributeDao;

    @Autowired
    private IProductAttributeConfigDao productAttributeConfigDao;

    public static  Map<Class,Merger> mergerMapper = new HashedMap();


    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("==> initializing  redis cache begin.....");

        mergerMapper.put(Area.class, new Merger<Long, Area>() {
            @Override
            public Long getKey(Area area) {
                return area.getId();
            }

            @Override
            public Long groupKey(Area area) {
                return null;
            }
        });

        mergerMapper.put(AssetCategory.class, new Merger<Long, AssetCategory>() {
            @Override
            public Long getKey(AssetCategory assetCategory) {
                return assetCategory.getId();
            }

            @Override
            public Long groupKey(AssetCategory assetCategory) {
                return null;
            }
        });

        mergerMapper.put(BudgetCategory.class,new Merger<Long, BudgetCategory>() {

            @Override
            public Long getKey(BudgetCategory budgetCategory) {
                return budgetCategory.getId();
            }

            @Override
            public Long groupKey(BudgetCategory budgetCategory) {
                return null;
            }
        });

        mergerMapper.put(Category.class,new Merger<Long, Category>() {

            @Override
            public Long getKey(Category category) {
                return category.getId();
            }

            @Override
            public Long groupKey(Category category) {
                return null;
            }
        });

        mergerMapper.put(DictionaryCategory.class, new Merger<Long, DictionaryCategory>() {

            @Override
            public Long getKey(DictionaryCategory dictionaryCategory) {
                return dictionaryCategory.getId();
            }

            @Override
            public Long groupKey(DictionaryCategory dictionaryCategory) {
                return null;
            }
        });

        mergerMapper.put(Dictionary.class, new Merger<Long, Dictionary>() {

            @Override
            public Long getKey(Dictionary dictionary) {
                return dictionary.getId();
            }

            @Override
            public Long groupKey(Dictionary dictionary) {
                return dictionary.getDictCategoryId();
            }
        });

        mergerMapper.put(EducationGoal.class,new Merger<Long, EducationGoal>() {

            @Override
            public Long getKey(EducationGoal educationGoal) {
                return educationGoal.getId();
            }

            @Override
            public Long groupKey(EducationGoal educationGoal) {
                return null;
            }
        });

        mergerMapper.put(EducationMode.class,  new Merger<Long, EducationMode>() {

            @Override
            public Long getKey(EducationMode educationMode) {
                return educationMode.getId();
            }

            @Override
            public Long groupKey(EducationMode educationMode) {
                return null;
            }
        });

        mergerMapper.put(GoalItemRelation.class, new Merger<Long, GoalItemRelation>() {

            @Override
            public Long getKey(GoalItemRelation goalItemRelation) {
                return goalItemRelation.getId();
            }

            @Override
            public Long groupKey(GoalItemRelation goalItemRelation) {
                return null;
            }
        });

        mergerMapper.put(GreadeYear.class, new Merger<Long, GreadeYear>() {

            @Override
            public Long getKey(GreadeYear greadeYear) {
                return greadeYear.getId();
            }

            @Override
            public Long groupKey(GreadeYear greadeYear) {
                return null;
            }
        });

        mergerMapper.put(GrowStages.class, new Merger<Long, GrowStages>() {

            @Override
            public Long getKey(GrowStages growStages) {
                return growStages.getId();
            }

            @Override
            public Long groupKey(GrowStages growStages) {
                return null;
            }
        });

        mergerMapper.put(Parameter.class,new Merger<String, Parameter>() {

            @Override
            public String getKey(Parameter parameter) {
                return parameter.getCode();
            }

            @Override
            public String groupKey(Parameter parameter) {
                return null;
            }
        });

        mergerMapper.put(RiskPreferenceDefinition.class,new Merger<Long, RiskPreferenceDefinition>() {

            @Override
            public Long getKey(RiskPreferenceDefinition riskPreferenceDefinition) {
                return riskPreferenceDefinition.getId();
            }

            @Override
            public Long groupKey(RiskPreferenceDefinition riskPreferenceDefinition) {
                return null;
            }
        });

        mergerMapper.put(SpvCorporation.class,new Merger<Long, SpvCorporation>() {

            @Override
            public Long getKey(SpvCorporation spvCorporation) {
                return spvCorporation.getId();
            }

            @Override
            public Long groupKey(SpvCorporation spvCorporation) {
                return null;
            }
        });

        mergerMapper.put(ProductAttributeConfig.class,new Merger<String, ProductAttributeConfig>() {
            @Override
            public String getKey(ProductAttributeConfig productAttributeConfig) {
                return productAttributeConfig.getAttribute().getCode();
            }

            @Override
            public String groupKey(ProductAttributeConfig productAttributeConfig) {
                return String.valueOf(productAttributeConfig.getProductId());
            }
        });

        mergerMapper.put(Attribute.class, new Merger<Long, Attribute>() {
            @Override
            public Long getKey(Attribute attribute) {
                return attribute.getId();
            }

            @Override
            public Long groupKey(Attribute attribute) {
                return null;
            }

        });

        mergerMapper.put(ItemField.class, new Merger<Long, ItemField>() {


            @Override
            public <K> K getKey(ItemField itemField) {
                return (K) itemField.getId();
            }

            @Override
            public <K> K groupKey(ItemField itemField) {
                return null;
            }
        });
        
        mergerMapper.put(ItemFieldValue.class, new Merger<Long, ItemFieldValue>() {


            @Override
            public <K> K getKey(ItemFieldValue itemField) {
                return (K) itemField.getId();
            }

            @Override
            public <K> K groupKey(ItemFieldValue itemField) {
                return null;
            }
        });
        

        loadCommon(areaDao.selectAll());
        loadCommon(assetCategoryDao.selectAll());
        loadCommon(budgetCategoryDao.selectAll());
        loadCommon(categoryDao.selectAll());
        loadCommon(educationGoalDao.selectAll());
        loadCommon(educationModeDao.selectAll());
        loadCommon(goalItemRelationDao.selectAll());
        loadCommon(greadeYearDao.selectAll());
        loadCommon(growStagesDao.selectAll());
        loadCommon(parameterDao.selectAll());
        loadCommon(riskPreferenceDefinitionDao.selectAll());
        loadCommon(spvCorporationDao.selectAll());
        loadCommon(dictionaryCategoryDao.selectAll());
        loadCommon(attributeDao.selectAll());
        loadCommon(itemFieldDao.selectAll());
        loadCommon(itemFieldValueDao.selectAll());


        loadDictionary(dictionaryDao.selectAll(), dictionaryCategoryDao.selectAll());
        loadProductAttributeConfig(productAttributeConfigDao.selectAssociations(new ProductAttributeConfig()));





        logger.debug("==> initializing  redis cache finish.....");


    }

    private void loadProductAttributeConfig(List<ProductAttributeConfig> productAttributeConfigs) {

        logger.debug("==> load [" + ProductAttributeConfig.class + "] begin ..");

        Map<String, List<ProductAttributeConfig>> productAttrMap =
                CollectionUtils.group(productAttributeConfigs, mergerMapper.get(ProductAttributeConfig.class));
        Map<String, Map<String,ProductAttributeConfig>> resultMap = new HashedMap();
        for (String productId : productAttrMap.keySet()) {
            List<ProductAttributeConfig> tempList = productAttrMap.get(productId);
            resultMap.put(productId,CollectionUtils.convert(tempList,mergerMapper.get(ProductAttributeConfig.class)));
        }

        String mapKey = getRedisMapKey(ProductAttributeConfig.class);
        redisDao.update(mapKey, resultMap);

        logger.debug("==> load [" + ProductAttributeConfig.class + "] finish..");

    }

    public <T> void loadCommon(List<T> t) throws Exception {
        if(t == null || t.size() == 0) {
            return;
        }
        Class classz = t.get(0).getClass();
        logger.debug("==> load [" + classz + "] begin ..");
        load(t, mergerMapper.get(classz));
        logger.debug("==> load [" + classz + "] finish..");
    }

    public void loadDictionary(List<Dictionary> dictionaryList, List<DictionaryCategory> dictionaryCategories) throws Exception {
        logger.debug("==> load [" + Dictionary.class + "] begin ..");

        Map<Long, List<Dictionary>> dictionaryMap =
                CollectionUtils.group(dictionaryList, mergerMapper.get(Dictionary.class));

        Map<Long, DictionaryCategory> dictionaryCategoryMap =
                CollectionUtils.convert(dictionaryCategories,mergerMapper.get(DictionaryCategory.class));

        Map<String, List<Dictionary>> resultMap = new HashedMap();
        for (Long categoryId : dictionaryCategoryMap.keySet()) {
            resultMap.put(dictionaryCategoryMap.get(categoryId).getCode(),dictionaryMap.get(categoryId));
        }

        String mapKey = getRedisMapKey(Dictionary.class);
        redisDao.update(mapKey, resultMap);

        logger.debug("==> load [" + Dictionary.class + "] finish..");
    }


    public <T> void updateCommon(List<T> t) throws Exception {
        if(t == null || t.size() == 0) {
            return;
        }
        Class classz = t.get(0).getClass();
        logger.debug("==> update [" + classz + "] begin ..");
        update(t, mergerMapper.get(classz));
        logger.debug("==> update [" + classz + "] finish..");
    }




    public void updateDictionary(List<Dictionary> dictionaryList, List<DictionaryCategory> dictionaryCategories) throws Exception {
        logger.debug("==> update [" + Dictionary.class + "] begin ..");

        Map<Long, List<Dictionary>> dictionaryMap =
                CollectionUtils.group(dictionaryList, mergerMapper.get(Dictionary.class));

        Map<Long, DictionaryCategory> dictionaryCategoryMap =
                CollectionUtils.convert(dictionaryCategories,mergerMapper.get(DictionaryCategory.class));

        Map<String, List<Dictionary>> resultMap = new HashedMap();
        for (Long categoryId : dictionaryCategoryMap.keySet()) {
            resultMap.put(dictionaryCategoryMap.get(categoryId).getCode(),dictionaryMap.get(categoryId));
        }

        String mapKey = getRedisMapKey(Dictionary.class);

        Map<String, List<Dictionary>> mapList = redisDao.getMapList(mapKey, Dictionary.class);
        mapList = CollectionUtils.update(mapList,resultMap,mergerMapper.get(Dictionary.class));
        redisDao.update(mapKey, mapList);

        logger.debug("==> load [" + Dictionary.class + "] finish..");
    }

    public void updateProductAttributeConfig(List<ProductAttributeConfig> productAttributeConfigs) {

        logger.debug("==> update [" + ProductAttributeConfig.class + "] begin ..");

        Map<String, List<ProductAttributeConfig>> productAttrMap =
                CollectionUtils.group(productAttributeConfigs, mergerMapper.get(ProductAttributeConfig.class));
        Map<String, Map<String,ProductAttributeConfig>> resultMap = new HashedMap();
        for (String productId : productAttrMap.keySet()) {
            List<ProductAttributeConfig> tempList = productAttrMap.get(productId);
            resultMap.put(productId,CollectionUtils.convert(tempList, mergerMapper.get(ProductAttributeConfig.class)));
        }

        String mapKey = getRedisMapKey(ProductAttributeConfig.class);


        Map<String, Map<String, ProductAttributeConfig>>  redisMap = redisDao.getMapCollection(mapKey, ProductAttributeConfig.class);
        redisMap = CollectionUtils.updateCollection(redisMap, resultMap);
        redisDao.update(mapKey, redisMap);

        logger.debug("==> update [" + ProductAttributeConfig.class + "] finish..");
    }



    public <T> void removeCommon(List<T> t) throws Exception {
        if(t == null || t.size() == 0) {
            return;
        }
        Class classz = t.get(0).getClass();
        logger.debug("==> remove [" + classz + "] begin ..");
        remove(t, mergerMapper.get(classz));
        logger.debug("==> remove [" + classz + "] finish..");
    }

    public void removeDictionary(List<Dictionary> dictionaryList, List<DictionaryCategory> dictionaryCategories) throws Exception {
        logger.debug("==> remove [" + Dictionary.class + "] begin ..");
        String mapKey = getRedisMapKey(Dictionary.class);
        Map<String, List<Dictionary>> mapList = redisDao.getMapList(mapKey, Dictionary.class);


        Map<Long, List<Dictionary>> dictionaryMap =
                CollectionUtils.group(dictionaryList, mergerMapper.get(Dictionary.class));

        Map<Long, DictionaryCategory> dictionaryCategoryMap =
                CollectionUtils.convert(dictionaryCategories, mergerMapper.get(DictionaryCategory.class));


        Map<String, List<Dictionary>> resultMap = new HashedMap();
        for (Long categoryId : dictionaryCategoryMap.keySet()) {
            resultMap.put(dictionaryCategoryMap.get(categoryId).getCode(),dictionaryMap.get(categoryId));
        }

        //当外界如果没有归集传过来，重缓存中匹配
        if(resultMap.isEmpty() && dictionaryList.size() > 0) {
            String dictionaryCategoryCode =
                        CollectionUtils.search(mapList, dictionaryList.get(0), mergerMapper.get(Dictionary.class));
            for (List<Dictionary> dictionarys : dictionaryMap.values()) {
                resultMap.put(dictionaryCategoryCode,dictionarys);
            }
        }

        mapList = CollectionUtils.remove(mapList, resultMap, mergerMapper.get(Dictionary.class));
        redisDao.update(mapKey, mapList);

        logger.debug("==> remove [" + Dictionary.class + "] finish..");
    }


    public void removeProductAttributeConfig(List<ProductAttributeConfig> productAttributeConfigs) {

        logger.debug("==> remove [" + ProductAttributeConfig.class + "] begin ..");

        Map<String, List<ProductAttributeConfig>> productAttrMap =
                CollectionUtils.group(productAttributeConfigs, mergerMapper.get(ProductAttributeConfig.class));
        Map<String, Map<String,ProductAttributeConfig>> resultMap = new HashedMap();
        for (String productId : productAttrMap.keySet()) {
            List<ProductAttributeConfig> tempList = productAttrMap.get(productId);
            resultMap.put(productId,CollectionUtils.convert(tempList, mergerMapper.get(ProductAttributeConfig.class)));
        }

        String mapKey = getRedisMapKey(ProductAttributeConfig.class);

        Map<String, Map<String, ProductAttributeConfig>>  redisMap = redisDao.getMapCollection(mapKey, ProductAttributeConfig.class);
        redisMap = CollectionUtils.updateCollection(redisMap, resultMap);
        redisDao.update(mapKey, redisMap);

        logger.debug("==> remove [" + ProductAttributeConfig.class + "] finish..");
    }

    public IAssetCategoryDao getAssetCategoryDao() {
        return assetCategoryDao;
    }

    public void setAssetCategoryDao(IAssetCategoryDao assetCategoryDao) {
        this.assetCategoryDao = assetCategoryDao;
    }

    public IAreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(IAreaDao areaDao) {
        this.areaDao = areaDao;
    }

    public IBudgetCategoryDao getBudgetCategoryDao() {
        return budgetCategoryDao;
    }

    public void setBudgetCategoryDao(IBudgetCategoryDao budgetCategoryDao) {
        this.budgetCategoryDao = budgetCategoryDao;
    }

    public ICategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * redis加载数据
     * @param dataList
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> boolean load(List<V> dataList, Merger<? super K, ? super V> merger) {

        //如果为空直接返回成功
        if(dataList == null || dataList.size() == 0) {
            return true;
        }

        Map<K, V> dataMap = CollectionUtils.convert(dataList, merger);

        Class<?> vClass = dataList.get(0).getClass();

        //缓存全部列表
        String listKey = getRedisListKey(vClass);
        redisDao.update(listKey, dataList);

        //缓存单个对象
        String mapKey = getRedisMapKey(vClass);
        redisDao.update(mapKey, dataMap);

        return true;
    }

    /**
     * redis更新数据
     * @param dataList
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> boolean update(List<V> dataList, Merger<? super K, ? super V> merger) {
        //如果为空直接返回成功
        if(dataList == null || dataList.size() == 0) {
            return true;
        }

        Class<?> clazz = dataList.get(0).getClass();

        //取出list进行更新
        String listKey = getRedisListKey(clazz);
        List<V> list = (List<V>) redisDao.getList(listKey, clazz);
        list = CollectionUtils.update(list, dataList, merger);
        redisDao.update(listKey, list);

        //取出map进行更新
        String mapKey = getRedisMapKey(clazz);
        Map<K, V>  redisMap = (Map<K, V>) redisDao.getMap(mapKey, clazz);
        Map<K, V> dataMap = CollectionUtils.convert(dataList, merger);
        if(redisMap == null)  redisMap = new HashedMap();
        redisMap.putAll(dataMap);
        redisDao.update(mapKey, redisMap);
        return true;
    }

    /**
     * redis删除数据
     * @param dataList
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> boolean remove(List<V> dataList, Merger<? super K, ? super V> merger) {
        //如果为空直接返回成功
        if(dataList == null || dataList.size() == 0) {
            return true;
        }

        Class<?> clazz = dataList.get(0).getClass();

        //取出list进行更新
        String listKey = getRedisListKey(clazz);
        List<V> redisList = (List<V>) redisDao.getList(listKey, clazz);
        redisList = CollectionUtils.remove(redisList, dataList, merger);
        redisDao.update(listKey, redisList);

        //取出map进行更新
        String mapKey = getRedisMapKey(clazz);
        Map<K, V>  redisMap = (Map<K, V>) redisDao.getMap(mapKey, clazz);
        Map<K, V> dataMap = CollectionUtils.convert(dataList, merger);
        for (K key : dataMap.keySet()) {
                redisMap.remove((K)key);
            //字符串类型需动态转为泛型类型，(Map<K, V>) redisDao.getMap(mapKey, clazz)类型本分泛型K，不成立
            redisMap.remove(String.valueOf(key));
        }
        redisDao.update(mapKey, redisMap);
        return true;
    }

    /**
     * redis加载数据
     * @param dataList
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> boolean loadMapList(List<V> dataList, Merger<? super K, ? super V> merger) {

        //如果为空直接返回成功
        if(dataList == null || dataList.size() == 0) {
            return true;
        }
        Class<?> vClass = dataList.get(0).getClass();
        String mapListKey = getRedisMapKey(vClass);

        Map<K, List<V>> dataMap = CollectionUtils.group(dataList, merger);

        redisDao.update(mapListKey, dataMap);
        return true;
    }

    /**
     * redis更新数据
     * @param dataList
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> boolean updateMapList(List<V> dataList, Merger<? super K, ? super V> merger) {
        //如果为空直接返回成功
        if(dataList == null || dataList.size() == 0) {
            return true;
        }

        Class<?> clazz = dataList.get(0).getClass();
        String mapKey = getRedisMapKey(clazz);

        //取出map进行更新
        Map<K, List<V>> dataMap = CollectionUtils.group(dataList, merger);
        Map<K, List<V>>  redisMap = ( Map<K, List<V>>) redisDao.getMap(mapKey, clazz);
        //map合并
        redisMap = CollectionUtils.update(redisMap, dataMap, merger);
        redisDao.update(mapKey, redisMap);
        return true;
    }


    /**
     * redis删除数据
     * @param dataList
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public <K,V> boolean removeMapList(List<V> dataList, Merger<? super K, ? super V> merger) {
        //如果为空直接返回成功
        if(dataList == null || dataList.size() == 0) {
            return true;
        }

        Class<?> clazz = dataList.get(0).getClass();
        String mapKey = getRedisMapKey(clazz);

        //取出map进行更新
        Map<K, List<V>> dataMap = CollectionUtils.group(dataList, merger);
        Map<K, List<V>>  redisMap = ( Map<K, List<V>>) redisDao.getMap(mapKey, clazz);
        //map合并
        redisMap = CollectionUtils.remove(redisMap, dataMap, merger);
        redisDao.update(mapKey, redisMap);
        return true;
    }






    /**
     * 	获取类的名称为redis key值
     * @param cls
     * @return
     */
    public String getRedisKey(Class<?> cls){
        return cls.asSubclass(cls).getSimpleName();
    }

    /**
     * 获取redis list key
     * @param cls
     * @return
     */
    public String getRedisListKey(Class<?> cls){
        return cls.asSubclass(cls).getSimpleName() + "_list";
    }
    /**
     * 获取redis map key
     * @param cls
     * @return
     */
    public String getRedisMapKey(Class<?> cls){
        return cls.asSubclass(cls).getSimpleName() + "_map";
    }


    public RedisDao getRedisDao() {
        return redisDao;
    }

    public void setRedisDao(RedisDao redisDao) {
        this.redisDao = redisDao;
    }
}
