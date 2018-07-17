/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.test_vcs123.classicmodels.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.test_vcs123.classicmodels.TempTimeCheck;

/**
 * Specifies methods used to obtain and modify TempTimeCheck related information
 * which is stored in the database.
 */
@Repository("classicmodels.TempTimeCheckDao")
public class TempTimeCheckDao extends WMGenericDaoImpl<TempTimeCheck, Integer> {

    @Autowired
    @Qualifier("classicmodelsTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}