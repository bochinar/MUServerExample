package org.bochinar.junitapp.ejemplo.controllers;

import org.bochinar.junitapp.ejemplo.beans.Booking;
import org.bochinar.junitapp.ejemplo.beans.BookingResponse;
import org.json.JSONObject;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/Restaurant")
public class BookingResource {

    ArrayList<Booking> bookings = new ArrayList<>();

    @GET
    @Path("/bookings")
    @Produces("application/json")
    public List<Booking> getBookings() {

        return bookings;
    }

    @POST
    @Path("/book")
    @Consumes("application/json")
    @Produces("application/json")
    public BookingResponse book(Booking booking) {
        booking.setId(UUID.randomUUID().toString());
        String response = validateBooking(booking);

        return new BookingResponse(booking.getId(), response, booking.getCustomerName(), booking.getTableSize(), booking.getDate(), booking.getTime());
    }

    @POST
    @Path("/book2")
    @Consumes("application/json")
    @Produces("text/plain")
    public String book2() {

        return "OK";
    }

    @GET
    @Path("/bookings/{date}")
    @Produces("application/json")
    public  List<Booking> getBookingsForDate(@PathParam("date") String date) {
        List<Booking> bookingsForDate = new ArrayList<>();
        if(validDate(date)){
            for (Booking booking : bookings) {
                if (booking.getDate().equals(date)) {
                    bookingsForDate.add(booking);
                }
            }
        }
        return bookingsForDate;
    }

    private String validateBooking(Booking booking) {
        String response ;

        if (!validDate(booking.getDate())){
            response = "The format for the date is: dd-mm-yyyy";
        } else if(!validTime(booking.getTime())){
            response = "The format for the time is: HH:MM";
        }else{
            bookings.add(booking);
            response = "Your reservation is complete";
        }
        return response;
    }

    private boolean validDate(String date) {
        return date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})");
    }

    private boolean validTime(String time) {
        return time.matches("^([01]\\d|2[0-3]):?([0-5]\\d)$");
    }

}

