package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Club;
import com.example.progexamnfinal.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService{
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public void insertClub(Club club) {
        clubRepository.insert(club);
    }

    @Override
    public void updateClub(int id, Club club) {
clubRepository.update(id ,club);
    }

    @Override
    public void deleteClub(int id) {
        clubRepository.delete(id);
    }

    @Override
    public Club findClubById(int id) {
        return clubRepository.findById(id);
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
}
