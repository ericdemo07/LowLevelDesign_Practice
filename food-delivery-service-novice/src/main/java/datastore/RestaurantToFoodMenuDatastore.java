package datastore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;

public class RestaurantToFoodMenuDatastore {

    private final List<Pair> pairs;

    public RestaurantToFoodMenuDatastore() {
        pairs = Collections.synchronizedList(new ArrayList<>());
    }

    public String add(String restaurantId, String foodMenuItemId) {
        pairs.add(new Pair(restaurantId, foodMenuItemId));
        System.out.println(pairs);
        return foodMenuItemId;
    }

    public String remove(String foodMenuItemId) {
        pairs.removeIf(pair -> pair.foodMenuId.equals(foodMenuItemId));
        return foodMenuItemId;
    }
}

@AllArgsConstructor
class Pair {
    String restaurantId;
    String foodMenuId;

    @Override
    public String toString() {
        return "Pair{" +
                "restaurantId='" + restaurantId + '\'' +
                ", foodMenuId='" + foodMenuId + '\'' +
                '}';
    }
}
