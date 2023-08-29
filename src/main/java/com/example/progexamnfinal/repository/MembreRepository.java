package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Membre;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MembreRepository {
    void insert(Membre membre);

    void update(int id, Membre membre);
    void delete(int id);
    Membre findById(int id);

    List<Membre> findAll();
}
