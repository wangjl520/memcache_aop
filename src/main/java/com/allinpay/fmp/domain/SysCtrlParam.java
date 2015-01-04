/**
 *   File Name       :  SysCtrlParam.java
 *   Date Created    :  2012-03-17 15:03:524
 *   Last Changed By :  $Author: haungfei $
 *   Last Changed On :  $Date: 2012-03-17 15:03:524 $
 *   Revision        :  $Revision: 1.0 $
 *   Description     :  *
 *   Allinpay Pte Ltd.  Copyright (c) 2011-2012.  All Rights Reserved. 
 *
 **/

package com.allinpay.fmp.domain;

import java.math.BigDecimal;

public class SysCtrlParam implements java.io.Serializable
{
    private java.math.BigDecimal agentOid;
    private String appType;
    private java.math.BigDecimal supplierOid;
    private String paramCode;
    private String cateCode;
    private String paramDesc;
    private String strValue;
    private Integer intValue;
    private java.util.Date dateValue;

    private String appTypeDesc;
    private Object paramValue;
    private String intValueStr;

    private BigDecimal entityOid;
    private Integer sortNo;
    private String remark;
    private Integer version;
    private java.util.Date whenmodified;
    private String origFlag;
    private String origApp;
    private String flagDeleted;
    private String createdBy;
    private java.util.Date createdDate;
    private String lastUpdBy;
    private java.util.Date lastUpdDate;
    private java.util.Date oldLastUpdDate;
    private BigDecimal modiNum;
    private String recDigiProof;

    private String sortField;
    private String sortOrder;


    public SysCtrlParam()
    {
    }


    /**
     * @return Returns the intValueStr.
     */
    public String getIntValueStr()
    {
        return intValueStr;
    }


    /**
     * @param intValueStr The intValueStr to set.
     */
    public void setIntValueStr(String intValueStr)
    {
        this.intValueStr = intValueStr;
    }


    /**
     * @return Returns the paramValue.
     */
    public Object getParamValue()
    {
        return paramValue;
    }


    /**
     * @param paramValue The paramValue to set.
     */
    public void setParamValue(Object paramValue)
    {
        this.paramValue = paramValue;
    }


    /**
     * @return Returns the appTypeDesc.
     */
    public String getAppTypeDesc()
    {
        return appTypeDesc;
    }


    /**
     * @param appTypeDesc The appTypeDesc to set.
     */
    public void setAppTypeDesc(String appTypeDesc)
    {
        this.appTypeDesc = appTypeDesc;
    }


    /**
     * @return java.math.BigDecimal
     */
    public java.math.BigDecimal getAgentOid()
    {
        return this.agentOid;
    }


    /**
     * @return String
     */
    public String getAppType()
    {
        return this.appType;
    }


    /**
     * @return java.math.BigDecimal
     */
    public java.math.BigDecimal getSupplierOid()
    {
        return this.supplierOid;
    }


    /**
     * @return String
     */
    public String getParamCode()
    {
        return this.paramCode;
    }


    /**
     * @return String
     */
    public String getCateCode()
    {
        return this.cateCode;
    }


    /**
     * @return String
     */
    public String getParamDesc()
    {
        return this.paramDesc;
    }


    /**
     * @return String
     */
    public String getStrValue()
    {
        return this.strValue;
    }


    /**
     * @return Integer
     */
    public Integer getIntValue()
    {
        return this.intValue;
    }


    /**
     * @return java.util.Date
     */
    public java.util.Date getDateValue()
    {
        return this.dateValue;
    }


    /**
     * @param java.math.BigDecimal agentOid
     */
    public void setAgentOid(java.math.BigDecimal agentOid)
    {
        this.agentOid = agentOid;
    }


    /**
     * @param String appType
     */
    public void setAppType(String appType)
    {
        this.appType = appType;
    }


    /**
     * @param java.math.BigDecimal supplierOid
     */
    public void setSupplierOid(java.math.BigDecimal supplierOid)
    {
        this.supplierOid = supplierOid;
    }


    /**
     * @param String paramCode
     */
    public void setParamCode(String paramCode)
    {
        this.paramCode = paramCode;
    }


    /**
     * @param String cateCode
     */
    public void setCateCode(String cateCode)
    {
        this.cateCode = cateCode;
    }


    /**
     * @param String paramDesc
     */
    public void setParamDesc(String paramDesc)
    {
        this.paramDesc = paramDesc;
    }


    /**
     * @param String strValue
     */
    public void setStrValue(String strValue)
    {
        this.strValue = strValue;
    }


    /**
     * @param Integer intValue
     */
    public void setIntValue(Integer intValue)
    {
        this.intValue = intValue;
    }


    /**
     * @param java.util.Date dateValue
     */
    public void setDateValue(java.util.Date dateValue)
    {
        this.dateValue = dateValue;
    }


    public BigDecimal getEntityOid()
    {
        return entityOid;
    }


    public void setEntityOid(BigDecimal entityOid)
    {
        this.entityOid = entityOid;
    }


    public Integer getSortNo()
    {
        return sortNo;
    }


    public void setSortNo(Integer sortNo)
    {
        this.sortNo = sortNo;
    }


    public String getRemark()
    {
        return remark;
    }


    public void setRemark(String remark)
    {
        this.remark = remark;
    }


    public Integer getVersion()
    {
        return version;
    }


    public void setVersion(Integer version)
    {
        this.version = version;
    }


    public java.util.Date getWhenmodified()
    {
        return whenmodified;
    }


    public void setWhenmodified(java.util.Date whenmodified)
    {
        this.whenmodified = whenmodified;
    }


    public String getOrigFlag()
    {
        return origFlag;
    }


    public void setOrigFlag(String origFlag)
    {
        this.origFlag = origFlag;
    }


    public String getOrigApp()
    {
        return origApp;
    }


    public void setOrigApp(String origApp)
    {
        this.origApp = origApp;
    }


    public String getFlagDeleted()
    {
        return flagDeleted;
    }


    public void setFlagDeleted(String flagDeleted)
    {
        this.flagDeleted = flagDeleted;
    }


    public String getCreatedBy()
    {
        return createdBy;
    }


    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }


    public java.util.Date getCreatedDate()
    {
        return createdDate;
    }


    public void setCreatedDate(java.util.Date createdDate)
    {
        this.createdDate = createdDate;
    }


    public String getLastUpdBy()
    {
        return lastUpdBy;
    }


    public void setLastUpdBy(String lastUpdBy)
    {
        this.lastUpdBy = lastUpdBy;
    }


    public java.util.Date getLastUpdDate()
    {
        return lastUpdDate;
    }


    public void setLastUpdDate(java.util.Date lastUpdDate)
    {
        this.lastUpdDate = lastUpdDate;
    }


    public java.util.Date getOldLastUpdDate()
    {
        return oldLastUpdDate;
    }


    public void setOldLastUpdDate(java.util.Date oldLastUpdDate)
    {
        this.oldLastUpdDate = oldLastUpdDate;
    }


    public BigDecimal getModiNum()
    {
        return modiNum;
    }


    public void setModiNum(BigDecimal modiNum)
    {
        this.modiNum = modiNum;
    }


    public String getRecDigiProof()
    {
        return recDigiProof;
    }


    public void setRecDigiProof(String recDigiProof)
    {
        this.recDigiProof = recDigiProof;
    }


    public String getSortField()
    {
        return sortField;
    }


    public void setSortField(String sortField)
    {
        this.sortField = sortField;
    }


    public String getSortOrder()
    {
        return sortOrder;
    }


    public void setSortOrder(String sortOrder)
    {
        this.sortOrder = sortOrder;
    }

}
