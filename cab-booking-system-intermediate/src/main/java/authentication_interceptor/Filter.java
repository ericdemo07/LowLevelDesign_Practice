package authentication_interceptor;

public interface Filter<T> {

    void setNext(Filter filter);

    Filter getNext();

    Filter getLast();

    StringBuilder execute(T user);
}
