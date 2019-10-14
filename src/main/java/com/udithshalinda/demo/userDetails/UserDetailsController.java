package com.udithshalinda.demo.userDetails;

import com.udithshalinda.demo.user.User;
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
}
