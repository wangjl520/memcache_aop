package com.allinpay.cache.memcached.client;

import java.util.Calendar;
import java.util.Date;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;

public class MemcachedClient
{
    private static final String MCONFIG_FILE_NAME = "memcached.xml";
    private static final String MCLIENT_NAME = "mclient0";

    private static ICacheManager<IMemcachedCache> cacheManager;


    public IMemcachedCache getCache()
    {
        if (null == cacheManager)
        {
            initializeCacheManager();
        }

        return cacheManager.getCache(MCLIENT_NAME);
    }


    public void put(String key, Object value)
    {
        getCache().put(key, value);

    }


    public void put(String key, Object value, Date expiry)
    {
        getCache().put(key, value, expiry);
    }


    /**
     * 
     * 将数据加入到cache server,并且指定失效时间
     * 
     * @author huangfei
     * @param key 存入到cache server的键
     * @param value 存入到cache server的值
     * @param expirySecond 失效时长,单位为 '秒'
     * @return
     */
    public void put(String key, Object value, int expirySecond)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expirySecond);

        getCache().put(key, value, calendar.getTime());
    }


    public Object get(String key)
    {
        return getCache().get(key);
    }


    public void remove(String key)
    {
        getCache().remove(key);
    }


    public boolean contain(String key)
    {
        return getCache().containsKey(key);
    }


    private void initializeCacheManager()
    {
        cacheManager = CacheUtil.getCacheManager(IMemcachedCache.class,
                MemcachedCacheManager.class.getName());
        cacheManager.setConfigFile(MCONFIG_FILE_NAME);
        cacheManager.start();
    }
}
