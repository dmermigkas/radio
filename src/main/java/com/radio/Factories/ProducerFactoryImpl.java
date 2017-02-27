package com.radio.Factories;

import com.radio.Daos.ProducerDao;
import com.radio.Daos.ProducerDaoImpl;
import com.radio.Models.Producer;

import java.util.HashSet;
import java.util.Set;

public class ProducerFactoryImpl implements FactoryGeneric<Producer, Integer>{

    private ProducerDao prodDao;

    public ProducerFactoryImpl(){
        prodDao = new ProducerDaoImpl();
    }

    @Override
    public void add(Producer entity){
        prodDao.add(entity);
    }

    @Override
    public void saveOrUpdate(Producer entity){

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
