package com.udithshalinda.demo.input_blogs;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class InputBlogWebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String updateInputBlog(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("hello t sfshfsfs");
        return "gsfsfsf";
    }
}
