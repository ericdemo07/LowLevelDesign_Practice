package authentication_interceptor;

public class FilterManager<T> {

    private final FilterChain filterChain;

    public FilterManager() {
        this.filterChain = new FilterChain();
    }

    public void addFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public StringBuilder filterRequest(T entity) {
        return filterChain.execute(entity);
    }
}
