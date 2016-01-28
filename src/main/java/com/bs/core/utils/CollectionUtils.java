package com.bs.core.utils;

import com.bs.core.entity.Merger;
import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zhangqh6
 * Date: 2015/11/17 17:03:03
 */
public class CollectionUtils {


    /**
     * 数据分组
     * @param list
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> Map<K,List<V>> group(List<V> list, Merger<? super K, ? super V> merger) {
        Map<K,List<V>> retMap = new HashMap<K, List<V>>();
        if(list != null && list.size() > 0) {
            for (V value : list) {
                K key = merger.groupKey(value);
                if(!retMap.containsKey(key)) {
                    retMap.put(key, new ArrayList<V>());
                }
                retMap.get(key).add(value);
            }
        }
        return retMap;
    }
    /**
     * List转Map
     * @param list
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> Map<K,V> convert(List<V> list, Merger<? super K, ? super V> merger) {
        Map<K,V> retMap = new HashMap<K, V>();
        if(list != null && list.size() > 0) {
            for (V value : list) {
                K key = merger.getKey(value);
                retMap.put(key, value);
            }
        }
        return retMap;
    }

    /**
     * List转Map
     * @param list
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> int search(List<V> list,V data, Merger<? super K, ? super V> merger) {
        K dataKey = merger.getKey(data);
        if(list != null && list.size() > 0) {
            for (V value : list) {
                K key = merger.getKey(value);
                if(key.equals(dataKey)) {
                    return list.indexOf(value);
                }
            }
        }
        return -1;
    }

    /**
     * List转Map
     * @param list
     * @param <K>
     * @param <V>
     * @param merger
     * @return
     */
    public static <K,V> K search(Map<K, List<V>> map, V data, Merger<? super K, ? super V> merger) {
        K dataKey = merger.getKey(data);
        for (Map.Entry<K, List<V>> mapEntry : map.entrySet()) {
            int index = search(mapEntry.getValue(), data, merger);
            if(index > -1) {
                return mapEntry.getKey();
            }
        }
        return null;
    }

    /**
     * 列表更新
     * @param srcList 被更新的列表
     * @param destList 更新列表
     * @param merger 合并器
     * @param <K> 对象
     * @param <V> Value
     * @return
     */
    public static <K,V> List<V> update(List<V> srcList, List<V> destList, Merger<? super K, ? super V> merger) {
        //更新列表为空，直接返回源对象即可
        if(destList == null || destList.isEmpty()) {
            return srcList;
        }

        //源对象为空，进行初始化
        if(srcList == null) {
            srcList = new ArrayList<>();
        }

        //循环更新列表，判断对应的值是否存在被更新列表中，
        // 如果存在进行替换，如果不存在直接添加一个新的对象
        flag : for (V dest : destList) {
            K dataKey = merger.getKey(dest);
            for (V value : srcList) {
                K key = merger.getKey(value);
                if(key.equals(dataKey)) {
                    srcList.set(srcList.indexOf(value),dest);
                    break flag;
                }
            }
            srcList.add(dest);

        }
        return srcList;
    }

