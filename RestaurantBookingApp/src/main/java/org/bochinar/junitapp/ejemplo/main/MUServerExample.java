package org.bochinar.junitapp.ejemplo.main;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import io.muserver.*;
import io.muserver.rest.RestHandlerBuilder;
import org.bochinar.junitapp.ejemplo.controllers.BookingResource;


public class MUServerExample {

    public static void main(String[] args) {
        BookingResource bookingResource = new BookingResource();
        MuServer server = MuServerBuilder.httpServer()
                .addHandler(
                        RestHandlerBuilder.restHandler(bookingResource)
                                .addCustomWriter(new JacksonJaxbJsonProvider())
                                .addCustomReader(new JacksonJaxbJsonProvider())
                )
                .start();

        System.out.println("API example: " + server.uri().resolve("/Restaurant/bookings"));
    }

}