package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Club;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClubService {
    void insertClub(Club club);


    void updateClub(int id, Club club);

    void deleteClub(int id);

    Club findClubById(int id);

    List<Club> getAllClubs();
}
