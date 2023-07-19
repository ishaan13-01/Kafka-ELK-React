package com.ishaan.KafkaDemo.DataModal;

public class TwitterRequest {

   private String name ;
    private String tweet;


    public TwitterRequest(String name, String tweet) {
        this.name = name;
        this.tweet = tweet;
    }

    public TwitterRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }


}
