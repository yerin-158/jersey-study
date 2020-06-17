package com.example.jersey.api.subResourceLocator;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;

@Component
public class SubController {

    @GET
    public String subPathTest() {
        return "this is sub controller";
    }
}
