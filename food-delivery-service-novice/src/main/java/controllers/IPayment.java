package controllers;

import java.util.Optional;

public interface IPayment {

    String processPayment(String userId, String paymentMode, Optional<String> couponAsOptional);
}
