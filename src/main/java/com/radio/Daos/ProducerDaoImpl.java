package com.radio.Daos;

import com.radio.Models.Producer;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProducerDaoImpl implements ProducerDao{

    Set<Producer> producers;

    public ProducerDaoImpl(){
        producers = new HashSet<>();
//        Producer student1 = new Producer();
//        producers.add(student1);
    }

    public void getDao(){
        System.out.println("Producer Dao");
        //return new ProducerDaoImpl();
    }

//    @Override
//    public void addProducer(){
//        System.out.println("i am addin");
//    }

    @Override
    public void add(Producer entity,EntityManager em){

        producers.add(entity);
        System.out.println("hello!!!");
    }

    @Override
    public void create(Producer prod,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(prod);
        tx.commit();
        em.close();

    }

//    @Override
//    public void merge(Producer prod,EntityManager em){
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        em.merge(prod);
//        tx.commit();
//        em.close();
//
//    }

    @Override
    public void update(Producer entity,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.merge(entity);
        tx.commit();
        em.close();

    }

    @Override
    public void remove(Producer entity,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.remove(em.contains(entity) ? entity : em.merge(entity));
        tx.commit();
        em.close();

    }

    @Override
    public Producer find(Integer key,EntityManager em) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Producer results = null;

        results = em.find(Producer.class, key);
        tx.commit();
        em.close();
        return results;

    }

    @Override
    public List<Producer> getAll(EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Producer> results = null;

        results = em.createQuery("select b from Producer b").getResultList();
        tx.commit();
        em.close();
        return results;

    }

}
