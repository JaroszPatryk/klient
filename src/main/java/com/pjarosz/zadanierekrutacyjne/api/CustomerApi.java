package com.pjarosz.zadanierekrutacyjne.api;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Customer;
import com.pjarosz.zadanierekrutacyjne.domain.credit.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerApi {

    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getOne(@PathVariable Long creditId) {
        return customerService.getCustomerById(creditId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody @Valid Customer customer) {
        customerService.createCustomer(customer);
    }


}
