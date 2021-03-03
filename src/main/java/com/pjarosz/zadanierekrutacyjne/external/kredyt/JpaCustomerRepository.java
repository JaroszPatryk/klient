package com.pjarosz.zadanierekrutacyjne.external.kredyt;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<Customer> findByName(String name);

    List<Customer> findBySurname(String name);

    List<Customer> findByPeselNumber(int peselNumber);

}
