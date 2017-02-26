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
        adTrack= new AdTrack("brand", new PlayBackZone(fromCalendar, toCalendar), fromCalendar, toCalendar, 5, 20);
    }

    @Test
    public void PlayBackZoneGettersTest(){
        Assert.assertEquals(adTrack.getBrand(), "brand");
        Assert.assertEquals(adTrack.getDuration(), 20);
        Assert.assertEquals(adTrack.getPlaysPerZone(), 5);
        //Assert.assertEquals(adTrack.getFrom(), fromCalendar);
        //Assert.assertEquals(adTrack.getTo(), toCalendar);
        //Assert.assertEquals(adTrack.getZone(), playBackZone);
    }

}
