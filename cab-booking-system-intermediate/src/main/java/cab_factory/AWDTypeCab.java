package cab_factory;

public class AWDTypeCab implements Cab{
    @Override
    public int ratePerMile() {
        return 20;
    }

    @Override
    public int distancePerMin() {
        return 2;
    }
}
