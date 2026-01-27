package com.APIRestAssuredPrograms.tests.vwo;

import com.APIRestAssuredPrograms.base.BaseTest;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import com.APIRestAssuredPrograms.pojos.vwo.response.LoginResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestVWOlogin extends BaseTest {

@Test
    public void test_VWO_Login(){
    rs.baseUri(APIConstants.VWO_BASE_URL);
    rs.basePath(APIConstants.VWO_LOGIN_URL);

    response = RestAssured.given(rs).when().body(payloadManager_vwo.setLoginData()).log().all().post();

    // Extraction part 2

    LoginResponse loginResponse = payloadManager_vwo.getLoginData(response.asString());

    //Validation and Verification via AssertJ, TestNG part - 3
    assertActions.verifyStatusCode(response,200);



}
}
