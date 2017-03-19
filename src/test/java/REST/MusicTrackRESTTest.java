package REST;

import com.radio.Controllers.MusicTrackController;
import com.radio.Controllers.MusicTracksLibraryController;
import com.radio.Initializer;
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
        return new ResourceConfig(MusicTracksLibraryController.class);
    }
    protected static MusicTrack musictrack;
    protected static MusicTrack musictrack2;
    protected static MusicTrack musictrack4;
    Initializer dataHelper;

    @Before
    public void setUpData() {

        musictrack = new MusicTrack("musictitle1", "musicartist", new Genre("musicgenre"), 1999, 100);
        musictrack4 = super.createMusicTrack(musictrack);
        System.out.println(musictrack4.getId() +"  uuuuuuuuu");

    }

    @Test
    public void testListAllMusicTracks() {
        String response = target("musicTrackLibrary").request().get(String.class);
        Assert.assertEquals("[{\"artist\":\"musicartist\",\"duration\":100,\"genre\":\"musicgenre\",\"id\":1,\"releaseYear\":1999,\"title\":\"musictitle1\"}]", response);
    }

    @Test
    public void testGetMusicTrackById() { //todo runs on its own not with others....

        String response = target("musicTrackLibrary/"+musictrack4.getId()).request().get(String.class);
        Assert.assertTrue(response.contains("musictitle1"));

    }

    @Test
    public void testAddMusicTrackToLibrary() {

        musictrack2 = new MusicTrack("dance of death", "musicartist2", new Genre("musicgenre"), 1999, 100);
        Response response = target("musicTrackLibrary").request().post(Entity.json(musictrack2));
        String allTracks = target("musicTrackLibrary").request().get(String.class);
        System.out.println(allTracks + " yyyyyyyyyyyyyyyyyyyyyyyyy");
        Assert.assertTrue(allTracks.contains("dance"));
    }

    @Test
    public void testDeleteTrackById() { //todo runs on its own not with others....
        Response response = target("musicTrackLibrary/"+musictrack4.getId()).request().delete();
        String allTracks = target("musicTrackLibrary").request().get(String.class);
        Assert.assertFalse(allTracks.contains("musictitle1"));
    }

    @Test
    public void testUpdateTrack() {
        musictrack4 = new MusicTrack("musictitle3", "rrrrrrrrrr", new Genre("musicgenre"), 1999, 100);
        MusicTrackInfo musicTrackInfo = new MusicTrackInfo(musictrack4);
        Response response = target( "musicTrackLibrary/"+musictrack4.getId()).request().put(Entity.entity(musictrack4, MediaType.APPLICATION_JSON));
        String allTracks = target("musicTrackLibrary").request().get(String.class);
        Assert.assertFalse(allTracks.contains("rrrrr"));

    }

}
