package com.APIRestAssuredPrograms.tests.restfulbooker.crud.CreateBooking;

import com.APIRestAssuredPrograms.base.BaseTest;
import com.APIRestAssuredPrograms.endpoints.APIConstants;
import com.APIRestAssuredPrograms.pojos.restfulbooker.response.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class TestCreateBooking extends BaseTest {

    @Test(groups= "reg", priority = 1)
    @Owner("Vipendra")
    @Description("#TC1 Verify the booking can be created")
    public void testCreateBookingPOST_Positive(){

        //Given
        //First making the request part 1
        rs.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(rs)
                //When
                .when().body(payloadManager.createPayloadBookingAsString())
                .log().all().post();


        //Extraction part-2 i.e Deserialization
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //Then
        assertActions.verifyStatusCode(response,200);
        assertActions.verifyStringkeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Vipendra");
    }
}
