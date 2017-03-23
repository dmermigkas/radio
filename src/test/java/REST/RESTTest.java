package REST;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Factories.MusicTrackFactory;
import com.radio.Factories.MusicTrackFactoryImpl;
import com.radio.Initializer;
import com.radio.Models.AdTrack;
import com.radio.Models.Genre;
import com.radio.Models.MusicTrack;

import com.radio.Models.Producer;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainerFactory;

import java.util.List;
import javax.ws.rs.client.WebTarget;

/**
 * Created by lotv on 12/03/2017.
 */
public abstract class RESTTest extends JerseyTest {

    MusicTrack musictrack;

    Initializer dataHelper;

    FactoryGeneric f = new FactoryGenericImpl(MusicTrack.class);

    FactoryGeneric p = new FactoryGenericImpl(Producer.class);

    public RESTTest() {
        super();
    }

    public RESTTest(TestContainerFactory testContainerFactory) {
        super(testContainerFactory);
    }

//    public RESTTest(Application app) { //todo this does not seem to run, the JerseyTest class supposedly has this constructor though: https://jersey.java.net/apidocs/2.8/jersey/org/glassfish/jersey/test/JerseyTest.html
//        super(app);
//     }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        dataHelper = new Initializer();
        dataHelper.eraseData();
        //dataHelper.prepareData();
    }

    public List<MusicTrack> listMusicTracks() {

        MusicTrackFactory musicTrackFactory = new MusicTrackFactoryImpl();

        List<MusicTrack> musicTracks = musicTrackFactory.getAll();

        return musicTracks;
    }

    public List<MusicTrack> findMusicTracksByGenre(Genre genre) {

        MusicTrackFactory musicTrackFactory = new MusicTrackFactoryImpl();
        List<MusicTrack> musicTracks = musicTrackFactory.getByGenre(genre);

        return musicTracks;
    }

    public MusicTrack createMusicTrack(MusicTrack mtrack){

        return (MusicTrack) f.create(mtrack);

    }

    public Producer createProducer(Producer pr){

        return (Producer) p.create(pr);

    }

    public Genre createGenre(Genre genre){

        return (Genre) f.create(genre);
    }

    public AdTrack createAdTrack(AdTrack adTrack){
        return (AdTrack) f.create(adTrack);
    }

}
