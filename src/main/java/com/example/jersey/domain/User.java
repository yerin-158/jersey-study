package com.example.jersey.domain;

import javax.ws.rs.*;

public class User {

    @PathParam("id")
    private long id;

    @MatrixParam("name")
    private String name;

    @QueryParam("age")
    @DefaultValue("20")
    private int age;

    @HeaderParam("Content-Type")
    private String contentType;

    public String toString(){
        return "id : "+id+"\nname : "+name+"\nage : "+age+"\nContent-type : "+contentType;
    }
}
