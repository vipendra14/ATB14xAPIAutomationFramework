package com.APIRestAssuredPrograms.modules.groqpayloadmanager;

import com.APIRestAssuredPrograms.pojos.groq.request.ChatRequest;
import com.APIRestAssuredPrograms.pojos.groq.request.Message;
import com.APIRestAssuredPrograms.pojos.groq.response.ChatCompletionResponse;
import com.google.gson.Gson;

import java.util.Collections;

public class GROQPayloadManager {
    static Gson gson;

    public void buildRequest(){
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("openai/gpt-oss-120b");
        Message message = new Message("user", "Explain the POJO");
        chatRequest.setMessages(Collections.singletonList(message));
    }

    public String setBuildRequest() {
        gson = new Gson();
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("openai/gpt-oss-120b");
        Message message = new Message("user", "Explain the pojo");
        chatRequest.setMessages(Collections.singletonList(message));
        return gson.toJson(chatRequest);
    }

    public static ChatCompletionResponse parseResponse(String jsonResponse){
        gson = new Gson();
        return gson.fromJson(jsonResponse, ChatCompletionResponse.class);
    }

}
