package com.kafkaDemo.demo.service;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kafkaDemo.demo.model.Patient;
@Service
public class ProducerService {
	@Autowired
    private ReplyingKafkaTemplate<String, Patient, Patient> kafkaTemplate;

	public void producePatient(Patient p) throws InterruptedException, ExecutionException
	{

		ProducerRecord<String,Patient> record =new ProducerRecord<>("patient",p);
		record.headers().add(KafkaHeaders.REPLY_TOPIC, "patientreply".getBytes());
		RequestReplyFuture<String, Patient, Patient> sendAndReceive = kafkaTemplate.sendAndReceive(record);
		SendResult<String, Patient> sendResult = sendAndReceive.getSendFuture().get();

        //print all headers
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + "  : " + header.value()));

        // get consumer record
        ConsumerRecord<String, Patient> consumerRecord = sendAndReceive.get();
        // return consumer value
        System.err.println(consumerRecord.value());
      //print all headers
        consumerRecord.headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));

}
}