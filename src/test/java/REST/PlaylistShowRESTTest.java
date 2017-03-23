package REST;

import com.radio.Controllers.MusicTracksLibraryController;
import com.radio.Controllers.PlaylistShowController;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lotv on 23/03/2017.
 */
public class PlaylistShowRESTTest extends RESTTest{

    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(PlaylistShowController.class);
    }

    protected static MusicTrack musictrack;
    protected static MusicTrack musictrack2;
    protected static MusicTrack musictrack4;
    Initializer dataHelper;
    PlaylistShow playlistShow;
    FactoryGenericImpl f;
    Calendar playDateTime;
    Producer producer;

    @Before
    public void setUp(){
        musictrack = new MusicTrack();
        playDateTime = Calendar.getInstance();
        producer = new Producer("firstName", "lastName", new EmailAddress("testing@email.org"));
        playlistShow = new PlaylistShow("playListShow",producer,3600, playDateTime.getTimeInMillis());

        f.create(playlistShow);

    }

    @Test
    public void testAddTrackToPlaylistShow(){
        System.out.println(f.getAll());
        Response response = target("playListShow/"+playlistShow.getId()).request().post(Entity.json(musictrack));
        List<Track> tracks = playlistShow.getTracks();
        Assert.assertEquals(1, tracks.size());
    }
}
