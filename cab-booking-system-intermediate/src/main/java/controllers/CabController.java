package controllers;

import java.util.UUID;

import authentication_interceptor.AdvanceCabFilter;
import authentication_interceptor.BaseCabFilter;
import authentication_interceptor.FilterManager;
import datastore.BaseDataStore;
import com.doom.geoservice.models.Coordinates;
import com.doom.geoservice.models.cab_builder.Cab;

public class CabController implements ICabController {

    private final FilterManager filterManager;
    private final BaseDataStore baseDataStore;

    public CabController(FilterManager filterManager) {
        this.filterManager = filterManager;

        this.filterManager.addFilter(new BaseCabFilter());
        this.filterManager.addFilter(new AdvanceCabFilter());

        baseDataStore = BaseDataStore.getInstance();
    }

    @Override
    public UUID registerCab(Cab cab) throws Exception {
        StringBuilder stringBuilder = filterManager.filterRequest(cab);

        if (stringBuilder.length() != 0) {
            throw new Exception(stringBuilder.toString());
        }
        UUID res = baseDataStore.createCab(cab);
        return res;
    }

    @Override
    public void echoLocation(UUID cabUUID, Coordinates coordinates) {
        baseDataStore.updateCabLocation(cabUUID, coordinates);
    }

    @Override
    public boolean toggleAvailability(boolean availability) {
        return false;
    }
}
