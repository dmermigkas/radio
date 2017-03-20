package REST;

import com.radio.Controllers.GenreLibraryController;
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
public class GenreRESTTest extends RESTTest { //todo needs work


    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(GenreLibraryController.class);
    }

    Genre genre1;
    Genre genre2;

    @Before
    public void setUpData() {
        Initializer dataHelper = new Initializer();
        dataHelper.eraseData();
        genre1 = new Genre("rock");
        genre2 = new Genre( "pop");
        Response response = target("genreLibrary").request().post(Entity.json(genre1));
        response =  target("genreLibrary").request().post(Entity.json(genre2));
    }


    @Test
    public void testListAllGenres() {
        String response = target("genreLibrary").request().get(String.class);
        System.out.println(response);
        Assert.assertEquals("[{\"genre\":\"rock\"},{\"genre\":\"pop\"}]", response);
    }

    @Test
    public void testGetGenreById() {
        String response = target("genreLibrary/"+genre1.getId()).request().get(String.class); //todo what is the id of a valid genre in the database? oeo?
        Assert.assertTrue(response.contains("rock"));
    }

    @Test
    public void testAddGenreToLibrary() {

        Genre genre = new Genre("death metal");
        Response response = target("genreLibrary").request().post(Entity.json(genre));
        String allGenres = target("genreLibrary").request().get(String.class);
        Assert.assertTrue(allGenres.contains("death metal"));
    }

    @Test
    public void testDeleteGenreById() {
        Response response = target("genreLibrary/9").request().delete(); ////todo what is the id of a valid genre in the database? oeo?
        String allTracks = target("genreLibrary").request().get(String.class);
        Assert.assertFalse(allTracks.contains("genre"));
    }

    @Test
    public void testUpdateGenre() {
        Genre genre = new Genre("death metal");
        Response response = target( "genreLibrary/9").request().put(Entity.entity(genre, MediaType.APPLICATION_JSON)); //todo I need to make sure the id is correct in the path
        String allTracks = target("genreLibrary").request().get(String.class);
        Assert.assertFalse(allTracks.contains("death metal"));

    }

}
