package com.APIRestAssuredPrograms.tests.restfulbooker.e2e;

import com.APIRestAssuredPrograms.asserts.AssertActions;
import com.APIRestAssuredPrograms.base.BaseTest;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import com.APIRestAssuredPrograms.pojos.restfulbooker.request.Booking;
import com.APIRestAssuredPrograms.pojos.restfulbooker.response.BookingResponse;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow1  extends BaseTest {

    // TestEndtoENd flow

    // Test to end Scenario

    //1 create booking

    // create token

    // verify the create booking

    //update booking

    // Delete booking

    @Test(groups = "reg", priority = 1)
    @Description("Create the booking")
    public void createBooking(ITestContext iTestContext){

        rs.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(rs).when().body(payloadManager.createPayloadBookingAsString()).post();

        vr = response.then().log().all();
        vr.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Vipendra");
        assertActions.verifyStringkeyNotNull(bookingResponse.getBookingid());

        Integer bookingid = bookingResponse.getBookingid();
        iTestContext.setAttribute("bookingid", bookingid);
        System.out.println("Booking created");

    }

    @Test (groups = "reg", priority = 2)
    @Description("Verify the booking is created")
    public void verifybooking(ITestContext iTestContext){
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String basePathGet = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
                System.out.println(basePathGet);

                rs.basePath(basePathGet);
                response = RestAssured.given(rs).when().get();
                vr = response.then().log().all();
                vr.statusCode(200);


        Booking booking = payloadManager.getResponsefromJSON(response.asString());
        assertActions.verifyStringkeyNotNull(booking.getFirstname());
    }


    @Test (groups = "reg", priority = 3)
    @Description("update the booking by ID ")
    public void upadtebookingbyID(ITestContext iTestContext){

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();
        iTestContext.setAttribute("token", token);

        String basepathPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL +"/"+ bookingid;
               System.out.println(basepathPUTPATCH);

               rs.basePath(basepathPUTPATCH);

               response = RestAssured
                       .given(rs).cookie("token", token)
                       .when().body(payloadManager.fullUpdatePayloadAsString()).put();

               vr= response.then().log().all();
               vr.statusCode(200);

               Booking booking = payloadManager.getResponsefromJSON(response.asString());

               assertActions.verifyStringkeyNotNull(booking.getFirstname());
               assertActions.verifyStringKey(booking.getFirstname(),"Chunky");
    }

    @Test (groups = "reg", priority = 4)
    @Description("Delete the booking")
    public void deletebookingById(ITestContext iTestContext){

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = (String)iTestContext.getAttribute("token");

        String baspathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL +"/"+ bookingid;

        rs.basePath(baspathDelete).cookie("token", token);
        vr = RestAssured.given().spec(rs).when().delete().then().log().all();
        vr.statusCode(201);

    }
}
