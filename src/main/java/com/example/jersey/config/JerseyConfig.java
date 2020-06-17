package com.example.jersey.config;

import com.example.jersey.api.rootResourcePathParam.ClassPathController;
import com.example.jersey.api.params.MyController;
import com.example.jersey.api.params.ParamTestController;
import com.example.jersey.api.subResourceLocator.RootController;
import com.example.jersey.api.subResourceLocator.SubController;
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
        register(RootController.class);
        register(SubController.class);
    }
}
