package com.org.carvalho.webstore.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.ApiModel;


@ApiModel(description = "Classe Principal")
@Path("/home")
public class Webstore {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Seja Bem Vindo!";
    }

}
