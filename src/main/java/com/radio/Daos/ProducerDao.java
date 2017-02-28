package com.radio.Daos;

import com.radio.Models.Producer;

import javax.persistence.EntityManager;

public interface ProducerDao extends DaoGeneric<Producer,Integer> {

    public void getDao();

    //public void merge(Producer entity,EntityManager em);


}
