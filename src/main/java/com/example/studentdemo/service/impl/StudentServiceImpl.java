package com.example.studentdemo.service.impl;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.mapper.StudentMapper;
import com.example.studentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    public void deleteStudent(Long id) {
        studentMapper.delete(id);
    }

    public Student getStudentById(Long id) {
        return studentMapper.selectById(id);
    }

    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }
}