package com.example.studentdemo.mapper;

import com.example.studentdemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    void insert(Student student);
    void update(Student student);
    void delete(Long id);
    Student selectById(Long id);
    List<Student> selectAll();
}