package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    void insert(Student etudiant);
    void update(Student etudiant);
    void delete(int id);
    Student findById(int id);

    List<Student> findAll();
}
