package com.kh.kafka;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
//@Profile("kafka")
public class EventProducer {
    @Autowired(required=false)
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageCreate(String msg) {
        kafkaTemplate.send("create-event-notification", msg);
    }

    public void sendMessageUpdate(String msg) {
        kafkaTemplate.send("update-event-notification", msg);
    }

    public void sendMessageDelete(String msg) {
        kafkaTemplate.send("delete-event-notification", msg);
    }



}
