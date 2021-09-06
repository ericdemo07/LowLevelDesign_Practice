import controllers.CabController;
import controllers.RiderController;
import datastore.CabsStore;
import datastore.RidersStore;
import datastore.TripsStore;
import com.doom.geoservice.models.CabModel;

public class App {

    private final CabController   cabController;
    private final RiderController riderController;

    private final CabsStore   cabsStore;
    private final RidersStore ridersStore;

    private final TripsStore tripsStore;

    public App() {
        this.cabsStore = new CabsStore();
        this.ridersStore = new RidersStore();

        this.tripsStore = new TripsStore(cabsStore, ridersStore);

        this.cabController = new CabController(cabsStore);
        this.riderController = new RiderController(ridersStore, tripsStore);
    }

    public static void main(String... args) {
        App app = new App();
        app.process();
    }

    private void process() {
        CabModel cabModel = new CabModel("KA-23-AA");
        cabController.register(cabModel);

        cabModel = new CabModel("KA-13-BB");
        cabController.register(cabModel);

        riderController.getData();

        cabController.print();
    }
}
