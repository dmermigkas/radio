package com.radio;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.ProducerFactoryImpl;
import com.radio.Models.EmailAddress;
import com.radio.Models.Producer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        dataHelper.eraseData();
        dataHelper.prepareData();
    }

    @Test
    public void addRemoveProducer() {
        producerDao = new ProducerFactoryImpl();
        Producer producer1 = new Producer("firstname1", "lastname", new EmailAddress("a@a.a"));
        Assert.assertEquals(producer1.getFirstName(), "firstname1");
        producerDao.create(producer1);
        Assert.assertEquals(producerDao.getAll().size(), 2);
        producer1.setFirstName("dimitris");
        producerDao.update(producer1);
        List<Producer> listPersons = producerDao.getAll();

        for(int i = 0; i < listPersons.size(); i++) {
            if(i == 1){
                Assert.assertEquals(listPersons.get(i).getFirstName(), "dimitris");
            }
        }
        //Assert.assertEquals(producerDao.getAll().get(1), 2);
//        producerDao.remove(producer1);
//        Assert.assertEquals(producerDao.getAll().size(), 1);
//        producerDao.create(null);
//        Assert.assertEquals(producerDao.getAll().size(), 2);
    }
}
