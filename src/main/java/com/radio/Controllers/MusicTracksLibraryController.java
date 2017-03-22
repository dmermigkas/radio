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
public class MusicTracksLibraryController {

    @Context
    UriInfo uriInfo;

    FactoryGenericImpl musicTrackFactory = new FactoryGenericImpl(MusicTrack.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMusicTrackToLibrary(MusicTrackInfo musicTrackInfo) {

        //todo check error codes
        try {
            MusicTrack musicTrack = musicTrackInfo.getMusicTrack(null);
            musicTrackFactory.create(musicTrack);

            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI newMusicTrackUri = ub.path(Integer.toString(musicTrack.getId())).build();

            musicTrackFactory.create(musicTrack);

            return Response.created(newMusicTrackUri).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + " not found").build();
        }

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
    public Response updateMusicTrack(@PathParam("trackId") int trackId, MusicTrackInfo musicTrackInfo) {

        //todo check error codes
        try {
            MusicTrack musicTrack = musicTrackInfo.getMusicTrack(trackId);
            musicTrackFactory.update(musicTrack);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + trackId + " not found").build();
        }

    }

    @DELETE
    @Path("{trackId:[0-9]*}")
    public Response deleteMusicTrack(@PathParam("trackId") int trackId) {

        if (musicTrackFactory.removeById(trackId) == true) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + trackId + " not found").build();
        }

    }

}