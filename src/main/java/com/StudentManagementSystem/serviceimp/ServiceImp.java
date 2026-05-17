package com.StudentManagementSystem.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.StudentRepository;
import com.StudentManagementSystem.service.StudentService;

@Service
public class ServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student getById(int id) {

        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {

        studentRepository.deleteById(id);
    }
}