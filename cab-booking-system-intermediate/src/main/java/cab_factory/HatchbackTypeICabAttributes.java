package cab_factory;

public class HatchbackTypeICabAttributes implements ICabAttributes {
    @Override
    public int ratePerMile() {
        return 10;
    }

    @Override
    public int distancePerMin() {
        return 4;
    }
}
