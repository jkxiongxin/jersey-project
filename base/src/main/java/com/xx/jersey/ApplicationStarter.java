package com.xx.jersey;

import com.xx.jersey.resource.HelloWorldResource;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.WadlFeature;
import org.glassfish.jersey.server.wadl.internal.WadlBuilder;
import org.glassfish.jersey.server.wadl.internal.WadlResource;

import javax.annotation.ManagedBean;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/**
 * author: XiongXin
 * description: 项目启动器
 * time: 2016/12/15.
 */
public class ApplicationStarter extends ResourceConfig {

    public ApplicationStarter(){
        register(HelloWorldResource.class);
        register(WadlFeature.class);
    }

    private static final String BASE_URI = "http://localhost:8080/";

    public static final String ROOT_PATH = "application.wadl";

    public static void main(String[] args){

        URI baseUri = UriBuilder.fromUri(BASE_URI).build();

        ResourceConfig resourceConfig = new ApplicationStarter();

        Server server = JettyHttpContainerFactory.createServer(baseUri, resourceConfig);

        System.out.println(String.format("Application started.\nTry out %s%s\nStop the application using CTRL+C",
                BASE_URI, ROOT_PATH));
    }

    /**
     * Create JAX-RS application. The same one is used also in the tests.
     *
     * @return Jersey's resource configuration of the Weld application.
     */
    public static ResourceConfig createJaxRsApp() {
        return ResourceConfig.forApplicationClass(JaxRsApplication.class);
    }

    /**
     * JAX-RS application defined as a CDI bean.
     */
    public static class JaxRsApplication extends Application {

        static final Set<Class<?>> appClasses = new HashSet<Class<?>>();

        static {
            appClasses.add(HelloWorldResource.class);
        }

        @Override
        public Set<Class<?>> getClasses() {
            return appClasses;
        }
    }
}
