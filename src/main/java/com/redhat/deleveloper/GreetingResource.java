package com.redhat.deleveloper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.qute.Engine;
import io.quarkus.qute.Template;
import io.quarkus.qute.runtime.TemplateProducer;

@Path("/qute")
public class GreetingResource {

    Engine engine = Engine.builder().addDefaults().build();

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response qute(QuteRequest quteRequest) {

        Template helloTemplate = engine.parse(quteRequest.template);

        return Response.ok(helloTemplate.data(quteRequest.data).render()).build();
    }
}