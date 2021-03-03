package com.pjarosz.zadanierekrutacyjne.domain.credit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.create(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findOne(id);
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }
}
