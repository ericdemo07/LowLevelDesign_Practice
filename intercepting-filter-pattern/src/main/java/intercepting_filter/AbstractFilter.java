package intercepting_filter;

public abstract class AbstractFilter implements Filter {

    private Filter next;

    public AbstractFilter() { }

    public AbstractFilter(Filter next) {
        this.next = next;
    }

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
    public StringBuilder execute(Car car) {
        if (getNext() != null) {
            return getNext().execute(car);
        }
        return new StringBuilder();
    }
}
