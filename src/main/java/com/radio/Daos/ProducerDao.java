package com.radio.Daos;

import com.radio.Models.Producer;

public interface ProducerDao extends DaoGeneric<Producer,Integer> {

    public void getDao();

    public void addProducer();


}
