package com.udithshalinda.demo.user_details;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

      public UserDetails findById(ObjectId id);

//    public UserDetails findByEmail(String email);
//    //    public List<User> findByLastName(String lastName);
//    public UserDetails findById(ObjectId id);

//    @Aggregation("{ $group : { _id : $customerId, total : { $sum : 1 } } }")
//    List<OrdersPerCustomer> totalOrdersPerCustomer(Sort sort);
//
//    @Aggregation(pipeline = { "{ $match : { customerId : ?0 } }", "{ $count : total }" })
//    Long totalOrdersForCustomer(String customerId);

}