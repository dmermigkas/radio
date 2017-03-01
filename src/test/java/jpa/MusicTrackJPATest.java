package jpa;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Factories.MusicTrackFactoryImpl;
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
    MusicTrack musictrack = new MusicTrack("title", "artist", new Genre("genre"), 1998, 100);

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.eraseData();
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
    public void musicTrackUpdateTest(){ //does not work when run with other tests
        musicTrackDao = new FactoryGenericImpl(MusicTrack.class);
        musicTrackDao.create(musictrack);
        musictrack.setArtist("mermigkas");
        musicTrackDao.update(musictrack);
        List<MusicTrack> tracks = musicTrackDao.getAll();
        Assert.assertEquals("mermigkas", tracks.get(0).getArtist());

    }

}
