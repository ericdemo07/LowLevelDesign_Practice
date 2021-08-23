package datastore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import models.CabModel;
import models.CoordinateModel;

import static utils.DistanceUtil.distanceInRange;

public class CabsStore {
    private final Map<UUID, CabModel> cabs = new HashMap<>();

    public UUID register(CabModel cabModel) {
        UUID uuid = UUID.randomUUID();

        CabModel cabModel1 = new CabModel(uuid, cabModel.getVehicleNumber());

        cabs.put(uuid, cabModel1);

        return uuid;
    }

    public void updateLocation(UUID id, CoordinateModel coordinateModel) {
        cabs.get(id).setCoordinateModel(coordinateModel);
    }

    public List<CabModel> getNearestCabs(int distance, CoordinateModel coordinateModel) {
        List<CabModel> modelList = new ArrayList<>();

        for (CabModel cabModel : cabs.values()) {
            if (distanceInRange(cabModel.getCoordinateModel(), coordinateModel, distance)) {
                modelList.add(cabModel);
            }
        }

        return modelList;
    }

    public void toggleAvailability(UUID id, boolean isAvailable) {
        cabs.get(id).setIsAvailable(isAvailable);
    }

    public Collection<CabModel> getCabs() {
        return cabs.values();
    }
}
