package com.udithshalinda.demo.input_blogs;

import com.udithshalinda.demo.upload_photo.Photo;
import com.udithshalinda.demo.upload_photo.PhotoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inputBlog")
public class InputBlogController {

    @Autowired
    private InputBlogRepository inputBlogRepository;

    @Autowired
    private PhotoService photoService;

    @PostMapping("save")
    public InputBlog saveUser(@RequestBody InputBlog inputBlog) {
        return this.inputBlogRepository.save(inputBlog);
    }

    @GetMapping("getOneBlog/{id}")
    public InputBlog getBlog(@PathVariable("id") ObjectId id){
        InputBlog inputBlog = this.inputBlogRepository.findById(id);
        Photo photo = photoService.getPhoto(inputBlog.coverImageId);
        inputBlog.coverImageId = Base64.getEncoder().encodeToString(photo.getImage().getData());
        return inputBlog;
    }

    @GetMapping("getAllBlogs")
    public Iterable<InputBlog> getAllPosts(){
        List<InputBlog> list =this.inputBlogRepository.findAll();
        for(InputBlog blog: list){
            blog.testId = blog.id.toString();
        }
        return list;
    }
    @PutMapping("addUpVoter/{blogId}")
    public int setUpVoter(@PathVariable("blogId") ObjectId blogId,@RequestBody Voter voter){
        InputBlog inputBlog = this.inputBlogRepository.findById(blogId);
        if(inputBlog.checkDownVoter(voter.userId)){
            inputBlog.removeDownVOter(voter.userId);
            this.inputBlogRepository.save(inputBlog);
        }else if(!inputBlog.checkUpVoter(voter.userId)){
            inputBlog.addUpVoters(voter.userId);
            this.inputBlogRepository.save(inputBlog);
        }
        return inputBlog.upVoters.size()-inputBlog.downVoters.size();
    }

    @PutMapping("addDownVoter/{id}")
    public int setDOwnVoter(@PathVariable("id") ObjectId blogId,@RequestBody Voter voter){
        InputBlog inputBlog = this.inputBlogRepository.findById(blogId);
        if(inputBlog.checkUpVoter(voter.userId)){
            inputBlog.removeUpVOter(voter.userId);
            this.inputBlogRepository.save(inputBlog);
        }else if(!inputBlog.checkDownVoter(voter.userId)){
            inputBlog.addDownVoters(voter.userId);
            this.inputBlogRepository.save(inputBlog);
        }
        return inputBlog.upVoters.size()-inputBlog.downVoters.size();
    }

}
