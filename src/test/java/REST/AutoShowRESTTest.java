package REST;

import com.radio.Controllers.AutoShowController;
import com.radio.Controllers.AutoShowResourceController;
import com.radio.Controllers.PoliciesController;
import com.radio.Factories.FactoryGeneric;
import com.radio.Initializer;
import com.radio.Models.*;
import com.radio.Resources.AutoShowInfo;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AutoShowRESTTest extends RESTTest{

    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(AutoShowResourceController.class);
    }

    Initializer dataHelper;
    FactoryGeneric producerDao;
    AutoShowController ctrl;
    AutoShow rockShow;
    AutoShow autoShow;
    List mtracks = new ArrayList();
    List atracks = new ArrayList();
    AutoShowInfo jsonbody;

    @Before
    public void setUpData() {

        dataHelper = new Initializer();
        dataHelper.eraseData();

        Producer prod = new Producer("dim", "mer", new EmailAddress("a@a.a"));

        PlayBackZone playBackZone = new PlayBackZone(Calendar.getInstance(), Calendar.getInstance());
        Calendar playDateTime = Calendar.getInstance();

        MusicTrack musictrack = new MusicTrack("dsdas", "dsadsa", new Genre("rock"), 1998, 200);

        MusicTrack musictrack2 = new MusicTrack("tidsdastle", "dsads", new Genre("rock"), 1998, 200);

        MusicTrack musictrack3 = new MusicTrack("titldsdsae", "adsadsartist", new Genre("pop"), 1998, 100);

        AdTrack adTrack = new AdTrack("titldsdsae", playBackZone, Calendar.getInstance(),Calendar.getInstance(), 1998, 200);

        autoShow = new AutoShow("testAutoShow", prod, 3600, new Genre("rock"), playDateTime.getTimeInMillis());

        mtracks.add(musictrack);
        mtracks.add(musictrack2);
        mtracks.add(musictrack3);

        atracks.add(adTrack);

        jsonbody = new AutoShowInfo(mtracks,atracks,autoShow);

    }

    @Test
    public void testAutoShow() {

//        String response = target("AutoShowInfo").request().post(Entity.json(jsonbody),String.class);
//        System.out.println(response.toString());

    }

}
