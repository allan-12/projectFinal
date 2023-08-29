package com.example.progexamnfinal.controller;

import com.example.progexamnfinal.model.Student;
import com.example.progexamnfinal.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping("/insertStudent")
    public void insertStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }

    @PutMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/getStudent/{id}")
    public Student findStudentById(@PathVariable int id) {
        return studentService.findStudentById(id);
    }
}
