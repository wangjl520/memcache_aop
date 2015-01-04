package com.allinpay.fmp.service;

import java.math.BigDecimal;
import java.util.List;

import com.allinpay.fmp.domain.ParamSysCtrlParam;
import com.allinpay.fmp.domain.SysCtrlParam;

public interface SysCtrlParamService
{

    public List<SysCtrlParam> getSysCtrlParams(ParamSysCtrlParam parameter);


    public void update(Object newObj, Object oldObj) throws Exception;


    public SysCtrlParam findOneByKey(java.math.BigDecimal entityOid);


    public SysCtrlParam findOneByKeyWithoutCache(java.math.BigDecimal entityOid);


    public SysCtrlParam findOneForInvestorByCode(BigDecimal agentOid,
            String code);


    public SysCtrlParam findOneForAgentByCode(java.math.BigDecimal agentOid,
            String code);


    public SysCtrlParam findOneForPortalByCode(java.math.BigDecimal agentOid,
            String code);


    public SysCtrlParam findOneForInvestorByCode(BigDecimal agentOid,
            String code, String cateCode);


    public SysCtrlParam findOneForAgentByCode(java.math.BigDecimal agentOid,
            String code, String cateCode);


    public SysCtrlParam findOneUnderAgentByCodeFromCache(BigDecimal agentOid,
            String code, String appType);


    public SysCtrlParam findOneUnderAgentByCodeFromCache(BigDecimal agentOid,
            String code, String cateCode, String appType);
}