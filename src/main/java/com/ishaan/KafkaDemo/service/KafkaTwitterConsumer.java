package com.ishaan.KafkaDemo.service;

import com.ishaan.ElasticSearch.ElasticSearchConnector;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaTwitterConsumer {

	@KafkaListener(topics = "topicA", groupId = "topicA-group")
	public void listenToKafkaTopic(String messageReceived) {
		System.out.println("Message received is " + messageReceived);
		// send message to Elastic search Twitter Index
		ElasticSearchConnector.publishToDataLakeCluster(messageReceived);
	}
}
