package controllers;

import java.util.UUID;

import models.Coordinates;

public interface IBookingController {

    int book(UUID userUUID, Coordinates start, Coordinates end) throws Exception;

}
