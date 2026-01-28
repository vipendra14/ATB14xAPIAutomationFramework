package com.APIRestAssuredPrograms.tests.restfulbooker.crud.healthCheck;

import com.APIRestAssuredPrograms.base.BaseTest;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {

    @Test(groups = "QA", priority = 1)
    @Description("Run the Health Check")
    public void testhealthCheck(){
        rs.basePath(APIConstants.PING_URL);

        response = RestAssured.given(rs).when().get();
        vr = response.then().log().all();
        vr.statusCode(201);

        assertActions.verifyTrue(response.asString().contains("Created"));
    }


}
