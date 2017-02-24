package com.radio;

import com.radio.Models.AutoShow;
import com.radio.Models.EmailAddress;
import com.radio.Models.Producer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lotv on 21/02/2017.
 */
public class ProducerTest {

    private Producer producer;

    @Before
    public void setupProducerTests(){
        producer = new Producer("firstname", "lastname", new EmailAddress("a@a.a"));
    }

    @Test
    public void producerGetFirstNameTest(){
        producer = new Producer("firstname", "lastname", new EmailAddress("a@a.a"));
        Assert.assertEquals("firstname", producer.getFirstName());
    }

    @Test
    public void producerGetLastNameTest(){
        Assert.assertEquals("lastname", producer.getLastName());
    }

    @Test
    public void producerGetEmailTest(){
        Assert.assertEquals("a@a.a", producer.getEmail().getEmail());
    }

    @Test
    public void producerSetFirstNameTest(){
        producer.setFirstName("newfirstname");
        Assert.assertEquals("newfirstname", producer.getFirstName());
    }

    @Test
    public void producerSetLastNameTest(){
        producer.setLastName("newlastname");
        Assert.assertEquals("newlastname", producer.getLastName());
    }

    @Test
    public void producerSetEmailTest(){
        producer.setEmail(new EmailAddress("b@b.c"));
        Assert.assertEquals(producer.getEmail().getEmail(), "b@b.c");
    }



}