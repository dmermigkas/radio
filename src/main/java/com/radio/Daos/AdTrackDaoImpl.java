package com.radio.Daos;

import com.radio.Models.AdTrack;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        em.close();

    }
//
//    @Override
//    public void merge(AdTrack prod,EntityManager em){
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
    public void update(AdTrack entity,EntityManager em){

    }

    @Override
    public void remove(AdTrack entity,EntityManager em){

    }

    @Override
    public AdTrack find(Integer key,EntityManager em) {
        return null;
    }

    @Override
    public List<AdTrack> getAll(EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<AdTrack> results = null;

        //results = em.createQuery("select b from PLAYLISTSHOWS b").getResultList();
        tx.commit();
        em.close();
        return new ArrayList<>();

    }


}
