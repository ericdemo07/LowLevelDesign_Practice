package com.doom.paymentservice.models;

import lombok.Data;

@Data
public class CreditCard {
    String cardNumber;
    String cardName;
    String cvvNumber;
    String expiryDate;
}
