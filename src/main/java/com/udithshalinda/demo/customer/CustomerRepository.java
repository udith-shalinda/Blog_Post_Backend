package com.udithshalinda.demo.customer;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    public Customer findById(ObjectId id);

//    @Aggregation("{ $group : { _id : $customerId, total : { $sum : 1 } } }")
//    List<OrdersPerCustomer> totalOrdersPerCustomer(Sort sort);
//
//    @Aggregation(pipeline = { "{ $match : { customerId : ?0 } }", "{ $count : total }" })
//    Long totalOrdersForCustomer(String customerId);

}