package REST;

import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;
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


}
