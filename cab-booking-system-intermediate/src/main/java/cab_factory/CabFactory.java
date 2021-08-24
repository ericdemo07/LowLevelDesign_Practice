package cab_factory;

public class CabFactory {

    public static Cab getCar(CabType type) {
        return type.getConstructor().get();
    }
}
