package com.kafkaDemo.demo.kafkaConfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafkaDemo.demo.model.Patient;


@Configuration
@EnableKafka
public class KafkaConfiguration {


	   
	    @Value("cons")
	    private String consumerGroup;

	    @Bean
	    public Map<String, Object> producerConfigs() {
	        Map<String, Object> props = new HashMap<>();       
	        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
	                "127.0.0.1:9092");
	        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	                StringSerializer.class);
	        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	        props.put(ProducerConfig.TRANSACTION_TIMEOUT_CONFIG, 366600);
	        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,160000);
	        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG,160000);
	        return props;
	    }

	    @Bean
	    public Map<String, Object> consumerConfigs() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	        props.put(ConsumerConfig.GROUP_ID_CONFIG, "load");
	        props.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG,20000);
	        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG,160000);
	      
	        return props;
	    }

	    @Bean
	    public ProducerFactory<String, Patient> producerFactory() {
	        return new DefaultKafkaProducerFactory<>(producerConfigs());
	    }

	    @Bean
	    public KafkaTemplate<String, Patient> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }

	    @Bean
	    public ReplyingKafkaTemplate<String, Patient, Patient> replyKafkaTemplate(ProducerFactory<String, Patient> pf, KafkaMessageListenerContainer<String, Patient> container) {
	        return new ReplyingKafkaTemplate<>(pf, container);

	    }

	    @Bean
	    public KafkaMessageListenerContainer<String, Patient> replyContainer(ConsumerFactory<String, Patient> cf) {
	        ContainerProperties containerProperties = new ContainerProperties("patientreply");
	        return new KafkaMessageListenerContainer<>(cf, containerProperties);
	    }

	    @Bean
	    public ConsumerFactory<String, Patient> consumerFactory() {
	        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(Patient.class));
	    }

	    @Bean
	    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Patient>> kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, Patient> factory = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        factory.setReplyTemplate(kafkaTemplate());
	        return factory;
	    }

	 
}
