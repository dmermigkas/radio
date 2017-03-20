package com.radio.Factories;

import com.radio.Daos.AdTrackDao;
import com.radio.Daos.AdTrackDaoImpl;
import com.radio.Models.AdTrack;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AdTrackFactoryImpl extends FactoryGenericImpl<AdTrack> implements AdTrackFactory{

    private AdTrackDao adtrackDao;
    @PersistenceContext
    private EntityManager em;

    protected String entityClass;

    public AdTrackFactoryImpl(){
        adtrackDao = new AdTrackDaoImpl();
    }

    @Override
    public List<AdTrack> getAdTracks(){

        em = JPAUtil.createEntityManager();
        return adtrackDao.getAdTracks(em);

    }

}
