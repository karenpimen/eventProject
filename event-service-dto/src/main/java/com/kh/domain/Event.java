package com.kh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Event {
    @Id
    @Column(name="event_id")
    @GeneratedValue
    private Long eventId;
    private String title;
    private String place;
    private String speaker;
    private EventType eventType;
    private LocalDateTime dateTime;

    public Event(String title, String place, String speaker, EventType eventType, LocalDateTime dateTime) {
        this.title = title;
        this.place = place;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }
}
