package com.radio;

import com.radio.Models.EmailAddress;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by agk on 22/02/2017.
 */
public class EmailTest {

    @Test
    public void emailConstructor() {
        EmailAddress emailAddress = new EmailAddress("testing@email.org");
        Assert.assertEquals("testing@email.org", emailAddress.getEmail());
    }
}
