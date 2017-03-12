package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.MusicTrack;
import com.radio.Resources.MusicTrackInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by lotv on 11/03/2017.
 */

@Path("musicTrackLibrary")
public class ManageLibraryController {


    UriInfo uriInfo;
    FactoryGenericImpl musicTrackFactory = new FactoryGenericImpl(MusicTrack.class);

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


}
