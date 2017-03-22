package com.radio.Daos;

import com.radio.Models.Show;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ShowDaoImpl extends DaoGenericImpl<Show> implements ShowDao{

    @Override
    public List<Show> getTodaysShows(EntityManager em, Long yesterday,Long now){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Show> results = null;

        try {
            results = em.createQuery("select distinct b from Show b join b.tracks a where a.trackPlayEvent.dateTime BETWEEN :yesterday AND :now").setParameter("yesterday", yesterday).setParameter("now", now).getResultList();
            tx.commit();
            em.close();
        } catch (NoResultException ex) {
            tx.rollback();
        }

        return results;

    }

    @Override
    public List<Show> getShowsByDate(EntityManager em, Long from,Long to){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Show> results = null;

        try {
            System.out.println(from+" rrrrrrrrrrrr");
            System.out.println(to+" eeeeeeeeee");
            results = em.createQuery("select b from Show b where b.playDateTime BETWEEN :from AND :to").setParameter("from", from).setParameter("to", to).getResultList();
            tx.commit();
            em.close();
        } catch (NoResultException ex) {
            tx.rollback();
        }

        return results;

    }

}
