package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.AdTrack;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * Created by lotv on 22/03/2017.
 */

@Path("adTracksLibrary")
public class AdTrackLibraryController {

    @Context
    UriInfo uriInfo;

    FactoryGenericImpl adTrackFactory = new FactoryGenericImpl(AdTrack.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAdTrackToLibrary(AdTrack adTrack) {

        //todo check error codes
        try {
            adTrackFactory.create(adTrack);

            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI newAdTrackURI = ub.path(Integer.toString(adTrack.getId())).build();

            adTrackFactory.create(adTrack);

            return Response.created(newAdTrackURI).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + " not found").build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdTrack> listAllAdTracks() {

        //todo check error codes
        List<AdTrack> adTracks = adTrackFactory.getAll();

        return adTracks;

    }

    @GET
    @Path("{adTrackId:[0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public AdTrack getAdTrackById(@PathParam("adTrackId") int trackId) {

        //todo check error codes
        AdTrack adTrack = (AdTrack) adTrackFactory.get(trackId);

        return adTrack;

    }

    @PUT
    @Path("{trackId:[0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAdTrack(@PathParam("trackId") int trackId, AdTrack adTrack) {

        //todo check error codes
        try {
            adTrackFactory.update(adTrack);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + trackId + " not found").build();
        }

    }

    @DELETE
    @Path("{trackId:[0-9]*}")
    public Response deleteAdTrack(@PathParam("trackId") int trackId) {

        if (adTrackFactory.removeById(trackId) == true) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + trackId + " not found").build();
        }

    }
}
