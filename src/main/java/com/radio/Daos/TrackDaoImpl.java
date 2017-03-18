package com.radio.Daos;

import com.radio.Models.MusicTrack;
import com.radio.Models.Track;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

public class TrackDaoImpl extends DaoGenericImpl<Track> implements TrackDao{

    @Override
    public List<MusicTrack> getMusicTracks(EntityManager em,Integer id){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<MusicTrack> results = null;

        try {
            results = em.createQuery("select a from Show b join b.tracks a where b.showId = :id and a.class = 'MT' ").setParameter("id", id).getResultList();
            tx.commit();
            em.close();
        } catch (NoResultException ex) {
            tx.rollback();
        }

        return results;

    }

}
