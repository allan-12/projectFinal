package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Club;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClubRepository {
    void insert(Club club);

    void update(int id, Club club);
    void delete(int id);
    Club findById(int id);

    List<Club> findAll();
}
