package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Factories.MusicTrackFactoryImpl;
import com.radio.Models.MusicTrack;
import com.radio.Resources.MusicTrackInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * Created by lotv on 11/03/2017.
 */

@Path("musicTrackLibrary")
public class ManageLibraryController {

    @Context
    UriInfo uriInfo;

    FactoryGenericImpl musicTrackFactory = new FactoryGenericImpl(MusicTrack.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMusicTrackToLibrary(MusicTrackInfo musicTrackInfo) {

        //todo check error codes
        MusicTrack musicTrack = musicTrackInfo.getMusicTrack(null);

        musicTrackFactory.create(musicTrack); //todo issue with factory

        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI newMusicTrackUri = ub.path(Integer.toString(musicTrack.getId())).build();

        musicTrackFactory.create(musicTrack);

        return Response.created(newMusicTrackUri).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MusicTrackInfo> listAllMusicTracks() {

        //todo check error codes
        List<MusicTrack> musicTracks = musicTrackFactory.getAll();

        List<MusicTrackInfo> musicTrackInfo = MusicTrackInfo.wrap(musicTracks);

        return musicTrackInfo;

    }

    @GET
    @Path("{musicTrackId:[0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public MusicTrackInfo getMusicTrackById(@PathParam("musicTrackId") int trackId) {

        //todo check error codes
        MusicTrack musicTrack = (MusicTrack) musicTrackFactory.get(trackId);

        MusicTrackInfo musicTrackInfo = MusicTrackInfo.wrap(musicTrack);

        return musicTrackInfo;

    }

    @PUT
    @Path("{trackId:[0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("trackId") int trackId,MusicTrackInfo musicTrackInfo) {

        //todo check error codes
        MusicTrack musicTrack = musicTrackInfo.getMusicTrack(trackId);

        musicTrackFactory.update(musicTrack);

        return Response.ok().build();
    }

    @DELETE
    @Path("{trackId:[0-9]*}")
    public Response deleteBook(@PathParam("trackId") int trackId) {

        //todo check error codes
        musicTrackFactory.removeById(trackId);

        return Response.ok().build();

    }


}
