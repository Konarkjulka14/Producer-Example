package com.kj.controller;

import com.kj.dto.Customer;
import com.kj.service.KafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class EventController {

    @Autowired
    private KafkaPublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publicMessage(@PathVariable String message){
        for(int i = 0; i < 10000; i++){
            publisher.sendMessageToTopic(message + " " + i);

        }
        return ResponseEntity.ok("message sent successfully");
    }

    @PostMapping("/publish")
    public void sendEvents(@RequestBody Customer customer){
        publisher.sendEventToTopic(customer);
    }
}
