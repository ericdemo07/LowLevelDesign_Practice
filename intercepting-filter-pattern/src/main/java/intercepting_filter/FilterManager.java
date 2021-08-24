package intercepting_filter;

public class FilterManager {

    private final FilterChain filterChain;

    public FilterManager(){
        filterChain = new FilterChain();
    }

    public void addFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public StringBuilder filterRequest(Car car){
        return filterChain.execute(car);
    }
}
