package com.example.jersey.api;

import com.example.jersey.domain.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;

@Path("/params")
@Component
public class ParamTestController {

    @GET
    @Path("{name}")
    public String pathParamTest(@PathParam("name") String name){
        return "pathParam -> "+name;
    }

    @GET
    @Path("query")
    public String queryParamTest(@QueryParam("name") String name){
        return "pathParam -> "+name;
    }

    @GET
    @Path("defaultValue")
    public String defaultValueTest(
            @QueryParam("name") String name,
            @DefaultValue("seoul") @QueryParam("address") String address){
        return "이름 : "+name+", 주소지 : "+address;
    }

    @GET
    @Path("matrix")
    public String matrixParamTest(
            @MatrixParam("name") String name,
            @MatrixParam("address") String address){
        return "이름 : "+name+", 주소지 : "+address;
    }

    @GET
    @Path("header")
    public String headerParamTest(@HeaderParam("Content-Type")MediaType contentType, @HeaderParam("User-Agent")MediaType userAgent){
        return "Content-Type: "+contentType+", user-agent: "+userAgent;
    }

    @GET
    @Path("cookies")
    public String cookieParamTest(@CookieParam("sessionId") int sessionId){
        return "Session id: "+sessionId;
    }

    @POST
    @Path("form")
    public String formParamTest(
            @FormParam("name") String name,
            @FormParam("id") String id){
        return "name: "+name+", id: "+id;
    }

    @GET
    @Path("bean/{id}")
    public String beanParam(@BeanParam User user){
        return user.toString();
    }
}
