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

        Producer prod = new Producer("dim", "mer", new EmailAddress("a@a.a"));

        PlayBackZone playBackZone = new PlayBackZone(Calendar.getInstance(), Calendar.getInstance());
        Calendar playDateTime = Calendar.getInstance();

        MusicTrack musictrack = new MusicTrack("dsdas", "dsadsa", new Genre("rock"), 1998, 2000);

        MusicTrack musictrack2 = new MusicTrack("tidsdastle", "dsads", new Genre("rock"), 1998, 2000);

        MusicTrack musictrack3 = new MusicTrack("titldsdsae", "adsadsartist", new Genre("pop"), 1998, 100);

        AdTrack adTrack = new AdTrack("titldsdsae", playBackZone, Calendar.getInstance(),Calendar.getInstance(), 1998, 2000);

        AutoShow autoShow = new AutoShow("testAutoShow", prod, 3600, new Genre("rock"), playDateTime);

        producerDao = new FactoryGenericImpl(Producer.class);

        producerDao.create(prod);

        producerDao = new FactoryGenericImpl(MusicTrack.class);

        producerDao.create(musictrack);
        producerDao.create(musictrack2);
        producerDao.create(musictrack3);

        List<MusicTrack> musicTracks = producerDao.getAll();

        producerDao = new FactoryGenericImpl(AdTrack.class);

        producerDao.create(adTrack);

        List<AdTrack> adTracks = producerDao.getAll();

        AutoShowController ctrl = new AutoShowController();

        AutoShow s = ctrl.fillAutoshow(musicTracks,adTracks,autoShow);

        System.out.println(s);



    }

}
