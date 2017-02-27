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
        Assert.assertEquals("newtitle", musictrack.getTitle());
    }

    @Test
    public void MusicTrackGetSetArtistTest(){
        musictrack.setArtist("newartist");
        Assert.assertEquals("newartist", musictrack.getArtist());
    }

    @Test
    public void MusicTrackGetSetGenreTest(){
        musictrack.setGenre(new Genre("newmusicgenre"));
        Assert.assertEquals("newmusicgenre", musictrack.getGenre().getGenre());

    }

    @Test
    public void MusicTrackGetSetReleaseYearTest(){
        musictrack.setReleaseYear(1998);
        Assert.assertEquals(1998, musictrack.getReleaseYear());
    }

    @Test
    public void MusicTrackGetSetDurationTest(){
        musictrack.setDuration(99);
        Assert.assertEquals(99, musictrack.getDuration());
    }
}
