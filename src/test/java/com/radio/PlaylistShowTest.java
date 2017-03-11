package com.radio;

import com.radio.Models.*;
import com.radio.Initializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class PlaylistShowTest {
    PlaylistShow playlistShow;
    Calendar playDateTime;
    Producer producer;

    @Before
    public void PlaylistShowSetup() {
        playDateTime = Calendar.getInstance();
        producer = new Producer("firstName", "lastName", new EmailAddress("testing@email.org"));
        playlistShow = new PlaylistShow("playListShow",producer,3600, playDateTime);
    }

    @Test
    public void PlaylistShowGettersTest() {
        Assert.assertEquals("playListShow", playlistShow.getName());
        Assert.assertEquals(3600, playlistShow.getDuration());
        Assert.assertEquals(producer, playlistShow.getProducer());
        Assert.assertEquals(playDateTime, playlistShow.getPlayDateTime());
    }
    @Test
    public void PlaylistShowSettersTest() {
        playlistShow.setName("playlistShow2");
        Producer producer2 = new Producer("firstName2", "lastName2", new EmailAddress("testing2@email.org"));
        Assert.assertEquals("playlistShow2", playlistShow.getName());
        playlistShow.setProducer(producer2);
        Assert.assertEquals(producer2, playlistShow.getProducer());
        playlistShow.setDuration(3200);
        Assert.assertEquals(3200, playlistShow.getDuration());
        Calendar playDateTime2 = playDateTime;
        playDateTime2.add(Calendar.HOUR, 2);
        playlistShow.setPlayDateTime(playDateTime2);
        Assert.assertEquals(playDateTime2, playlistShow.getPlayDateTime());
    }

    @Test
    public void AddRemoveTrackTest() {

        Track musicTrack = new MusicTrack("musictitle", "musicartist", new Genre("musicgenre"), 1999, 100);

        Calendar fromCalendar = Calendar.getInstance();
        Calendar toCalendar = fromCalendar;
        toCalendar.add(Calendar.DATE, 2);
        Calendar fromZone = fromCalendar;
        fromZone.add(Calendar.HOUR, 1);
        Calendar toZone = fromCalendar;
        toZone.add(Calendar.HOUR, 2);
        PlayBackZone playBackZone = new PlayBackZone(fromZone, toZone);


        Track adTrack = new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20);

        playlistShow.addTrackToList(musicTrack);
        Assert.assertEquals(musicTrack, playlistShow.getTracks().get(0));

        playlistShow.removeTrackFromList(musicTrack);
        Assert.assertEquals(true, playlistShow.getTracks().isEmpty());



    }
}

