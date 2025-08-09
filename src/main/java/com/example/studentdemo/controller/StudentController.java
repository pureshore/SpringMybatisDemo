package com.example.studentdemo.controller;

import com.example.studentdemo.entity.BaseResponse;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String createStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "{\"status\": \"success\", \"message\": \"学生添加成功\"}";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return "{\"status\": \"success\", \"message\": \"学生更新成功\"}";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "{\"status\": \"success\", \"message\": \"学生删除成功\"}";
    }

    @GetMapping("/id")
    public BaseResponse getStudent(@RequestParam(required = false) Long id, HttpServletRequest request) {
        // 从header中获取token
        String token = request.getHeader("accessToken");

        // 校验token
        if (token == null || token.isEmpty()) {
            return BaseResponse.error("token不能为空");
        }

        // 简单的token校验，实际项目中可能需要更复杂的逻辑
        if (!"valid-token".equals(token)) {
            return BaseResponse.error("token无效");
        }
        if (id == null) {
            return BaseResponse.error("id入参为空");
        }

        Student student = studentService.getStudentById(id);
        return BaseResponse.success(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}