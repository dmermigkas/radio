package REST;

import com.radio.Controllers.MusicTracksLibraryController;
import com.radio.Controllers.PlaylistShowController;
import com.radio.Initializer;
import com.radio.Models.MusicTrack;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Application;

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

    @Before
    public void setUp(){
        dataHelper.eraseData();
        musictrack = new MusicTrack();
    }

    @Test
    public void testAddTrackToPlaylistShow(){
        String response = target("musicTrackLibrary").request().get(String.class);
    }
}
