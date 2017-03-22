package jpa;

import com.radio.Controllers.PoliciesController;
import com.radio.Controllers.StatisticsController;
import com.radio.Factories.*;
import com.radio.Initializer;
import com.radio.Models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.*;

public class PoliciesJPATest {

    Initializer dataHelper;
    FactoryGeneric adtrackdao;
    FactoryGeneric showdao;
    ShowFactory showFactory;
    TrackFactory trackFactory;
    AdTrack adTrack2;
    AdTrack adTrack21;
    AdTrack adTrack22;
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

        musicTrack = new MusicTrack("title", "artist", new Genre("genre"), 1998, 100,event3,new Policies(1,4));

        adTrack2 = new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20,event,new Policies(1,3));
        adTrack21 = new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20,event,new Policies(1,3));
        adTrack22 = new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20,event,new Policies(1,3));


        adTrack3 = new AdTrack("survivor", playBackZone, fromCalendar, toCalendar, 5, 20,event2,new Policies(1,5));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        Calendar cal2 = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);

        plShow1 = new PlaylistShow("playlist1",new Producer(),200,cal.getTimeInMillis());
        plShow2 = new PlaylistShow("playlist2",new Producer(),200,cal2.getTimeInMillis());

        plShow1.addTrackToList(adTrack2);
        plShow1.addTrackToList(adTrack21);
        plShow1.addTrackToList(adTrack22);
        plShow1.addTrackToList(musicTrack);
       // plShow2.addTrackToList(adTrack21);
        plShow2.addTrackToList(adTrack3);

    }

    @Test
    public void getAdTracksBetweenDates() {

        System.out.println(plShow1.getTracks());
        showdao = new FactoryGenericImpl(Show.class);
        showdao.create(plShow1);
        showdao.create(plShow2);

        showFactory = new ShowFactoryImpl();

        trackFactory = new TrackFactoryImpl();

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.DATE, -11);

        StatisticsController ctrl = new StatisticsController();

        List<Show> allShows = ctrl.getShowsByDate(from.getTimeInMillis(),to.getTimeInMillis());

        PoliciesController polCtrl = new PoliciesController();

        Map hm = polCtrl.getUniqueAdTracks(allShows);

        Set set = hm.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry m = (Map.Entry)i.next();
            Assert.assertEquals(true,ctrl.satisfiesPolicies((int)m.getValue(),(AdTrack) m.getKey()));
        }

    }

}
