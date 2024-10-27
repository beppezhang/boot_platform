package com.beppe.kafka.cache;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheManager = "defaultCacheManager11")
public class CaffeineService {

    // 手动创建缓存

    @Resource
    @Qualifier("manualCache")
    private Cache<Object, Object> manualCache;

    @Cacheable(value = "CaffeineService:getUser",cacheManager = "defaultCacheManager",key="'all'")
    public String getUser(Long id){
        System.out.println("没有走缓存获取到数据");
        return "beppe"+id;
    }



    @Cacheable(value = "CaffeineService:getCity",cacheManager = "specCacheManager",key="#name")
    public String getCity(String name){
        System.out.println("没有走缓存获取到数据");
        return "shanghaibeppe"+name;
    }

    public String getPerson(String personName){
        String name = (String)manualCache.get(personName,k-> getPersonName(personName));
        return name;

    }

    private String getPersonName(String personName){
        return "beppe777"+personName;
    }



}
