package controllers;

import java.util.Optional;

import models.Bill;

public interface IOrder {
    //applicable to all assuming user can only do one order at a time

    String addToCart(String userId, String menuItemId, int quantity);

    String removeFromCart(String userId, String menuItemId);

    String getCartItems(String userId);

    String publishOrder(String userId);

    String cancelOrder(String userId);

    Bill getBill(String userId);

    String getOrderStatus(String userId);
}
