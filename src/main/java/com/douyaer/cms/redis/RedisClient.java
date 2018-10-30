package com.douyaer.cms.redis;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisClient {

    @Autowired
    protected RedisTemplate<String, Serializable> redisTemplate;


    public void cleanCache() {
        Set<String> keys = redisTemplate.keys("*");
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

}