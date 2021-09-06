package controllers;

import java.util.UUID;

import datastore.CabsStore;
import com.doom.geoservice.models.CabModel;
import com.doom.geoservice.models.CoordinateModel;

public class CabController {

    private final CabsStore cabsStore;

    public CabController(CabsStore cabsStore) {
        this.cabsStore = cabsStore;
    }

    public void register(CabModel cabModel) {
        cabsStore.register(cabModel);
    }

    public void updateLocation(UUID id, CoordinateModel coordinates) {

    }

    public void toggleAvailability() {

    }

    public void print(){
        System.out.println(cabsStore.getCabs());
    }

    public void endTrip() {

    }
}
