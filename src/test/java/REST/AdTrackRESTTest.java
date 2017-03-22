package com.radio.REST;

import REST.RESTTest;
import com.radio.Controllers.AdTrackLibraryController;
import com.radio.Models.AdTrack;
import com.radio.Models.PlayBackZone;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;

/**
 * Created by lotv on 22/03/2017.
 */
public class AdTrackRESTTest extends RESTTest {

    protected Application configure() { //todo does not know DebugExceptionMapper
        return new ResourceConfig(AdTrackLibraryController.class);
    }

    AdTrack adTrack1;
    AdTrack adTrack2;
    Calendar fromCalendar;
    Calendar toCalendar;
    Calendar fromZone;
    Calendar toZone;
    PlayBackZone playBackZone;

    @Before
    public void setUpData() {
        fromCalendar = Calendar.getInstance();
        toCalendar = fromCalendar;
        toCalendar.add(Calendar.DATE, 2);
        fromZone = fromCalendar;
        fromZone.add(Calendar.HOUR, 1);
        toZone = fromCalendar;
        toZone.add(Calendar.HOUR, 2);
        playBackZone = new PlayBackZone(fromZone, toZone);
        adTrack1= new AdTrack("jumbo", playBackZone, fromCalendar, toCalendar, 5, 20);
        adTrack2 = super.createAdTrack(adTrack1);
    }


    @Test
    public void testListAllAdTracks() {
        String response = target("adTracksLibrary").request().get(String.class);
        Assert.assertTrue(response.contains("jumbo"));
    }

    @Test
    public void testGetAdTrackById() {
        String response = target("adTracksLibrary/"+ adTrack1.getId()).request().get(String.class);
        Assert.assertTrue(response.contains("jumbo"));
    }

    @Test
    public void testAddAdTrackToLibrary() {

        AdTrack adTrack = new AdTrack("cosmote", playBackZone, fromCalendar, toCalendar, 5, 20);
        Response response = target("adTracksLibrary").request().post(Entity.json(adTrack));
        String allGenres = target("adTracksLibrary").request().get(String.class);
        Assert.assertTrue(allGenres.contains("cosmote"));
    }

    @Test
    public void testDeleteAdTrackById() {
        Response response = target("adTracksLibrary/"+ adTrack2.getId()).request().delete();
        String allGenres = target("adTracksLibrary").request().get(String.class);
        Assert.assertFalse(allGenres.contains("jumbo"));
    }

    @Test
    public void testUpdateAdTracl() {
        adTrack2.setBrand("cosmote");
        Response response = target( "adTracksLibrary/"+ adTrack2.getId()).request().put(Entity.entity(adTrack2, MediaType.APPLICATION_JSON)); //todo I need to make sure the id is correct in the path
        String allGenres = target("adTracksLibrary").request().get(String.class);
        Assert.assertTrue(allGenres.contains("cosmote"));

    }
}
