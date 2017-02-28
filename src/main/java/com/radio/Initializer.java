package com.radio;

import com.radio.Controllers.PlaylistShowController;
import com.radio.Factories.AdTrackFactoryImpl;
import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.MusicTrackFactoryImpl;
import com.radio.Factories.ProducerFactoryImpl;
import com.radio.Models.*;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;


public class Initializer {

    public void eraseData(){
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query query = em.createNativeQuery("delete from TRACKS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from ADTRACKS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from AUTOSHOWS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from GENRES");
        query.executeUpdate();
        query = em.createNativeQuery("delete from MUSICTRACKS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from PLAYLISTSHOWS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from PRODUCERS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from TRACKS");
        query.executeUpdate();
        tx.commit();
        em.close();
    }

    public void prepareData() {
        eraseData();

        Producer producer = new Producer("firstname1", "lastname", new EmailAddress("a@a.a"));

        Track musictrack = new MusicTrack("musictitle1", "musicartist", new Genre("musicgenre"), 1999, 100);


        Calendar fromCalendar = Calendar.getInstance();
        Calendar toCalendar = fromCalendar;
        toCalendar.add(Calendar.DATE, 2);
        Calendar fromZone = fromCalendar;
        fromZone.add(Calendar.HOUR, 1);
        Calendar toZone = fromCalendar;
        toZone.add(Calendar.HOUR, 2);
        PlayBackZone playBackZone = new PlayBackZone(fromZone, toZone);


        Track adTrack= new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20);


        Calendar playDateTime = Calendar.getInstance();
        //Show pl = new PlaylistShow("playListShow",producer,3600, playDateTime);

        Genre genre = new Genre("genre");


        Show autoShow = new AutoShow("testAutoShow", 3600, genre, playDateTime);
        autoShow.setProducer(producer);

        Show autoShow = new AutoShow("testAutoShow", producer, 3600, genre, playDateTime);


        EntityManager em = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //FactoryGeneric producerdao = new ProducerFactoryImpl();
        //producerdao.create(producer);

////        FactoryGeneric musictrackdao = new MusicTrackFactoryImpl();
////        musictrackdao.create(musictrack);
////
////        FactoryGeneric adtrackdao = new AdTrackFactoryImpl();
////        adtrackdao.create(adTrack);
//

//        FactoryGeneric adtrackdao = new AdTrackFactoryImpl();
//        adtrackdao.create(adTrack);

//        em.persist(pl);
//        em.persist(genre);
//
        em.persist(autoShow);

//        em.persist(pl);
//        em.persist(genre);
//
//        em.persist(autoShow);


        tx.commit();
        em.close();

//        pl.setTracks(new ArrayList<Track>());
//
//        pl.addTrackToList(musictrack);
//        pl.addTrackToList(adTrack);
//        pl.getTracks();
//
//        PlaylistShowController plCtrl = new PlaylistShowController();
//        System.out.println(plCtrl.checkDuration(pl));
//        while (plCtrl.checkDuration(pl) == true){
//            plCtrl.fixDuration(pl);
//        }
//
//        System.out.println(pl.getTracks());

    }
}
