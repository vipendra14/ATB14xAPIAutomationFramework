package com.APIRestAssuredPrograms.tests.restfulbooker.crud.CreateBooking;

import com.APIRestAssuredPrograms.base.BaseTest;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateToken extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Vipendra")
    @Description("Generate the auth Token and verify")

    public void createTokenPOST(){
        rs.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(rs).when().body(payloadManager.setAuthPayload()).post();


        //Extraction (JSON string to JAVA Object)
        String token = payloadManager.getTokenFromJSON(response.asString());
     //   String token = response.jsonPath().getString("token");
        System.out.println("token is -> "+ token);

        assertActions.verifyStringkeyNotNull(token);
    }
}
