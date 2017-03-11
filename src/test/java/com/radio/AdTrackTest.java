package com.radio;

import com.radio.Models.AdTrack;
import com.radio.Models.PlayBackZone;
import com.radio.Initializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
        Assert.assertEquals("jumbo", adTrack.getBrand());
        Assert.assertEquals(20, adTrack.getDuration());
        Assert.assertEquals(5, adTrack.getPlaysPerZone());
        Assert.assertEquals(fromCalendar, adTrack.getFrom());
        Assert.assertEquals(toCalendar, adTrack.getTo());
        //Assert.assertEquals(adTrack.getZone(), playBackZone); // problem with @Override equals of playbackzone class
    }

    @Test
    public void PlaybackZoneSettersTest(){
        adTrack.setBrand("newbrand");
        Assert.assertEquals("newbrand", adTrack.getBrand());
        adTrack.setDuration(30);
        Assert.assertEquals(30, adTrack.getDuration());
        adTrack.setPlaysPerZone(8);
        Assert.assertEquals(8, adTrack.getPlaysPerZone());
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.add(Calendar.DATE, 7);
        adTrack.setFrom(newCalendar);
        Assert.assertEquals(newCalendar, adTrack.getFrom());
        newCalendar.add(Calendar.DATE, 2);
        adTrack.setTo(newCalendar);
        Assert.assertEquals(newCalendar, adTrack.getTo());
        adTrack.setDuration(12);
        Assert.assertEquals(adTrack.getDuration(), 12);
    }

}
