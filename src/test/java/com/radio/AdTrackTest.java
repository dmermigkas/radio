package com.radio;

import com.radio.Models.AdTrack;
import com.radio.Models.PlayBackZone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.Calendar;

/**
 * Created by lotv on 26/02/2017.
 */
public class AdTrackTest {

    AdTrack adTrack;
    Calendar fromCalendar;
    Calendar toCalendar;
    Calendar fromZone;
    Calendar toZone;
    PlayBackZone playBackZone;

    @Before
    public void PlayBackZoneTestSetUp(){
        fromCalendar = Calendar.getInstance();
        toCalendar = fromCalendar;
        toCalendar.add(Calendar.DATE, 2);
        fromZone = fromCalendar;
        fromZone.add(Calendar.HOUR, 1);
        toZone = fromCalendar;
        toZone.add(Calendar.HOUR, 2);
        playBackZone = new PlayBackZone(fromZone, toZone);
        adTrack= new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20);
    }

    @Test
    public void PlayBackZoneGettersTest(){
        Assert.assertEquals(adTrack.getBrand(), "jumbo");
        Assert.assertEquals(adTrack.getDuration(), 20);
        Assert.assertEquals(adTrack.getPlaysPerZone(), 5);
        Assert.assertEquals(adTrack.getFrom(), fromCalendar);
        Assert.assertEquals(adTrack.getTo(), toCalendar);
        //Assert.assertEquals(adTrack.getZone(), playBackZone); // problem with @Override equals of playbackzone class
    }

    @Test
    public void PlaybackZoneSettersTest(){
        adTrack.setBrand("newbrand");
        Assert.assertEquals(adTrack.getBrand(), "newbrand");
        adTrack.setDuration(30);
        Assert.assertEquals(adTrack.getDuration(), 30);
        adTrack.setPlaysPerZone(8);
        Assert.assertEquals(adTrack.getPlaysPerZone(), 8);
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.add(Calendar.DATE, 7);
        adTrack.setFrom(newCalendar);
        Assert.assertEquals(adTrack.getFrom(), newCalendar);
        newCalendar.add(Calendar.DATE, 2);
        adTrack.setTo(newCalendar);
        Assert.assertEquals(adTrack.getTo(), newCalendar);
        //I have to assert setplaybackzone here
    }

}
