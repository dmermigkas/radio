package com.radio.Daos;

import com.radio.Models.Producer;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
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

    @Override
    public void addProducer(){
        System.out.println("i am addin");
    }

    @Override
    public void add(Producer entity,EntityManager em){

        producers.add(entity);
        System.out.println("hello!!!");
    }

    @Override
    public Boolean create(Producer prod,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (prod != null) {
            em.persist(prod);
            tx.commit();
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public void update(Producer entity){

    }

    @Override
    public void remove(Producer entity){

    }

    @Override
    public Producer find(Integer key) {
        return null;
    }

    @Override
    public Set<Producer> getAll(){
        return new HashSet<>(producers);
    }

}
