package datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import models.Coordinates;
import models.cab_builder.Cab;
import models.user_step_builder.User;

import static utils.HelperFunctions.distance;

public final class BaseDataStore {

    private static volatile BaseDataStore instance;

    private final Map<UUID, User> userVirtualDb;
    private final Map<UUID, Cab>  cabVirtualDb;
    private final Map<UUID, UUID> cabsToUserBookingsVirtualDb;


    public UUID createUser(User user) {
        userVirtualDb.put(user.getUuid(), user);
        return user.getUuid();
    }

    public UUID createCab(Cab cab) {
        cabVirtualDb.put(cab.getCabUUID(), cab);
        return cab.getCabUUID();
    }

    public void updateCabLocation(UUID cabUUID, Coordinates coordinates) {
        Cab cab = cabVirtualDb.get(cabUUID);

        Cab updatedCab = new Cab.Builder().from(cab).coordinates(coordinates).build();

        cabVirtualDb.put(cab.getCabUUID(), updatedCab);
    }

    public List<UUID> getCabsInRadius(Coordinates coordinates, int radius) {
        List<UUID> listOfCabs = new ArrayList<>();

        for (Map.Entry<UUID, Cab> entry : cabVirtualDb.entrySet()) {
            if (cabsToUserBookingsVirtualDb.keySet().contains(entry.getKey())) {
                continue;
            }

            if (distance(coordinates, entry.getValue().getCoordinates()) < radius) {
                listOfCabs.add(entry.getKey());
            }
        }

        return listOfCabs;
    }

    public boolean blockCabForUser(UUID cabUUID, UUID userUUID) {
        cabsToUserBookingsVirtualDb.put(cabUUID, userUUID);
        return true;
    }

    public void print() {
        System.out.println("\nuserDB :" + userVirtualDb);
        System.out.println("\ncabDB :" + cabVirtualDb);
        System.out.println("\nmappingDB :" + cabsToUserBookingsVirtualDb);
    }

    private BaseDataStore() {
        // Protect against instantiation via reflection
        if (instance == null) {
            instance = this;
            userVirtualDb = new ConcurrentHashMap<>();
            cabVirtualDb = new ConcurrentHashMap<>();
            cabsToUserBookingsVirtualDb = new ConcurrentHashMap<>();
        }
        else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * The instance doesn't get created until the method is called for the first time.
     */
    public static synchronized BaseDataStore getInstance() {
        if (instance == null) {
            synchronized (BaseDataStore.class) {
                if (instance == null) {
                    instance = new BaseDataStore();
                }
            }
        }
        return instance;
    }
}
