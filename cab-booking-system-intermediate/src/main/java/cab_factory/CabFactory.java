package cab_factory;

public class CabFactory {

    public static ICabAttributes getCar(CabType type) {
        return type.getConstructor().get();
    }
}
