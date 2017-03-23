package REST;

import com.radio.Controllers.PoliciesController;
import com.radio.Controllers.ProducerResourceController;
import com.radio.Controllers.StatisticsResourceController;
import com.radio.Factories.FactoryGeneric;
import com.radio.Initializer;
import com.radio.Models.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;

public class StatisticsRESTTest extends RESTTest{

    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(StatisticsResourceController.class);
    }
    Initializer dataHelper;
    FactoryGeneric adtrackdao;
    FactoryGeneric showdao;
    AdTrack adTrack2;
    AdTrack adTrack3;
    Calendar fromCalendar;
    Calendar toCalendar;
    Calendar fromZone;
    Calendar toZone;
    PlayBackZone playBackZone;
    TrackPlayEvent event;
    TrackPlayEvent event2;
    TrackPlayEvent event3;
    PlaylistShow plShow1;
    PlaylistShow plShow2;
    MusicTrack musicTrack;

    @Before
    public void setUpdfdData() {

        fromCalendar = Calendar.getInstance();
        toCalendar = fromCalendar;
        toCalendar.add(Calendar.DATE, 2);
        fromZone = fromCalendar;
        fromZone.add(Calendar.HOUR, 1);
        toZone = fromCalendar;
        toZone.add(Calendar.HOUR, 2);
        playBackZone = new PlayBackZone(fromZone, toZone);

        Calendar date2 = Calendar.getInstance();
        date2.add(Calendar.DATE, 2);

        event = new TrackPlayEvent(Calendar.getInstance().getTimeInMillis()-10);
        event2 = new TrackPlayEvent(Calendar.getInstance().getTimeInMillis()-10);
        event3 = new TrackPlayEvent(Calendar.getInstance().getTimeInMillis()-100);

        musicTrack = new MusicTrack("title", "artist", new Genre("genre"), 1998, 100,event3);

        adTrack2 = new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20,event);
        adTrack3 = new AdTrack("survivor", playBackZone, fromCalendar, toCalendar, 5, 20,event2);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -5);
        plShow1 = new PlaylistShow("playlist1",new Producer(),200,cal.getTimeInMillis());
        plShow1.addTrackToList(adTrack2);
        plShow1.addTrackToList(musicTrack);
        plShow2 = new PlaylistShow("playlist2",new Producer(),200,Calendar.getInstance().getTimeInMillis());
        plShow2.addTrackToList(adTrack3);

//        PoliciesController polctrl = new PoliciesController();
//
        super.createShow(plShow1);
        super.createShow(plShow2);

    }

    @Test
    public void testSchedule() {
        //todo!!!
        Response response = target("getDailySchedule").request().get();
        System.out.println(response);

    }

}
