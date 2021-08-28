package cab_factory;

public class AWDTypeICabAttributes implements ICabAttributes {
    @Override
    public int ratePerMile() {
        return 20;
    }

    @Override
    public int distancePerMin() {
        return 2;
    }
}
