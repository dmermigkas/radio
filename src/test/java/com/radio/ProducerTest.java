package com.radio;

import com.radio.Models.EmailAddress;
import com.radio.Models.Producer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lotv on 21/02/2017.
 */
public class ProducerTest {

    @Before
    public void setupProducerTests(){
        Producer producer = new Producer("firstname", "lastname", new EmailAddress("a@a.a"));
    }/*

    @Test
    public void producerGetFirstNameTest(){
        Producer producer = new Producer("firstname", "lastname", new EmailAddress("a@a.a"));
        Assert.assertEquals("firstname", producer.getFirstName);
    }

    @Test
    public void producerGetLastNameTest(){
        Assert.assertEquals("lastname", producer.getLastName);
    }

    @Test
    public void producerGetEmailTest(){
        Assert.assertEquals("a@a.a", producer.getEmail.getEmail);
    }

*/
}
