package com.radio.Daos;

import com.radio.Models.AdTrack;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AdTrackDaoImpl extends DaoGenericImpl<AdTrack> implements AdTrackDao{

    @Override
    public List<AdTrack> getAdTracks(EntityManager em){

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<AdTrack> results = null;

        results = em.createQuery("select b from Track b where type(b) = AdTrack ").getResultList();

        tx.commit();
        em.close();
        return results;

    }

}
