package jpa;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

public class PlayListShowJPATest {
    Initializer dataHelper;
    FactoryGeneric playListShowDao;
    PlaylistShow playlistShow;
    Calendar playDateTime;
    Producer producer;

    @Before
    public void setUpJPA(){
        dataHelper = new Initializer();
        dataHelper.eraseData();
        playDateTime = Calendar.getInstance();
        producer = new Producer("firstName", "lastName", new EmailAddress("testing@email.org"));
        playlistShow = new PlaylistShow("playListShow",producer,3600, playDateTime);
    }

    @Test
    public void testShow() {

        MusicTrack musictrack = new MusicTrack("dsdas", "dsadsa", new Genre("rock"), 1998, 2000);

        playlistShow.addTrackToList(musictrack);

        playListShowDao = new FactoryGenericImpl(PlaylistShow.class);

        playListShowDao.create(playlistShow);

        PlaylistShow play2 = (PlaylistShow) playListShowDao.getAll().get(0);
        Assert.assertEquals(1, play2.getTracks().size());

        playlistShow.removeTrackFromList(musictrack);

        Assert.assertEquals(0, playlistShow.getTracks().size());

        playListShowDao = new FactoryGenericImpl(PlaylistShow.class);

        playListShowDao.update(playlistShow);

        PlaylistShow play = (PlaylistShow) playListShowDao.getAll().get(0);
        Assert.assertEquals(0, play.getTracks().size() );

    }

}
