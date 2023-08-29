package com.example.progexamnfinal.controller;

import com.example.progexamnfinal.model.Membre;
import com.example.progexamnfinal.service.MembreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembreController {
    private MembreService membreService;

    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @GetMapping("/membre")
    public List<Membre> getAllMembres() {
        return membreService.getAllMembres();
    }

    @PostMapping("/insertMembre")
    public void insertMembre(@RequestBody Membre membre) {
        membreService.insertMembre(membre);
    }

    @PutMapping("/updateMembre/{id}")
    public void updateMembre(@RequestBody Membre membre, @PathVariable int id) {
        membreService.updateMembre(id, membre);
    }

    @DeleteMapping("/deleteMembre/{id}")
    public void deleteMembre(@PathVariable int id) {
        membreService.deleteMembre(id);
    }

    @GetMapping("/getMembre/{id}")
    public Membre findMembreById(@PathVariable int id) {
        return membreService.findMembreById(id);
    }
}

