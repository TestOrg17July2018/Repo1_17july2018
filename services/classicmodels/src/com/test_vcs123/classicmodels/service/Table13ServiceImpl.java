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

import com.test_vcs123.classicmodels.Table13;


/**
 * ServiceImpl object for domain model class Table13.
 *
 * @see Table13
 */
@Service("classicmodels.Table13Service")
@Validated
public class Table13ServiceImpl implements Table13Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table13ServiceImpl.class);


    @Autowired
    @Qualifier("classicmodels.Table13Dao")
    private WMGenericDao<Table13, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table13, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Table13 create(Table13 table13) {
        LOGGER.debug("Creating a new Table13 with information: {}", table13);

        Table13 table13Created = this.wmGenericDao.create(table13);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table13Created);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Table13 getById(Integer table13Id) {
        LOGGER.debug("Finding Table13 by id: {}", table13Id);
        return this.wmGenericDao.findById(table13Id);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Table13 findById(Integer table13Id) {
        LOGGER.debug("Finding Table13 by id: {}", table13Id);
        try {
            return this.wmGenericDao.findById(table13Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table13 found with id: {}", table13Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public List<Table13> findByMultipleIds(List<Integer> table13Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table13s by ids: {}", table13Ids);

        return this.wmGenericDao.findByMultipleIds(table13Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public Table13 update(Table13 table13) {
        LOGGER.debug("Updating Table13 with information: {}", table13);

        this.wmGenericDao.update(table13);
        this.wmGenericDao.refresh(table13);

        return table13;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Table13 delete(Integer table13Id) {
        LOGGER.debug("Deleting Table13 with id: {}", table13Id);
        Table13 deleted = this.wmGenericDao.findById(table13Id);
        if (deleted == null) {
            LOGGER.debug("No Table13 found with id: {}", table13Id);
            throw new EntityNotFoundException(String.valueOf(table13Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public void delete(Table13 table13) {
        LOGGER.debug("Deleting Table13 with {}", table13);
        this.wmGenericDao.delete(table13);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Table13> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table13s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Table13> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table13s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service classicmodels for table Table13 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service classicmodels for table Table13 to {} format", options.getExportType());
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