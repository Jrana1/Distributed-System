package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
        static final String BASE_URI = "http://localhost:8080";
        public static void main(String[] args) throws Exception {
            HttpServer server = null ;
            ResourceConfig rc = new ResourceConfig(RestService1.class,RestService2.class);
            URI endpoint = new URI(BASE_URI);
            server = GrizzlyHttpServerFactory.createHttpServer(endpoint,rc);
            System.out.println("Press Enter to stop the server. ");
            System.in.read();
            server.shutdownNow();

    }
}