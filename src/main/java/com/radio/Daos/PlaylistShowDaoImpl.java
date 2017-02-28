package com.radio.Daos;

import com.radio.Models.PlaylistShow;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlaylistShowDaoImpl implements PlaylistShowDao{

    Set<PlaylistShow> playlists;

    public PlaylistShowDaoImpl(){
        playlists = new HashSet<>();
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
    public void add(PlaylistShow entity,EntityManager em){

        playlists.add(entity);
        System.out.println("hello!!!");
    }

    @Override
    public void create(PlaylistShow playlist,EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println("i run!");
        em.persist(playlist);
        tx.commit();
        em.close();

    }

//    @Override
//    public void merge(PlaylistShow prod,EntityManager em){
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
    public void update(PlaylistShow entity,EntityManager em){

    }

    @Override
    public void remove(PlaylistShow entity,EntityManager em){

    }

    @Override
    public PlaylistShow find(Integer key,EntityManager em) {
        return null;
    }

    @Override
    public List<PlaylistShow> getAll(EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<PlaylistShow> results = null;

        //results = em.createQuery("select b from PLAYLISTSHOWS b").getResultList();
        tx.commit();
        em.close();
        return new ArrayList<>();

    }

}
