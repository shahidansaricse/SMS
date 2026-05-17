package com.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;
@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student student) {

        Student existing = service.getById(id);

        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());

        return service.saveStudent(existing);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteById(id);
        return "Student deleted successfully";
    }
}
