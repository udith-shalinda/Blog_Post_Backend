package com.udithshalinda.demo.customer;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public ObjectId id;

    public String firstName;
    public String lastName;



    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setId(ObjectId id){
        this.id = id;
    }
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}