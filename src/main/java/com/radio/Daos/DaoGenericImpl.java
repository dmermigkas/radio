package com.radio.Daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DaoGenericImpl<T> implements DaoGeneric<T,Integer>{

    protected String entityClass;
    protected Class<T> thisClass;

    public DaoGenericImpl(String entityClass,Class<T> thisClass) {
        this.thisClass = thisClass;
        this.entityClass = entityClass;
    }

    @Override
    public void create(T prod,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(prod);
        tx.commit();
        em.close();

    }


    @Override
    public void update(T entity,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.merge(entity);
        tx.commit();
        em.close();

    }

    @Override
    public void remove(T entity,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.remove(em.contains(entity) ? entity : em.merge(entity));
        tx.commit();
        em.close();

    }

    @Override
    public T find(Integer key,EntityManager em) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        T results = null;

        results = em.find(thisClass, key);
        tx.commit();
        em.close();
        return results;

    }

    @Override
    public List<T> getAll(EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<T> results = null;
        System.out.println(entityClass);
        results = em.createQuery("select b from " + entityClass + " b").getResultList();
        tx.commit();
        em.close();
        return results;

    }

}
