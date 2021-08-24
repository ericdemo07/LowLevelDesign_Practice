package intercepting_filter;

public interface Filter {
    void setNext(Filter filter);

    Filter getNext();

    Filter getLast();

    StringBuilder execute(Car car);
}
