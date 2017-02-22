package com.radio;

import com.radio.Models.PlayBackZone;
import org.junit.Before;

import java.util.Calendar;

/**
 * Created by lotv on 22/02/2017.
 */
public class PlayBackZoneTest {

    private PlayBackZone playBackZone;

    @Before
    public void PlayBackZoneTestSetUp(){
        playBackZone= new PlayBackZone(Calendar.getInstance(), Calendar.getInstance()); //stub calendar instances?
    }
}
