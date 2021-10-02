package datastore;

public interface ICRUDOperations<E> {
    String add(E item);

    E get(String id);

    String update(E item);

    String delete(String id);
}
