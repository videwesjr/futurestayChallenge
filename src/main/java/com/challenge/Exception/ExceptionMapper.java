package com.challenge.Exception;

import com.fasterxml.jackson.core.JsonParseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<JsonParseException> {

    @Override
    public Response toResponse(JsonParseException e) {
        ErrorResponse.ErrorMessage errorMessages = new ErrorResponse.ErrorMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(errorMessages)).build();
    }
}

