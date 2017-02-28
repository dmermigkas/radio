package com.radio.Factories;

import com.radio.Daos.MusicTrackDao;
import com.radio.Daos.MusicTrackDaoImpl;
import com.radio.Models.MusicTrack;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MusicTrackFactoryImpl  implements MusicTrackFactory{

    private MusicTrackDao musicDao;
    @PersistenceContext
    private EntityManager em;

    public MusicTrackFactoryImpl(){

        musicDao = new MusicTrackDaoImpl();

    }

//    @Override
//    public void add(MusicTrack entity){
//
//        musicDao.add(entity,em);
//
//    }

    @Override
    public void create(MusicTrack prod){

        em = JPAUtil.createEntityManager();
        musicDao.create(prod,em);

    }

    @Override
    public void update(MusicTrack entity){

    }

    @Override
    public void remove(MusicTrack entity){

        em = JPAUtil.createEntityManager();
        musicDao.remove(entity,em);

    }

    @Override
    public List<MusicTrack> getAll(){
        em = JPAUtil.createEntityManager();
        return musicDao.getAll(em);
    }

    @Override
    public MusicTrack get(Integer id) {
        return null;
    }

}
