package com.udithshalinda.demo.user_details;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @PostMapping("save")
    public String saveUser(@RequestBody UserDetails userDetails) {
        UserDetails userDetails1 = this.userDetailsRepository.save(userDetails);
        return userDetails1.id.toString();
    }

    @GetMapping("getuserDetailsById/{id}")
    public UserDetails getDetails(@PathVariable("id") ObjectId userDetailsId){
        System.out.println(userDetailsId);
        return this.userDetailsRepository.findById(userDetailsId);
    }
    @PutMapping("updateUserDetails/{id}")
    public UserDetails updateUserDetails(@PathVariable("id") ObjectId userDetailsId,@RequestBody UserDetails userDetails){
        System.out.println(userDetailsId);
        userDetails.setId(userDetailsId);
        return this.userDetailsRepository.save(userDetails);
    }
}
