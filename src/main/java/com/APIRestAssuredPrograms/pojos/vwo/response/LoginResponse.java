package com.APIRestAssuredPrograms.pojos.vwo.response;

public class LoginResponse {
    private String message;
    private String showCaptcha;

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getShowCaptcha() {
        return showCaptcha;
    }

    public void setShowCaptcha(String showCaptcha) {
        this.showCaptcha = showCaptcha;
    }

    private String captchaKey;

}
