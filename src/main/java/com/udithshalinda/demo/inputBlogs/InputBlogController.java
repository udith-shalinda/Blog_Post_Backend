package com.udithshalinda.demo.inputBlogs;

import com.udithshalinda.demo.userDetails.UserDetails;
import com.udithshalinda.demo.userDetails.UserDetailsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inputBlog")
public class InputBlogController {

    @Autowired
    private InputBlogRepository inputBlogRepository;

    @PostMapping("save")
    public InputBlog saveUser(@RequestBody InputBlog inputBlog) {
        return this.inputBlogRepository.save(inputBlog);
    }

    @GetMapping("getOneBlog/{id}")
    public InputBlog getBlog(@PathVariable("id") ObjectId id){
        return this.inputBlogRepository.findById(id);
    }
}
