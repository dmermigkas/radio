package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.PlaylistShow;
import com.radio.Models.Track;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("playListShow")
public class PlaylistShowController extends ShowController{

    @Context
    UriInfo uriInfo;

    FactoryGenericImpl f = new FactoryGenericImpl(PlaylistShow.class);

    @POST
    @Path("{showId:[0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTrackToPlaylistShow(@PathParam("showId") int showId, Track track) {
        try {
            PlaylistShow playlistShow = (PlaylistShow) f.get(showId);
            playlistShow.addTrackToList(track);

            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI newPlayListURI = ub.path(Integer.toString(playlistShow.getId())).build();

            return Response.created(newPlayListURI).build();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + showId + " not found").build();
        }
    }

    @POST
    @Path("{showId:[0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTrackFromPlaylistShow(@PathParam("showId") int showId, Track track) {
        try{
            PlaylistShow playlistShow = (PlaylistShow) f.get(showId);
            playlistShow.removeTrackFromList(track);

            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI newPlayListURI = ub.path(Integer.toString(playlistShow.getId())).build();

            return Response.created(newPlayListURI).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + showId + " not found").build();
        }
    }
}
