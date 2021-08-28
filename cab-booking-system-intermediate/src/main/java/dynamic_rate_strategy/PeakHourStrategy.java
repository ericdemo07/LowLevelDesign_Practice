package dynamic_rate_strategy;

public class PeakHourStrategy implements IDynamicRateStrategy {
    @Override
    public int rate() {
        return 44;
    }
}
