package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Membre;
import com.example.progexamnfinal.repository.MembreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MembreServiceImpl implements MembreService{
    private MembreRepository membreRepository;

    public MembreServiceImpl(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    @Override
    public void insertMembre(Membre membre) {
        membreRepository.insert(membre);
    }

    @Override
    public void updateMembre(int id, Membre membre) {
        membreRepository.update(id, membre);
    }

    @Override
    public void deleteMembre(int id) {
        membreRepository.delete(id);
    }

    @Override
    public Membre findMembreById(int id) {
        return membreRepository.findById(id);
    }

    @Override
    public List<Membre> getAllMembres() {
        return membreRepository.findAll();
    }
}

