//package com.udithshalinda.demo.student;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * StudentController
// */
//
//@RestController
//@RequestMapping("/api/students")
//public class StudentController {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @GetMapping
//    public Iterable<Student> getAllStudenets() {
//        return this.studentRepository.findAll();
//    }
//
//    @PostMapping
//    public Student saveStudent(@RequestBody Student student) {
//        return this.studentRepository.save(student);
//    }
//
//}