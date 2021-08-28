package cab_factory;

public class SedanTypeICabAttributes implements ICabAttributes {
    @Override
    public int ratePerMile() {
        return 15;
    }

    @Override
    public int distancePerMin() {
        return 6;
    }
}
