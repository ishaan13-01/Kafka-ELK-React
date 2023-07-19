package com.ishaan.KafkaDemo.Controller;

import com.ishaan.KafkaDemo.DataModal.TwitterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ishaan.KafkaDemo.service.KafkaTwitterProducer;

@RestController
@RequestMapping("/rest/api")
public class FetchMessageFromClient {

	@Autowired
    KafkaTwitterProducer kafkaTwitterProducer;

    @PostMapping(value = "/tweet")
    public String sendPostMessageToTopic(@RequestBody TwitterRequest twitterRequest) {
        //String tweet =
        kafkaTwitterProducer.sendMessageToTopic(twitterRequest);
        return "tweet sent Successfully to the your topic ";
    }

    @RequestMapping("/error")
    public String handleError() {
        return "error-page";
    }
	
}
