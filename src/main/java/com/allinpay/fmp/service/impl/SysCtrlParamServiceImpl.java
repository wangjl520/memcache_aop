/**
 *   File Name       :  SysCtrlParamServiceImpl.java
 *   Date Created    :  2012-03-17 15:03:524
 *   Last Changed By :  $Author: haungfei $
 *   Last Changed On :  $Date: 2012-03-17 15:03:524 $
 *   Revision        :  $Revision: 1.0 $
 *   Description     :  *
 *   Allinpay Pte Ltd.  Copyright (c) 2011-2012.  All Rights Reserved. 
 *
 **/

package com.allinpay.fmp.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.allinpay.fmp.dao.SysCtrlParamMapper;
import com.allinpay.fmp.domain.ParamSysCtrlParam;
import com.allinpay.fmp.domain.SysCtrlParam;
import com.allinpay.fmp.service.SysCtrlParamService;

@Service("sysCtrlParamService")
public class SysCtrlParamServiceImpl implements SysCtrlParamService
{
    @Autowired
    @Qualifier("sysCtrlParamMapper")
    private SysCtrlParamMapper dao;


    public List<SysCtrlParam> getSysCtrlParams(ParamSysCtrlParam parameter)
    {
        return dao.getSysCtrlParams(parameter);
    }


    public void delete(Object oldObj) throws Exception
    {
        int rlt = dao.deleteSysCtrlParam((SysCtrlParam) oldObj);

        if (rlt < 1)
        {
            throw new Exception("No record effected when delete SysCtrlParam ["
                    + oldObj + "]");
        }
    }


    public void insert(Object newObj) throws Exception
    {
        String actor = "TesterADD";

        int rlt = dao.insertSysCtrlParam((SysCtrlParam) newObj);

        if (rlt != 1)
        {
            throw new Exception("No record effected when insert SysCtrlParam ["
                    + newObj + "]");
        }
    }


    public void update(Object newObj, Object oldObj) throws Exception
    {
        String actor = "TesterUPD";
        int rlt = dao.updateSysCtrlParam((SysCtrlParam) newObj);

        if (rlt != 1)
        {
            throw new Exception(
                    "No record effected when update SysCtrlParam from ["
                            + oldObj + "] to [" + newObj + "]");
        }
    }


    public SysCtrlParam findOneByKey(java.math.BigDecimal entityOid)
    {
        if (null == entityOid) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setEntityOid(entityOid);

        return dao.findOneByKey(parameter);
    }


    @Override
    public SysCtrlParam findOneByKeyWithoutCache(BigDecimal entityOid)
    {
        if (null == entityOid) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setEntityOid(entityOid);

        return dao.findOneByKey(parameter);
    }


    public SysCtrlParam findOneUnderAgentByCodeFromCache(BigDecimal agentOid,
            String code, String appType)
    {
        if (null == agentOid) return null;
        if (null == code || code.trim().length() < 1) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setParamCode(code);
        parameter.setAppType(appType);
        parameter.setAgentOid(agentOid);

        List<SysCtrlParam> rlts = dao.getSysCtrlParams(parameter);

        if (null != rlts && rlts.size() > 0)
        {
            return rlts.get(0);
        }
        else
        {
            parameter.setAgentOid(null);
            parameter.setAgentOidMustNull("Y");

            rlts = dao.getSysCtrlParams(parameter);
            if (null == rlts || rlts.size() < 1)
            {
                return null;
            }
            else
            {
                return rlts.get(0);
            }
        }
    }


    public SysCtrlParam findOneUnderAgentByCodeFromCache(BigDecimal agentOid,
            String code, String cateCode, String appType)
    {
        if (null == agentOid) return null;
        if (null == code || code.trim().length() < 1) return null;
        if (null == appType || appType.trim().length() < 1) return null;
        if (null == cateCode || cateCode.trim().length() < 1) return null;

        List<SysCtrlParam> rlts = dao.getAllSysCtrlParamsFromCache(null);

        if (null == rlts || rlts.isEmpty())
        {
            return null;
        }

        SysCtrlParam rlt = null;

        for (SysCtrlParam sysCtrl : rlts)
        {
            if (code.equalsIgnoreCase(sysCtrl.getParamCode())
                    && cateCode.equalsIgnoreCase(sysCtrl.getCateCode())
                    && appType.equalsIgnoreCase(sysCtrl.getAppType()))
            {
                if (null == sysCtrl.getAgentOid())
                {
                    // 如果指定代理人下找不到这个参数,则取默认代理人的这个参数
                    rlt = sysCtrl;
                }
                else if (agentOid.longValue() == sysCtrl.getAgentOid()
                        .longValue())
                {
                    return sysCtrl;
                }
            }
        }

        return rlt;
    }


