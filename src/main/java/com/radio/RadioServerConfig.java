package com.radio;
import java.io.IOException;
import java.net.URI;

import com.radio.Utilities.JPAUtil;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RadioServerConfig {

    public static final String BASE_URI = "http://localhost:8080/radio/Controllers/";

    public static HttpServer startServer() {

        // Create resource configuration that scans for JAX-RS
        // resources and providers in gr.aueb.mscis.library.resource package
        final ResourceConfig rc = new ResourceConfig().packages("com.radio.Controllers");

        // Create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

        return server;
    }

    public static void main(String[] args) throws IOException {

        Initializer dataHelper = new Initializer();
        dataHelper.prepareData();

        final HttpServer server = startServer();
        System.out.println(String.format(
                "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
                BASE_URI));
        System.in.read();
        //server.stop();

        //JPAUtil.getEntityManagerFactory().close();

    }

}
