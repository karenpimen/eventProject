package com.kh.kafka;

import com.kh.api.EventMessaging;
import com.kh.api.EventService;
import com.kh.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
//@Profile("kafka")
public class EventConsumer {
    @Autowired(required = false)
    EventMessaging eventMessaging;

    @KafkaListener
    public void createEvent(Event event){
        log.info("Message received create event");
    }
    @KafkaListener
    public void updateEvent(Event event){
        eventMessaging.updateEvent(event);
    }
    @KafkaListener
    public void deleteEvent(Long id){
        eventMessaging.deleteEvent(id);
    }
}


