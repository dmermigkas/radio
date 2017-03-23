package com.radio.Controllers;

import com.radio.Models.AdTrack;
import com.radio.Models.AutoShow;
import com.radio.Models.MusicTrack;
import com.radio.Resources.AutoShowInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("AutoShowInfo")
public class AutoShowResourceController {

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAutoShow(List<AutoShowInfo> jsonbody) {
        System.out.println("fffffffffffff "+jsonbody);
//        List<MusicTrack> mtracks = (List<MusicTrack>) jsonbody.get(0);
//        List<AdTrack> atracks = (List<AdTrack>) jsonbody.get(1);
//        AutoShow autoShow = (AutoShow) jsonbody.get(2);

//        try {
//
//            AutoShowController ctrl = new AutoShowController();
//
//
//
//            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
//            URI newAdTrackURI = ub.path(Integer.toString(autoShow.getShowId())).build();
//
//            ctrl.fillAutoshow(mtracks,atracks,autoShow);
//
//            return Response.created(newAdTrackURI).build();
//
//        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + " not found").build();
//        }

    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<AutoShow> getAllShows() {
//
//        return null;
//
//    }

}
