package com.example.progexamnfinal.controller;

import com.example.progexamnfinal.model.Event;
import com.example.progexamnfinal.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EventController {

    private  final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/insertEvent")
    public void insertEvent(@RequestBody Event event) {
        eventService.insertEvent(event);
    }

    @PutMapping("/updateEvent/{id}")
    public void updateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/getEvent/{id}")
    public Event findEventById(@PathVariable int id) {
        return eventService.findEventById(id);
    }
}
