package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Student;
import com.example.progexamnfinal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{


    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.delete(id);
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findById(id);

    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
