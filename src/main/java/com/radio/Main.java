package com.radio;

import com.radio.Daos.DaoGeneric;
import com.radio.Daos.ProducerDaoImpl;
import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.ProducerFactoryImpl;
import com.radio.Models.*;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();


        Producer prod = new Producer("dimitris", "mermigkas", new EmailAddress("ddsadasds"));
        //MusicTrackDao dao = prod.getDao();

 //       Track track = new MusicTrack("test","test artist",new Genre("test"),1990);
//
//        Track track2 = new MusicTrack("test","test artist",new Genre("tdfest"),1990);
//
//        Track track3 = new AdTrack();

//        Show pl = new PlaylistShow();
//        pl.addTrackToList(track);
//        pl.addTrackToList(track3);
//        pl.removeTrackFromList(track);
//        pl.setProducer(prod);
//        pl.getProducer();

        FactoryGeneric studentDao = new ProducerFactoryImpl();
        studentDao.create(prod);

        //prod.getDao();

        EntityManager em = JPAUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(prod);
        tx.commit();
        em.close();
//        em.persist(track2);
//        em.persist(track3);
//        em.persist(prod);
//        em.persist(prod);




        int diffInDays = (int)( (System.currentTimeMillis() - 0)
                / (1000 * 60 * 60 * 24) );

        System.out.println(System.nanoTime());

        //prod.addPlaylistShow(pl);
        //prod.getPlaylistShows();

//        MusicTrack track = new MusicTrack("test","test artist",new Genre("test"),1990);
//        AdTrack ad = new AdTrack("test",new PlayBackZone(today,today),today,today,4);
//        PlaylistShow pl = new PlaylistShow();
//        pl.addMusicTrackToList(track);
//        pl.removeMusicTrackFromList(track);
//        pl.addAdTrackToList(ad);
//
//        AutoShow auto = new AutoShow();
//        auto.getPolicies().playedLastHour();

    }

}