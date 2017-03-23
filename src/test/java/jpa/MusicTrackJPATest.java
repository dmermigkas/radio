package jpa;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;
import com.radio.Models.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by lotv on 28/02/2017.
 */
public class MusicTrackJPATest {

    Initializer dataHelper;
    FactoryGeneric musicTrackDao;
    MusicTrack musictrack;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.eraseData();
        musictrack = new MusicTrack("title", "artist", new Genre("genre"), 1998, 100);
    }

    @Test
    public void musicTrackAddTest(){
        musicTrackDao = new FactoryGenericImpl(MusicTrack.class);
        musicTrackDao.create(musictrack);
        Assert.assertEquals(1, musicTrackDao.getAll().size());
    }

    @Test
    public void musicTrackRemoveTest(){
        musicTrackDao = new FactoryGenericImpl(MusicTrack.class);
        musicTrackDao.create(musictrack);
        musicTrackDao.remove(musictrack);
        Assert.assertEquals(0, musicTrackDao.getAll().size());
    }

    @Test
    public void musicTrackUpdateTest(){ //todo add assert
        musicTrackDao = new FactoryGenericImpl(MusicTrack.class);
        musicTrackDao.create(musictrack);
        musictrack.setArtist("mermigkas");
        musicTrackDao.update(musictrack);
        List<MusicTrack> tracks = musicTrackDao.getAll();


    }

}
