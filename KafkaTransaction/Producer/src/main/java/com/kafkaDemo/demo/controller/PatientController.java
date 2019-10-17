package com.kafkaDemo.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaDemo.demo.model.Patient;
import com.kafkaDemo.demo.service.LoggingService;
import com.kafkaDemo.demo.service.ProducerService;

@RestController
public class PatientController {
	@Autowired
	LoggingService los;
	@Autowired
	ProducerService producer;
	@GetMapping("/get/patient")
	public Patient get() {
		Patient p=new Patient();
		p=los.dataFeeder(p);
		//ProducerService producer=new ProducerService();
		try {
			producer.producePatient(p);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	@PostMapping("/post/patient")
	public String post(@RequestBody Patient p) {
	return los.dataGetter(p); }
}
