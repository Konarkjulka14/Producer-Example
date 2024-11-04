package com.kj.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfigProducer {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("javatechie-demo-6",3,(short)1);
    }
}
