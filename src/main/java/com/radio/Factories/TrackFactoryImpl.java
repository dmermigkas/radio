package com.radio.Factories;

import com.radio.Daos.TrackDao;
import com.radio.Daos.TrackDaoImpl;
import com.radio.Models.MusicTrack;
import com.radio.Models.Track;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TrackFactoryImpl extends FactoryGenericImpl<Track> implements TrackFactory{

    private TrackDao trackDao;
    @PersistenceContext
    private EntityManager em;

    protected String entityClass;

    public TrackFactoryImpl(){
        trackDao = new TrackDaoImpl();
    }

    @Override
    public List<MusicTrack> getMusicTracks(Integer id){

        em = JPAUtil.createEntityManager();
        return trackDao.getMusicTracks(em,id);

    }

}
