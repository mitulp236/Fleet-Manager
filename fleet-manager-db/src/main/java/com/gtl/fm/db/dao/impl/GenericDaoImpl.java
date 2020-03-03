package com.gtl.fm.db.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.gtl.fm.db.dao.GenericDao;


public abstract class GenericDaoImpl<E> implements GenericDao<E> {

    private final Class<E> entityClass;

    @Autowired
    @Qualifier("sessionFactoryfm")
    private SessionFactory sessionFactoryfm;

    /**
     * Implementation for generic DAO.
     */
    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        this.entityClass =
            (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return this.sessionFactoryfm.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true, value = TRANSACTION_MANAGER_FM)
    public E findById(final Serializable id) {
        return (E) getSession().get(this.entityClass, id);
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    @Transactional(readOnly = true, value = TRANSACTION_MANAGER_FM)
    public List<E> findAll() {
        return getSession().createCriteria(this.entityClass).list();
    }

    @Override
    @Transactional(readOnly = false, value = TRANSACTION_MANAGER_FM)
    public Serializable save(E entity) {
        return getSession().save(entity);
    }
    
    @Override
    @Transactional(readOnly = false, value = TRANSACTION_MANAGER_FM)
    public void saveOrUpdate(E entity) {
       getSession().saveOrUpdate(entity);
    }

    @Override
    @Transactional(readOnly = false, value = TRANSACTION_MANAGER_FM)
    public void update(E entity) {
        getSession().update(entity);
    }

    @Override
    @Transactional(readOnly = false, value = TRANSACTION_MANAGER_FM)
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Override
    @Transactional(readOnly = false, value = TRANSACTION_MANAGER_FM)
    public void deleteAll() {
        List<E> entities = findAll();
        for (E entity : entities) {
            getSession().delete(entity);
        }
    }

    /**
     * Create Hibernate query for given string.
     * @param query string to create query
     * @return hql Query
     */
    public Query<?> createQuery(String query) {
        return getSession().createQuery(query);

    }

    /**
     * Create Hibernate query for given string and entity class.
     * @param query string to create query
     * @param clazz entity class
     * @param <T> entity class type
     * @return hql Query
     */
    public <T> Query<T> createQuery(String query, Class<T> clazz) {
        return getSession().createQuery(query, clazz);

    }

    @Override
    public void clear() {
        getSession().clear();

    }

    @Override
    public void flush() {
        getSession().flush();

    }
}
