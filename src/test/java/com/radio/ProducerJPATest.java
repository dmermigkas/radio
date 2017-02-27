package com.radio;

import com.radio.Daos.ProducerDao;
import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.ProducerFactoryImpl;
import com.radio.Models.EmailAddress;
import com.radio.Models.Producer;
import com.radio.Utilities.JPAUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by lotv on 27/02/2017.
 */
public class ProducerJPATest {

    Initializer dataHelper;
    FactoryGeneric producerDao;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.prepareData();
    }

    @Test
    public void addProducer(){
        producerDao = new ProducerFactoryImpl();
        Producer producer1 = new Producer();
        producerDao.add(producer1);
        Assert.assertEquals(producerDao.getAll().size(), 2);
    }
}
