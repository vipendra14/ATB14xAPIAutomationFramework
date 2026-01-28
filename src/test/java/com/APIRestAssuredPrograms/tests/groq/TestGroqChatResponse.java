package com.APIRestAssuredPrograms.tests.groq;

import com.APIRestAssuredPrograms.base.BaseTest;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import com.APIRestAssuredPrograms.pojos.groq.response.ChatCompletionResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestGroqChatResponse extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Vipendra")
    @Description("Write the positive test cases")

    public void testGroqGhat(){
        rs.baseUri(APIConstants.GROQ_BASE_URL);
        rs.basePath(APIConstants.GROQ_CHAT);
        rs.header("Authorization","Bearer <>");
        response = RestAssured.given(rs).when().body(groqPayloadManager.setBuildRequest()).log().all().post();


        ChatCompletionResponse chatCompletionResponse = groqPayloadManager.parseResponse(response.asString());

        String response_chat = chatCompletionResponse.getChoices().get(0).getMessage().getContent();

        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringkeyNotNull(response_chat);


    }
}
