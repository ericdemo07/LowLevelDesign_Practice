package com.doom.paymentservice.controllers;

import com.doom.paymentservice.dao.CreditCardInformationRepository;
import com.doom.paymentservice.dao.models.CreditCardInformation;
import com.doom.paymentservice.models.CreditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
public class ValidationController implements IValidation {

    private final CreditCardInformationRepository creditCardInformationRepository;

    @Autowired
    public ValidationController(CreditCardInformationRepository creditCardInformationRepository) {
        this.creditCardInformationRepository = creditCardInformationRepository;
    }

    @Override
    public String validateCard(String userId, CreditCard creditCard) {
        final boolean valid = true;

        if (valid) {
            creditCardInformationRepository.save(prepareCreditCardInformation(userId, creditCard));
        }
        return "SUCCESS";
    }

    private CreditCardInformation prepareCreditCardInformation(String userId, CreditCard creditCard) {
        CreditCardInformation creditCardInformation = new CreditCardInformation();

        creditCardInformation.setId(UUID.randomUUID().toString());
        creditCardInformation.setUserId(userId);
        creditCardInformation.setCardNumber(creditCard.getCardNumber());
        creditCardInformation.setCardName(creditCard.getCardName());
        creditCardInformation.setCvvNumber(creditCard.getCvvNumber());
        creditCardInformation.setCreatedAt(OffsetDateTime.now());

        return creditCardInformation;
    }
}
