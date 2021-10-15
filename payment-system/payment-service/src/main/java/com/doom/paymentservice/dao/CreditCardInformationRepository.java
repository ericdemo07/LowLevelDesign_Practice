package com.doom.paymentservice.dao;

import com.doom.paymentservice.dao.models.CreditCardInformation;

import org.springframework.data.repository.CrudRepository;

public interface CreditCardInformationRepository extends CrudRepository<CreditCardInformation, String> {
}
