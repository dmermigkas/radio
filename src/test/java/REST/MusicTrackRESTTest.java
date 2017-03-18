package REST;

import com.radio.Controllers.ManageLibraryController;
import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;
import com.radio.Resources.MusicTrackInfo;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * Created by lotv on 18/03/2017.
 */
public class MusicTrackRESTTest extends RESTTest {


    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(ManageLibraryController.class);
    }


    @Before
    public void setUpData() {
        dataHelper.prepareData();
    }


    @Test
    public void testListAllMusicTracks() {
        String response = target("musicTrackLibrary").request().get(String.class);
        Assert.assertEquals("[{\"artist\":\"musicartist\",\"duration\":100,\"genre\":\"musicgenre\",\"id\":9,\"releaseYear\":1999,\"title\":\"musictitle1\"}]", response);
    }

    @Test
    public void testGetMusicTrackById() { //todo runs on its own not with others....
        String response = target("musicTrackLibrary/9").request().get(String.class);
        System.out.println(response);
        Assert.assertTrue(response.contains("musictitle1"));
    }

    @Test
    public void testAddMusicTrackToLibrary() {

        MusicTrack musictrack = new MusicTrack("musictitle2", "musicartist2", new Genre("musicgenre"), 1999, 100);
        Response response = target("musicTrackLibrary").request().post(Entity.json(musictrack));
        String allTracks = target("musicTrackLibrary").request().get(String.class);
        System.out.println(allTracks);
        Assert.assertTrue(allTracks.contains("musictitle2"));
    }

    @Test
    public void testDeleteTrackById() { //todo runs on its own not with others....
        Response response = target("musicTrackLibrary/9").request().delete();
        String allTracks = target("musicTrackLibrary").request().get(String.class);
        Assert.assertFalse(allTracks.contains("musictitle1"));
    }

    @Test
    public void testUpdateTrack() {
        MusicTrack musictrack = new MusicTrack("musictitle3", "musicartist2", new Genre("musicgenre"), 1999, 100);
        MusicTrackInfo musicTrackInfo = new MusicTrackInfo(musictrack);
        Response response = target( "musicTrackLibrary/9").request().put(Entity.entity(musicTrackInfo, MediaType.APPLICATION_JSON));
        String allTracks = target("musicTrackLibrary").request().get(String.class);
        Assert.assertFalse(allTracks.contains("musictitle2"));

    }

}
