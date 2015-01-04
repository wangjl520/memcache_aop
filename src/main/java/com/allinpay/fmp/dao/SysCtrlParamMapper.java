/**
 *   File Name       :  SysCtrlParamMapper.java
 *   Date Created    :  2012-03-17 15:03:668
 *   Last Changed By :  $Author: haungfei $
 *   Last Changed On :  $Date: 2012-03-17 15:03:668 $
 *   Revision        :  $Revision: 3.0 $
 *   Description     :  *
 *   Allinpay Pte Ltd.  Copyright (c) 2011-2012.  All Rights Reserved. 
 *
 **/

package com.allinpay.fmp.dao;

import java.util.List;

import com.allinpay.fmp.domain.ParamSysCtrlParam;
import com.allinpay.fmp.domain.SysCtrlParam;

public interface SysCtrlParamMapper
{

    public List<SysCtrlParam> getAllSysCtrlParamsFromCache(
            ParamSysCtrlParam parameter);


    public List<SysCtrlParam> getSysCtrlParams(ParamSysCtrlParam parameter);


    public SysCtrlParam findOneByKey(ParamSysCtrlParam parameter);


    /**
     * add a SysCtrlParam's information
     * 
     * @param parameter the object to be added
     */
    public int insertSysCtrlParam(SysCtrlParam parameter);


    /**
     * update a SysCtrlParam's information
     * 
     * @param parameter the object to be updated
     */
    public int updateSysCtrlParam(SysCtrlParam parameter);


    /**
     * delete a SysCtrlParam from the database by parameter
     * 
     * @param parameter the object to be removed
     */
    public int deleteSysCtrlParam(SysCtrlParam parameter);
}