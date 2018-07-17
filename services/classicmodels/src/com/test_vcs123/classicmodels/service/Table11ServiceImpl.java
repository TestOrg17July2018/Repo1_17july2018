/*Copyright (c) 2018-2019 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.test_vcs123.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.test_vcs123.classicmodels.Table11;


/**
 * ServiceImpl object for domain model class Table11.
 *
 * @see Table11
 */
@Service("classicmodels.Table11Service")
@Validated
public class Table11ServiceImpl implements Table11Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table11ServiceImpl.class);


    @Autowired
    @Qualifier("classicmodels.Table11Dao")
    private WMGenericDao<Table11, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table11, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Table11 create(Table11 table11) {
        LOGGER.debug("Creating a new Table11 with information: {}", table11);

        Table11 table11Created = this.wmGenericDao.create(table11);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table11Created);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Table11 getById(Integer table11Id) {
        LOGGER.debug("Finding Table11 by id: {}", table11Id);
        return this.wmGenericDao.findById(table11Id);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Table11 findById(Integer table11Id) {
        LOGGER.debug("Finding Table11 by id: {}", table11Id);
        try {
            return this.wmGenericDao.findById(table11Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table11 found with id: {}", table11Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public List<Table11> findByMultipleIds(List<Integer> table11Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table11s by ids: {}", table11Ids);

        return this.wmGenericDao.findByMultipleIds(table11Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public Table11 update(Table11 table11) {
        LOGGER.debug("Updating Table11 with information: {}", table11);

        this.wmGenericDao.update(table11);
        this.wmGenericDao.refresh(table11);

        return table11;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Table11 delete(Integer table11Id) {
        LOGGER.debug("Deleting Table11 with id: {}", table11Id);
        Table11 deleted = this.wmGenericDao.findById(table11Id);
        if (deleted == null) {
            LOGGER.debug("No Table11 found with id: {}", table11Id);
            throw new EntityNotFoundException(String.valueOf(table11Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public void delete(Table11 table11) {
        LOGGER.debug("Deleting Table11 with {}", table11);
        this.wmGenericDao.delete(table11);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Table11> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table11s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Table11> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table11s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service classicmodels for table Table11 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service classicmodels for table Table11 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}