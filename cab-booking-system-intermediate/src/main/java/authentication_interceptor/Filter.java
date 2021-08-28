package authentication_interceptor;

import models.user_step_builder.User;

public interface Filter<T> {

    void setNext(Filter filter);

    Filter getNext();

    Filter getLast();

    StringBuilder execute(T user);
}
