package jpa;

import com.radio.Controllers.AutoShowController;
import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

public class AutoShowJPATest {

    Initializer dataHelper;
    FactoryGeneric factory;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.eraseData();
    }



    @Test
    public void testShow() {

        Producer prod = new Producer("dim", "mer", new EmailAddress("a@a.a"));

        PlayBackZone playBackZone = new PlayBackZone(Calendar.getInstance(), Calendar.getInstance());
        Calendar playDateTime = Calendar.getInstance();

        MusicTrack musictrack = new MusicTrack("dsdas", "dsadsa", new Genre("rock"), 1998, 1000);

        MusicTrack musictrack2 = new MusicTrack("tidsdastle", "dsads", new Genre("rock"), 1998, 1000);

        MusicTrack musictrack3 = new MusicTrack("titldsdsae", "adsadsartist", new Genre("pop"), 1998, 100);

        AdTrack adTrack = new AdTrack("titldsdsae", playBackZone, Calendar.getInstance(),Calendar.getInstance(), 1998, 1000);

        AutoShow autoShow = new AutoShow("testAutoShow", prod, 3600, new Genre("rock"), playDateTime);

        factory = new FactoryGenericImpl(Producer.class);

        factory.create(prod);

        factory = new FactoryGenericImpl(MusicTrack.class);

        factory.create(musictrack);
        factory.create(musictrack2);
        factory.create(musictrack3);

        List<MusicTrack> musicTracks = factory.getAll();

        factory = new FactoryGenericImpl(AdTrack.class);

        factory.create(adTrack);

        List<AdTrack> adTracks = factory.getAll();

        AutoShowController ctrl = new AutoShowController();

        AutoShow s = ctrl.fillAutoshow(musicTracks,adTracks,autoShow);

        Assert.assertEquals(3, s.getTracks().size());


    }

}
