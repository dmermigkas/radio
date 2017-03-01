package jpa;

import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.AdTrack;
import com.radio.Models.MusicTrack;
import com.radio.Models.PlayBackZone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

/**
 * Created by agk on 28/02/2017.
 */
public class AdTrackJPATest {

    AdTrack adTrack;
    Calendar fromCalendar;
    Calendar toCalendar;
    Calendar fromZone;
    Calendar toZone;
    PlayBackZone playBackZone;

    Initializer dataHelper;
    FactoryGeneric adtrackdao;


    @Before
    public void setUpJPA(){

        dataHelper = new Initializer();
        dataHelper.eraseData();

        fromCalendar = Calendar.getInstance();
        toCalendar = fromCalendar;
        toCalendar.add(Calendar.DATE, 2);
        fromZone = fromCalendar;
        fromZone.add(Calendar.HOUR, 1);
        toZone = fromCalendar;
        toZone.add(Calendar.HOUR, 2);
        playBackZone = new PlayBackZone(fromZone, toZone);
        adTrack= new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20);


    }

    @Test
    public void adTrackCreateTest(){
        adtrackdao = new FactoryGenericImpl(AdTrack.class);
        adtrackdao.create(adTrack);
        Assert.assertEquals(1, adtrackdao.getAll().size());
    }

    @Test
    public void adTrackRemoveTest(){
        adtrackdao = new FactoryGenericImpl(AdTrack.class);
        adtrackdao.create(adTrack);
        adtrackdao.remove(adTrack);
        Assert.assertEquals(0, adtrackdao.getAll().size());
    }

    @Test
    public void adTrackUpdateTest(){ //does not work when run with other tests
        adtrackdao = new FactoryGenericImpl(AdTrack.class);
        adtrackdao.create(adTrack);
        adTrack.setBrand("mermigkas");
        adtrackdao.update(adTrack);
        List<AdTrack> tracks = adtrackdao.getAll();
        Assert.assertEquals("mermigkas", tracks.get(0).getBrand());

    }
}
