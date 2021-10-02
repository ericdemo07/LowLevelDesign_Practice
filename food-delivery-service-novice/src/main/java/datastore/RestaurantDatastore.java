package datastore;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import models.CuisineType;

public class RestaurantDatastore implements ICRUDOperations<models.Restaurant> {
    private final List<Restaurant> restaurants;

    public RestaurantDatastore() {
        restaurants = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public String add(models.Restaurant item) {
        final String id = UUID.randomUUID().toString();

        Restaurant restaurant1 = Restaurant.builder()
                                           .id(id)
                                           .name(item.getName())
                                           .address(item.getAddress())
                                           .city(item.getCity())
                                           .cuisineType(item.getCuisineType())
                                           .updatedAt(OffsetDateTime.now())
                                           .createdAt(OffsetDateTime.now())
                                           .build();

        restaurants.add(restaurant1);
        System.out.println(restaurants);
        return id;
    }

    @Override
    public models.Restaurant get(String id) {
        return null;
    }

    @Override
    public String update(models.Restaurant item) {
        final String id = item.getId();
        int i;

        for (i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).id.equals(id)) {
                break;
            }
        }

        Restaurant restaurant1 = Restaurant.builder()
                                           .id(id)
                                           .name(item.getName())
                                           .address(item.getAddress())
                                           .city(item.getCity())
                                           .cuisineType(item.getCuisineType())
                                           .updatedAt(OffsetDateTime.now())
                                           .createdAt(OffsetDateTime.now())
                                           .build();

        restaurants.set(i, restaurant1);

        return id;
    }

    @Override
    public String delete(String id) {
        restaurants.removeIf(restaurant -> restaurant.id.equals(id));
        return id;
    }
}

@Builder
class Restaurant {
    String         id;
    String         name;
    String         address;
    String         city;
    CuisineType    cuisineType;
    OffsetDateTime createdAt;
    OffsetDateTime updatedAt;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", cuisineType=" + cuisineType +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
