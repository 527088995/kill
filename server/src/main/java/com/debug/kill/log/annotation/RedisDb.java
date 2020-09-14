package com.debug.kill.log.annotation;


import com.debug.kill.log.util.SpringContextHolder;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisDb<T> {


    private Class<T> clazz;

    private StringRedisTemplate baseMapper;

    private PropertiesEnv propertiesEnv;


    private RedisDb(Class clazz) {
        this.clazz = clazz;
        this.baseMapper = (StringRedisTemplate) SpringContextHolder.getBean(clazz);
        this.propertiesEnv = (PropertiesEnv) SpringContextHolder.getBean(clazz);
    }


    public static <T> RedisDb<T> create(Class<T> clazz) {
        return new RedisDb<T>(clazz);
    }


    public StringRedisTemplate getMapper() {
        return this.baseMapper;
    }

    public PropertiesEnv getPropertiesEnv() {
        return this.propertiesEnv;
    }


    public static <T> T getMapper(Class<T> clazz) {
        return SpringContextHolder.getBean(clazz);
    }
    public static <T> T getPropertiesEnv(Class<T> clazz) {
        return SpringContextHolder.getBean(clazz);
    }

}
