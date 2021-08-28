package cab_factory;

import java.util.function.Supplier;

public enum CabType {
    AWD(AWDTypeICabAttributes::new),
    SEDAN(SedanTypeICabAttributes::new),
    HATCHBACK(HatchbackTypeICabAttributes::new);

    private final Supplier<ICabAttributes> constructor;

    private CabType(Supplier<ICabAttributes> constructor) {
        this.constructor = constructor;
    }

    public Supplier<ICabAttributes> getConstructor() {
        return constructor;
    }
}
