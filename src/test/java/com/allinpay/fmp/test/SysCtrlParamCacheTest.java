package com.allinpay.fmp.test;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allinpay.cache.memcached.client.MemcachedClient;
import com.allinpay.fmp.service.SysCtrlParamService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SysCtrlParamCacheTest
{
    private static final BigDecimal TEST_ENTITY_OID = new BigDecimal(10000001);
    private static final BigDecimal TEST_AGENT_OID = new BigDecimal(8800);
    private static final String TEST_PARAM_CODE = "TEST_CODE_FOR_CACHE";

    @Autowired
    private SysCtrlParamService sysCtrlParamService;
    @Autowired
    private MemcachedClient memcachedClient;

    private SimpleDateFormat df = new SimpleDateFormat("HHmmss.SSS");


    @Test
    public void testfindSysCtrlParamByKey()
    {
        // initialize environment
        sysCtrlParamService.findOneByKeyWithoutCache(TEST_ENTITY_OID);

        // test time cost without cache
        System.out.println("begin at : " + df.format(new Date()));
        for (int i = 0; i < 1000; i++)
        {
            Object rltObj = sysCtrlParamService
                    .findOneByKeyWithoutCache(TEST_ENTITY_OID);
            assertTrue(null != rltObj);
        }
        System.out.println("  end at : " + df.format(new Date()));

        // clean cache()
        memcachedClient.remove("SYSCTRLPARAM_" + TEST_ENTITY_OID);

        // test time cost with cache
        System.out.println("begin at : " + df.format(new Date()));
        for (int i = 0; i < 1000; i++)
        {
            Object rltObj = sysCtrlParamService.findOneByKey(TEST_ENTITY_OID);
            assertTrue(null != rltObj);
        }
        System.out.println("  end at : " + df.format(new Date()));
    }


    @Test
    public void testFindOneUnderAgentByCode()
    {
        // initialize environment
        sysCtrlParamService.findOneByKeyWithoutCache(TEST_ENTITY_OID);

        // test time cost without cache
        System.out.println("begin at : " + df.format(new Date()));
        for (int i = 0; i < 1000; i++)
        {
            Object rltObj = sysCtrlParamService.findOneForAgentByCode(
                    TEST_AGENT_OID, TEST_PARAM_CODE);
            assertTrue(null != rltObj);
        }
        System.out.println("  end at : " + df.format(new Date()));

        // clean cache()
        memcachedClient.remove("SYSCTRLPARAM_A_" + TEST_PARAM_CODE + "_"
                + TEST_AGENT_OID);

        // test time cost with cache
        System.out.println("begin at : " + df.format(new Date()));
        for (int i = 0; i < 1000; i++)
        {
            Object rltObj = sysCtrlParamService
                    .findOneUnderAgentByCodeFromCache(TEST_AGENT_OID,
                            TEST_PARAM_CODE, "A");
            assertTrue(null != rltObj);
        }
        System.out.println("  end at : " + df.format(new Date()));
    }
}
