package dynamic_rate_strategy;

public class RateSelector {
    private static volatile RateSelector instance;

    private IDynamicRateStrategy dynamicRateStrategy;

    public void changeStrategy(IDynamicRateStrategy strategy) {
        this.dynamicRateStrategy = strategy;
    }

    public int getRate() {
        return this.dynamicRateStrategy.rate();
    }

    private RateSelector() {
        // Protect against instantiation via reflection
        if (instance == null) {
            instance = this;
            this.dynamicRateStrategy = new NormalStrategy();
        }
        else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * The instance doesn't get created until the method is called for the first time.
     */
    public static synchronized RateSelector getInstance() {
        if (instance == null) {
            synchronized (RateSelector.class) {
                if (instance == null) {
                    instance = new RateSelector();
                }
            }
        }
        return instance;
    }
}
