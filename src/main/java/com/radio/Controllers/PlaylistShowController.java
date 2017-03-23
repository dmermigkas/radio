package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;

import com.radio.Models.MusicTrack;
import com.radio.Models.PlaylistShow;
import com.radio.Resources.PlaylistShowInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("playListShow")
public class PlaylistShowController extends ShowController{

    @Context
    UriInfo uriInfo;

    FactoryGenericImpl f = new FactoryGenericImpl(PlaylistShowInfo.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTrackToPlaylistShow(PlaylistShowInfo pl) {
        System.out.println(pl);
        try {
            PlaylistShow play = pl.getplaylistshow(null);
            f.create(pl);

            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI newPlayListURI = ub.path(Integer.toString(play.getShowId())).build();

            return Response.created(null).build();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("").build();
        }
    }

}
