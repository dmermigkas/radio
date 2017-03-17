package com.radio.Daos;

import com.radio.Models.AutoShow;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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
    public T create(T prod,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(prod);

        tx.commit();
        em.close();

        return prod;

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
    public boolean removeById(Integer id,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            T ent = em.getReference(thisClass, id);
            em.remove(ent);
            tx.commit();
            em.close();
            return true;
        } catch (EntityNotFoundException e) {
            tx.rollback();
        }

        em.close();
        return false;

    }

    @Override
    public T find(Integer key,EntityManager em) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        T results = null;

        try {
            results = em.find(thisClass, key);
            tx.commit();
            em.close();
        } catch (NoResultException ex) {
            tx.rollback();
        }

        return results;

    }

    @Override
    public List<T> getAll(EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<T> results = null;

        try {
            results = em.createQuery("select b from " + entityClass + " b").getResultList();
            tx.commit();
            em.close();
        } catch (NoResultException ex) {
            tx.rollback();
        }

        return results;

    }

}
