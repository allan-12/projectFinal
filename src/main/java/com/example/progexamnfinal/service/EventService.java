package com.example.progexamnfinal.service;

import com.example.progexamnfinal.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventService {
    void insertEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(int id);
    Event findEventById(int id);
    List<Event> getAllEvents();
}
