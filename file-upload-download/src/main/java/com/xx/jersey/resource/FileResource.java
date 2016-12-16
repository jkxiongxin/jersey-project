package com.xx.jersey.resource;

import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.activation.MimetypesFileTypeMap;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.InputStream;

/**
 * author: XiongXin
 * description: 文件资源类
 * time: 2016/12/16.
 */
@Path("file")
public class FileResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response postFile(@FormDataParam("file")InputStream file,
                             @NotNull(message = "username不能为空") @FormParam("username")String username,
                             @NotNull(message = "password不能为空") @FormParam("password")String password){

        if(!username.equals("熊鑫")){
            return Response.status(Response.Status.BAD_REQUEST).tag("用户名不正确").build();
        }
        if(!password.equals("password")){
            return Response.status(Response.Status.BAD_REQUEST).tag("密码不正确").build();
        }

        /**
         * 执行上传文件方法
         */

        return Response.ok("上传文件成功").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(){
        File file = new File("d:/1.txt");
        String type = new MimetypesFileTypeMap().getContentType(file);

        return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-type", "attachment;filename=1.txt")
                .build();
    }

}
