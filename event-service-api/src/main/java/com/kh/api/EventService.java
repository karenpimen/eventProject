package com.kh.api;

import com.kh.domain.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    	Event createEvent(Event event);
    	Event updateEvent(Long id, Event event);
    	Event getEvent(Long id);
    	Event deleteEvent(Long id);
    	List getAllEvents();

}
