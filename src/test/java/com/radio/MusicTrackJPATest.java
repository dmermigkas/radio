package com.radio;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.MusicTrackFactoryImpl;
import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;
import com.radio.Models.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lotv on 28/02/2017.
 */
public class MusicTrackJPATest {

    Initializer dataHelper;
    FactoryGeneric musicTrackDao;
    Track musictrack;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.eraseData();
        musictrack = new MusicTrack("title", "artist", new Genre("genre"), 1998, 100);
    }

    @Test
    public void musicTrackAddTest(){
        musicTrackDao = new MusicTrackFactoryImpl();
        musicTrackDao.create(musictrack);
        Assert.assertEquals(1, musicTrackDao.getAll().size());
    }

    @Test
    public void musicTrackRemoveTest(){ //somehow fails...
        musicTrackDao = new MusicTrackFactoryImpl();
        musicTrackDao.remove(musictrack);
        Assert.assertEquals(0, musicTrackDao.getAll().size());
    }

}
