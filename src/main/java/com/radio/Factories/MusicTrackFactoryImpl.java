package com.radio.Factories;

import com.radio.Daos.DaoGenericImpl;
import com.radio.Daos.MusicTrackDao;
import com.radio.Daos.MusicTrackDaoImpl;
import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MusicTrackFactoryImpl extends FactoryGenericImpl<MusicTrack> implements MusicTrackFactory{

    private MusicTrackDao musicDao;
    @PersistenceContext
    private EntityManager em;

    protected String entityClass;

    public MusicTrackFactoryImpl(){
        musicDao = new MusicTrackDaoImpl();
    }

    @Override
    public List<MusicTrack> getByGenre(Genre genre){

        em = JPAUtil.createEntityManager();
        return musicDao.getByGenre(em,genre);

    }

}
