package cab_factory;

public class SedanTypeCab implements Cab{
    @Override
    public int ratePerMile() {
        return 15;
    }

    @Override
    public int distancePerMin() {
        return 6;
    }
}
