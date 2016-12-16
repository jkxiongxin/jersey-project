package com.xx.jersey.resource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * author: XiongXin
 * description: 验证类实例
 * time: 2016/12/16.
 */
@Path("demo")
public class ValidationResource {

    @Path("{name}")
    @GET
    public Response getName(@NotNull @PathParam("name") String name,
                            @NotNull(message = "word不能为空") @QueryParam("word")String word){
        return Response.ok(name).build();
    }
}
