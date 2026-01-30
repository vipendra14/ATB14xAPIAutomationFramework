package com.APIRestAssuredPrograms.tests.restfulbooker.e2e;

import com.APIRestAssuredPrograms.base.BaseTest;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import com.APIRestAssuredPrograms.pojos.restfulbooker.response.BookingResponse;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow2 extends BaseTest {

    // Create Booking  // Delete it  //Verify

    @Test(groups = "QA", priority = 1)
    @Description("TC1 Create the booking by id")
    public void createbooking(ITestContext iTestContext){
        rs.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response= RestAssured.given(rs).when().body(payloadManager.createPayloadBookingAsString()).post();

        vr = response.then().log().all();
        vr.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Vipendra");
        assertActions.verifyStringkeyNotNull(bookingResponse.getBookingid());

        Integer bookingid = bookingResponse.getBookingid();
        iTestContext .setAttribute("bookingid", bookingid);

    }

    @Test(groups = "QA", priority = 2)
    @Description("TC2 Delete the booking by ID")
    public void deletebookingbyId(ITestContext iTestContext){

        String token = getToken();
        iTestContext.setAttribute("token", token);

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String token1  = (String)iTestContext.getAttribute("token");

        String basepathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL +"/"+ bookingid;

        rs.basePath(basepathDelete).cookie("token", token1);
        vr= RestAssured.given().spec(rs).when().delete().then().log().all();
        vr.statusCode(201);


    }
    @Test(groups = "QA", priority = 3)
    @Description("TC3 verify the booking is deleted")
    public void verifydeletedbooking(ITestContext iTestContext){

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String basePathGet = APIConstants.CREATE_UPDATE_BOOKING_URL +"/"+ bookingid;
        vr = RestAssured.given().spec(rs).when().get(basePathGet).then().log().all();
        vr.statusCode(404);

    }
}
