package com.APIRestAssuredPrograms.modules.vwo;

import com.APIRestAssuredPrograms.pojos.vwo.request.LoginRequest;
import com.APIRestAssuredPrograms.pojos.vwo.response.LoginResponse;
import com.google.gson.Gson;

public class PayloadManager_vwo {
    Gson gson;

    //Java Object to JSON
    //Serialization
public String setLoginData(){
    LoginRequest loginRequest = new LoginRequest();
    loginRequest.setUsername("viperkumar@wipro.com");
    loginRequest.setPassword("Welcome@1234");
    loginRequest.setRemember(String.valueOf(false));
    loginRequest.setRecaptcha_response_field("");


    gson = new Gson();
    String jsonPayloadString = gson.toJson(loginRequest);
    System.out.println("Payload login to the "+ jsonPayloadString);
    return jsonPayloadString;

    }

    //Dserialiization
    //JSON to JAVA Object

    public LoginResponse getLoginData(String loginResponseEx){
    gson = new Gson();
    LoginResponse loginResponse = gson.fromJson(loginResponseEx, LoginResponse.class);
    return loginResponse;

    }
}
