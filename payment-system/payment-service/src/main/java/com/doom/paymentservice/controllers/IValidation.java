package com.doom.paymentservice.controllers;

import com.doom.paymentservice.models.CreditCard;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IValidation {

    @PostMapping("{id}/validate")
    String validateCard(@PathVariable("id") String userId, @RequestBody CreditCard creditCard);
}
