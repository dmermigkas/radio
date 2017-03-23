package REST;

import com.radio.Controllers.MusicTracksLibraryController;
import com.radio.Controllers.PlaylistShowController;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.*;
import com.radio.Resources.PlaylistShowInfo;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.List;

public class PlaylistShowRESTTest extends RESTTest{

    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(PlaylistShowController.class);
    }

    protected static MusicTrack musictrack;
    Initializer dataHelper;
    PlaylistShowInfo playListShowInfo;
    Calendar playDateTime;
    Producer producer;

    @Before
    public void setupPlaylistshowtest(){

        musictrack = new MusicTrack();
        playDateTime = Calendar.getInstance();
        producer = new Producer("firstName", "lastName", new EmailAddress("testing@email.org"));
        playListShowInfo = new PlaylistShowInfo("playListShow",producer,3600, playDateTime.getTimeInMillis());

        //playListShow.addTrackToList(musictrack);

    }

    @Test
    public void testAddTrackToPlaylistShow(){

        //Response response = target("playListShow").request().post(Entity.json(playListShowInfo));
        //System.out.println(response);
        //List<Track> tracks = playlistShow.getTracks();
        //Assert.assertEquals(1, tracks.size());
    }
}
