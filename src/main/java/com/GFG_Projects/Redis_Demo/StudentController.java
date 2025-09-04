package com.GFG_Projects.Redis_Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        System.out.println("Added new student");
        studentService.addStudentToLocalRedisDB(student);
        return student;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return   studentService.getStudentFromRedis(id);
    }
}
