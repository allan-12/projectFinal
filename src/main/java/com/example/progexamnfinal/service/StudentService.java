package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    Student findStudentById(int id);

    List<Student> getAllStudents();


}
