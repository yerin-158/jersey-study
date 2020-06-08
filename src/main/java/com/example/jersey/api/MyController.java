package com.example.jersey.api;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/Welcome")
@Component
public class MyController {
    @GET
    public String welcome(@QueryParam("user") String user){
        return "Welcome "+user;
    }
}