    public SysCtrlParam findOneForInvestorByCode(BigDecimal agentOid,
            String code)
    {
        if (null == agentOid) return null;
        if (null == code || code.trim().length() < 1) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setParamCode(code);
        parameter.setAppType("I");
        parameter.setAgentOid(agentOid);

        List<SysCtrlParam> rlts = dao.getSysCtrlParams(parameter);

        if (null != rlts && rlts.size() > 0)
        {
            return rlts.get(0);
        }
        else
        {
            parameter.setAgentOid(null);
            parameter.setAgentOidMustNull("Y");

            rlts = dao.getSysCtrlParams(parameter);
            if (null == rlts || rlts.size() < 1)
            {
                return null;
            }
            else
            {
                return rlts.get(0);
            }
        }
    }


    public SysCtrlParam findOneForAgentByCode(BigDecimal agentOid, String code)
    {
        if (null == agentOid) return null;
        if (null == code || code.trim().length() < 1) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setParamCode(code);
        parameter.setAppType("A");
        parameter.setAgentOid(agentOid);

        List<SysCtrlParam> rlts = dao.getSysCtrlParams(parameter);

        if (null != rlts && rlts.size() > 0)
        {
            return rlts.get(0);
        }
        else
        {
            parameter.setAgentOid(null);
            parameter.setAgentOidMustNull("Y");

            rlts = dao.getSysCtrlParams(parameter);
            if (null == rlts || rlts.size() < 1)
            {
                return null;
            }
            else
            {
                return rlts.get(0);
            }
        }
    }


    public SysCtrlParam findOneForInvestorByCode(BigDecimal agentOid,
            String code, String cateCode)
    {
        if (null == agentOid) return null;
        if (null == code || code.trim().length() < 1) return null;
        if (null == cateCode || cateCode.trim().length() < 1) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setParamCode(code);
        parameter.setCateCode(cateCode);
        parameter.setAppType("I");
        parameter.setAgentOid(agentOid);

        List<SysCtrlParam> rlts = dao.getSysCtrlParams(parameter);

        if (null != rlts && rlts.size() > 0)
        {
            return rlts.get(0);
        }
        else
        {
            parameter.setAgentOid(null);
            parameter.setAgentOidMustNull("Y");

            rlts = dao.getSysCtrlParams(parameter);
            if (null == rlts || rlts.size() < 1)
            {
                return null;
            }
            else
            {
                return rlts.get(0);
            }
        }
    }


    public SysCtrlParam findOneForAgentByCode(BigDecimal agentOid, String code,
            String cateCode)
    {
        if (null == agentOid) return null;
        if (null == code || code.trim().length() < 1) return null;
        if (null == cateCode || cateCode.trim().length() < 1) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setParamCode(code);
        parameter.setCateCode(cateCode);
        parameter.setAppType("A");
        parameter.setAgentOid(agentOid);

        List<SysCtrlParam> rlts = dao.getSysCtrlParams(parameter);

        if (null != rlts && rlts.size() > 0)
        {
            return rlts.get(0);
        }
        else
        {
            parameter.setAgentOid(null);
            parameter.setAgentOidMustNull("Y");

            rlts = dao.getSysCtrlParams(parameter);
            if (null == rlts || rlts.size() < 1)
            {
                return null;
            }
            else
            {
                return rlts.get(0);
            }
        }
    }


    public SysCtrlParam findOneForPortalByCode(BigDecimal agentOid, String code)
    {
        if (null == agentOid) return null;
        if (null == code || code.trim().length() < 1) return null;

        ParamSysCtrlParam parameter = new ParamSysCtrlParam();
        parameter.setParamCode(code);
        parameter.setAppType("A");
        parameter.setAgentOid(agentOid);

        List<SysCtrlParam> rlts = dao.getSysCtrlParams(parameter);

        if (null != rlts && rlts.size() > 0)
        {
            return rlts.get(0);
        }
        else
        {
            parameter.setAgentOid(null);
            parameter.setAgentOidMustNull("Y");

            rlts = dao.getSysCtrlParams(parameter);
            if (null == rlts || rlts.size() < 1)
            {
                return null;
            }
            else
            {
                return rlts.get(0);
            }
        }
    }
}