    /**
     * Map更新
     * @param srcMap
     * @param destMap
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> Map<K, List<V>> update(Map<K, List<V>> srcMap, Map<K, List<V>> destMap, Merger<? super K, ? super V> merger) {
        //更新列表为空，直接返回源对象即可
        if(destMap == null || destMap.isEmpty()) {
            return srcMap;
        }

        //源对象为空，进行初始化
        if(srcMap == null) {
            srcMap = new HashedMap();
        }

        //循环Map对象进行值列表更新
        for (K key : destMap.keySet()) {
            List<V> destList = destMap.get(key);
            List<V> srcList = srcMap.get(key);
            srcList = update(srcList, destList, merger);
            srcMap.put(key,srcList);

        }

        return srcMap;
    }

    public static <K, V> Map<K, V> update (Map<K, V> srcMap, Map<K, V> destMap) {
        //更新列表为空，直接返回源对象即可
        if(destMap == null || destMap.isEmpty()) {
            return srcMap;
        }

        //源对象为空，进行初始化
        if(srcMap == null) {
            srcMap = new HashedMap();
        }

        //循环Map对象进行值列表更新
        srcMap.putAll(destMap);

        return srcMap;
    }

    /**
     * Map更新
     * @param srcMap
     * @param destMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> Map<K, Map<K,V>> updateCollection(Map<K, Map<K,V>> srcMap, Map<K, Map<K,V>> destMap) {
        //更新列表为空，直接返回源对象即可
        if(destMap == null || destMap.isEmpty()) {
            return srcMap;
        }

        //源对象为空，进行初始化
        if(srcMap == null) {
            srcMap = new HashedMap();
        }

        //循环Map对象进行值列表更新
        for (K key : destMap.keySet()) {
            Map<K, V> destValueMap = destMap.get(key);
            Map<K, V> srcValueMap = srcMap.get(key);
            srcValueMap = update(srcValueMap, destValueMap);
            srcMap.put(key,srcValueMap);

        }

        return srcMap;
    }

    /**
     * 列表删除
     * @param srcList 总列表
     * @param destList 删除列表
     * @param merger 合并器
     * @param <K> 对象
     * @param <V> Value
     * @return
     */
    public static <K,V> List<V> remove(List<V> srcList, List<V> destList, Merger<? super K, ? super V> merger) {
        //更新列表为空，直接返回源对象即可
        if(destList == null || destList.isEmpty()) {
            return srcList;
        }

        //源对象为空，进行初始化
        if(srcList == null) {
            return srcList;
        }

        //循环待删除列表，判断对应的值是否存在总列表中，
        // 如果存在直接删除，否则不做任何处理
        for (V dest : destList) {
            int index = CollectionUtils.search(srcList, dest, merger);
            if(index > -1) {
                srcList.remove(index);
            }
        }
        return srcList;
    }

    /**
     * Map删除
     * @param srcMap
     * @param destMap
     * @param merger
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> Map<K, List<V>> remove(Map<K, List<V>> srcMap, Map<K, List<V>> destMap, Merger<? super K, ? super V> merger) {
        //更新列表为空，直接返回源对象即可
        if(destMap == null || destMap.isEmpty()) {
            return srcMap;
        }

        //源对象为空,无需删除，直接返回
        if(srcMap == null) {
            return srcMap;
        }

        //循环Map对象进行列表值删除操作
        for (K key : destMap.keySet()) {
            List<V> destList = destMap.get(key);
            List<V> srcList = srcMap.get(key);
            srcList = remove(srcList, destList, merger);
            srcMap.put(key,srcList);
        }
        return srcMap;
    }

    /**
     * Map删除
     * @param srcMap
     * @param destMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> Map<K, Map<K,V>> removeCollection(Map<K, Map<K,V>> srcMap, Map<K, Map<K,V>> destMap) {
        //更新列表为空，直接返回源对象即可
        if(destMap == null || destMap.isEmpty()) {
            return srcMap;
        }

        //源对象为空,无需删除，直接返回
        if(srcMap == null) {
            return srcMap;
        }

        //循环Map对象进行列表值删除操作
        for (K key : destMap.keySet()) {
            Map<K, V> destValueMap = destMap.get(key);
            Map<K, V> srcValueMap = srcMap.get(key);
            srcValueMap = remove(srcValueMap, destValueMap);
            srcMap.put(key,srcValueMap);
        }

        return srcMap;
    }

    private static <K, V> Map<K, V> remove(Map<K, V> srcMap, Map<K, V> destMap) {
        //更新列表为空，直接返回源对象即可
        if(destMap == null || destMap.isEmpty()) {
            return srcMap;
        }

        //源对象为空,无需删除，直接返回
        if(srcMap == null) {
            return srcMap;
        }


        //循环Map对象进行列表值删除操作
        for (K key : destMap.keySet()) {
            srcMap.remove(key);
        }

        return srcMap;
    }

}
