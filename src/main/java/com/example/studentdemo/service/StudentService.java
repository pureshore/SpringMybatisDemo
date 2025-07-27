package com.example.studentdemo.service;

import com.example.studentdemo.entity.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
}