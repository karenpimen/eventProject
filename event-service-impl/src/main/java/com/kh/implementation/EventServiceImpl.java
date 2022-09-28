package com.kh.implementation;

import com.kh.api.EventMessaging;
import com.kh.api.EventService;
import com.kh.domain.Event;
import com.kh.domain.EventType;
import com.kh.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventServiceImpl implements EventService{

    @Autowired(required = false)
    EventMessaging eventMessaging;

    //@Autowired(required = false)
    //EventProducer eventProducer;


    @Autowired
    private EventRepository eventRepository;

    public void createKafkaEvent(Event kafkaEvent){
        eventMessaging.createEvent(kafkaEvent);
    }

    public void updateKafkaEvent(Event kafkaEvent){
        eventMessaging.updateEvent(kafkaEvent);
    }

    public void deleteKafkaEvent(Long id){
        eventMessaging.deleteEvent(id);
    }


    @PostConstruct
    public void initDoctor(){
        eventRepository.saveAll(Stream.of
                        (new Event(101L,"Stay safe","Guadalajara","Karen ", EventType.WORKSHOP, LocalDateTime.of(2022,12,22,4,30)),
                                new Event(102L,"Stay safe II","Guadalajara","Karen ", EventType.WORKSHOP, LocalDateTime.of(2022,12,23,4,30)))
                .collect(Collectors.toList()));
    }
    @Override
    public Event createEvent(Event event) {
        //eventProducer.sendMessageCreate(event.getTitle());
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        existingEvent.setTitle(event.getTitle());
        existingEvent.setPlace(event.getPlace());
        existingEvent.setSpeaker(event.getSpeaker());
        existingEvent.setEventType(event.getEventType());
        existingEvent.setDateTime(event.getDateTime());

        return eventRepository.save(existingEvent);
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event deleteEvent(Long id) {
        Event existingEvent= this.getEvent(id);
        eventRepository.delete(existingEvent);
        return existingEvent;
    }

    @Override
    public List getAllEvents() {
        return eventRepository.findAll();
    }
}
