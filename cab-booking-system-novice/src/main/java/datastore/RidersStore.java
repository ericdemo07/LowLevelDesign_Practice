package datastore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.doom.geoservice.models.RiderModel;

public class RidersStore {

    private final Map<UUID, RiderModel> riders = new HashMap<>();

    public UUID register(RiderModel riderModel) {
        UUID uuid = UUID.randomUUID();

        RiderModel riderModel1 = new RiderModel(uuid, riderModel.getName());

        riders.put(uuid, riderModel1);

        return uuid;
    }
}
