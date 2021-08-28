import java.util.UUID;

import authentication_interceptor.FilterManager;
import controllers.BookingController;
import controllers.CabController;
import controllers.UserController;
import dynamic_rate_strategy.NormalStrategy;
import dynamic_rate_strategy.RateSelector;
import models.Coordinates;
import models.cab_builder.Cab;
import models.user_step_builder.User;
import utils.Dummies;

public class App {
    private final FilterManager cabFilterManager;
    private final FilterManager userFilterManager;

    private final CabController     cabController;
    private final UserController    userController;
    private final BookingController bookingController;

    public App() {
        this.cabFilterManager = new FilterManager();
        this.userFilterManager = new FilterManager();

        this.cabController = new CabController(cabFilterManager);
        this.userController = new UserController(userFilterManager);
        this.bookingController = new BookingController();
    }

    public static void main(String... args) {
        App app = new App();

        app.process();
    }

    private void process() {
        try {
            User user1 = Dummies.getDummyUser();
            userController.registerUser(user1);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Cab cab1 = Dummies.getDummyCab();
            cabController.registerCab(cab1);
            userController.print();
            cabController.echoLocation(cab1.getCabUUID(), new Coordinates(3, 5));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int fare = bookingController.book(UUID.fromString("6a2acde3-9253-4bd2-bd49-c3749bf604af"),
                                              new Coordinates(0, 0),
                                              new Coordinates(2, 2));

            System.out.println("\nfare :" + fare);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        userController.print();

    }
}
