package com.radio.Daos;

import com.radio.Models.AdTrack;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.Set;

public class AdTrackDaoImpl implements AdTrackDao{

    Set<AdTrack> tracks;

    public AdTrackDaoImpl(){
        tracks = new HashSet<>();
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
    public void add(AdTrack entity,EntityManager em){

        tracks.add(entity);
        System.out.println("hello!!!");
    }

    @Override
    public void create(AdTrack prod,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println("helloooooooooooooooooooooooooooooooooooooooo");
        em.persist(prod);
        tx.commit();

    }

    @Override
    public void merge(AdTrack prod,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.merge(prod);
        tx.commit();

    }

    @Override
    public void update(AdTrack entity){

    }

    @Override
    public void remove(AdTrack entity){

    }

    @Override
    public AdTrack find(Integer key) {
        return null;
    }

    @Override
    public Set<AdTrack> getAll(){
        return new HashSet<>(tracks);
    }


}
