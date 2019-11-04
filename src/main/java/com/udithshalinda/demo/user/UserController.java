package com.udithshalinda.demo.user;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * CustomerController
 */
@CrossOrigin(origins = "https://blog-posts-142d5.firebaseapp.com/")
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
    public ResponseEntity<?> getUserByEmail(@RequestBody User inputUser){
        User user = this.userRepository.findByEmail(inputUser.email);
        if(user != null){
            if(user.password.equals(inputUser.password)){
                return new ResponseEntity<>(user.userDetailsId.toString(),HttpStatus.resolve(200));
            }else{
                return new ResponseEntity<>("password is not correct",HttpStatus.resolve(203));
            }
        }else{
            return new ResponseEntity<>("Email not found",HttpStatus.resolve(404));
        }
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