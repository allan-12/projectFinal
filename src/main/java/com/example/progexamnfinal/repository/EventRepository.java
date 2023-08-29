package com.example.progexamnfinal.repository;

import com.example.progexamnfinal.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepository {
    void insert(Event event);
    void update(Event event);
    void delete(int id);
    Event findById(int id);
    List<Event> findAll();
}
