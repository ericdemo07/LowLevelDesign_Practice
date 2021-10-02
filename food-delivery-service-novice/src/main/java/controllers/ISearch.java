package controllers;

import java.util.List;

import models.Menu;
import models.MenuItem;
import models.Restaurant;

public interface ISearch {

    List<Restaurant> getAllRestaurants(String cityName);

    Restaurant getRestaurant(String restaurantName);

    Menu getMenu(String restaurantName);

    List<MenuItem> getMenuItemByCuisine(String cuisineType);
}
