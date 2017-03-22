package com.radio;

import com.radio.Models.*;
import com.radio.Utilities.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Calendar;

public class Initializer {

    public void eraseData(){
        EntityManager em = JPAUtil.getCurrentEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query query = em.createNativeQuery("delete from TRACKS");
        query.executeUpdate();
//        query = em.createNativeQuery("delete from AUTOSHOWS");
//        query.executeUpdate();
//        query = em.createNativeQuery("delete from PLAYLISTSHOWS");
//        query.executeUpdate();

        query = em.createNativeQuery("delete from SHOWS");
        query.executeUpdate();
        query = em.createNativeQuery("delete from GENRES");
        query.executeUpdate();
//        query = em.createNativeQuery("delete from MUSICTRACKS");
//        query.executeUpdate();
//        query = em.createNativeQuery("delete from ADTRACKS");
//        query.executeUpdate();
//        query = em.createNativeQuery("delete from PLAYLISTSHOWS");
//        query.executeUpdate();
        query = em.createNativeQuery("delete from PRODUCERS");
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

        Show autoShow = new AutoShow("testAutoShow", producer, 3600, new Genre("genre"), playDateTime.getTimeInMillis());

        EntityManager em = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(autoShow);
        em.persist(musictrack);

        tx.commit();
        em.close();

    }

}