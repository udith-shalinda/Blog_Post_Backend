package com.udithshalinda.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerController
 */

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getAllCustomers")
    public Iterable<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @PostMapping("saveCustomer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

}