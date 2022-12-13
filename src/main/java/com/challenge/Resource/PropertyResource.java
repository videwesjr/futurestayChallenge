package com.challenge.Resource;

import com.challenge.Resource.Input.AvailablePropertyInput;
import com.challenge.Service.PropertyService;
import io.quarkus.logging.Log;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/property")
public class PropertyResource {
    @Inject
    public PropertyService service;

    @Path("/available")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response availableProperty(@Valid AvailablePropertyInput input) {
        Log.info("Received payload for availableProperty = ".concat(input.toString()));
        return Response.ok(service.searchProperty(input)).build();
    }
}