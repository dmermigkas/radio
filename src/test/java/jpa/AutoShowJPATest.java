package jpa;

import com.radio.Controllers.AutoShowController;
import com.radio.Controllers.ShowController;
import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AutoShowJPATest { //todo clean the test and add assertions

    Initializer dataHelper;
    FactoryGeneric producerDao;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.eraseData();
    }

    @Test
    public void testShow() {

        List mtracks = new ArrayList();
        List atracks = new ArrayList();

        Producer prod = new Producer("dim", "mer", new EmailAddress("a@a.a"));

        PlayBackZone playBackZone = new PlayBackZone(Calendar.getInstance(), Calendar.getInstance());
        Calendar playDateTime = Calendar.getInstance();

        MusicTrack musictrack = new MusicTrack("dsdas", "dsadsa", new Genre("rock"), 1998, 200);

        MusicTrack musictrack2 = new MusicTrack("tidsdastle", "dsads", new Genre("rock"), 1998, 200);

        MusicTrack musictrack3 = new MusicTrack("titldsdsae", "adsadsartist", new Genre("pop"), 1998, 100);

        AdTrack adTrack = new AdTrack("titldsdsae", playBackZone, Calendar.getInstance(),Calendar.getInstance(), 1998, 200);

        AutoShow autoShow = new AutoShow("testAutoShow", prod, 3600, new Genre("rock"), playDateTime);

        mtracks.add(musictrack);
        mtracks.add(musictrack2);
        mtracks.add(musictrack3);

        atracks.add(adTrack);

        AutoShowController ctrl = new AutoShowController();

        AutoShow rockShow = ctrl.fillAutoshow(mtracks,atracks,autoShow);

        Assert.assertEquals(2, ctrl.getMusicTrackSize(rockShow.getShowId()));

        for (MusicTrack tr : ctrl.getMusicTracks(rockShow.getShowId())){
            Assert.assertEquals("rock", tr.getGenre().getGenre());
        }

    }

}
