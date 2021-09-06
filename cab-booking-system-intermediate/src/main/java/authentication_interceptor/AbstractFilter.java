package authentication_interceptor;

public class AbstractFilter<T> implements Filter<T> {

    private Filter next;

    @Override
    public void setNext(Filter filter) {
        this.next = filter;
    }

    @Override
    public Filter getNext() {
        return next;
    }

    @Override
    public Filter getLast() {
        Filter last = this;

        while (last.getNext() != null) {
            last = last.getNext();
        }

        return last;
    }

    @Override
    public StringBuilder execute(T user) {
        if(getNext() != null){
            return getNext().execute(user);
        }

        return new StringBuilder();
    }
}
