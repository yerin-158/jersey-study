package com.example.jersey.api.params;

import com.example.jersey.domain.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/params")
@Component
public class ParamTestController {

    @GET
    @Path("{name}")
    public String pathParamTest(@PathParam("name") String name) {
        return "pathParam -> " + name;
    }


    @GET
    @Path("query")
    public String queryParamTest(@QueryParam("name") String name) {
        return "pathParam -> " + name;
    }

    @GET
    @Path("defaultValue")
    public String defaultValueTest(
            @QueryParam("name") String name,
            @DefaultValue("seoul") @QueryParam("address") String address) {
        return "이름 : " + name + ", 주소지 : " + address;
    }

    @GET
    @Path("matrix")
    public String matrixParamTest(
            @MatrixParam("name") String name,
            @MatrixParam("address") String address) {
        return "이름 : " + name + ", 주소지 : " + address;
    }

    @GET
    @Path("header")
    public String headerParamTest(@HeaderParam("Content-Type") MediaType contentType, @HeaderParam("User-Agent") MediaType userAgent) {
        return "Content-Type: " + contentType + ", user-agent: " + userAgent;
    }

    @GET
    @Path("cookies")
    public String cookieParamTest(@CookieParam("sessionId") int sessionId) {
        return "Session id: " + sessionId;
    }

    @POST
    @Path("form")
    public String formParamTest(
            @FormParam("name") String name,
            @FormParam("id") String id) {
        return "name: " + name + ", id: " + id;
    }

    @PUT
    @Path("form")
    public String putMethodTest(@FormParam("name") String name,
                                @FormParam("id") String id) {
        String thisName = "before name";
        String thisId = "before id";

        thisName = name;
        thisId = id;

        return "name: " + thisName + ", id: " + thisId;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMethodTest(@PathParam("id") long id) {
        List<User> users = new ArrayList<>();
        for (long i = 1; i < 10; ++i) {
            User user = User.builder().id(i).name(i + "name" + i).build();
            users.add(user);
        }

        users = users.stream().filter(user -> user.getId() != id).collect(Collectors.toList());

        return Response.ok(users).build();
    }


    @GET
    @Path("bean/{id}")
    public String beanParam(@BeanParam User user) {
        return user.toString();
    }

    @GET
    @Path("multiPath/{name}/{age}")
    public String multiParam(@PathParam("name")String name, @PathParam("age")int age) {
        return "name : "+name+", age : "+age;
    }

}
