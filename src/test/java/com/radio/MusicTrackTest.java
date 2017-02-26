package com.radio;

import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

/**
 * Created by lotv on 26/02/2017.
 */
public class MusicTrackTest {
    MusicTrack musictrack;

    @Before
    public void MusicTrackSetup(){
        musictrack = new MusicTrack("musictitle", "musicartist", new Genre("musicgenre"), 1999, 100);
    }

    @Test
    public void MusicTrackGetSetTitleTest(){
        musictrack.setTitle("newtitle");
        Assert.assertEquals(musictrack.getTitle(), "newtitle");
    }

    @Test
    public void MusicTrackGetSetArtistTest(){
        musictrack.setArtist("newartist");
        Assert.assertEquals(musictrack.getArtist(), "newartist");
    }

    @Test
    public void MusicTrackGetSetGenreTest(){
        musictrack.setGenre(new Genre("newmusicgenre"));
        Assert.assertEquals(musictrack.getGenre().getGenre(), "newmusicgenre");

    }

    @Test
    public void MusicTrackGetSetReleaseYearTest(){
        musictrack.setReleaseYear(1998);
        Assert.assertEquals(musictrack.getReleaseYear(), 1998);
    }

    @Test
    public void MusicTrackGetSetDurationTest(){
        musictrack.setDuration(99);
        Assert.assertEquals(musictrack.getDuration(), 99);
    }
}
