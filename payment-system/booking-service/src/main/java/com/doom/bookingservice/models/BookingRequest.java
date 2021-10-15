package com.doom.bookingservice.models;

import lombok.Data;

@Data
public class BookingRequest {
    double amount;
    int    installments;
    String itemId;
    String userId;
    String creditCardId;
}
