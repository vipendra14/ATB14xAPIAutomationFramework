package com.APIRestAssuredPrograms.pojos.groq.request;

import java.util.List;

public class ChatRequest {

    private String model;

    public ChatRequest(){

    }
    public ChatRequest(String model, List<Message>messages){
        this.model  = model;
        this.messages = messages;

    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private List<Message> messages;
}
