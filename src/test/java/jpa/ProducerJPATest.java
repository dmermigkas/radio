package jpa;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.ProducerFactoryImpl;
import com.radio.Initializer;
import com.radio.Models.Producer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Producer producer1 = new Producer();
        producerDao.create(producer1);
        Assert.assertEquals(producerDao.getAll().size(), 2);
//        producerDao.create(null);
//        Assert.assertEquals(producerDao.getAll().size(), 2);
    }
}
