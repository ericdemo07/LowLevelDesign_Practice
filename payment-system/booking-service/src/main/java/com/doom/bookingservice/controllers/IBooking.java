package com.doom.bookingservice.controllers;

import com.doom.bookingservice.models.BookingRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IBooking {

    @PostMapping("book")
    String book(@RequestBody BookingRequest bookingRequest);
}
