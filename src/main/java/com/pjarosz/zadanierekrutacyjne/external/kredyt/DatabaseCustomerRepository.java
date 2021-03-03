package com.pjarosz.zadanierekrutacyjne.external.kredyt;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Customer;
import com.pjarosz.zadanierekrutacyjne.domain.credit.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DatabaseCustomerRepository implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Optional<Customer> findOne(Long id) {
        return jpaCustomerRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Customer> findAll() {
        return jpaCustomerRepository.findAll()
                .stream().map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void create(Customer customer) {
        jpaCustomerRepository.save(toEntity(customer));
    }

    private Customer toDomain(CustomerEntity entity) {
        return Customer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .peselNumber(entity.getPeselNumber())
                .build();
    }

    private CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .peselNumber(customer.getPeselNumber())
                .build();
    }
}
