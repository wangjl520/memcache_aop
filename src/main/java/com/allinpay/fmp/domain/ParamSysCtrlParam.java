/**
 *   File Name       :  ParamSysCtrlParam.java
 *   Date Created    :  2012-03-17 15:03:524
 *   Last Changed By :  $Author: haungfei $
 *   Last Changed On :  $Date: 2012-03-17 15:03:524 $
 *   Revision        :  $Revision: 1.0 $
 *   Description     :  *
 *   Allinpay Pte Ltd.  Copyright (c) 2011-2012.  All Rights Reserved. 
 *
 **/

package com.allinpay.fmp.domain;

import java.util.List;

public class ParamSysCtrlParam extends SysCtrlParam
{
    private String agentOidMustNull;
    private String suppOidMustNull;

    private List<String> paramCodeLimitList;
    private String defnAppType;


    /**
     * @return Returns the defnAppType.
     */
    public String getDefnAppType()
    {
        return defnAppType;
    }


    /**
     * @param defnAppType The defnAppType to set.
     */
    public void setDefnAppType(String defnAppType)
    {
        this.defnAppType = defnAppType;
    }


    /**
     * @return Returns the paramCodeLimitList.
     */
    public List<String> getParamCodeLimitList()
    {
        return paramCodeLimitList;
    }


    /**
     * @param paramCodeLimitList The paramCodeLimitList to set.
     */
    public void setParamCodeLimitList(List<String> paramCodeLimitList)
    {
        this.paramCodeLimitList = paramCodeLimitList;
    }


    public String getAgentOidMustNull()
    {
        return agentOidMustNull;
    }


    public void setAgentOidMustNull(String agentOidMustNull)
    {
        this.agentOidMustNull = agentOidMustNull;
    }


    public String getSuppOidMustNull()
    {
        return suppOidMustNull;
    }


    public void setSuppOidMustNull(String suppOidMustNull)
    {
        this.suppOidMustNull = suppOidMustNull;
    }
}
