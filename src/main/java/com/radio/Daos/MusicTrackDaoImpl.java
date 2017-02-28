package com.radio.Daos;

import com.radio.Models.MusicTrack;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MusicTrackDaoImpl implements MusicTrackDao{

    Set<MusicTrack> tracks;

    public MusicTrackDaoImpl(){
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
    public void add(MusicTrack entity,EntityManager em){

        tracks.add(entity);
        System.out.println("hello!!!");
    }

    @Override
    public void create(MusicTrack prod,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(prod);
        tx.commit();
        em.close();

    }

//    @Override
//    public void merge(MusicTrack prod,EntityManager em){
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
    public void update(MusicTrack entity){

    }

    @Override
    public void remove(MusicTrack entity){

    }

    @Override
    public MusicTrack find(Integer key) {
        return null;
    }

    @Override
    public List<MusicTrack> getAll(EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<MusicTrack> results = null;

        //results = em.createQuery("select b from PLAYLISTSHOWS b").getResultList();
        tx.commit();
        em.close();
        return new ArrayList<>();

    }

}
