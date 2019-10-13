package com.udithshalinda.demo.userDetails;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class UserDetails {

    @Id
    public ObjectId id;

    public String name;
    public String profilePictureLink;
    public String status;

    public UserDetails(String name, String profilePictureLink,String status) {
        this.name = name;
        this.profilePictureLink = profilePictureLink;
        this.status = status;
    }
    public void setId(ObjectId id){
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "UserDetails[id=%s, name='%s', profileImage='%s', status='%s']",
                id, name, profilePictureLink,status);
    }

}