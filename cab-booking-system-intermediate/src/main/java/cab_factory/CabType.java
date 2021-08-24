package cab_factory;

import java.util.function.Supplier;

public enum CabType {
    AWD(AWDTypeCab::new),
    SEDAN(SedanTypeCab::new),
    HATCHBACK(HatchbackTypeCab::new);

    private final Supplier<Cab> constructor;

    private CabType(Supplier<Cab> constructor) {
        this.constructor = constructor;
    }

    public Supplier<Cab> getConstructor() {
        return constructor;
    }
}
