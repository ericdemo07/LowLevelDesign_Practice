package dynamic_rate_strategy;

public class NormalStrategy implements IDynamicRateStrategy {
    @Override
    public int rate() {
        return 11;
    }
}
