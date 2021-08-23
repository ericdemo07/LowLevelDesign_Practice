package datastore;

public class TripsStore {

    private CabsStore cabsStore;
    private RidersStore ridersStore;

    public TripsStore(CabsStore cabsStore, RidersStore ridersStore){
        this.cabsStore = cabsStore;
        this.ridersStore = ridersStore;
    }

    public void print(){
        System.out.println(cabsStore.getCabs());
    }
}
