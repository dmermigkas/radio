package com.radio.Controllers;

import com.radio.Factories.FactoryGenericImpl;
import com.radio.Models.Producer;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("producer")
public class ProducerResourceController {

    @Context
    UriInfo uriInfo;

    FactoryGenericImpl prodFactory = new FactoryGenericImpl(Producer.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer) {

        try {
            prodFactory.create(producer);

            UriBuilder ub = uriInfo.getAbsolutePathBuilder();
            URI newAdTrackURI = ub.path(Integer.toString(producer.getId())).build();

            prodFactory.create(producer);

            return Response.created(newAdTrackURI).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producer> listAllProducers() {

        //todo check error codes
        List<Producer> producers = prodFactory.getAll();

        return producers;

    }

    @GET
    @Path("{producerId:[0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducerById(@PathParam("producerId") int producerId) {

        //todo check error codes
        Producer producer = (Producer) prodFactory.get(producerId);

        return producer;

    }

    @PUT
    @Path("{producerId:[0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProducer(Producer producer) {

        //todo check error codes
        try {
            prodFactory.update(producer);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @DELETE
    @Path("{producerId:[0-9]*}")
    public Response deleteAdTrack(@PathParam("producerId") int producerId) {

        if (prodFactory.removeById(producerId) == true) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Id " + producerId + " not found").build();
        }

    }
}
