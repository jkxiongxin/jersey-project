package com.xx.jersey;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * author: XiongXin
 * description:
 * time: 2016/12/16.
 */
public class MyApplication extends ResourceConfig{

    public MyApplication(){
        //设置资源路径
        packages("com.xx.jersey.resource");
    }

    public static final String BASE_URI = "http://localhost:8082/";

    public static final String ROOT_PATH = "application.wadl";

    public static void main(String[] args){

        URI baseUri = UriBuilder.fromUri(BASE_URI).build();

        ResourceConfig resourceConfig = new MyApplication();

        Server server = JettyHttpContainerFactory.createServer(baseUri, resourceConfig);

        System.out.println(String.format("资源地址请访问 %s%s", BASE_URI, ROOT_PATH));
    }
}
