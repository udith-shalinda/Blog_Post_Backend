package com.udithshalinda.demo.inputBlogs;

import com.udithshalinda.demo.userDetails.UserDetails;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InputBlogRepository extends MongoRepository<InputBlog, String> {

    public InputBlog findById(ObjectId id);
}
