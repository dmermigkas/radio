package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.Genre;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * Created by lotv on 19/03/2017.
 */

@Path("genreLibrary")
public class GenreLibraryController {

    @Context
    UriInfo uriInfo;

    FactoryGenericImpl genreFactory = new FactoryGenericImpl(Genre.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGenreToLibrary(Genre genre) {

        //todo check error codes
        try {
            genreFactory.create(genre); //todo issue with factory

            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI genreURI = ub.path(Integer.toString(genre.getId())).build();

            genreFactory.create(genre);

            return Response.created(genreURI).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + " not found").build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Genre> listAllGenre() {

        //todo check error codes
        List<Genre> genres = genreFactory.getAll();

        return genres;

    }

    @GET
    @Path("{genreId:[0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Genre getGenreById(@PathParam("genreId") int genreId) {

        //todo check error codes
        Genre genre = (Genre)genreFactory.get(genreId);

        return genre;

    }

    @PUT
    @Path("{genreId:[0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGenre(@PathParam("genreId") int genreId, Genre genre) {

        //todo check error codes
        try {
            genreFactory.update(genre);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + genre + " not found").build();
        }

    }

    @DELETE
    @Path("{genreId:[0-9]*}")
    public Response deleteGenre(@PathParam("genreId") int genreId) {

        if (genreFactory.removeById(genreId) == true) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + genreId + " not found").build();
        }

    }

}
