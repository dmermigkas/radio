package jpa;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.EmailAddress;
import com.radio.Models.Producer;
import com.radio.Initializer;
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

        Producer producer = new Producer("firstname1", "lastname", new EmailAddress("a@a.a"));
        producerDao = new FactoryGenericImpl(Producer.class);
        Assert.assertEquals(producer.getFirstName(), "firstname1");
        producerDao.create(producer);
        Assert.assertEquals(producerDao.getAll().size(), 1);
        producer.setFirstName("dimitris");
        producerDao.update(producer);
        List<Producer> listPersons = producerDao.getAll();
        Assert.assertEquals(listPersons.get(0).getFirstName(), "dimitris");

    }

    @Test
    public void findProducer() {

        Producer producer = new Producer("name1", "name2", new EmailAddress("a@a.a"));
        producerDao = new FactoryGenericImpl(Producer.class);
        producerDao.create(producer);
        List<Producer> producers = producerDao.getAll();
        Producer producer1 = producers.get(0);
        Producer producer2 = (Producer) producerDao.get(producer1.getId());
        Assert.assertEquals(producer1.getFirstName(), producer2.getFirstName());

    }

}
