package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Event;
import com.example.progexamnfinal.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void insertEvent(Event event) {
        eventRepository.insert(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventRepository.update(event);
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.delete(id);
    }

    @Override
    public Event findEventById(int id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
