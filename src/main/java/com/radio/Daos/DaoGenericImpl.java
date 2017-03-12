package com.radio.Daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DaoGenericImpl<T> implements DaoGeneric<T,Integer>{

    protected String entityClass;
    protected Class<T> thisClass;

    public DaoGenericImpl(){}

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
    public boolean update(T entity,EntityManager em,Integer id){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.getReference(thisClass, id);
            em.merge(entity);
        } catch (EntityNotFoundException e) {
            return false;
        }

        tx.commit();
        em.close();
        return true;
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
    public boolean removeById(Integer id,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            T ent = em.getReference(thisClass, id);
            em.remove(ent);
        } catch (EntityNotFoundException e) {
            tx.rollback();
            return false;
        }

        tx.commit();
        em.close();
        return true;

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

        results = em.createQuery("select b from " + entityClass + " b").getResultList();
        tx.commit();
        em.close();
        return results;

    }

}
