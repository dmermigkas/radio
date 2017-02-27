package com.radio.Factories;

import com.radio.Daos.AdTrackDao;
import com.radio.Daos.AdTrackDaoImpl;
import com.radio.Models.AdTrack;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdTrackFactoryImpl implements FactoryGeneric<AdTrack, Integer>{

    private AdTrackDao musicDao;
    @PersistenceContext
    private EntityManager em;

    public AdTrackFactoryImpl(){

        em = JPAUtil.getCurrentEntityManager();
        musicDao = new AdTrackDaoImpl();

    }

    @Override
    public void add(AdTrack entity){

        musicDao.add(entity,em);

    }

    @Override
    public void create(AdTrack prod){

        if(prod == null){

            musicDao.create(prod,em);
        }
        else{
            System.out.println("helloooooooooooooooooooooo2");
            musicDao.create(prod,em);
        }

    }

    @Override
    public void update(AdTrack entity){

    }

    @Override
    public void remove(AdTrack entity){

    }

    @Override
    public List<AdTrack> getAll(){
        return new ArrayList<>();
    }

    @Override
    public AdTrack get(Integer id) {
        return null;
    }

}
