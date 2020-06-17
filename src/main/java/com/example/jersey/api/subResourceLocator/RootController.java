package com.example.jersey.api.subResourceLocator;

import org.springframework.stereotype.Component;

import javax.ws.rs.Path;

@Path("/rootPath")
@Component
public class RootController {

    @Path("/subPath")
    public SubController subResourceLocator() {
        return new SubController();
    }
}
