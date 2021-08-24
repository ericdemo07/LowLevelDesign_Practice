package intercepting_filter;

public class FilterChain {

    private Filter chain;

    public void addFilter(Filter filter) {
        if (chain == null) {
            chain = filter;
        }
        else {
            chain.getLast().setNext(filter);
        }
    }

    public StringBuilder execute(Car car) {
        if (chain != null) {
            return chain.execute(car);
        }
        return new StringBuilder("Running...");
    }
}
