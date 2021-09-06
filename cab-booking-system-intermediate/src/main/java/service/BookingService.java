package service;

import java.util.List;
import java.util.UUID;

import datastore.BaseDataStore;
import dynamic_rate_strategy.RateSelector;
import com.doom.geoservice.models.Coordinates;

import static utils.Constants.DEFAULT_RADIUS;
import static utils.HelperFunctions.distance;

public final class BookingService {
    private final BaseDataStore baseDataStore;
    private final RateSelector  rateSelector;

    public BookingService() {
        this.baseDataStore = BaseDataStore.getInstance();
        this.rateSelector = RateSelector.getInstance();
    }

    public int handleBooking(UUID userUUID,
                             Coordinates startCoordinates,
                             Coordinates endCoordinates) throws Exception {

        List<UUID> listOfNearestCabs = getNearestCabs(startCoordinates);

        //any logic to make search better like cab rating etc.

        boolean blocked = baseDataStore.blockCabForUser(listOfNearestCabs.get(0), userUUID);

        int totalTravelDistance = distance(startCoordinates, endCoordinates).intValue();

        return totalTravelDistance * rateSelector.getRate();
    }

    private List<UUID> getNearestCabs(Coordinates coordinates) throws Exception {
        List<UUID> listOfNearestCabs = baseDataStore.getCabsInRadius(coordinates, DEFAULT_RADIUS);

        if (listOfNearestCabs.isEmpty()) {
            throw new Exception("Sorry! no can available");
        }

        return listOfNearestCabs;
    }
}
