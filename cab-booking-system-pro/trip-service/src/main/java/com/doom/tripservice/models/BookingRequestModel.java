package com.doom.tripservice.models;

import com.doom.tripservice.constants.CabType;

import lombok.Data;

@Data
public class BookingRequestModel {
    Coordinates startCoordinates;
    Coordinates endCoordinates;
    CabType     cabType;
    String      voucherCode;
}
