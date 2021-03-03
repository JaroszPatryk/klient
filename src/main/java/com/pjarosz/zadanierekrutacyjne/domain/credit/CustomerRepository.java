package com.pjarosz.zadanierekrutacyjne.domain.credit;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findOne(Long id);

    List<Customer> findAll();

    void create(Customer customer);

}
