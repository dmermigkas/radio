package com.radio.Factories;

import com.radio.Daos.DaoGenericImpl;
import com.radio.Daos.ProducerDao;
import com.radio.Daos.ProducerDaoImpl;
import com.radio.Models.Producer;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProducerFactoryImpl implements ProducerFactory{

    private DaoGenericImpl prodDao;
    @PersistenceContext
    private EntityManager em;

    public ProducerFactoryImpl(){

        //prodDao = new DaoGenericImpl<>();

    }

//    @Override
//    public void add(Producer entity){
//
//        prodDao.add(entity,em);
//
//    }

    @Override
    public void create(Producer prod){

        em = JPAUtil.createEntityManager();
        System.out.println("into create!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //if(prod == null){
            prodDao.create(prod,em);
        //}
        //else{
            //prodDao.merge(prod,em);
        //}

    }

    @Override
    public void update(Producer entity){

        em = JPAUtil.createEntityManager();
        prodDao.update(entity,em);

    }

    @Override
    public void remove(Producer entity){

        em = JPAUtil.createEntityManager();
        prodDao.remove(entity,em);

    }

    @Override
    public List<Producer> getAll(){

        em = JPAUtil.createEntityManager();
        return prodDao.getAll(em);

    }

    @Override
    public Producer get(Integer id) {

        em = JPAUtil.createEntityManager();
        //return prodDao.find(id,em);
        return new Producer();

    }

}
