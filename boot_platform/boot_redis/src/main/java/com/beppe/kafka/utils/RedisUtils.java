package com.beppe.kafka.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

    private static String ADDR="106.54.189.153";
    private static int PORT=6379;
    private static int TIMEOUT=10000;
    private static String AUTH="33654336";

    private static JedisPool jedisPool;

    // 初始化连接池
    static {
        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(300);
            jedisPoolConfig.setMaxWaitMillis(500);
            jedisPoolConfig.setMaxIdle(100);
            jedisPoolConfig.setTestOnBorrow(true);
            jedisPool = new JedisPool(jedisPoolConfig, ADDR, PORT, TIMEOUT, AUTH);
        }catch (Exception e){
            System.out.println("初始化连接池异常");
        }
    }

    // 获取jedis 实例
    public synchronized static Jedis getJedis(){
        if (jedisPool!=null){
            return jedisPool.getResource();
        }
        return null;
    }

    // 释放实例
    public static void release(final Jedis jedis){
        if(jedis!=null){
            // 返回到pool中
            jedisPool.returnResource(jedis);
        }

    }


    public static void set(String key,String val){
        Jedis jedis = getJedis();
        jedis.set(key,val);
    }

    public static String get(String key){
        Jedis jedis = getJedis();
        return jedis.get(key);
    }

    public static void setBit(String key,int offset){
        Jedis jedis = getJedis();
        jedis.setbit(key,offset,true);
    }

    public static long bitCount(String key){
        Jedis jedis = getJedis();
        Long bitcount = jedis.bitcount(key);
        return bitcount;
    }



}
