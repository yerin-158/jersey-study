package com.example.jersey.domain;

import lombok.Builder;
import lombok.Getter;

import javax.ws.rs.*;

@Getter
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

    @Builder
    public User(long id, String name, int age, String contentType){
        this.id = id;
        this.name = name;
        this.age = age;
        this.contentType = contentType;
    }
}
