package com.doom.bookingservice.controllers;

import com.doom.bookingservice.dao.BookingRepository;
import com.doom.bookingservice.dao.models.Bookings;
import com.doom.bookingservice.models.BookingRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
public class BookingController implements IBooking {

    private final BookingRepository bookingRepository;


    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public String book(BookingRequest bookingRequest) {
        bookingRepository.save(mapBookingRequestToBookingModel(bookingRequest));
        System.out.println(bookingRequest);
        return "SUCCESS";
    }

    private Bookings mapBookingRequestToBookingModel(BookingRequest request) {
        Bookings booking = new Bookings();
        booking.setId(UUID.randomUUID().toString());
        booking.setItemId(request.getItemId());
        booking.setUserId(request.getUserId());
        booking.setCreatedAt(OffsetDateTime.now());

        return booking;
    }
}
