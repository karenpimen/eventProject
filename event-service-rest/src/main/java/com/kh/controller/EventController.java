package com.kh.controller;

import com.kh.api.EventService;
import com.kh.domain.Event;
import com.kh.implementation.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventServiceImpl eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        event = eventService.createEvent(event);
        return event;
    }

    @GetMapping("/{id}")
    public Event findEventById(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @PutMapping("/update/{id}")
    public Event updateProduct(@RequestBody Event event, @PathVariable Long id) {
        return eventService.updateEvent(id, event);
    }

    @GetMapping
    public List<Event> findAllEvents()
    {
        return eventService.getAllEvents();
    }

    @DeleteMapping( path = "/{id}")
    public String deleteEvent(@PathVariable("id") Long id){
        Event outcome = eventService.deleteEvent(id);
        if (outcome!=null){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
