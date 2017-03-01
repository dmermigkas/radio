package com.radio.Factories;

import com.radio.Daos.DaoGenericImpl;
import com.radio.Models.Producer;
import com.radio.Utilities.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FactoryGenericImpl<T> implements FactoryGeneric<T,Integer>{

    private DaoGenericImpl prodDao;
    @PersistenceContext
    private EntityManager em;

    protected String entityClass;

    public FactoryGenericImpl(Class<T> entityClass){
        this.entityClass = entityClass.getSimpleName();
        prodDao = new DaoGenericImpl<>(entityClass.getSimpleName(),entityClass);

    }


    @Override
    public void create(T prod){

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
    public void update(T entity){

        em = JPAUtil.createEntityManager();
        prodDao.update(entity,em);

    }

    @Override
    public void remove(T entity){

        em = JPAUtil.createEntityManager();
        prodDao.remove(entity,em);

    }

    @Override
    public List<T> getAll(){

        em = JPAUtil.createEntityManager();
        return prodDao.getAll(em);

    }

    @Override
    public T get(Integer id) {

        em = JPAUtil.createEntityManager();
        return (T) prodDao.find(id,em);
        //return  (T) new Producer();

    }

}