package com.udithshalinda.demo.user;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {


    public User findByEmail(String email);
//    public List<User> findByLastName(String lastName);
    public User findById(ObjectId id);

//    @Aggregation("{ $group : { _id : $customerId, total : { $sum : 1 } } }")
//    List<OrdersPerCustomer> totalOrdersPerCustomer(Sort sort);
//
//    @Aggregation(pipeline = { "{ $match : { customerId : ?0 } }", "{ $count : total }" })
//    Long totalOrdersForCustomer(String customerId);

}