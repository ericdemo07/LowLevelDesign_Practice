package dynamic_rate_strategy;

public class MidnightStrategy implements IDynamicRateStrategy{
    @Override
    public int rate() {
        return 22;
    }
}
