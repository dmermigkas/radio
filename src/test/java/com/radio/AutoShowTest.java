package com.radio;

import com.radio.Models.AutoShow;
import com.radio.Models.EmailAddress;
import com.radio.Models.Genre;
import com.radio.Models.Producer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by lotv on 24/02/2017.
 */
public class AutoShowTest {

    AutoShow autoShow;
    Calendar playDateTime;
    Producer producer;
    Genre genre;

    @Before
    public void AutoShowTestSetup() {
        playDateTime = Calendar.getInstance();
        genre = new Genre("testGenre");
        producer = new Producer("firstName", "lastName", new EmailAddress("testing@email.org"));
        //autoShow = new AutoShow("testAutoShow", producer, 3600, genre, playDateTime);
    }

    @Test
    public void AutoShowGetterTest() {
        Assert.assertEquals(autoShow.getName(), "testAutoShow");
        Assert.assertEquals(autoShow.getGenre(), genre);
        Assert.assertEquals(autoShow.getDuration(), 3600);
        Assert.assertEquals(autoShow.getProducer(), producer);
        Assert.assertEquals(autoShow.getPlayDateTime(), playDateTime);
    }

    @Test
    public void AutoShowSetterTest() {
        autoShow.setName("autoShow2");
        Assert.assertEquals(autoShow.getName(), "autoShow2");
        Genre genre2 = new Genre("testGenre2");
        autoShow.setGenre(genre2);
        Assert.assertEquals(autoShow.getGenre(), genre2);
        autoShow.setDuration(3200);
        Assert.assertEquals(autoShow.getDuration(), 3200);
        Producer producer2 = new Producer("firstName2", "lastName2", new EmailAddress("testing2@email.org"));
        autoShow.setProducer(producer2);
        Assert.assertEquals(autoShow.getProducer(), producer2);
        Calendar playDateTime2 = playDateTime;
        playDateTime2.add(Calendar.HOUR, 2);
        autoShow.setPlayDateTime(playDateTime2);
        Assert.assertEquals(autoShow.getPlayDateTime(),playDateTime2);

    }
}
