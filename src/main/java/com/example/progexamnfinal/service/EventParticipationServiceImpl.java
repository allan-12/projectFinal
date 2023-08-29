package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Event_Participation;
import com.example.progexamnfinal.repository.EventParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventParticipationServiceImpl implements EventParticipationService{
    private EventParticipationRepository eventParticipationRepository;

    public EventParticipationServiceImpl(EventParticipationRepository eventParticipationRepository) {
        this.eventParticipationRepository = eventParticipationRepository;
    }

    @Override
    public void insertEventParticipation(Event_Participation eventParticipation) {
        eventParticipationRepository.insert(eventParticipation);
    }

    @Override
    public void updateEventParticipation(int id, Event_Participation eventParticipation) {
        eventParticipationRepository.update(id, eventParticipation);
    }

    @Override
    public void deleteEventParticipation(int id) {
        eventParticipationRepository.delete(id);
    }

    @Override
    public Event_Participation findEventParticipationById(int id) {
        return eventParticipationRepository.findById(id);
    }

    @Override
    public List<Event_Participation> getAllEventParticipations() {
        return eventParticipationRepository.findAll();
    }
}

