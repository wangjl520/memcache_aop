package com.allinpay.fmp.cache.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.allinpay.cache.memcached.client.MemcachedClient;
import com.allinpay.fmp.domain.SysCtrlParam;

@Aspect
public class SysCtrlParamInterceptor
{
    public static final Logger log = Logger
            .getLogger(SysCtrlParamInterceptor.class);

    @Autowired
    private MemcachedClient memcachedClient;


    @Pointcut("execution(* com.allinpay.fmp.service.SysCtrlParamService.findOneByKey(..))")
    private void findOneByKeyMethod()
    {
    }


    @Pointcut("execution(* com.allinpay.fmp.service.SysCtrlParamService.findOneUnderAgentByCodeFromCache(..))")
    private void findOneUnderAgentByCodeFromCacheMethod()
    {

    }


    @Before("findOneByKeyMethod() && args(entityOid)")
    public void doBeforeFindOneByKey(java.math.BigDecimal entityOid)
    {
        // System.out.println("Before method 'findOneByKey' ");
        // System.out.println("Argments of findOneByKey is ==> " + entityOid);
    }


    @AfterReturning("findOneByKeyMethod()")
    public void doAfterFindOneByKey()
    {
        // System.out.println("After method  'findOneByKey'  was executed ");
    }


    @After("findOneByKeyMethod()")
    public void doFinalFindOneByKey()
    {
        // System.out.println("Final method  'findOneByKey'  was executed ");
    }


    @Around("findOneByKeyMethod() && args(entityOid)")
    public SysCtrlParam doFineOneByKeyAround(ProceedingJoinPoint call,
            java.math.BigDecimal entityOid)
    {
        SysCtrlParam rtlObj = null;
        String cacheKey = "SYSCTRLPARAM_" + entityOid;
        if (memcachedClient.contain(cacheKey))
        {
            rtlObj = (SysCtrlParam) memcachedClient.get(cacheKey);
            log.debug("return result from cache ");
        }
        else
        {
            try
            {
                rtlObj = (SysCtrlParam) call.proceed();

                if (null != rtlObj)
                {
                    memcachedClient.put(cacheKey, rtlObj);
                    log.debug("put cache for key :: " + cacheKey);
                }
            }
            catch (Throwable e)
            {
                e.printStackTrace();
            }
        }

        return rtlObj;
    }


    @Around("findOneUnderAgentByCodeFromCacheMethod() && args(agentOid,code,appType)")
    public SysCtrlParam doFindOneUnderAgentByCodeFromCacheAround(
            ProceedingJoinPoint call, java.math.BigDecimal agentOid,
            String code, String appType)
    {
        SysCtrlParam rtlObj = null;
        String cacheKey = "SYSCTRLPARAM_" + appType + "_" + code + "_"
                + agentOid;
        if (memcachedClient.contain(cacheKey))
        {
            rtlObj = (SysCtrlParam) memcachedClient.get(cacheKey);
            log.debug("return result from cache ");
        }
        else
        {
            try
            {
                rtlObj = (SysCtrlParam) call.proceed();

                if (null != rtlObj)
                {
                    memcachedClient.put(cacheKey, rtlObj);
                    log.debug("put cache for key :: " + cacheKey);
                }
            }
            catch (Throwable e)
            {
                e.printStackTrace();
            }
        }

        return rtlObj;
    }
}
