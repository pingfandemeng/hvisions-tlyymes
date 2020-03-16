package com.hvisions.mes.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @description: redis工具类
 * @author: Bruce
 * @version:
 * @date: 2019-11-11 11:08
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     */
    public boolean set(final Object key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新缓存
     */
    public boolean getAndSet(final Object key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     */
    public boolean delete(final Object key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
