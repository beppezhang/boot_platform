package com.beppe.kafka.config;

import com.beppe.kafka.proxy.dynamic.ExtensionProxyFactoryBean;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    /**
     * 通用的缓存管理器   在方法中直接使用  @cacheable 即可生效缓存
     * @return
     */
    @Bean(name = "defaultCacheManager")
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterAccess(600, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(500));
        return cacheManager;
    }

    @Bean(name = "specCacheManager")
    public CacheManager specCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterAccess(4, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(500));
        return cacheManager;
    }

    @Bean(name = "manualCache")
    public Cache<Object, Object> manualCache() {
        Cache<Object, Object> build = Caffeine.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .initialCapacity(100)
                .maximumSize(500)
                .build();
        return build;
    }

    @Bean
    public ExtensionProxyFactoryBean ExtensionProxyFactoryBean() {
        return new ExtensionProxyFactoryBean();
    }




}
