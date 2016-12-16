package com.xx.jersey;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * author: XiongXin
 * description: 项目启动类
 * time: 2016/12/16.
 */
public class MyApplication extends ResourceConfig{

    public MyApplication(){
        //设置资源路径
        packages("com.xx.jersey.resource");

        /**
         * 配置bean validation
         */
        //启用返回值中包含错误信息
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        //禁用验证失败检查
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
    }

    /**
     * 项目基础路径
     */
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * 基础路径
     */
    public static final String ROOT_PATH = "application.wadl";

    public static void main(String[] args){

        URI baseUri = UriBuilder.fromUri(BASE_URI).build();

        ResourceConfig resourceConfig = new MyApplication();

        //启动项目
        Server server = JettyHttpContainerFactory.createServer(baseUri, resourceConfig);

        System.out.println(String.format("资源地址请访问 %s%s", BASE_URI, ROOT_PATH));
    }

}
