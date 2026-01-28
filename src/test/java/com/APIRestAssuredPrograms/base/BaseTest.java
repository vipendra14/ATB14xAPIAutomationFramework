package com.APIRestAssuredPrograms.base;

import com.APIRestAssuredPrograms.asserts.AssertActions;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import com.APIRestAssuredPrograms.modules.groqpayloadmanager.GROQPayloadManager;
import com.APIRestAssuredPrograms.modules.restfulbooker.PayloadManager;
import com.APIRestAssuredPrograms.modules.vwo.PayloadManager_vwo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification rs;
    public Response response;
    public ValidatableResponse vr;


    public PayloadManager payloadManager;
    public PayloadManager_vwo payloadManager_vwo;
    public GROQPayloadManager groqPayloadManager;
    public JsonPath jsonPath;
    public AssertActions assertActions;


    @BeforeTest
    public void setup(){
        System.out.println("Start the testing");
        payloadManager = new PayloadManager();
        payloadManager_vwo = new PayloadManager_vwo();
        groqPayloadManager = new GROQPayloadManager();
        assertActions = new AssertActions();

        rs= RestAssured.given();
        rs.baseUri(APIConstants.BASE_URL);
        rs.contentType(ContentType.JSON).log().all();

    }

    public String getToken(){
        rs= RestAssured.given();
        rs.baseUri(APIConstants.BASE_URL).basePath(APIConstants.AUTH_URL);

        String payload = payloadManager.setAuthPayload();

        response = rs.contentType(ContentType.JSON).body(payload).when().post();
        String token = payloadManager.getTokenFromJSON(response.asString());
        return token;

    }


    @AfterTest
    public void tearDown(){
        System.out.println("Finished the test");

    }
}
