package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Factories.MusicTrackFactoryImpl;
import com.radio.Models.MusicTrack;
import com.radio.Resources.MusicTrackInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("musicTrackLibrary")
public class ManageLibraryController {

    UriInfo uriInfo;
    FactoryGenericImpl musicTrackFactory = new MusicTrackFactoryImpl();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMusicTrackToLibrary(MusicTrackInfo musicTrackInfo) {

        MusicTrack musicTrack = musicTrackInfo.getMusicTrack();

        musicTrackFactory.create(musicTrack); //todo issue with factory

        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI newMusicTrackUri = ub.path(Integer.toString(musicTrack.getId())).build();

        musicTrackFactory.create(musicTrack);

        return Response.created(newMusicTrackUri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MusicTrackInfo> listAllMusicTracks() {
        List<MusicTrack> musicTracks = musicTrackFactory.getAll();

        List<MusicTrackInfo> musicTrackInfo = MusicTrackInfo.wrap(musicTracks);

        return musicTrackInfo;

    }

    @GET
    @Path("{musicTrackId:[0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public MusicTrackInfo getMusicTrackById(@PathParam("musicTrackId") int trackId) {

        MusicTrack musicTrack = (MusicTrack)musicTrackFactory.get(trackId);

        MusicTrackInfo musicTrackInfo = MusicTrackInfo.wrap(musicTrack);

        return musicTrackInfo;

    }

    @PUT
    @Path("{trackId:[0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("trackId") int trackId) {

        boolean result = musicTrackFactory.update(MusicTrack.class,trackId);

        if (!result) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().build();

    }

    @DELETE
    @Path("{trackId:[0-9]*}")
    public Response deleteTrackById(@PathParam("trackId") int trackId) {

        boolean result = musicTrackFactory.removeById(trackId);

        if (!result) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().build();

    }

}
