package authentication_interceptor;

public class FilterChain<T> {

    private Filter chain;

    public void addFilter(Filter filter) {
        if (chain == null) {
            chain = filter;
        }
        else {
            chain.getLast().setNext(filter);
        }
    }

    public StringBuilder execute(T user) {
        if (chain != null) {
            return chain.execute(user);
        }
        return new StringBuilder("Running...");
    }
}
