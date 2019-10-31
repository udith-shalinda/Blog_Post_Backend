package com.udithshalinda.demo.user_details;

import com.udithshalinda.demo.upload_photo.Photo;
import com.udithshalinda.demo.upload_photo.PhotoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private PhotoService photoService;

    @PostMapping("save")
    public String saveUser(@RequestBody UserDetails userDetails) {
        UserDetails userDetails1 = this.userDetailsRepository.save(userDetails);
        return userDetails1.id.toString();
    }

    @GetMapping("getuserDetailsById/{id}")
    public UserDetails getDetails(@PathVariable("id") ObjectId userDetailsId){
        System.out.println(userDetailsId);
        UserDetails userDetails = this.userDetailsRepository.findById(userDetailsId);
        Photo photo = photoService.getPhoto(userDetails.profilePictureLink);
        userDetails.profilePictureLink= "data:image/png;base64, "+Base64.getEncoder().encodeToString(photo.getImage().getData());
        return userDetails;
    }
    @PutMapping("update")
    public UserDetails updateUserDetails(@RequestBody UserDetails userDetails){
//        userDetails.setId(userDetailsId);
        userDetails = this.userDetailsRepository.save(userDetails);
        Photo photo = photoService.getPhoto(userDetails.profilePictureLink);
        userDetails.profilePictureLink= "data:image/png;base64, "+Base64.getEncoder().encodeToString(photo.getImage().getData());
        return userDetails;
    }
}
