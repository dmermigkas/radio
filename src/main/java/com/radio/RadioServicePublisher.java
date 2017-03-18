package com.radio;

import com.radio.Initializer;
import com.radio.Utilities.JPAUtil;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Created by lotv on 14/03/2017.
 */
public class RadioServicePublisher {

        // Base URI the Grizzly HTTP server will listen on
        public static final String BASE_URI = "http://localhost:8080/radio/";

        /**
         * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
         * application.
         *
         * @return Grizzly HTTP server.
         */
        public static HttpServer startServer() {

            // Create resource configuration that scans for JAX-RS
            // resources and providers in gr.aueb.mscis.library.resource package
            final ResourceConfig rc = new ResourceConfig().packages("gr.aueb.mscis.library.resource"); //todo not sure gow to change this

            // Create and start a new instance of grizzly http server
            // exposing the Jersey application at BASE_URI
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

            return server;
        }

        /**
         * Main method.
         *
         * @param args
         * @throws IOException
         */
        public static void main(String[] args) throws IOException { //todo this uses JPAUtil, we should use our factories instead?

            Initializer dataHelper = new Initializer();
            dataHelper.prepareData();

            final HttpServer server = startServer();
            System.out.println(String.format(
                    "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
                    BASE_URI));
            System.in.read();
            server.stop(); //todo it says it's deprecated, maybe we should delete line

            JPAUtil.getEntityManagerFactory().close();

        }
}
