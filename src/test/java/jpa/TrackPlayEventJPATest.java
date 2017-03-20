package jpa;

import com.radio.Controllers.StatisticsController;
import com.radio.Factories.FactoryGeneric;
import com.radio.Factories.FactoryGenericImpl;
import com.radio.Initializer;
import com.radio.Models.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

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
    PlaylistShow plShow1;
    PlaylistShow plShow2;

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

        event = new TrackPlayEvent(Calendar.getInstance().getTimeInMillis()-1000000);
        event2 = new TrackPlayEvent(date2.getTimeInMillis());

        adTrack2 = new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20,event);
        adTrack3 = new AdTrack("survivor", playBackZone, fromCalendar, toCalendar, 5, 20,event2);

        plShow1 = new PlaylistShow("playlist1",new Producer(),200,Calendar.getInstance());
        plShow1.addTrackToList(adTrack2);
        plShow2 = new PlaylistShow("playlist2",new Producer(),200,Calendar.getInstance());
        plShow2.addTrackToList(adTrack3);

    }

    @Test
    public void testEvent() {

        showdao = new FactoryGenericImpl(Show.class);
        showdao.create(plShow1);
        showdao.create(plShow2);

        StatisticsController ctrl = new StatisticsController();
        System.out.println(ctrl.getAllAdTracks());
        System.out.println(ctrl.showDailySchedule());

    }

}
