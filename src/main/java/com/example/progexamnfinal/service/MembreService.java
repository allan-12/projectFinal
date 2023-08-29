package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Membre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MembreService {
    void insertMembre(Membre membre);

    void updateMembre(int id, Membre membre);

    void deleteMembre(int id);

    Membre findMembreById(int id);

    List<Membre> getAllMembres();
}
