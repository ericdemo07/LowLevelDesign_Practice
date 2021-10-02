package service;

import java.util.List;

import controllers.IUser;
import datastore.UserDatastore;
import models.Delivery;
import models.Order;
import models.User;

public class UserService implements IUser {
    private final UserDatastore userDatastore;

    public UserService(UserDatastore userDatastore) {
        this.userDatastore = userDatastore;
    }

    @Override
    public String register(User user) {
        return userDatastore.add(user);
    }

    @Override
    public String update(User user) {
        return userDatastore.add(user);
    }

    @Override
    public User getProfile(String userId) {
        return userDatastore.get(userId);
    }

    @Override
    public String deleteProfile(String userId) {
        return userDatastore.delete(userId);
    }

    @Override
    public List<Order> getAllOrders(String userId) {
        return null;
    }

    @Override
    public List<Delivery> getAllDeliveries(String userId) {
        return null;
    }
}
