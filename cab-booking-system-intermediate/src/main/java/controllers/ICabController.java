package controllers;

import java.util.UUID;

import models.Coordinates;
import models.cab_builder.Cab;

public interface ICabController {

    UUID registerCab(Cab cab) throws Exception;

    void echoLocation(UUID cabUUID, Coordinates coordinates);

    boolean toggleAvailability(boolean availability);
}
