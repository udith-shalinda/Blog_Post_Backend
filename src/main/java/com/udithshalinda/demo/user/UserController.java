package com.udithshalinda.demo.user;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * CustomerController
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @PostMapping("saveUser")
    public User saveUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PostMapping("/login")
    public String getUserByEmail(@RequestBody User inputUser){
        User user = this.userRepository.findByEmail(inputUser.email);
        System.out.println(user.userDetailsId.toString());
        return user.userDetailsId.toString();
    }

    @PutMapping("updateUser/{id}")
    public User updateUser(@PathVariable("id") ObjectId id, @Valid @RequestBody User user){
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") ObjectId id){
        userRepository.delete(userRepository.findById(id));
    }
}