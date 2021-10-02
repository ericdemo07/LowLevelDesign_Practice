package controllers;

import models.MenuItem;
import models.Restaurant;

public interface IRestaurant {

    String register(Restaurant restaurant);

    String addMenuItem(String restaurantId, MenuItem menuItem);

    String updateMenuItem(String restaurantId, MenuItem menuItem);

    String deleteMenuItem(String menuItemId);
}
