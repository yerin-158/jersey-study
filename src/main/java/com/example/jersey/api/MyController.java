package com.example.jersey.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/welcome")
@Component
public class MyController {
    @GET
    public String welcome(@QueryParam("user") String user){
        return "Welcome "+user;
    }

    @GET
    @Path("{name}")
    public String callName(@PathParam("name") String name){
        return "Welcome "+name;
    }

    @GET
    @Path("/v2/{name}")
    public String callName2(@PathParam(value = "name") String name){
        return "Welcome "+name+" (v2)";
    }

    @GET
    @Path("v3/{name: ([a-zA-Z])*}")
    public String callName3(@PathParam(value = "name") String name){
        return "Welcome "+name+" (v3)";
    }
}
