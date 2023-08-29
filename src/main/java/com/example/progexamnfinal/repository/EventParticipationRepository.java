package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Event_Participation;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventParticipationRepository {
    void insert(Event_Participation eventParticipation);

    void update(int id, Event_Participation eventParticipation);

    void update(Event_Participation eventParticipation);

    void delete(int id);
    Event_Participation findById(int id);

    List<Event_Participation> findAll();
}
