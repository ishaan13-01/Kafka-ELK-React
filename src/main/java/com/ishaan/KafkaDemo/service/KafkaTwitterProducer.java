package com.ishaan.KafkaDemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ishaan.KafkaDemo.DataModal.TwitterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTwitterProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessageToTopic(TwitterRequest tweet) {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonTweet =null;
		try {
			jsonTweet = objectMapper.writeValueAsString(tweet);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		System.out.println("twitter message is========" +jsonTweet);
		kafkaTemplate.send("topicA", jsonTweet);
	}

}
