//package com.udithshalinda.demo.student;
//
//import com.hrandika.moodle.modules.course.Course;
//import com.hrandika.moodle.modules.department.Department;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
///**
// * Student
// */
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//    private Integer year;
//    private String address;
//
//    @ManyToMany
//    private Set<Department> departments;
//
//    @OneToMany
//    private Set<Course> courses;
//
//}