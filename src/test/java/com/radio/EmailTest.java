package com.radio;

import com.radio.Models.EmailAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by agk on 22/02/2017.
 */
public class EmailTest {

    EmailAddress emailAddress;

    @Before
    public void emailTestSetup(){
        emailAddress = new EmailAddress("testing@email.org");
    }

    @Test
    public void emailGetEmail() {
        Assert.assertEquals("testing@email.org", emailAddress.getEmail());
    }

    @Test
    public void emailSetEmailAddressTest(){
        emailAddress.setEmail("another@email.org");
        Assert.assertEquals("another@email.org", emailAddress.getEmail());
    }
}
