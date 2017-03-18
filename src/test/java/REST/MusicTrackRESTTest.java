package REST;

import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;
import com.radio.Resources.MusicTrackInfo;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lotv on 12/03/2017.
 */
public class MusicTrackRESTTest {

    MusicTrack musictrack;

    @Before
    public void MusicTrackSetup(){
        musictrack = new MusicTrack("musictitle", "musicartist", new Genre("musicgenre"), 1999, 100);

    }


    @Test
    public void testListBookById() {

        // get all books
        List<MusicTrackInfo> books = target(BOOKS).request().get(new GenericType<List<BookInfo>>() {
        });

        String firstBookId = Integer.toString(books.get(0).getId());

        BookInfo book = target(bookIdUri(firstBookId)).request().get(BookInfo.class);
        Assert.assertNotNull(book);
        Assert.assertEquals("The Unified Modeling Language User Guide", book.getTitle());
    }

}
