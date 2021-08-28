package controllers;

import java.util.UUID;

import models.Coordinates;
import service.BookingService;

public class BookingController implements IBookingController {

    private final BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    @Override
    public int book(UUID userUUID, Coordinates start, Coordinates end) throws Exception {
        return bookingService.handleBooking(userUUID, start, end);
    }
}
