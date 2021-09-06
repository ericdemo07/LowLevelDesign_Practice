import java.util.UUID;

import authentication_interceptor.FilterManager;
import controllers.BookingController;
import controllers.CabController;
import controllers.IBookingController;
import controllers.ICabController;
import controllers.IUserController;
import controllers.UserController;
import com.doom.geoservice.models.Coordinates;
import com.doom.geoservice.models.cab_builder.Cab;
import com.doom.geoservice.models.user_step_builder.User;
import utils.Dummies;

public class App {
    private final FilterManager cabFilterManager;
    private final FilterManager userFilterManager;

    private final ICabController     cabController;
    private final IUserController    userController;
    private final IBookingController bookingController;

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

        try {
            int fare = bookingController.book(UUID.fromString("6a2acde3-9253-4bd2-bd49-c3749bf604af"),
                                              new Coordinates(0, 0),
                                              new Coordinates(2, 2));

            System.out.println("\nfare :" + fare);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        userController.print();

    }
}
