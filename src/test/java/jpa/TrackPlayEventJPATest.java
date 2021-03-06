package jpa;

import com.radio.Controllers.PoliciesController;
import com.radio.Controllers.StatisticsController;
import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TrackPlayEventJPATest {

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

        Calendar date2 = Calendar.getInstance();
        date2.add(Calendar.DATE, 2);

        event = new TrackPlayEvent(Calendar.getInstance().getTimeInMillis()-10000);
        event2 = new TrackPlayEvent(Calendar.getInstance().getTimeInMillis()-100);
        event3 = new TrackPlayEvent(Calendar.getInstance().getTimeInMillis()-1000);

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

    }

    @Test
    public void testScheduleSize() {

        PoliciesController polctrl = new PoliciesController();

        polctrl.createShows(plShow1);
        polctrl.createShows(plShow2);

        StatisticsController ctrl = new StatisticsController();

        List<Show> plshows = ctrl.showDailySchedule();

        Assert.assertEquals(2,plshows.size());

    }

    @Test
    public void testProgramGaps() {

        PoliciesController polctrl = new PoliciesController();

        polctrl.createShows(plShow1);
        polctrl.createShows(plShow2);

        StatisticsController ctrl = new StatisticsController();

        List<Show> plshows = ctrl.showDailySchedule();
        Calendar date3 = Calendar.getInstance();
        date3.add(Calendar.HOUR, 2);

        Assert.assertTrue(date3.getTimeInMillis()>ctrl.getProgramGaps(plshows));

    }

    @Test
    public void testShowGaps() {

        PoliciesController polctrl = new PoliciesController();
        StatisticsController ctrl = new StatisticsController();
        polctrl.createShows(plShow1);

        Assert.assertTrue(Calendar.getInstance().getTimeInMillis()-10>ctrl.getShowGaps(plShow1));

    }

}
