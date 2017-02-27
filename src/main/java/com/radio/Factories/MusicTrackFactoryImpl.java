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

public class MusicTrackFactoryImpl  implements FactoryGeneric<MusicTrack, Integer>{

    private MusicTrackDao musicDao;
    @PersistenceContext
    private EntityManager em;

    public MusicTrackFactoryImpl(){

        em = JPAUtil.getCurrentEntityManager();
        musicDao = new MusicTrackDaoImpl();

    }

    @Override
    public void add(MusicTrack entity){

        musicDao.add(entity,em);

    }

    @Override
    public void create(MusicTrack prod){

        if(prod == null){
            musicDao.create(prod,em);
        }
        else{
            musicDao.merge(prod,em);
        }

    }

    @Override
    public void update(MusicTrack entity){

    }

    @Override
    public void remove(MusicTrack entity){

    }

    @Override
    public List<MusicTrack> getAll(){
        return new ArrayList<>();
    }

    @Override
    public MusicTrack get(Integer id) {
        return null;
    }

}
