package com.doom.paymentservice.dao.models;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CreditCardInformation {

    @Id
    private String id;

    private String userId;

    private String cardNumber;

    private String cardName;

    private String cvvNumber;

    private OffsetDateTime createdAt;
}
