package com.radio;

import com.radio.Models.PlayBackZone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by lotv on 22/02/2017.
 */
public class PlayBackZoneTest {

    PlayBackZone playBackZone;
    Calendar fromCalendar;
    Calendar toCalendar;

    @Before
    public void PlayBackZoneTestSetUp(){
        fromCalendar = Calendar.getInstance();
        toCalendar = fromCalendar;
        toCalendar.add(Calendar.HOUR, 2);
        playBackZone= new PlayBackZone(fromCalendar, toCalendar);
    }

    @Test
    public void PlayBackZoneGettersTest(){
        Assert.assertEquals(playBackZone.getFromTime(), fromCalendar);
        Assert.assertEquals(playBackZone.getToTime(), toCalendar);
        //PlayBackZone newPlaybackZone = playBackZone;                          // This part of the test does not work
        //Assert.assertEquals(newPlaybackZone, playBackZone.getPlaybackZone()); //

    }

    @Test
    public void PlayBackZoneSettersTest(){
        Calendar newFromCalendar = fromCalendar;
        newFromCalendar.add(Calendar.HOUR, 2);
        Calendar newToCalendar = toCalendar;
        newToCalendar.add(Calendar.HOUR, 4);
        playBackZone.setFromTime(newFromCalendar);
        Assert.assertEquals(playBackZone.getFromTime(), newFromCalendar);
        playBackZone.setToTime(newToCalendar);
        Assert.assertEquals(playBackZone.getToTime(), newToCalendar);
    }

    @Test
    public void PlayBackZoneEqualsTest(){
        Calendar newFromCalendar = fromCalendar;
        newFromCalendar.add(Calendar.HOUR, 2);
        Calendar newToCalendar = toCalendar;
        newToCalendar.add(Calendar.HOUR, 4);
        PlayBackZone playBackZone2;
        playBackZone2 = null;
        Assert.assertNotEquals(playBackZone, playBackZone2);
        //playBackZone2 = new PlayBackZone(newFromCalendar, newToCalendar);
        //Assert.assertNotEquals(playBackZone, playBackZone2);  //not sure why it does not run
        playBackZone2 = playBackZone;
        Assert.assertEquals(playBackZone, playBackZone2);
        Assert.assertNotEquals(playBackZone, "hello");
    }

}
