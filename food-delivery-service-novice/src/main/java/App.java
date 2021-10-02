import constants.FoodItem;
import datastore.FoodMenuDataStore;
import datastore.RestaurantDatastore;
import datastore.RestaurantToFoodMenuDatastore;
import datastore.UserDatastore;
import models.CuisineType;
import models.MenuItem;
import models.Restaurant;
import models.User;
import service.RestaurantService;
import service.UserService;

public class App {

    private final UserDatastore userDatastore;

    private final RestaurantDatastore           restaurantDatastore;
    private final FoodMenuDataStore             foodMenuDataStore;
    private final RestaurantToFoodMenuDatastore restaurantToFoodMenuDatastore;

    private final UserService       userService;
    private final RestaurantService restaurantService;

    public App() {
        this.userDatastore = new UserDatastore();

        this.restaurantDatastore = new RestaurantDatastore();
        this.foodMenuDataStore = new FoodMenuDataStore();
        this.restaurantToFoodMenuDatastore = new RestaurantToFoodMenuDatastore();

        this.userService = new UserService(userDatastore);
        this.restaurantService = new RestaurantService(restaurantDatastore,
                                                       foodMenuDataStore,
                                                       restaurantToFoodMenuDatastore);
    }

    public static void main(String... args) {
        App app = new App();
        app.process();
    }

    private void process() {
        userService.register(new User(null, "Chacha Choudhary", "c@c.com", "Delhi", "Peeche wali gali"));

        String restaurantId = restaurantService.register(new Restaurant(null,
                                                                        "Chacha Choudhary",
                                                                        "Delhi",
                                                                        "Saamne wali gali",
                                                                        CuisineType.AFRICAN_CUISINE));

        restaurantService.addMenuItem(restaurantId,
                                      new MenuItem(null, FoodItem.CHOWMEIN, 12.22, "nice chowmein"));
        restaurantService.addMenuItem(restaurantId,
                                      new MenuItem(null, FoodItem.HOT_AND_SOUR_SOUP, 43.12, "very hot soup"));
    }
}
