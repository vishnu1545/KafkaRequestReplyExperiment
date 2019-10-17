package com.kafkaDemo.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.kafkaDemo.demo.model.Patient;
@Service
public class ConsumerService {
	@KafkaListener(topics = "patient")
    @SendTo
	public Patient ConsumePatient(ConsumerRecord<String,Patient> cf)
	{ Patient p=cf.value();
		
		p.setEmail(p.getEmail()+"Cons");
		cf.headers().forEach(header -> System.err.println(header.key() + "  : " + header.value()));
		return p;
		
	}
}
