package com.radio;

import com.radio.Models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by agk on 26/02/2017.
 */
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
        Assert.assertEquals(playlistShow.getName(), "playListShow");
        Assert.assertEquals(playlistShow.getDuration(), 3600);
        Assert.assertEquals(playlistShow.getProducer(), producer);
        Assert.assertEquals(playlistShow.getPlayDateTime(), playDateTime);
    }
    @Test
    public void PlaylistShowSettersTest() {
        playlistShow.setName("playlistShow2");
        Producer producer2 = new Producer("firstName2", "lastName2", new EmailAddress("testing2@email.org"));
        Assert.assertEquals(playlistShow.getName(), "playlistShow2");
        playlistShow.setProducer(producer2);
        Assert.assertEquals(playlistShow.getProducer(), producer2);
        playlistShow.setDuration(3200);
        Assert.assertEquals(playlistShow.getDuration(), 3200);
        Calendar playDateTime2 = playDateTime;
        playDateTime2.add(Calendar.HOUR, 2);
        playlistShow.setPlayDateTime(playDateTime2);
        Assert.assertEquals(playlistShow.getPlayDateTime(), playDateTime2);
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
        Assert.assertEquals(playlistShow.getTracks().get(0), musicTrack);

        playlistShow.removeTrackFromList(musicTrack);
        Assert.assertEquals(playlistShow.getTracks().isEmpty(), true);



    }
}

