package datastore;

public class DataStore {

    private final RestaurantDatastore restaurantDatastore;
    private final UserDatastore       userDatastore;

    public DataStore() {
        restaurantDatastore = new RestaurantDatastore();
        userDatastore = new UserDatastore();
    }


}
