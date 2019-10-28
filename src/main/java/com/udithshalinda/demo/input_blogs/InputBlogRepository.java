package com.udithshalinda.demo.input_blogs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InputBlogRepository extends MongoRepository<InputBlog, String> {

    public InputBlog findById(ObjectId id);
    public List<InputBlog> findAll();
    public List<InputBlog> findByCreaterId(String createrId);
}
