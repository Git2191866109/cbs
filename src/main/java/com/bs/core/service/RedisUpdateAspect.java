package com.bs.core.service;

import com.bs.core.entity.Entity;
import com.bs.plugins.custom.pc.attribute.entity.Attribute;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;
import com.bs.plugins.custom.sc.dictionarycategory.entity.DictionaryCategory;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * User: zhangqh6
 * Date: 2015/12/30 10:56:56
 */
@Aspect
public class RedisUpdateAspect implements InitializingBean {

    private RedisService redisService;

    @Pointcut("execution(* com.bs.plugins.custom..dao.IAreaDao.*(..))"
            + "|| execution(* com.bs.plugins.custom..dao.IAssetCategoryDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IBudgetCategoryDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.ICategoryDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IDictionaryDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IDictionaryCategoryDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IEducationGoalDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IEducationModeDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IGoalItemRelationDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IGreadeYearDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IGrowStagesDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IParameterDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IRiskPreferenceDefinitionDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IProductAttributeConfigDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IAttributeDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.ISpvCorporationDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IItemFieldDao.*(..)) "
            + "|| execution(* com.bs.plugins.custom..dao.IItemFieldValueDao.*(..)) "
    )
    public void configDataDao(){}


    @Pointcut("execution(* add*(..))"
            + "||execution(* insert*(..))"
            + "||execution(* save*(..))")
    public void insertMethod(){}

    @Pointcut("execution(* update*(..))"
            + "||execution(* modify*(..))"
            + "||execution(* edit*(..))"
    )
    public void updateMethod(){}


    @Pointcut("execution(* delete*(..))"
            + "||execution(* remove*(..))"
            + "||execution(* move*(..))" )
    public void removeMethod(){}


    @AfterReturning("configDataDao() && insertMethod() && args(entity)")
    public void doRedisInsert(JoinPoint joinPoint, Entity entity) {
        try {
            entity = (Entity) BeanUtils.cloneBean(entity);
            entity.setId(entity.getGeneratedKey());
            entity.setHttpServletRequest(null);
            entity.setHttpServletResponse(null);
            entity.setBindingResult(null);
            entity.setModelMap(null);
            entity.setButtonGroup(null);
            if(entity.getClass().equals(Dictionary.class)) {
                //获得更新的字典对象
                Dictionary dictionary = (Dictionary) entity;
                List<Dictionary> dictionaryList = Arrays.asList(new Dictionary[]{dictionary});

                //根据字典对象归属查询字典分类对象
                Map<String, DictionaryCategory> map =
                        redisService.getRedisDao().getMap(redisService.getRedisMapKey(DictionaryCategory.class), DictionaryCategory.class);
                List<DictionaryCategory> dictionaryCategoryList = Arrays.asList(new DictionaryCategory[]{map.get(String.valueOf(dictionary.getDictCategoryId()))});

                //同时字典组合对象至字典表中
                redisService.updateDictionary(dictionaryList, dictionaryCategoryList);
            }else if(entity.getClass().equals(ProductAttributeConfig.class)) {
                ProductAttributeConfig productAttributeConfig = (ProductAttributeConfig) entity;

                //查询属性信息
                Map<String, Attribute> map =
                        redisService.getRedisDao().getMap(redisService.getRedisMapKey(Attribute.class), Attribute.class);
                Attribute attribute = map.get(String.valueOf(productAttributeConfig.getAttributeId()));
                productAttributeConfig.setAttribute(attribute);

                redisService.updateProductAttributeConfig(Arrays.asList(new ProductAttributeConfig[]{productAttributeConfig}));
            }else {
                redisService.updateCommon(Arrays.asList(new Entity[]{entity}));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterReturning("configDataDao() && updateMethod() && args(entity)")
    public void doRedisUpdate(JoinPoint joinPoint, Entity entity) {
        try {
            entity = (Entity) BeanUtils.cloneBean(entity);
            entity.setHttpServletRequest(null);
            entity.setHttpServletResponse(null);
            entity.setBindingResult(null);
            entity.setModelMap(null);
            entity.setButtonGroup(null);
            if(entity.getClass().equals(Dictionary.class)) {
                //获得更新的字典对象
                Dictionary dictionary = (Dictionary) entity;
                List<Dictionary> dictionaryList = Arrays.asList(new Dictionary[]{dictionary});

                //根据字典对象归属查询字典分类对象
                Map<String, DictionaryCategory> map =
                        redisService.getRedisDao().getMap(redisService.getRedisMapKey(DictionaryCategory.class), DictionaryCategory.class);
                List<DictionaryCategory> dictionaryCategoryList =  Arrays.asList(new DictionaryCategory[]{map.get(String.valueOf(dictionary.getDictCategoryId()))});

                //同时字典组合对象至字典表中
                redisService.updateDictionary(dictionaryList, dictionaryCategoryList);
            }else if(entity.getClass().equals(ProductAttributeConfig.class)) {
                ProductAttributeConfig productAttributeConfig = (ProductAttributeConfig) entity;

                //查询属性信息
                Map<String, Attribute> map =
                        redisService.getRedisDao().getMap(redisService.getRedisMapKey(Attribute.class), Attribute.class);
                Attribute attribute = map.get(String.valueOf(productAttributeConfig.getAttributeId()));
                productAttributeConfig.setAttribute(attribute);

                redisService.updateProductAttributeConfig(Arrays.asList(new ProductAttributeConfig[]{productAttributeConfig}));
            }else {
                redisService.updateCommon(Arrays.asList(new Entity[]{entity}));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterReturning("configDataDao() && removeMethod() && args(entity)")
    public void doRedisRemove(JoinPoint joinPoint, Entity entity) {
        try {
            entity = (Entity) BeanUtils.cloneBean(entity);
            entity.setHttpServletRequest(null);
            entity.setHttpServletResponse(null);
            entity.setBindingResult(null);
            entity.setModelMap(null);
            entity.setButtonGroup(null);
            if(entity.getClass().equals(Dictionary.class)) {
                //获得更新的字典对象
                Dictionary dictionary = (Dictionary) entity;
                List<Dictionary> dictionaryList = Arrays.asList(new Dictionary[]{dictionary});

                //根据字典对象归属查询字典分类对象
                Map<String, DictionaryCategory> map =
                        redisService.getRedisDao().getMap(redisService.getRedisMapKey(DictionaryCategory.class), DictionaryCategory.class);
                List<DictionaryCategory> dictionaryCategoryList =  new ArrayList<>();
                if(map.get(String.valueOf(dictionary.getDictCategoryId())) != null) {
                    dictionaryCategoryList.add(map.get(String.valueOf(dictionary.getDictCategoryId())));
                }

                //同时字典组合对象至字典表中
                redisService.removeDictionary(dictionaryList, dictionaryCategoryList);
            }else if(entity.getClass().equals(ProductAttributeConfig.class)) {
//                redisService.removeProductAttributeConfig(Arrays.asList(new ProductAttributeConfig[]{(ProductAttributeConfig) entity}));
            }else {
                redisService.removeCommon(Arrays.asList(new Entity[]{entity}));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RedisService getRedisService() {
        return redisService;
    }

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
