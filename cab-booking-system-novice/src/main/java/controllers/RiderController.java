package controllers;

import datastore.RidersStore;
import datastore.TripsStore;
import models.RiderModel;

public class RiderController {

    private final RidersStore ridersStore;
    private final TripsStore  tripsStore;

    public RiderController(RidersStore ridersStore, TripsStore tripsStore) {
        this.ridersStore = ridersStore;
        this.tripsStore = tripsStore;
    }

    public void register() {
        RiderModel riderModel = new RiderModel("Sowmya");
        ridersStore.register(riderModel);
    }

    public void getData() {
        tripsStore.print();
    }

    public void book() {

    }

    public void getHistory() {

    }
}
