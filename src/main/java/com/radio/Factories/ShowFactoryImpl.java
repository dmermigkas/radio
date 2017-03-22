package com.radio.Factories;

import com.radio.Daos.ShowDao;
import com.radio.Daos.ShowDaoImpl;
import com.radio.Models.Show;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ShowFactoryImpl extends FactoryGenericImpl<Show> implements ShowFactory{

    private ShowDao showDao;
    @PersistenceContext
    private EntityManager em;

    protected String entityClass;

    public ShowFactoryImpl(){
        showDao = new ShowDaoImpl();
    }

    @Override
    public List<Show> getTodaysShows(Long yesterday,Long now){

        em = JPAUtil.createEntityManager();
        return showDao.getTodaysShows(em,yesterday,now);

    }

    @Override
    public List<Show> getShowsByDate(Long from,Long to){

        em = JPAUtil.createEntityManager();
        return showDao.getShowsByDate(em,from,to);

    }

}
