package com.radio;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Factories.ProducerFactoryImpl;
import com.radio.Models.EmailAddress;
import com.radio.Models.Producer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProducerJPATest {

    Initializer dataHelper;
    FactoryGeneric producerDao;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.eraseData();
    }

    @Test
    public void addRemoveUpdateProducer() {

        Producer producer1 = new Producer("firstname1", "lastname", new EmailAddress("a@a.a"));
        producerDao = new FactoryGenericImpl(Producer.class);
        Assert.assertEquals(producer1.getFirstName(), "firstname1");
        producerDao.create(producer1);
        Assert.assertEquals(producerDao.getAll().size(), 1);
        producer1.setFirstName("dimitris");
        producerDao.update(producer1);
        List<Producer> listPersons = producerDao.getAll();
        Assert.assertEquals(listPersons.get(0).getFirstName(), "dimitris");

    }

    @Test
    public void findProducer() {

        Producer producer2 = new Producer("name1", "name2", new EmailAddress("a@a.a"));
        producerDao = new FactoryGenericImpl(Producer.class);


    }

}
