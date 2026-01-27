package com.APIRestAssuredPrograms.pojos.vwo.request;

public class LoginRequest {
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
    private String remember ;

    public String getRecaptcha_response_field() {
        return recaptcha_response_field;
    }

    public void setRecaptcha_response_field(String recaptcha_response_field) {
        this.recaptcha_response_field = recaptcha_response_field;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    private String recaptcha_response_field;

}
