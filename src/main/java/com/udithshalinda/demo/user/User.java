package com.udithshalinda.demo.user;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {

    @Id
    public ObjectId id;

    public String email;
    public String password;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public void setId(ObjectId id){
        this.id = id;
    }
    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s', password='%s']",
                id, email, password);
    }

}