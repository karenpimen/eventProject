package com.kh.api;

import com.kh.domain.Event;

public interface EventMessaging {
    void createEvent(Event event);
    void updateEvent(Event event);
    void deleteEvent(Long id);
}

