package com.udithshalinda.demo.inputBlogs;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class InputBlog {
    @Id
    public ObjectId id;

    public String blog;
    public String createrId;


    public InputBlog(String blog,String createrId) {
        this.blog = blog;
        this.createrId= createrId;
    }
    public void setId(ObjectId id){
        this.id = id;
    }
}
