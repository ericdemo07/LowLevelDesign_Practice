package controllers;

import java.util.UUID;

import com.doom.geoservice.models.Coordinates;
import com.doom.geoservice.models.cab_builder.Cab;

public interface ICabController {

    UUID registerCab(Cab cab) throws Exception;

    void echoLocation(UUID cabUUID, Coordinates coordinates);

    boolean toggleAvailability(boolean availability);
}
