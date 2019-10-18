package com.udithshalinda.demo.input_blogs;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inputBlog")
public class InputBlogController {

    @Autowired
    private InputBlogRepository inputBlogRepository;

    @PostMapping("save")
    public InputBlog saveUser(@RequestBody InputBlog inputBlog) {
        System.out.println(inputBlog.createrId);
        return this.inputBlogRepository.save(inputBlog);
    }

    @GetMapping("getOneBlog/{id}")
    public InputBlog getBlog(@PathVariable("id") ObjectId id){
        System.out.println(id);
        return this.inputBlogRepository.findById(id);
    }

    @GetMapping("getAllBlogs")
    public Iterable<InputBlog> getAllPosts(){
        List<InputBlog> list =this.inputBlogRepository.findAll();
        for(InputBlog blog: list){
            blog.testId = blog.id.toString();
        }
        return list;
    }
}
