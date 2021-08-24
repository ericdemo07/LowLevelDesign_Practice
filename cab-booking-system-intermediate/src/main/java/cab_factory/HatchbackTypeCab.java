package cab_factory;

public class HatchbackTypeCab implements Cab{
    @Override
    public int ratePerMile() {
        return 10;
    }

    @Override
    public int distancePerMin() {
        return 4;
    }
}
