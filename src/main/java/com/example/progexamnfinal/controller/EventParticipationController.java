package com.example.progexamnfinal.controller;

import com.example.progexamnfinal.model.Event_Participation;
import com.example.progexamnfinal.service.EventParticipationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EventParticipationController {
    private EventParticipationService eventParticipationService;

    public EventParticipationController(EventParticipationService eventParticipationService) {
        this.eventParticipationService = eventParticipationService;
    }

    @GetMapping("/eventParticipation")
    public List<Event_Participation> getAllEventParticipations() {
        return eventParticipationService.getAllEventParticipations();
    }

    @PostMapping("/insertEventParticipation")
    public void insertEventParticipation(@RequestBody Event_Participation eventParticipation) {
        eventParticipationService.insertEventParticipation(eventParticipation);
    }

    @PutMapping("/updateEventParticipation/{id}")
    public void updateEventParticipation(@RequestBody Event_Participation eventParticipation, @PathVariable int id) {
        eventParticipationService.updateEventParticipation(id, eventParticipation);
    }

    @DeleteMapping("/deleteEventParticipation/{id}")
    public void deleteEventParticipation(@PathVariable int id) {
        eventParticipationService.deleteEventParticipation(id);
    }

    @GetMapping("/getEventParticipation/{id}")
    public Event_Participation findEventParticipationById(@PathVariable int id) {
        return eventParticipationService.findEventParticipationById(id);
    }
}
