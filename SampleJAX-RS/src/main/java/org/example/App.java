package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ResourceConfig resourceConfig = new ResourceConfig()
                .packages("org.example.resources")
                .register(JacksonFeature.class);

        ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(resourceConfig));

        Server server= new Server(9000);

        ServletContextHandler context= new ServletContextHandler(server,"/");

        context.addServlet(jerseyServlet,"/*");

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}
