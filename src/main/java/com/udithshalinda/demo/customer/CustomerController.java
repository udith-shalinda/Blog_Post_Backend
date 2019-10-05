package com.udithshalinda.demo.customer;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @GetMapping("/getCustomerByName")
    public Customer getCustomerByFirstName(){
        Customer customer = customerRepository.findByFirstName("Alice");
        System.out.println(customer);
        return customer;
    }
    @PutMapping("updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable("id") ObjectId id, @Valid @RequestBody Customer customer){
        customer.setId(id);
        return customerRepository.save(customer);
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") ObjectId id){
        customerRepository.delete(customerRepository.findById(id));
    }
}