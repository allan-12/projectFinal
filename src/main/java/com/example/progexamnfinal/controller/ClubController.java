package com.example.progexamnfinal.controller;

import com.example.progexamnfinal.model.Club;
import com.example.progexamnfinal.service.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/club")
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @PostMapping("/insertClub")
    public void insertClub(@RequestBody Club club) {
        clubService.insertClub(club);
    }

    @PutMapping("/updateClub/{id}")
    public void updateClub(@RequestBody Club club, @PathVariable int id) {
        clubService.updateClub(id ,club);
    }

    @DeleteMapping("/deleteClub/{id}")
    public void deleteClub(@PathVariable int id) {
        clubService.deleteClub(id);
    }

    @GetMapping("/getClub/{id}")
    public Club findClubById(@PathVariable int id) {
        return clubService.findClubById(id);
    }
}

