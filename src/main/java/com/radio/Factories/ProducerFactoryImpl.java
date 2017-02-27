package com.radio.Factories;

import com.radio.Daos.ProducerDao;
import com.radio.Daos.ProducerDaoImpl;
import com.radio.Models.Producer;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

public class ProducerFactoryImpl implements FactoryGeneric<Producer, Integer>{

    private ProducerDao prodDao;
    @PersistenceContext
    private EntityManager em;

    public ProducerFactoryImpl(){

        em = JPAUtil.getCurrentEntityManager();
        prodDao = new ProducerDaoImpl();

    }

    @Override
    public void add(Producer entity){

        prodDao.add(entity,em);

    }

    @Override
    public void create(Producer entity){
        Boolean a = prodDao.create(entity,em);
        System.out.println(a);
    }

    @Override
    public void update(Producer entity){

    }

    @Override
    public void remove(Producer entity){

    }

    @Override
    public Set<Producer> getAll(){
        return new HashSet<>();
    }

    @Override
    public Producer get(Integer id) {
        return null;
    }

}
