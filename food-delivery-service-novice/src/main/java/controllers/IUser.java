package controllers;

import java.util.List;

import models.Delivery;
import models.Order;
import models.User;

public interface IUser {

    String register(User user);

    String update(User user);

    User getProfile(String userId);

    String deleteProfile(String userId);

    List<Order> getAllOrders(String userId);

    List<Delivery> getAllDeliveries(String userId);
}
