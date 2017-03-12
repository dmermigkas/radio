package com.radio.Daos;

import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MusicTrackDaoImpl extends DaoGenericImpl<MusicTrack> implements MusicTrackDao{

    @Override
    public List<MusicTrack> getByGenre(EntityManager em, Genre genre2){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<MusicTrack> results = null;

        results = em.createQuery("select b from MusicTrack b join fetch b.genre p where b.genre.genre like :genre2").setParameter("genre2", "%" + genre2.getGenre() + "%").getResultList();
        tx.commit();
        em.close();
        return results;

    }

}
