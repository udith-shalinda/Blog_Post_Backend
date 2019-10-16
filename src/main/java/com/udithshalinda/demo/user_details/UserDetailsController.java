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
    public UserDetails saveUser(@RequestBody UserDetails userDetails) {
        return this.userDetailsRepository.save(userDetails);
    }

    @GetMapping("getuserDetailsById/{id}")
    public UserDetails getDetails(@PathVariable("id") ObjectId userDetailsId){
        System.out.println(userDetailsId);
        return this.userDetailsRepository.findById(userDetailsId);
    }
}
