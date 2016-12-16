package com.xx.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * author: XiongXin
 * description: 资源示例
 * time: 2016/12/15.
 */
@Path("users")
public class HelloWorldResource {

    /**
     * 打招呼
     * 限制get请求
     * @param name 姓名
     * @return 招呼内容
     */
    @GET
    @Path("{name}")
    public Response sayHello(@PathParam("name") String name){
        String nameString = "hello," + name;
        return Response.ok(nameString).build();
    }

    @GET
    public Response getUser(){
        return Response.ok("username").build();
    }
}
