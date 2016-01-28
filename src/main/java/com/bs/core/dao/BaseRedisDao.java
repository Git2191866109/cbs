package com.bs.core.dao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;


public abstract class BaseRedisDao<K, T>{
	
	private RedisTemplate<K, T> redisTemplate;

	public RedisTemplate<K, T> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<K, T> redisTemplate) {
		this.redisTemplate = redisTemplate;
	} 

	protected RedisSerializer<String> getRedisSerializer() {  
        return redisTemplate.getStringSerializer();  
    } 
}
 