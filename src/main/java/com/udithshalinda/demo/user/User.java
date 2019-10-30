package com.udithshalinda.demo.user;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class User {

    @Id
    public ObjectId id;

    @Indexed(unique = true)
    public String email;
    public String password;
    public ObjectId userDetailsId;

    public User(String email, String password,ObjectId userDetailsId) {
        this.email = email;
        this.password = password;
        this.userDetailsId = userDetailsId;
    }
    public void setId(ObjectId id){
        this.id = id;
    }
    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s', password='%s', userDetailsId:'%s']",
                id, email, password,userDetailsId);
    }

}