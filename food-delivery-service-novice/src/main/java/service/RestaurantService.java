package service;

import controllers.IRestaurant;
import datastore.FoodMenuDataStore;
import datastore.RestaurantDatastore;
import datastore.RestaurantToFoodMenuDatastore;
import models.MenuItem;
import models.Restaurant;

public class RestaurantService implements IRestaurant {

    private final RestaurantDatastore           restaurantDatastore;
    private final FoodMenuDataStore             foodMenuDataStore;
    private final RestaurantToFoodMenuDatastore restaurantToFoodMenuDatastore;

    public RestaurantService(RestaurantDatastore restaurantDatastore,
                             FoodMenuDataStore foodMenuDataStore,
                             RestaurantToFoodMenuDatastore restaurantToFoodMenuDatastore) {

        this.restaurantDatastore = restaurantDatastore;
        this.foodMenuDataStore = foodMenuDataStore;
        this.restaurantToFoodMenuDatastore = restaurantToFoodMenuDatastore;
    }

    @Override
    public String register(Restaurant restaurant) {
        return restaurantDatastore.add(restaurant);
    }

    @Override
    public String addMenuItem(String restaurantId, MenuItem menuItem) {
        String menuItemId = foodMenuDataStore.add(menuItem);
        return restaurantToFoodMenuDatastore.add(restaurantId, menuItemId);
    }

    @Override
    public String updateMenuItem(String restaurantId, MenuItem menuItem) {
        return foodMenuDataStore.update(menuItem);
    }

    @Override
    public String deleteMenuItem(String menuItemId) {
        foodMenuDataStore.delete(menuItemId);
        return restaurantToFoodMenuDatastore.remove(menuItemId);
    }
}
