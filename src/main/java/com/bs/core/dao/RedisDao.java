package com.bs.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bs.core.entity.Entity;

public class RedisDao extends BaseRedisDao<String,Entity> implements IBaseRedisDao<Entity>{
	
	@Override
	public boolean add(final String key, final Entity entity) {
		boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] keybt  = serializer.serialize(String.valueOf(key)); 
                String value = JSON.toJSON(entity).toString();
                byte[] json = serializer.serialize(value);  
                return connection.setNX(keybt, json);  
            }  
        });  
        return result; 
	}

	public String getString(final String key) {
		String result = super.getRedisTemplate().execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();

				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				String mjson = serializer.deserialize(value);
				return mjson;
			}
		});
		return result;
	}
	
	
	@Override
	public boolean add(final Entity entity) {
		boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] key  = serializer.serialize(String.valueOf(entity.getId())); 
                String value = JSON.toJSON(entity).toString();
                byte[] json = serializer.serialize(value);  
                return connection.setNX(key, json);  
            }  
        });  
        return result; 
	}

	@Override
	public boolean add(final List<Entity> list) {
		Assert.notEmpty(list);  
        boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                for (Entity entity : list) {  
                	byte[] key  = serializer.serialize(String.valueOf(entity.getId())); 
                    String value = JSON.toJSON(entity).toString();
                    byte[] json = serializer.serialize(value); 
                    connection.setNX(key, json);  
                }  
                return true;  
            }  
        }, false, true);  
        return result;  
	}


	@Override
	public boolean update(final Entity entity) {
		String key = String.valueOf(entity.getId());
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }
        boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(String.valueOf(entity.getId()));
                String value = JSON.toJSON(entity).toString();
                byte[] json = serializer.serialize(value);
                connection.set(key, json);
                return true;
            }
        });
        return result;
	}

	@Override
	public boolean update(final String key, final Entity entity) {
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }
        boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(String.valueOf(entity.getId()));
                String value = JSON.toJSON(entity).toString();
                byte[] json = serializer.serialize(value);
                connection.set(key, json);
                return true;
            }
        });
        return result;
	}





	@Override
	public boolean add(final String keyId, final String value) {
		// TODO Auto-generated method stub
		boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(keyId);
                byte[] json = serializer.serialize(value);
                return connection.setNX(key, json);
            }
        });
        return result;
	}


	@Override
	public String getByString(final String keyId) {
		// TODO Auto-generated method stub
		String result = super.getRedisTemplate().execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keybt = serializer.serialize(keyId);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				String mjson = serializer.deserialize(value);
				return mjson;
			}
		});
		return result;
	}


	public <K,T> Map<K,T> getMap(final String key, final Class<T> cls) {
		Map<K,T> result = super.getRedisTemplate().execute(new RedisCallback<Map<K,T>>() {
			@SuppressWarnings("unchecked")
			public Map<K,T> doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				System.out.println(key);
				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				Map<K,T> resultMap = new HashMap<K,T>();
				String mjson = serializer.deserialize(value);
				if (mjson != null){
					JSONObject jsonObject = JSON.parseObject(mjson);
					Iterator<String> iterator = jsonObject.keySet().iterator();
					while(iterator.hasNext()){
						String key = iterator.next();
						String val = jsonObject.getString(key);
						K k = (K) key;
						T t = (T) JSON.parseObject(val, cls);
						resultMap.put(k, t);
					}
				}
				return resultMap;
			}
		});
		return result;
	}


	/*******************************************************/
	public void delete(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		delete(list);
	}

	public void delete(List<String> keys) {
		super.getRedisTemplate().delete(keys);
	}


	public <T> boolean update(final String key, final T t) {
		if (get(key) == null) {
			//如果值不存在，则添加入库
			return this.add(key, t);
		}
		boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keyTemp  = serializer.serialize(key);
				String value = JSON.toJSON(t).toString();
				byte[] json = serializer.serialize(value);
				connection.set(keyTemp, json);
				return true;
			}
		});
		return result;
	}

	public String get(final String key) {
		String result = super.getRedisTemplate().execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				String mjson = serializer.deserialize(value);
				return mjson;
			}
		});
		return result;
	}

	public <K,T> Map<K,T> getMapObject(final String key, final Class<T> cls) {
		Map<K,T> result = super.getRedisTemplate().execute(new RedisCallback<Map<K,T>>() {
			@SuppressWarnings("unchecked")
			public Map<K,T> doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				System.out.println(key);
				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				Map<K,T> resultMap = new HashMap<K,T>();
				String mjson = serializer.deserialize(value);
				if (mjson != null){
					JSONObject jsonObject = JSON.parseObject(mjson);
					Iterator<String> iterator = jsonObject.keySet().iterator();
					while(iterator.hasNext()){
						String key = iterator.next();
						String val = jsonObject.getString(key);
						K k = (K) key;
						T t = (T) JSON.parseObject(val, cls);
						resultMap.put(k, t);
					}
				}
				return resultMap;
			}
		});
		return result;
	}

	public <K,T> Map<K,List<T>> getMapList(final String key, final Class<T> cls) {
		Map<K,List<T>> result = super.getRedisTemplate().execute(new RedisCallback<Map<K,List<T>>>() {
			@SuppressWarnings("unchecked")
			public Map<K,List<T>> doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				Map<K,List<T>> resultMap = new HashMap<K,List<T>>();
				String mjson = serializer.deserialize(value);
				if (mjson != null){
					JSONObject jsonObject = JSON.parseObject(mjson);
					Iterator<String> iterator = jsonObject.keySet().iterator();
					while(iterator.hasNext()){
						String key = iterator.next();
						String val = jsonObject.getString(key);
						K k = (K) key;
						List<T> t = (List<T>) JSON.parseArray(val, cls);
						resultMap.put(k, t);
					}
				}
				return resultMap;
			}
		});
		return result;
	}

	public <K,T> Map<K,Map<K,T>> getMapCollection(final String key, final Class<T> cls) {
		Map<K,Map<K,T>> result = super.getRedisTemplate().execute(new RedisCallback<Map<K,Map<K,T>>>() {
			@SuppressWarnings("unchecked")
			public Map<K,Map<K,T>> doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				Map<K,Map<K,T>> resultMap = new HashMap<K,Map<K,T>>();
				String mjson = serializer.deserialize(value);
				if (mjson != null){
					JSONObject jsonObject = JSON.parseObject(mjson);
					Iterator<String> iterator = jsonObject.keySet().iterator();
					while(iterator.hasNext()){
						String key = iterator.next();
						String val = jsonObject.getString(key);
						K k = (K) key;
						JSONObject jsonObjectTemp = JSON.parseObject(val);
						Iterator<String> iteratorTemp = jsonObjectTemp.keySet().iterator();
						Map<K,T> map = new HashMap<K,T>();
						while(iteratorTemp.hasNext()){
							String keyTemp = iteratorTemp.next();
							String valTemp = jsonObjectTemp.getString(keyTemp);
							K ktemp = (K) keyTemp;
							T ttemp = JSON.parseObject(valTemp,cls);
							map.put(ktemp, ttemp);
						}
						resultMap.put(k, map);
					}
				}
				return resultMap;
			}
		});
		return result;
	}

	public <T> List<T> getList(final String key, final Class<T> cls) {
		List<T> result = super.getRedisTemplate().execute(new RedisCallback<List<T>>() {
			public List<T> doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				String mjson = serializer.deserialize(value);
				return (List<T>) JSON.parseArray(mjson, cls);
			}
		});
		return result;
	}

	public <T> T get(final String key, final Class<T> cls) {
		T result = super.getRedisTemplate().execute(new RedisCallback<T>() {
			public T doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keybt = serializer.serialize(key);
				byte[] value = connection.get(keybt);
				if (value == null) {
					return null;
				}
				String mjson = serializer.deserialize(value);
				return (T) JSON.parseObject(mjson, cls);
			}
		});
		return result;
	}

	public <T> boolean add(final String key,final T t) {
		boolean result = super.getRedisTemplate().execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] keybt  = serializer.serialize(String.valueOf(key));
				String value = JSON.toJSON(t).toString();
				byte[] json = serializer.serialize(value);
				return connection.setNX(keybt, json);
			}
		});
		return result;
	}

	/**
	 * 获取redis map key
	 * @param cls
	 * @return
	 */
	public String getRedisMapKey(Class<?> cls){
		return cls.asSubclass(cls).getSimpleName() + "_map";
	}
}
