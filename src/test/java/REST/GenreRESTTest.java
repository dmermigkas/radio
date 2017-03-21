package REST;

import com.radio.Controllers.GenreLibraryController;
import com.radio.Models.Genre;
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
        genre1 = new Genre("rock");
        genre2 = super.createGenre(genre1);
    }


    @Test
    public void testListAllGenres() {
        String response = target("genreLibrary").request().get(String.class);
        Assert.assertEquals("[{\"genre\":\"rock\"}]", response);
    }

    @Test
    public void testGetGenreById() {
        String response = target("genreLibrary/"+genre1.getId()).request().get(String.class);
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
        Response response = target("genreLibrary/"+genre2.getId()).request().delete();
        String allGenres = target("genreLibrary").request().get(String.class);
        Assert.assertFalse(allGenres.contains("genre"));
    }

    @Test
    public void testUpdateGenre() {//todo does not want to run
        genre2.setGenre("death metal");
        Response response = target( "genreLibrary/"+genre2.getId()).request().put(Entity.entity(genre2, MediaType.APPLICATION_JSON)); //todo I need to make sure the id is correct in the path
        String allGenres = target("genreLibrary").request().get(String.class);
        Assert.assertTrue(allGenres.contains("death metal"));

    }

}
