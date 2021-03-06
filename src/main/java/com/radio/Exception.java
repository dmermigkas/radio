package com.radio;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

public class Exception {

    @Provider
    public static class DebugMapper implements ExceptionMapper<Throwable> {
        @Override
        public Response toResponse(Throwable e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
