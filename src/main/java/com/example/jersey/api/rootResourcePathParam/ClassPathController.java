package com.example.jersey.api.rootResourcePathParam;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/classPath/{msg}")
@Component
public class ClassPathController {

    @GET
    public String printMsg(@PathParam("msg") String msg){
        return "패스 메세지: "+msg;
    }
}
