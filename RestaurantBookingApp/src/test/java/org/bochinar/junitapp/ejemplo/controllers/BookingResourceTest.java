package org.bochinar.junitapp.ejemplo.controllers;

import org.bochinar.junitapp.ejemplo.beans.Booking;
import org.bochinar.junitapp.ejemplo.beans.BookingResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingResourceTest {

    @Test
    void getBookings() {
        BookingResource resource = new BookingResource();
        resource.book(new Booking("1", "Juan Alvarez", 2, "03-03-2024", "21:00"));
        resource.book(new Booking("2", "Mariana Sanchez", 6, "03-03-2024", "23:00"));
        resource.book(new Booking("3", "Eduardo Diaz", 8, "08-03-2024", "20:00"));
        resource.book(new Booking("4", "Francisco Ruiz", 8, "10/03/2024", "20:00"));   //Date format error
        resource.book(new Booking("5", "Ernesto Reyes", 4, "10-03-2024", "20:00:00")); //Time format error

        List<Booking> bookings =  resource.getBookings();

        assertEquals(3, bookings.size());
        assertTrue(bookings.stream().anyMatch(c -> c.getCustomerName().equals("Juan Alvarez")));
        assertTrue(bookings.stream().anyMatch(c -> c.getCustomerName().equals("Mariana Sanchez")));
        assertTrue(bookings.stream().anyMatch(c -> c.getCustomerName().equals("Eduardo Diaz")));
    }

    @Test
    void book() {
        BookingResource resource = new BookingResource();
        BookingResponse response = resource.book(new Booking("1", "Juan Alvarez", 2, "03-03-2024", "21:00"));
        assertEquals("Juan Alvarez", response.getCustomerName());
        assertEquals("Your reservation is complete", response.getResponse());

        BookingResponse response2 = resource.book(new Booking("1", "Juan Alvarez", 2, "03/03/2024", "21:00"));
        assertEquals("The format for the date is: dd-mm-yyyy", response2.getResponse());

        BookingResponse response3 = resource.book(new Booking("1", "Juan Alvarez", 2, "03-03-2024", "21:00:00"));
        assertEquals("The format for the time is: HH:MM", response3.getResponse());

    }

    @Test
    void getBookingsForDate() {
        BookingResource resource = new BookingResource();
        resource.book(new Booking("1", "Juan Alvarez", 2, "03-03-2024", "21:00"));
        resource.book(new Booking("2", "Mariana Sanchez", 6, "03-03-2024", "23:00"));
        resource.book(new Booking("3", "Eduardo Diaz", 8, "07-03-2024", "20:00"));

        List<Booking> bookings =  resource.getBookingsForDate("03-03-2024");
        assertEquals(2, bookings.size());
        assertTrue(bookings.stream().anyMatch(c -> c.getCustomerName().equals("Juan Alvarez")));
        assertTrue(bookings.stream().anyMatch(c -> c.getCustomerName().equals("Mariana Sanchez")));
        assertFalse(bookings.stream().anyMatch(c -> c.getCustomerName().equals("Eduardo Diaz")));
    }
}