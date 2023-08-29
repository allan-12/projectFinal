package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Event_Participation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventParticipationService {
    void insertEventParticipation(Event_Participation eventParticipation);

    void updateEventParticipation(int id, Event_Participation eventParticipation);

    void deleteEventParticipation(int id);

    Event_Participation findEventParticipationById(int id);

    List<Event_Participation> getAllEventParticipations();
}
