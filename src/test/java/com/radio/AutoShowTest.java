package com.radio;

import com.radio.Models.AutoShow;
import com.radio.Models.EmailAddress;
import com.radio.Models.Genre;
import com.radio.Models.Producer;
import com.radio.Initializer;
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
        autoShow = new AutoShow("testAutoShow", producer, 3600, genre, playDateTime);
    }

    @Test
    public void AutoShowGetterTest() {
        Assert.assertEquals("testAutoShow", autoShow.getName());
        Assert.assertEquals(genre, autoShow.getGenre());
        Assert.assertEquals(3600, autoShow.getDuration());
        Assert.assertEquals(producer, autoShow.getProducer());
        Assert.assertEquals(playDateTime, autoShow.getPlayDateTime());
    }

    @Test
    public void AutoShowSetterTest() {
        autoShow.setName("autoShow2");
        Assert.assertEquals("autoShow2", autoShow.getName());
        Genre genre2 = new Genre("testGenre2");
        autoShow.setGenre(genre2);
        Assert.assertEquals(genre2, autoShow.getGenre());
        autoShow.setDuration(3200);
        Assert.assertEquals(3200, autoShow.getDuration());
        Producer producer2 = new Producer("firstName2", "lastName2", new EmailAddress("testing2@email.org"));
        autoShow.setProducer(producer2);
        Assert.assertEquals(producer2, autoShow.getProducer());
        Calendar playDateTime2 = playDateTime;
        playDateTime2.add(Calendar.HOUR, 2);
        autoShow.setPlayDateTime(playDateTime2);
        Assert.assertEquals(playDateTime2,autoShow.getPlayDateTime());

    }
}
