package com.example.jersey.config;

import com.example.jersey.api.ClassPathController;
import com.example.jersey.api.MyController;
import com.example.jersey.api.ParamTestController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/MyRestService")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(MyController.class);
        register(ClassPathController.class);
        register(ParamTestController.class);
    }
}
