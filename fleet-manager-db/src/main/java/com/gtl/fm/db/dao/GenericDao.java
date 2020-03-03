package com.gtl.fm.db.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;


public interface GenericDao<E> {

    String TRANSACTION_MANAGER_FM = "transactionManagerfm";

    /**
     * Find by primary key.
     *
     * @param id primary key
     * @return unique entity
     */
    E findById(Serializable id);

    /**
     * Find all records.
     *
     * @return list of records.
     */
    List<E> findAll();

    /**
     * Save record in database table.
     * @param entity entity to save
     * @return Identifier of saved entity
     */
    Serializable save(E entity);
    
    /**
     * Save or update record in database table.
     * @param entity entity to save
     * @return Identifier of saved entity
     */
    void saveOrUpdate(E entity);

    /**
     *Update record in database table.
     * @param entity entity to save or update
     */
    void update(E entity);

    /**
     *Delete record.
     * @param entity entity to delete
     */
    void delete(E entity);

    /**
     * Delete all records.
     */
    void deleteAll();

    /**
     * Create hibernate query.
     * @param query String to create query
     * @return hql quwery
     */
    Query<?> createQuery(String query);

    /**
     * Clear session.
     */
    void clear();

    /**
     * Flush session.
     */
    void flush();
}
